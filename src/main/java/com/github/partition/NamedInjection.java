package com.github.partition;

import com.github.partition.common.Greeter;
import com.github.partition.common.HappyGreeter;
import com.github.partition.common.SadGreeter;
import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Named;

public class NamedInjection {

  @Inject @Named("sad")
  Greeter sad;

  @Inject @Named("happy")
  Greeter happy;

  public NamedInjection() {
    ObjectGraph.create(NamedModule.class).inject(this);
    System.out.println(sad.greet("Janusz"));
    System.out.println(happy.greet("Janusz"));
  }

  @Module(injects = NamedInjection.class)
  static class NamedModule {

    @Provides @Named("happy")
    public Greeter provideHappyGreeter() {
      return new HappyGreeter();
    }

    @Provides @Named("sad")
    public Greeter provideSadGreeter() {
      return new SadGreeter();
    }
  }
}
