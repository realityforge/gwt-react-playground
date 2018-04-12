package com.example.callback;

import elemental2.core.JsObject;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.core.ComponentConstructorFunction;
import react4j.core.NativeAdapterComponent;
import react4j.core.ReactConfig;

@Generated("react4j.processor.ReactProcessor")
class React4j_CustomReturnType extends CustomReturnType {
  static final ComponentConstructorFunction TYPE = getConstructorFunction();

  @Nonnull
  final CustomReturnType.CustomHandler _handleRender = create_handleRender();

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "CustomReturnType" );
    }
    return componentConstructor;
  }

  @Nonnull
  private CustomReturnType.CustomHandler create_handleRender() {
    final CustomReturnType.CustomHandler handler = () -> this.handleRender();
    if( ReactConfig.enableComponentNames() ) {
      JsObject.defineProperty( Js.cast( handler ), "name", Js.cast( JsPropertyMap.of( "value", "CustomReturnType.handleRender" ) ) );
    }
    return handler;
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<CustomReturnType> {
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected CustomReturnType createComponent() {
      return new React4j_CustomReturnType();
    }
  }
}
