package com.example.prop;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
class ImmutablePropTypeBoxedLongBuilder {
  private ImmutablePropTypeBoxedLongBuilder() {
  }

  @Nonnull
  static ReactNode myProp(final Long myProp) {
    return new Builder().myProp( myProp );
  }

  public interface Step1 {
    @Nonnull
    ReactNode myProp(Long myProp);
  }

  private static class Builder implements Step1 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_ImmutablePropTypeBoxedLong.Factory.TYPE );

    @Override
    @Nonnull
    public final ReactNode myProp(final Long myProp) {
      _element.setKey( String.valueOf( myProp ) );
      _element.props().set( React4j_ImmutablePropTypeBoxedLong.Props.myProp, myProp );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}