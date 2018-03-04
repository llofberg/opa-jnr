package io.lbg;

public interface OpaLib {
  void run(long t);

  void stop();

  void compile(String module, String filename);

  boolean query(String query, String input);
}
