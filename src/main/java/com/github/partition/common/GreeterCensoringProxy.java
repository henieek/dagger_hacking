package com.github.partition.common;

import javax.inject.Inject;

public class GreeterCensoringProxy {

  private Greeter greeter;

  @Inject
  public GreeterCensoringProxy(HappyGreeter greeter) {
    this.greeter = greeter;
  }

  public String greet(String name) {
    return "Censored.";
  }
}
