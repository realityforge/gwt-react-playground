package com.example.lifecycle;

import elemental2.core.JsError;
import javax.annotation.Nonnull;
import react4j.Component;
import react4j.ReactErrorInfo;
import react4j.ReactNode;
import react4j.annotations.OnError;
import react4j.annotations.PostMount;
import react4j.annotations.PostMountOrUpdate;
import react4j.annotations.PostUpdate;
import react4j.annotations.PreUpdate;
import react4j.annotations.ReactComponent;

@ReactComponent
abstract class OverrideLifecycleMethodsComponent
  extends Component
{
  @Override
  protected ReactNode render()
  {
    return null;
  }

  @PreUpdate
  final void preUpdate()
  {
  }

  @PostUpdate
  final void postUpdate()
  {
  }

  @PostMountOrUpdate
  final void postMountOrUpdate()
  {
  }

  @PostMount
  final void postMount()
  {
  }

  @OnError
  final void onError( @Nonnull final JsError error, @Nonnull final ReactErrorInfo info )
  {
  }
}
