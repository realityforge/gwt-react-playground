---
title: Frequently Asked Questions
---
<nav class="page-toc">

<!-- toc -->

- [Design](#design)
  * [Will React4j work on future versions of GWT?](#will-react4j-work-on-future-versions-of-gwt)
  * [Where is the equivalent of React's stateless function components?](#where-is-the-equivalent-of-reacts-stateless-function-components)
  * [Why is there both NativeComponent and Component classes?](#why-is-there-both-nativecomponent-and-component-classes)
  * [Why does React4j manually export types to Javascript?](#why-does-react4j-manually-export-types-to-javascript)
- [Arez Integration](#arez-integration)
  * [Which components should extend ReactArezComponent?](#which-components-should-extend-reactarezcomponent)
  * [Should components implement custom shouldComponentUpdate() method?](#should-components-implement-custom-shouldcomponentupdate-method)
  * [Why is there an 'arez' key in component state?](#why-is-there-an-arez-key-in-component-state)
  * [Why can't render methods update observable state?](#why-cant-render-methods-update-observable-state)

<!-- tocstop -->

</nav>

## Design

### Will React4j work on future versions of GWT?

React4j was designed from the ground up to be as forward compatible as possible with future
versions of GWT. Google is currently working on [J2CL](https://github.com/google/j2cl) (Java 2
Closure Compiler) which is a modern take on a java-to-javascript transpiler that emits Closure
Compiler annotated javascript as output. This promises a modern take on the story with an even
more advanced optimizing compiler working in the background. Every React4j build is also tested
against J2CL.

### Where is the equivalent of React's stateless function components?

The project originally supported stateless functional components defined by an interface that had
a single render method. You could define the rendering of the method using a simple lambda method
that accepted a `props` object. This resulted in code that looked like:

```java
class MyComponent {
  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
  static class Props extends BaseProps {
    int param;
  }

  @View
  public static final StatelessComponent<Props> COMPONENT = (props) -> {
    return span(new HtmlProps().className("myclass"), String.valueOf( props.param ));
  };
}
```

Contrast this with code that uses normal components:

```java
@View
class MyComponent extends Component<MyComponent.Props, BaseState> {
  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
  static class Props extends BaseProps {
    int param;
  }

  public ReactElement<?, ?> render() {
    return span(new HtmlProps().className("myclass"), String.valueOf( props.param ));
  };
}
```

In java, the `StatelessComponent` approach seemed to offer few advantages. The two approaches were
roughly equal in the amount of ceremony required and identical from a performance standpoint. However the
`StatelessComponent` approach required more work if you needed to refactor the components later to add state,
or use the lifecycle callback methods.

So we removed `StatelessComponent` and simplified our application, the library and supporting tools. (The
annotation processor is significantly simpler as a result of this change.)

The react team has promised that at some point in the future, stateless functional components will have a
better performance profile due to lower memory usage and low-level optimization opportunities within
the react runtime. When this eventuates, it will be reasonably easy for React4j to take advantage of these
enhancements with no changes to the way components are written. The annotation processor already analyzes
the component to determine if the component uses state or if any lifecycle methods are declared. If neither
of these conditions is true, React4j could transparently expose the component as a stateless functional
component and take advantage of the potential performance enhancements.

Actually it turns out that functional components should be slightly faster in React 16 as there's no
instance created to wrap them unlike in React 15. However this seems to be obscured by the slight overhead
of React4j but when/if the performance becomes more discernible, expect React4j to begin supporting stateless
functional components.

It should be noted that a month or two after we had made this decision the article
["7 Reasons to Outlaw React’s Functional Components"](https://medium.freecodecamp.org/7-reasons-to-outlaw-reacts-functional-components-ff5b5ae09b7c)
was published and a similar sentiment arose in the Javascript community.

### Why is there both NativeComponent and Component classes?

The project initially required that React4j components all extend the equivalent of the `NativeComponent`
and thus React4j components had to be exported as javascript objects using the `@JsType(isNative = false)` annotation.
This model required that the developer was very aware of the constraints of developing classes that would be
exported as javascript. This often resulted in lots of code being annotated with either `@JsIgnore` or
`@SuppressWarnings("unusable-by-js")` to avoid warnings being generated by the GWT compiler. The developer
experience was less than optimal.

Building a parallel component hierarchy allowed us to remove the boilerplate and constraints required to export
a native object to javascript. It also made it possible to add additional validation to verify that the application
code interacts with the native react runtime correctly.

### Why does React4j manually export types to Javascript?

GWT has `@JsType(isNative = false)` and yet the framework does not use it. The main reason is that this
is not a use case that the J2CL/GWT compiler team want to support. `@JsType(isNative = false)` is intended to
be used to export classes for consumption by other javascript projects and requires that the consumers of
the library pass command line arguments to the compiler to control which parts of the framework is exported
to native javascript. React4j needs to export components in a particular shape so that the native javascript
library knows how to use the components. Turning off exports or excluding the wrong elements would result in
a broken library. As the J2CL/GWT team have taken a philosophical stance against controlling the
export of code inside `.gwt.xml`, there is a strong possibility that users of React4j could end up with broken
applications through incorrect build configuration.

To avoid this scenario impacting users of React4j, the library manually exports the components to native code.
Users of the library are free to use `@JsType(isNative = false)` and control it through the normal means but
this should not impact the correctness of the React4j <=> react integration. The amount of code that is manually
exported to Javascript has been minimized and is mostly restricted to the equivalent of static class properties
in ES6 and a constructor function.

## Arez Integration

**WARNING**: This section is no longer up to date. We hope to fix this in the medium term.

### Which components should extend ReactArezComponent?

Any component that uses arez observable properties or computed properties within the `render()` method should
extend `ReactArezComponent`. This ensures that the component is scheduled for re-render when the data changes.

Sometimes you want to share a generic component between projects and rather than passing arez reactive components
into the component and making the generic component extend `ReactArezComponent` you can instead pass in simple
values as props into the generic component. The container component will still extend `ReactArezComponent` and
will be re-rendered when the observable and/or computed properties change and will pass new props to the generic
component forcing it to re-render. This is slightly less optimized but allows you to create generic components
like `ToggleButton` rather than domain specific `TodoToggleAllButton`.

### Should components implement custom shouldComponentUpdate() method?

The `ReactArezComponent` class already implements an optimized `shouldComponentUpdate()` that will only trigger
a re-render if the dependent observable/computed properties have changed, the state has changed or a shallow
comparison of props produces no differences. In most scenarios, it is not necessary to override
`shouldComponentUpdate()` but if you **need** to override the method `shouldComponentUpdate()` then it is possible
however you should return true if `ReactArezComponent.hasRenderDepsChanged()` returns true to ensure integration
works as expected.

### Why is there an 'arez' key in component state?

Components that extend `ReactArezComponent` will automatically have a key `arez` set if the configuration
property `react4j.arez.store_arez_data_as_state` is set to `true`. This can be done manually or by inheriting
from the GWT module `react4j.arez.ReactArezDev`. The purpose of this is to give the developer a quick visual
indication of the direct arez dependencies of the `ReactArezComponent`. It began as a stop-gap measure until
a "Arez DevTools" tool was implemented but remained as people found it useful. This should NOT be enabled in
production code as updating the dependency information can cause a re-render of the component even though there
is no actual changes to the content rendered in the browser.

### Why can't render methods update observable state?

Arez has the concept of read-write and read-only transactions and observable state should only be modified in
read-write transactions. This is enforced in development mode and assertion failures will occur if you attempt
to modify observable state in a read-only transaction. The `render()` method is deliberately wrapped in a read-only
transaction.

The main reason for this is to disallow a render triggering further renders and to stop potentially long render
times as other observers react to changes in observable state. The underlying react library also considers this
pattern a very bad idea conceptually and performance-wise and likewise blocks calling `setState()` from within
the render method.
