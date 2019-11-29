package com.example.prop_validate;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.React4jProcessor")
final class FloatPropValidateBuilder {
  private FloatPropValidateBuilder() {
  }

  @Nonnull
  static ReactNode myProp(final float myProp) {
    return new Builder().myProp( myProp );
  }

  public interface Step1 {
    @Nonnull
    ReactNode myProp(float myProp);
  }

  private static class Builder implements Step1 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_FloatPropValidate.Factory.TYPE );

    @Override
    @Nonnull
    public final ReactNode myProp(final float myProp) {
      _element.props().set( React4j_FloatPropValidate.Props.myProp, myProp );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}
