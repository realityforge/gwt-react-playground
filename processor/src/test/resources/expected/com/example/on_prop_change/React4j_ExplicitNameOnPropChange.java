package com.example.on_prop_change;

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
class React4j_ExplicitNameOnPropChange extends ExplicitNameOnPropChange {
  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = ( ReactConfig.shouldStoreDebugDataAsState() || ReactConfig.shouldValidatePropValues() ) ? NativeReactComponent::new : LiteNativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "ExplicitNameOnPropChange" );
    }
    return componentConstructor;
  }

  @Override
  protected double getMyProp() {
    return props().getAny( Props.myProp ).asDouble();
  }

  private void $$react4j$$_componentPreUpdate(@Nullable final JsPropertyMap<Object> prevProps) {
    if ( null != prevProps ) {
      final JsPropertyMap<Object> props = props();
      final boolean myProp = !Js.isTripleEqual( props.get( Props.myProp ), prevProps.get( Props.myProp ) );
      if ( myProp ) {
        onMyPropChange( props.getAny( Props.myProp ).asDouble() );
      }
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
    Object getSnapshotBeforeUpdate(@Nonnull JsPropertyMap<Object> prevProps,
        @Nonnull JsPropertyMap<Object> prevState);
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "?"
  )
  interface Lifecycle {
    Object getSnapshotBeforeUpdate(@Nonnull JsPropertyMap<Object> prevProps,
        @Nonnull JsPropertyMap<Object> prevState);
  }

  private static final class LiteNativeReactComponent extends NativeAdapterComponent<ExplicitNameOnPropChange> implements LiteLifecycle {
    @JsConstructor
    LiteNativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ExplicitNameOnPropChange createComponent() {
      return new React4j_ExplicitNameOnPropChange();
    }

    @Override
    public final Object getSnapshotBeforeUpdate(@Nonnull JsPropertyMap<Object> prevProps,
        @Nonnull JsPropertyMap<Object> prevState) {
      ((React4j_ExplicitNameOnPropChange) component() ).$$react4j$$_componentPreUpdate( prevProps );
      return null;
    }
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<ExplicitNameOnPropChange> implements Lifecycle {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ExplicitNameOnPropChange createComponent() {
      return new React4j_ExplicitNameOnPropChange();
    }

    @Override
    public final Object getSnapshotBeforeUpdate(@Nonnull JsPropertyMap<Object> prevProps,
        @Nonnull JsPropertyMap<Object> prevState) {
      ((React4j_ExplicitNameOnPropChange) component() ).$$react4j$$_componentPreUpdate( prevProps );
      return null;
    }
  }
}
