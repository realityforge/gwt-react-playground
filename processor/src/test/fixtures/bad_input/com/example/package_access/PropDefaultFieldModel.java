package com.example.package_access;

import com.example.package_access.other.BasePropDefaultFieldModel;
import javax.annotation.Nullable;
import react4j.ReactNode;
import react4j.annotations.ReactComponent;

@ReactComponent
public abstract class PropDefaultFieldModel
  extends BasePropDefaultFieldModel
{
  @Nullable
  @Override
  protected ReactNode render()
  {
    return null;
  }
}