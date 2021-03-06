package react4j.internal;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;
import react4j.ReactNode;

/**
 * The react native component.
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "React.Component" )
@SuppressWarnings( "unused" )
public abstract class NativeView
{
  @JsProperty( name = "props" )
  private JsPropertyMap<Object> inputs;
  @JsProperty
  private JsPropertyMap<Object> state;

  @JsConstructor
  protected NativeView( @Nullable final JsPropertyMap<Object> inputs )
  {
  }

  @JsMethod
  @Nullable
  public abstract ReactNode render();

  @JsOverlay
  @Nullable
  public final JsPropertyMap<Object> inputs()
  {
    return inputs;
  }

  @JsOverlay
  @Nullable
  public final JsPropertyMap<Object> state()
  {
    return state;
  }

  public final native void setState( @Nonnull JsPropertyMap<Object> state );

  public final native void forceUpdate();
}
