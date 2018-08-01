package com.example.prop;

import java.util.Collection;
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
class React4j_CollectionPropComponent extends CollectionPropComponent {
  static final ComponentConstructorFunction TYPE = getConstructorFunction();

  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = NativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "CollectionPropComponent" );
    }
    return componentConstructor;
  }

  @Override
  protected Collection<String> getMyProp() {
    return null != props().getAny( "myProp" ) ? props().getAny( "myProp" ).cast() : null;
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<CollectionPropComponent> {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected CollectionPropComponent createComponent() {
      return new React4j_CollectionPropComponent();
    }
  }
}
