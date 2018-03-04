package io.lbg;

import jnr.ffi.LibraryLoader;

import static java.lang.System.out;

public class OpaJnr {

  private static final String LIBRARY_NAME = "opa";
  private static final OpaLib OPA_LIB;

  static {
    OPA_LIB = LibraryLoader.create(OpaLib.class).load(LIBRARY_NAME);
  }

  public static void main(String[] args) {
    String module = "" +
      "package example\n" +
      "default allow = false\n" +
      "allow {\n" +
      "  input.identity = \"admin\"\n" +
      "}\n" +
      "allow {\n" +
      "  input.method = \"GET\"\n" +
      "}\n";

    String filename = "example.rego";
    String query = "data.example.allow";
    String input1 = "{\"identity\": \"bob\", \"method\":   \"GET\"}";
    String input2 = "{\"identity\": \"bob\", \"method\":   \"POST\"}";

    OpaLib opaLib = OPA_LIB;
    opaLib.compile(module, filename);
    out.println(input1 + " : " + opaLib.query(query, input1));
    out.println(input2 + " : " + opaLib.query(query, input2));
  }
}
