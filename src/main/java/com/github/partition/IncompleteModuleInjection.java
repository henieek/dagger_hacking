package com.github.partition;

import dagger.Module;
import dagger.ObjectGraph;

public class IncompleteModuleInjection {

  public IncompleteModuleInjection() {
    ObjectGraph.create(IAmNotFinishedModule.class).inject(this);
  }

  /**
   * Otherwise (default complete parameter value) this wouldn't compile.
   */
  @Module(complete = false)
  static class IAmNotFinishedModule {

  }
}
