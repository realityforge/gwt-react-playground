package gwt.react.client.api;
/* The MIT License (MIT)

Copyright (c) 2016 GWT React

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. */

import gwt.interop.utils.client.plainobjects.JsPlainObj;
import gwt.interop.utils.shared.collections.Array;
import gwt.react.client.components.Component;
import gwt.react.client.components.ComponentConstructorFn;
import gwt.react.client.components.ComponentUtils;
import gwt.react.client.components.PureComponent;
import gwt.react.client.components.StatelessComponent;
import gwt.react.client.elements.DOMElement;
import gwt.react.client.elements.ReactElement;
import gwt.react.client.elements.ReactElementChildren;
import gwt.react.client.proptypes.BaseProps;
import gwt.react.client.proptypes.html.AnchorProps;
import gwt.react.client.proptypes.html.AudioProps;
import gwt.react.client.proptypes.html.BtnProps;
import gwt.react.client.proptypes.html.ColProps;
import gwt.react.client.proptypes.html.FormProps;
import gwt.react.client.proptypes.html.HtmlProps;
import gwt.react.client.proptypes.html.IFrameProps;
import gwt.react.client.proptypes.html.ImgProps;
import gwt.react.client.proptypes.html.InputProps;
import gwt.react.client.proptypes.html.LabelProps;
import gwt.react.client.proptypes.html.OptGroupProps;
import gwt.react.client.proptypes.html.OptionProps;
import gwt.react.client.proptypes.html.SelectProps;
import gwt.react.client.proptypes.html.SourceProps;
import gwt.react.client.proptypes.html.TdProps;
import gwt.react.client.proptypes.html.TextAreaProps;
import gwt.react.client.proptypes.html.ThProps;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public class React
{
  /**
   * This is a static class.
   */
  private React()
  {
  }

  /**
   * <p>Create and return a new ReactElement of the given type.
   *
   * @param type  a HTML tag name (eg. 'div', 'span', etc)
   * @param props the props to pass to the element
   * @return a {@link DOMElement}
   */
  public static native <P extends HtmlProps> DOMElement<P> createElement( String type, P props );

  public static native <P extends HtmlProps> DOMElement<P> createElement( String type, P props, String value );

  public static native <P extends HtmlProps> DOMElement<P> createElement( String type,
                                                                          P props,
                                                                          ReactElement<?, ?>... child );

  /**
   * Create and return a new ReactElement of the given type.
   *
   * @param type  a ReactClass (created via React.createClass).
   * @param props the props to pass to the element
   * @return a {@link ReactElement}
   */

  //Create Stateless Components
  public static native <P extends BaseProps> ReactElement<P, StatelessComponent<P>> createElement( StatelessComponent<P> type,
                                                                                                   P props );

  public static native <P extends BaseProps> ReactElement<P, StatelessComponent<P>> createElement( StatelessComponent<P> type,
                                                                                                   P props,
                                                                                                   String value );

  public static native <P extends BaseProps> ReactElement<P, StatelessComponent<P>> createElement( StatelessComponent<P> type,
                                                                                                   P props,
                                                                                                   ReactElement<?, ?>... child );

  //Create ES6 Components

  /**
   * <p>Create and return a new {@link ReactElement} for the provided React component class.</p>
   *
   * <p>Note that calling this method will have undefined results in the following circumstances:</p>
   *
   * <p>1) when invoked for Java classes that are not exported to JavaScript via {@link JsType}</p>
   * <p>2) with Java classes exported to JavaScript under a different name (i.e. when the class was renamed using the 'namespace' and/or 'name' attributes
   * of the {@link JsType} annotation)</p>
   * <p>3) When class data is disabled when building</p>
   *
   * @param type  the {@link Class} object of a React component extending {@link Component} or {@link PureComponent}
   * @param props the props to pass to the element
   * @return a {@link ReactElement}
   */
  @JsOverlay
  public static <P extends BaseProps, S extends JsPlainObj, T extends Component<P, S>> ReactElement<P, T> createElement(
    Class<T> type,
    P props )
  {
    return createElement( ComponentUtils.getCtorFn( type ), props );
  }

  @JsOverlay
  public static <P extends BaseProps, S extends JsPlainObj, T extends Component<P, S>> ReactElement<P, T> createElement(
    Class<T> type,
    P props,
    String value )
  {
    return createElement( ComponentUtils.getCtorFn( type ), props, value );
  }

  @JsOverlay
  public static <P extends BaseProps, S extends JsPlainObj, T extends Component<P, S>> ReactElement<P, T> createElement(
    Class<T> type,
    P props,
    ReactElement<?, ?>... child )
  {
    return createElement( ComponentUtils.getCtorFn( type ), props, child );
  }

  public static native <P extends BaseProps, S extends JsPlainObj, T extends Component<P, S>> ReactElement<P, T> createElement(
    ComponentConstructorFn<P> type,
    P props );

  public static native <P extends BaseProps, S extends JsPlainObj, T extends Component<P, S>> ReactElement<P, T> createElement(
    ComponentConstructorFn<P> type,
    P props,
    String value );

  public static native <P extends BaseProps, S extends JsPlainObj, T extends Component<P, S>> ReactElement<P, T> createElement(
    ComponentConstructorFn<P> type,
    P props,
    ReactElement<?, ?>... child );

  /**
   * <p>Clone and return a new ReactElement using element as the starting point. The resulting
   * element will have the original element's props with the new props merged in shallowly.
   * New children will replace existing children. Unlike React.addons.cloneWithProps, key and
   * ref from the original element will be preserved. There is no special behavior for merging
   * any props (unlike cloneWithProps). See the v0.13 RC2 blog post for additional details.</p>
   *
   * @param element the element to clone
   * @param props   the props to merge
   * @return the cloned element
   */
  public static native <P extends BaseProps, T> ReactElement<P, T> cloneElement( ReactElement<P, T> element,
                                                                                 JsPlainObj props );

  public static native boolean isValidElement( Object object );

  /**
   * React.DOM provides convenience wrappers around React.createElement for DOM components.
   * For example React.DOM.div(null, 'Hello World!')
   */
  @JsType( isNative = true )
  public static class DOM
  {
    /**
     * This is a static class.
     */
    private DOM()
    {
    }

    public static native DOMElement<HtmlProps> a( AnchorProps props, String value );

    public static native DOMElement<HtmlProps> a( AnchorProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> article( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> audio( AudioProps props, ReactElement<?, ?>... child );

    public static native DOMElement<BtnProps> br( HtmlProps props );

    public static native DOMElement<BtnProps> br();

    public static native DOMElement<BtnProps> button( BtnProps props );

    public static native DOMElement<BtnProps> button( BtnProps props, String value );

    public static native DOMElement<BtnProps> canvas( HtmlProps props );

    public static native DOMElement<HtmlProps> caption( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> caption( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> col( ColProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> colgroup( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> div( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> div( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> footer( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> form( FormProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> header( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> h1( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> h2( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> h3( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> h4( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> h5( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> h6( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> iframe( IFrameProps props );

    public static native DOMElement<HtmlProps> img( ImgProps props );

    public static native DOMElement<HtmlProps> input( InputProps props );

    public static native DOMElement<HtmlProps> label( LabelProps props, String value );

    public static native DOMElement<HtmlProps> li( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> li( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> ol( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> option( OptionProps props, String value );

    public static native DOMElement<HtmlProps> optgroup( OptGroupProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> p( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> p( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> span( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> span( HtmlProps props, ReactElement<?, ?> child1 );

    public static native DOMElement<HtmlProps> span( HtmlProps props, ReactElement<?, ?> child1, String value );

    public static native DOMElement<HtmlProps> select( SelectProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> section( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> strong( HtmlProps props, String value );

    public static native DOMElement<HtmlProps> source( SourceProps props );

    public static native DOMElement<HtmlProps> table( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> textarea( TextAreaProps props );

    public static native DOMElement<HtmlProps> td( TdProps props, String value );

    public static native DOMElement<HtmlProps> td( TdProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> th( ThProps props, String value );

    public static native DOMElement<HtmlProps> th( ThProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> tr( HtmlProps props, ReactElement<?, ?>... child );

    public static native DOMElement<HtmlProps> ul( HtmlProps props, ReactElement<?, ?>... child );
  }

  /**
   * React.Children provides utilities for dealing with the this.props.children opaque data
   * structure.
   */
  @JsType( isNative = true )
  public static class Children
  {
    /**
     * This is a static class.
     */
    private Children()
    {
    }

    /**
     * Invoke fn on every immediate child contained within children. If children is a nested
     * object or array it will be traversed: fn will never be passed the container objects.
     * If children is null returns null rather than an array.
     *
     * @param children The opaque children structure to iterate over
     * @param Fn       The function to execute
     * @return An Array of child ReactElements
     */
    public static native Array<ReactElement<?, ?>> map( ReactElementChildren children,
                                                        ChildrenMapFn Fn ); // Object thisArg);

    /**
     * Like React.Children.map() but does not return an array.
     *
     * @param children The opaque children structure to iterate over
     * @param fn       The function to execute
     */
    public static native void forEach( ReactElementChildren children, ChildrenForEachFn fn ); // [, object thisArg]);

    /**
     * Return the total number of components in children, equal to the number of times that a
     * callback passed to map or forEach would be invoked.
     *
     * @param children The opaque children structure to count
     * @return the number of child components
     */
    public static native int count( ReactElementChildren children );

    /**
     * Return the only child in children. Throws otherwise.
     *
     * @param children The opaque children structure to access
     * @return the first and only child. Throws an exception if more than one exis
     */
    public static native ReactElement<?, ?> only( ReactElementChildren children );

    /**
     * Return the children opaque data structure as a flat array with keys assigned to
     * each child. Useful if you want to manipulate collections of children in your render
     * methods, especially if you want to reorder or slice this.props.children before passing
     * it down.
     *
     * @param children The opaque children structure to iterate over
     * @return a {@link Array} of {@link ReactElement}
     */
    public static native Array<ReactElement<?, ?>> toArray( ReactElementChildren children );
  }
}
