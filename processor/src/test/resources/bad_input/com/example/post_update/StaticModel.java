package com.example.post_update;

import react4j.Component;
import react4j.ReactNode;
import react4j.annotations.PostUpdate;
import react4j.annotations.ReactComponent;

@ReactComponent
abstract class StaticModel
  extends Component
{
  @PostUpdate
  static void postUpdate()
  {
  }

  @Override
  protected ReactNode render()
  {
    return null;
  }
}
