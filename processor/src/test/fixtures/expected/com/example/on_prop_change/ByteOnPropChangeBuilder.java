package com.example.on_prop_change;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import react4j.ReactElement;
import react4j.ReactNode;

@Generated("react4j.processor.ReactProcessor")
final class ByteOnPropChangeBuilder {
  private ByteOnPropChangeBuilder() {
  }

  @Nonnull
  static ReactNode myProp(final byte myProp) {
    return new Builder().myProp( myProp );
  }

  public interface Step1 {
    @Nonnull
    ReactNode myProp(byte myProp);
  }

  private static class Builder implements Step1 {
    private final ReactElement _element = ReactElement.createComponentElement( React4j_ByteOnPropChange.Factory.TYPE );

    @Override
    @Nonnull
    public final ReactNode myProp(final byte myProp) {
      _element.props().set( React4j_ByteOnPropChange.Props.myProp, myProp );
      return build();
    }

    @Nonnull
    public final ReactNode build() {
      _element.complete();
      return _element;
    }
  }
}