package com.example.state;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsConstructor;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.core.ComponentConstructorFunction;
import react4j.core.NativeAdapterComponent;
import react4j.core.ReactConfig;

@Generated("react4j.processor.ReactProcessor")
class React4j_GetterMissingAnnotation extends GetterMissingAnnotation {
  static final ComponentConstructorFunction TYPE = getConstructorFunction();

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "GetterMissingAnnotation" );
    }
    return componentConstructor;
  }

  @Override
  protected String getMyValue() {
    return state().getAny( "myValue" ).asString();
  }

  @Override
  protected void setMyValue(final String value) {
    scheduleStateUpdate( ( ( previousState, currentProps ) -> JsPropertyMap.of( "myValue", value ) ) );
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<GetterMissingAnnotation> {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected GetterMissingAnnotation createComponent() {
      return new React4j_GetterMissingAnnotation();
    }
  }
}
