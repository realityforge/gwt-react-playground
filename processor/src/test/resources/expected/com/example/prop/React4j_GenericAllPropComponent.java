package com.example.prop;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsConstructor;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.ComponentConstructorFunction;
import react4j.NativeAdapterComponent;
import react4j.ReactConfig;

@Generated("react4j.processor.ReactProcessor")
class React4j_GenericAllPropComponent<T> extends GenericAllPropComponent<T> {
  static final ComponentConstructorFunction TYPE = getConstructorFunction();

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "GenericAllPropComponent" );
    }
    return componentConstructor;
  }

  @Override
  protected <K> K getValue() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( "value" ) ? props().getAny( "value" ).cast() : null;
    } else {
      return Js.uncheckedCast( props().getAny( "value" ) );
    }
  }

  private static final class NativeReactComponent<T> extends NativeAdapterComponent<GenericAllPropComponent<T>> {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected GenericAllPropComponent<T> createComponent() {
      return new React4j_GenericAllPropComponent<T>();
    }
  }
}
