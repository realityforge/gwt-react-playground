package com.example.default_props;

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
class React4j_ExplicitNameFieldPropDefault extends ExplicitNameFieldPropDefault {
  static final ComponentConstructorFunction TYPE = getConstructorFunction();

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "ExplicitNameFieldPropDefault" );
    }
    final JsPropertyMap<Object> defaultProps = JsPropertyMap.of();
    defaultProps.set( "myProp", ExplicitNameFieldPropDefault.MY_PROP );
    Js.asPropertyMap( componentConstructor ).set( "defaultProps", defaultProps );
    return componentConstructor;
  }

  @Override
  protected String getMyProp() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( "myProp" ) ? props().getAny( "myProp" ).asString() : null;
    } else {
      return Js.uncheckedCast( props().getAny( "myProp" ) );
    }
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<ExplicitNameFieldPropDefault> {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ExplicitNameFieldPropDefault createComponent() {
      return new React4j_ExplicitNameFieldPropDefault();
    }
  }
}
