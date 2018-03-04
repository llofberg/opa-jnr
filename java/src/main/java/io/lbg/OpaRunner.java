package io.lbg;

import jnr.ffi.LibraryLoader;

public class OpaRunner implements Runnable {
  private static final int SECOND = 1000 * 1000 * 1000;
  private static final int DEFAULT_SLEEP_SECONDS = 1;

  private int sleepNanos;

  private static final OpaLib OPA_LIB;

  static {
    OPA_LIB = LibraryLoader.create(OpaLib.class).load("opa");
  }

  public OpaRunner() {
    this(DEFAULT_SLEEP_SECONDS);
  }

  public OpaRunner(int sleepSeconds) {
    this.sleepNanos = sleepSeconds * SECOND;
  }

  @Override
  public void run() {
    OPA_LIB.run(sleepNanos);
  }

  OpaLib getOpaLib() {
    return OPA_LIB;
  }
}
