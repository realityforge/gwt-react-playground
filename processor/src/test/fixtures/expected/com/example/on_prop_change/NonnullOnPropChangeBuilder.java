package com.example.on_prop_change;

import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.React4jProcessor")
final class NonnullOnPropChangeBuilder {
  private NonnullOnPropChangeBuilder() {
  }

  @Nonnull
  private static Step1 newBuilder() {
    return new Builder();
  }

  @Nonnull
  static ReactNode myProp(@Nonnull final String myProp) {
    return newBuilder().myProp( myProp );
  }

  public interface Step1 {
    @Nonnull
    ReactNode myProp(@Nonnull String myProp);
  }

  private static class Builder implements Step1 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_NonnullOnPropChange.Factory.TYPE );

    @Override
    @Nonnull
    public final ReactNode myProp(@Nonnull final String myProp) {
      Objects.requireNonNull( myProp );
      _element.props().set( React4j_NonnullOnPropChange.Props.myProp, myProp );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}
