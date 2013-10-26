package com.github.partition;

import com.github.partition.common.Greeter;
import com.github.partition.common.HappyGreeter;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

import javax.inject.Inject;

public class MultipleImplementationsInterfaceInjection {

  @Inject
  Greeter iAmHappy;

  public MultipleImplementationsInterfaceInjection() {
    ObjectGraph.create(HappyModule.class).inject(this);
  }

  @Module(injects = MultipleImplementationsInterfaceInjection.class)
  static class HappyModule {

    @Provides
    public Greeter provideGreeter(HappyGreeter happyGreeter) {
      return happyGreeter;
    }
  }
}
