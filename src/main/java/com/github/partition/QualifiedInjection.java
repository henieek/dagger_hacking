package com.github.partition;

import com.github.partition.annotation.Activity;
import com.github.partition.annotation.Application;
import com.github.partition.common.Greeter;

import javax.inject.Inject;
import javax.inject.Named;

public class QualifiedInjection {

  @Inject @Activity
  Greeter sad;

  @Inject @Application
  Greeter happy;

}
