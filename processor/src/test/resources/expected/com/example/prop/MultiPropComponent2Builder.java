package com.example.prop;

import elemental2.core.JsArray;
import java.util.Objects;
import java.util.stream.Stream;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
class MultiPropComponent2Builder {
  private MultiPropComponent2Builder() {
  }

  @Nonnull
  static Builder2 key(@Nonnull final String key) {
    return new Builder().key( key );
  }

  @Nonnull
  static Builder2 key(final int key) {
    return new Builder().key( key );
  }

  @Nonnull
  static Builder3 myProp(final String myProp) {
    return new Builder().myProp( myProp );
  }

  public interface Builder1 {
    @Nonnull
    Builder2 key(@Nonnull String key);

    @Nonnull
    Builder2 key(@Nonnull int key);
  }

  public interface Builder2 {
    @Nonnull
    Builder3 myProp(String myProp);
  }

  public interface Builder3 {
    @Nonnull
    Builder4 myProp2(String myProp2);
  }

  public interface Builder4 {
    @Nonnull
    ReactNode children(ReactNode... children);

    @Nonnull
    ReactNode children(@Nonnull Stream<? extends ReactNode> children);

    @Nonnull
    ReactNode build();
  }

  private static class Builder implements Builder1, Builder2, Builder3, Builder4 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_MultiPropComponent2.Factory.TYPE );

    @Override
    @Nonnull
    public final Builder2 key(@Nonnull final String key) {
      _element.setKey( Objects.requireNonNull( key ) );
      return this;
    }

    @Override
    @Nonnull
    public final Builder2 key(@Nonnull final int key) {
      return key( String.valueOf( key ) );
    }

    @Override
    @Nonnull
    public final Builder3 myProp(final String myProp) {
      _element.props().set( React4j_MultiPropComponent2.Props.myProp, myProp );
      return this;
    }

    @Override
    @Nonnull
    public final Builder4 myProp2(final String myProp2) {
      _element.props().set( React4j_MultiPropComponent2.Props.myProp2, myProp2 );
      return this;
    }

    @Override
    @Nonnull
    public final ReactNode children(final ReactNode... children) {
      _element.props().set( React4j_MultiPropComponent2.Props.children, JsArray.of( children ) );
      return build();
    }

    @Override
    @Nonnull
    public final ReactNode children(@Nonnull final Stream<? extends ReactNode> children) {
      children( children.toArray( ReactNode[]::new ) );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      return _element;
    }
  }
}
