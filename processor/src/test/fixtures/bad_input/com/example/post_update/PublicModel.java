package com.example.post_update;

import react4j.ReactNode;
import react4j.annotations.PostUpdate;
import react4j.annotations.Render;
import react4j.annotations.View;

@View
abstract class PublicModel
{
  @PostUpdate
  public void postUpdate()
  {
  }

  @Render
  ReactNode render()
  {
    return null;
  }
}
