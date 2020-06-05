package com.example.default_props;

import react4j.ReactNode;
import react4j.annotations.Input;
import react4j.annotations.InputDefault;
import react4j.annotations.Render;
import react4j.annotations.View;

@View
abstract class BadNameFieldPropDefault
{
  @InputDefault( name = "-myProp" )
  static final String MY_PROP = "Foo";

  @Input
  protected abstract String getMyProp();

  @Render
  ReactNode render()
  {
    return null;
  }
}
