package com.example.on_prop_change;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import react4j.Component;
import react4j.ReactNode;
import react4j.annotations.OnPropChange;
import react4j.annotations.Prop;
import react4j.annotations.ReactComponent;

@ReactComponent
abstract class BadNullability2OnPropChange
  extends Component
{
  @OnPropChange
  void onMyPropChange( @Nullable String myProp )
  {
  }

  @Nonnull
  @Prop
  protected abstract String getMyProp();

  @Override
  protected ReactNode render()
  {
    return null;
  }
}