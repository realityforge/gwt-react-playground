package com.example.inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import javax.annotation.Generated;
import javax.inject.Provider;
import react4j.Component;

@Generated("react4j.processor.ReactProcessor")
public interface BasicReactComponentDaggerFactory {
  DaggerSubcomponent getBasicReactComponentDaggerSubcomponent();

  default void bindBasicReactComponent() {
    React4j_BasicReactComponent.setProvider( () -> getBasicReactComponentDaggerSubcomponent().get() );
  }

  @Module
  interface DaggerModule {
    @Binds
    Component bindComponent(React4j_BasicReactComponent component);
  }

  @Subcomponent(
      modules = DaggerModule.class
  )
  interface DaggerSubcomponent {
    Provider<Component> createProvider();

    default BasicReactComponent get() {
      return (BasicReactComponent) createProvider().get();
    }
  }
}
