package com.example.prop;

import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
class ImplicitDisposablePropBuilder {
  private ImplicitDisposablePropBuilder() {
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
  static ReactNode model(final ImplicitDisposableProp.Model model) {
    return new Builder().model( model );
  }

  public interface Builder1 {
    @Nonnull
    Builder2 key(@Nonnull String key);

    @Nonnull
    Builder2 key(@Nonnull int key);
  }

  public interface Builder2 {
    @Nonnull
    ReactNode model(ImplicitDisposableProp.Model model);
  }

  private static class Builder implements Builder1, Builder2 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_ImplicitDisposableProp.Factory.TYPE );

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
    public final ReactNode model(final ImplicitDisposableProp.Model model) {
      _element.props().set( React4j_ImplicitDisposableProp.Props.model, model );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      return _element;
    }
  }
}
