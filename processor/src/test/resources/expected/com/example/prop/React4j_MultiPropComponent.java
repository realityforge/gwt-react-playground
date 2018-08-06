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
class React4j_MultiPropComponent extends MultiPropComponent {
  static final ComponentConstructorFunction TYPE = getConstructorFunction();

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "MultiPropComponent" );
    }
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

  @Override
  protected String getMyProp2() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( "myProp2" ) ? props().getAny( "myProp2" ).asString() : null;
    } else {
      return Js.uncheckedCast( props().getAny( "myProp2" ) );
    }
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<MultiPropComponent> {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected MultiPropComponent createComponent() {
      return new React4j_MultiPropComponent();
    }
  }
}
