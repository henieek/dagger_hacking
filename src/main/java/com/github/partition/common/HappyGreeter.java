package com.github.partition.common;

import javax.inject.Inject;

public class HappyGreeter implements Greeter {

  @Inject
  public HappyGreeter() {
  }

  @Override
  public String greet(String name) {
    return "HI " + name + "!!!!!!!!";
  }
}
