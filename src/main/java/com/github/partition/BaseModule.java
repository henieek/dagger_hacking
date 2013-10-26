package com.github.partition;

import com.github.partition.common.HappyGreeter;
import com.github.partition.common.SadGreeter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

public class BaseModule {

  private static ObjectGraph baseGraph = ObjectGraph.create(new MyModule());

  public static ObjectGraph generateGraph(Object... modulesToPlus) {
    if (modulesToPlus.length > 0) {
      return baseGraph.plus(modulesToPlus);
    }
    return baseGraph;
  }

  @Module(injects = { ScopedInjection.First.class, ScopedInjection.Second.class }, complete = false)
  public static class MyModule {

    @Provides
    @Singleton
    @ScopedInjection.Blah
    public SadGreeter provideSadGreeter() {
      return new SadGreeter();
    }

    @Provides
    @Singleton
    public SadGreeter provideSadGreeterAgain() {
      return new SadGreeter();
    }

    @Provides
    @Singleton
    public HappyGreeter provideHappyGreeter() {
      return new HappyGreeter();
    }
  }
}
