package io.lbg;

import static java.lang.System.out;

public class OpaJnr {

  private static final int SLEEP_SECONDS = 1;

  private static String module = "" +
    "package example\n" +
    "default allow = false\n" +
    "allow {\n" +
    "  input.identity = \"admin\"\n" +
    "}\n" +
    "allow {\n" +
    "  input.method = \"GET\"\n" +
    "}\n";
  private static String filename = "example.rego";
  private static String query = "data.example.allow";
  private static String input1 = "{\"identity\": \"bob\", \"method\":   \"GET\"}";
  private static String input2 = "{\"identity\": \"bob\", \"method\":   \"POST\"}";

  public static void main(String[] args) throws InterruptedException {
    OpaRunner opaRunner = new OpaRunner(SLEEP_SECONDS);
    OpaLib opaLib = opaRunner.getOpaLib();
    Thread thread = new Thread(opaRunner);
    thread.start();
    out.println("Compiling");
    opaLib.compile(module, filename);
    out.println("Querying");
    out.println(input1 + " : " + opaLib.query(query, input1));
    out.println(input2 + " : " + opaLib.query(query, input2));
    out.println("Done");
    opaLib.stop();
    thread.join();
  }
}
