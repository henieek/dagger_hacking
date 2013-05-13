package com.github.partition;

import com.github.partition.common.Greeter;
import com.github.partition.common.HappyGreeter;
import com.github.partition.common.SingletonGreeter;
import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Singleton;

public class SingletonInjection {

  @Inject
  SingletonGreeter iAmASingleton;

  @Inject
  Greeter iAmASingletonToo;

  public SingletonInjection() {
    ObjectGraph.create(SingletonModule.class).inject(this);
  }

  @Module(injects = SingletonInjection.class)
  static class SingletonModule {

    @Provides
    @Singleton
    public Greeter provideSingleton() {
      return new HappyGreeter();
    }
  }
}
