package com.example.prop_validate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import react4j.ReactNode;
import react4j.annotations.Input;
import react4j.annotations.InputValidate;
import react4j.annotations.Render;
import react4j.annotations.View;

@View
abstract class BadNullabilityProp2Validate
{
  @InputValidate
  void validateMyProp( @Nullable String prop )
  {
  }

  @Input
  @Nonnull
  protected abstract String getMyProp();

  @Render
  ReactNode render()
  {
    return null;
  }
}
