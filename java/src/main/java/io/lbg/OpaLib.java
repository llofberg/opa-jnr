package io.lbg;

public interface OpaLib {
  void compile(String module, String filename);

  boolean query(String query, String input);
}
