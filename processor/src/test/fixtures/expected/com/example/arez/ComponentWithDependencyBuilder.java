package com.example.arez;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
final class ComponentWithDependencyBuilder {
  private ComponentWithDependencyBuilder() {
  }

  @Nonnull
  static Step2 value(final String value) {
    return new Builder().value( value );
  }

  public interface Step1 {
    @Nonnull
    Step2 value(String value);
  }

  public interface Step2 {
    @Nonnull
    ReactNode model(ComponentWithDependency.Model model);
  }

  private static class Builder implements Step1, Step2 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_ComponentWithDependency.Factory.TYPE );

    @Override
    @Nonnull
    public final Step2 value(final String value) {
      _element.props().set( React4j_ComponentWithDependency.Props.value, value );
      return this;
    }

    @Override
    @Nonnull
    public final ReactNode model(final ComponentWithDependency.Model model) {
      _element.props().set( React4j_ComponentWithDependency.Props.model, model );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}