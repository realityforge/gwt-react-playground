package com.example.prop;

import arez.Disposable;
import arez.annotations.ArezComponent;
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

@ArezComponent(
    name = "ImplicitDisposableProp"
)
@Generated("react4j.processor.ReactProcessor")
abstract class React4j_ImplicitDisposableProp extends ImplicitDisposableProp {
  @Nonnull
  private static ComponentConstructorFunction getConstructorFunction() {
    final ComponentConstructorFunction componentConstructor = ( ReactConfig.shouldStoreDebugDataAsState() || ReactConfig.shouldValidatePropValues() ) ? NativeReactComponent::new : LiteNativeReactComponent::new;
    if ( ReactConfig.enableComponentNames() ) {
      Js.asPropertyMap( componentConstructor ).set( "displayName", "ImplicitDisposableProp" );
    }
    return componentConstructor;
  }

  @Override
  protected final boolean anyPropsDisposed() {
    final ImplicitDisposableProp.Model $$react4jv$$_getModel = getModel();
    if ( Disposable.isDisposed( $$react4jv$$_getModel ) ) {
      return true;
    }
    return false;
  }

  @Override
  protected ImplicitDisposableProp.Model getModel() {
    if ( ReactConfig.shouldCheckInvariants() ) {
      return null != props().getAny( Props.model ) ? props().getAny( Props.model ).cast() : null;
    } else {
      return Js.uncheckedCast( props().getAny( Props.model ) );
    }
  }

  void $$react4j$$_componentDidMount() {
    storeDebugDataAsState();
  }

  final void $$react4j$$_componentDidUpdate(@Nullable final JsPropertyMap<Object> prevProps) {
    storeDebugDataAsState();
  }

  final void $$react4j$$_componentWillUnmount() {
    Disposable.dispose( this );
  }

  @Override
  protected boolean shouldUpdateOnPropChanges(@Nonnull final JsPropertyMap<Object> nextProps) {
    if ( !Js.isTripleEqual( props().get( Props.model ), nextProps.get( Props.model ) ) ) {
      return true;
    }
    return false;
  }

  static final class Factory {
    static final ComponentConstructorFunction TYPE = getConstructorFunction();
  }

  static final class Props {
    static final String model = ReactConfig.shouldMinimizePropKeys() ? "a" : "model";
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "?"
  )
  interface LiteLifecycle {
    boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps);

    void componentWillUnmount();
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "?"
  )
  interface Lifecycle {
    void componentDidMount();

    boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps);

    void componentDidUpdate(@Nonnull JsPropertyMap<Object> prevProps);

    void componentWillUnmount();
  }

  private static final class LiteNativeReactComponent extends NativeAdapterComponent<ImplicitDisposableProp> implements LiteLifecycle {
    @JsConstructor
    LiteNativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ImplicitDisposableProp createComponent() {
      return new Arez_React4j_ImplicitDisposableProp();
    }

    @Override
    public final boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps) {
      return performShouldComponentUpdate( nextProps );
    }

    @Override
    public final void componentWillUnmount() {
      ((Arez_React4j_ImplicitDisposableProp) component() ).$$react4j$$_componentWillUnmount();
    }
  }

  private static final class NativeReactComponent extends NativeAdapterComponent<ImplicitDisposableProp> implements Lifecycle {
    @JsConstructor
    NativeReactComponent(@Nullable final JsPropertyMap<Object> props) {
      super( props );
    }

    @Override
    protected ImplicitDisposableProp createComponent() {
      return new Arez_React4j_ImplicitDisposableProp();
    }

    @Override
    public final void componentDidMount() {
      ((Arez_React4j_ImplicitDisposableProp) component() ).$$react4j$$_componentDidMount();
    }

    @Override
    public final boolean shouldComponentUpdate(@Nonnull JsPropertyMap<Object> nextProps) {
      return performShouldComponentUpdate( nextProps );
    }

    @Override
    public final void componentDidUpdate(@Nonnull JsPropertyMap<Object> prevProps) {
      ((Arez_React4j_ImplicitDisposableProp) component() ).$$react4j$$_componentDidUpdate( prevProps );
    }

    @Override
    public final void componentWillUnmount() {
      ((Arez_React4j_ImplicitDisposableProp) component() ).$$react4j$$_componentWillUnmount();
    }
  }
}
