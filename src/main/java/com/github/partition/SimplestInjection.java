package com.github.partition;

import com.github.partition.common.HappyGreeter;
import dagger.Module;
import dagger.ObjectGraph;

import javax.inject.Inject;

public class SimplestInjection {

  @Inject
  HappyGreeter greeter;

  public SimplestInjection() {
    ObjectGraph.create(MyModule.class).inject(this);
    System.out.println(greeter.greet("Janusz"));
  }

  @Module(injects = SimplestInjection.class)
  static class MyModule {

  }

}
