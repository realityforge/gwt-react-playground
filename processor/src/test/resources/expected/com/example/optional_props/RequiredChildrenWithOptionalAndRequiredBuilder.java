package com.example.optional_props;

import elemental2.core.JsArray;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.core.React;
import react4j.core.ReactNode;

class RequiredChildrenWithOptionalAndRequiredBuilder {
  private RequiredChildrenWithOptionalAndRequiredBuilder() {
  }

  @Nonnull
  static Builder2 key(@Nonnull final String key) {
    return new Builder().key( key );
  }

  @Nonnull
  static Builder3 myRequiredProp(final String myRequiredProp) {
    return new Builder().myRequiredProp( myRequiredProp );
  }

  public interface Builder1 {
    @Nonnull
    Builder2 key(@Nonnull String key);
  }

  public interface Builder2 {
    @Nonnull
    Builder3 myRequiredProp(String myRequiredProp);
  }

  public interface Builder3 {
    @Nonnull
    Builder3 myProp(String myProp);

    @Nonnull
    ReactNode children(ReactNode... children);

    @Nonnull
    Builder4 child(@Nullable ReactNode child);
  }

  public interface Builder4 {
    @Nonnull
    ReactNode children(ReactNode... children);

    @Nonnull
    Builder4 child(@Nullable ReactNode child);

    @Nonnull
    ReactNode build();
  }

  private static class Builder implements Builder1, Builder2, Builder3, Builder4 {
    private final JsPropertyMap<Object> _props = JsPropertyMap.of();

    private final JsArray<ReactNode> _children = new JsArray<>();

    @Override
    @Nonnull
    public final Builder2 key(@Nonnull final String key) {
      _props.set( "key", Objects.requireNonNull( key ) );
      return this;
    }

    @Override
    @Nonnull
    public final Builder3 myRequiredProp(final String myRequiredProp) {
      _props.set( "myRequiredProp", myRequiredProp );
      return this;
    }

    @Override
    @Nonnull
    public final Builder3 myProp(final String myProp) {
      _props.set( "myProp", myProp );
      return this;
    }

    @Override
    @Nonnull
    public final ReactNode children(final ReactNode... children) {
      for ( final ReactNode child : children ) {
        child( child );
      }
      return build();
    }

    @Override
    @Nonnull
    public final Builder4 child(@Nullable final ReactNode child) {
      if ( null != child ) {
        _children.push( child );
      }
      return this;
    }

    @Nonnull
    public final ReactNode build() {
      return React.createElement( RequiredChildrenWithOptionalAndRequired_.TYPE, Js.uncheckedCast( _props ), _children );
    }
  }
}
