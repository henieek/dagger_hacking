package com.github.partition;

import com.github.partition.common.HappyGreeter;
import com.github.partition.common.SadGreeter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Inject;
import javax.inject.Qualifier;

import dagger.ObjectGraph;

public class ScopedInjection {

  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  public @interface Blah {

  }

  public static class First {

    @Inject
    SadGreeter sad;

    @Inject
    HappyGreeter hapy;
  }

  public static class Second {
    @Inject @Blah
    SadGreeter sad;

    @Inject
    HappyGreeter hapy;
  }

  public static void main(String[] args) {
    final ObjectGraph subGraph = BaseModule.generateGraph();
    final First first = new First();
    final Second second = new Second();
    subGraph.inject(first);
    subGraph.inject(second);

    System.out.println(first.hapy);
    System.out.println(first.sad);

    System.out.println(second.hapy);
    System.out.println(second.sad);
  }
}
