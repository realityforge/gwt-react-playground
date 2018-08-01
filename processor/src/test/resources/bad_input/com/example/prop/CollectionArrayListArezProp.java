package com.example.prop;

import arez.annotations.ArezComponent;
import java.util.ArrayList;
import javax.annotation.Nullable;
import react4j.ReactNode;
import react4j.annotations.Prop;
import react4j.annotations.ReactComponent;
import react4j.arez.ReactArezComponent;

@ReactComponent
abstract class CollectionArrayListArezProp
  extends ReactArezComponent
{
  @ArezComponent( allowEmpty = true )
  static abstract class AnArezElement
  {

  }

  @Prop
  protected abstract ArrayList<AnArezElement> getMyKey();

  @Nullable
  @Override
  protected ReactNode render()
  {
    return null;
  }
}