package com.example.prop_validate;

import react4j.Component;
import react4j.ReactNode;
import react4j.annotations.Prop;
import react4j.annotations.PropValidate;
import react4j.annotations.ReactComponent;

@ReactComponent
abstract class BooleanPropValidate
  extends Component
{
  @PropValidate
  void validateMyProp( boolean prop )
  {
  }

  @Prop
  protected abstract boolean getMyProp();

  @Override
  protected ReactNode render()
  {
    return null;
  }
}