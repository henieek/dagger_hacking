package com.github.partition.common;

public class SadGreeter implements Greeter {

  @Override
  public String greet(String name) {
    return "Oh, it's you again " + name + ". Hello...";
  }
}
