package com.github.partition;

import com.github.partition.common.GreeterCensoringProxy;
import dagger.Module;
import dagger.ObjectGraph;

import javax.inject.Inject;

public class ConstructorInjection {

  @Inject
  GreeterCensoringProxy greeterProxy;

  public ConstructorInjection() {
    ObjectGraph.create(new ProxyModule()).inject(this);
    System.out.println(greeterProxy.greet("Hey"));
  }

  @Module(injects = ConstructorInjection.class)
  static class ProxyModule {

  }
}
