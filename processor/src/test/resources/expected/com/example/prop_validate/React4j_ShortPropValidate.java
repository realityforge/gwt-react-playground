package com.example.prop_validate;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.ComponentConstructorFunction;
import react4j.NativeAdapterComponent;
import react4j.ReactConfig;

@Generated("react4j.processor.ReactProcessor")
class React4j_ShortPropValidate extends ShortPropValidate {
  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = ( ReactConfig.shouldStoreDebugDataAsState() || ReactConfig.shouldValidatePropValues() ) ? NativeReactComponent::new : LiteNativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "ShortPropValidate" );
    }
    return componentConstructor;
  }

  @Override
  protected short getMyProp() {
    return props().getAny( Props.myProp ).asShort();
  }

  @Override
  protected final void validatePropValues(@Nonnull final JsPropertyMap<Object> props) {
    final Object raw$myProp = props.get( Props.myProp );
    if ( null != raw$myProp ) {
      final short typed$myProp = Js.asShort( raw$myProp );
      validateMyProp( typed$myProp );
    }
  }

  static final class Factory {
    static final ComponentConstructorFunction TYPE = getConstructorFunction();
  }

  static final class Props {
    static final String myProp = ReactConfig.shouldMinimizePropKeys() ? "a" : "myProp";
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "?"
  )
  interface LiteLifecycle {
    boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps);
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "?"
  )
  interface Lifecycle {
    boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps);
  }

  private static final class LiteNativeReactComponent extends NativeAdapterComponent<ShortPropValidate> implements LiteLifecycle {
    @JsConstructor
    LiteNativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ShortPropValidate createComponent() {
      return new React4j_ShortPropValidate();
    }

    @Override
    public final boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps) {
      return performShouldComponentUpdate( nextProps );
    }
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<ShortPropValidate> implements Lifecycle {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ShortPropValidate createComponent() {
      return new React4j_ShortPropValidate();
    }

    @Override
    public final boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps) {
      return performShouldComponentUpdate( nextProps );
    }
  }
}
