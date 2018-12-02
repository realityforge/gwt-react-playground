package com.example.post_mount;

import react4j.Component;
import react4j.ReactNode;
import react4j.annotations.PostMount;
import react4j.annotations.ReactComponent;

@ReactComponent
abstract class ReturnsValueModel
  extends Component
{
  @PostMount
  int postMount()
  {
    return 0;
  }

  @Override
  protected ReactNode render()
  {
    return null;
  }
}
