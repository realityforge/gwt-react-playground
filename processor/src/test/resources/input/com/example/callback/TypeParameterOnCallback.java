package com.example.callback;

import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import react4j.annotations.Callback;
import react4j.annotations.ReactComponent;
import react4j.core.Component;
import react4j.core.ReactNode;

@ReactComponent
abstract class TypeParameterOnCallback
  extends Component
{
  @JsFunction
  public interface CustomHandler
  {
    Object render();
  }

  @Nullable
  @Override
  protected ReactNode render()
  {
    return null;
  }

  @Callback( CustomHandler.class )
  public <T> T handleFoo()
  {
    return null;
  }
}
