package com.example.prop;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
final class NonDisposableDisposablePropBuilder {
  private NonDisposableDisposablePropBuilder() {
  }

  @Nonnull
  static ReactNode model(final NonDisposableDisposableProp.Model model) {
    return new Builder().model( model );
  }

  public interface Step1 {
    @Nonnull
    ReactNode model(NonDisposableDisposableProp.Model model);
  }

  private static class Builder implements Step1 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_NonDisposableDisposableProp.Factory.TYPE );

    @Override
    @Nonnull
    public final ReactNode model(final NonDisposableDisposableProp.Model model) {
      _element.props().set( React4j_NonDisposableDisposableProp.Props.model, model );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}