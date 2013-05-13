package com.github.partition;

import com.github.partition.common.Greeter;
import com.github.partition.common.HappyGreeter;
import com.github.partition.common.SadGreeter;
import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

import javax.inject.Inject;

public class ConflictingModules {

  @Inject
  Greeter iAmHappy;

  public ConflictingModules() {
    // passing conflicting modules to create() will fail on compile time.
    ObjectGraph.create(FirstModule.class).plus(new SecondModule()).inject(this);
    System.out.println(iAmHappy.greet("Henryk"));
  }

  @Module(injects = ConflictingModules.class)
  static class FirstModule {

    @Provides
    public Greeter provideGreeter() {
      return new HappyGreeter();
    }

  }

  /**
   * This one will be ignored as it's used later. (greeter will be happy)
   */
  @Module(injects = ConflictingModules.class)
  static class SecondModule {

    @Provides
    public Greeter provideGreeter() {
      return new SadGreeter();
    }
  }
}
