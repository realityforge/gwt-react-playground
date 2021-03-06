# Other void elements that should not have children: area, base, embed, hr, keygen, link, meta, param, track, wbr, menuitem
def dom_factory_types
  {
    'a' => { :prop_type => 'AnchorProps' },
    'article' => { :prop_type => 'HtmlProps' },
    'audio' => { :prop_type => 'AudioProps' },
    'br' => { :prop_type => 'HtmlProps', :children => false },
    'button' => { :prop_type => 'BtnProps' },
    'canvas' => { :prop_type => 'HtmlProps' },
    'caption' => { :prop_type => 'HtmlProps' },
    'col' => { :prop_type => 'ColProps', :children => false },
    'colgroup' => { :prop_type => 'HtmlProps' },
    'div' => { :prop_type => 'HtmlProps' },
    'footer' => { :prop_type => 'HtmlProps' },
    'form' => { :prop_type => 'FormProps' },
    'header' => { :prop_type => 'HtmlProps' },
    'h1' => { :prop_type => 'HtmlProps' },
    'h2' => { :prop_type => 'HtmlProps' },
    'h3' => { :prop_type => 'HtmlProps' },
    'h4' => { :prop_type => 'HtmlProps' },
    'h5' => { :prop_type => 'HtmlProps' },
    'h6' => { :prop_type => 'HtmlProps' },
    'i' => { :prop_type => 'HtmlProps' },
    'iframe' => { :prop_type => 'IFrameProps' },
    'img' => { :prop_type => 'ImgProps', :children => false },
    'input' => { :prop_type => 'InputProps', :children => false },
    'label' => { :prop_type => 'LabelProps' },
    'li' => { :prop_type => 'HtmlProps' },
    'ol' => { :prop_type => 'HtmlProps' },
    'option' => { :prop_type => 'OptionProps' },
    'optgroup' => { :prop_type => 'OptGroupProps' },
    'p' => { :prop_type => 'HtmlProps' },
    'span' => { :prop_type => 'HtmlProps' },
    'select' => { :prop_type => 'SelectProps' },
    'section' => { :prop_type => 'HtmlProps' },
    'strong' => { :prop_type => 'HtmlProps' },
    'source' => { :prop_type => 'SourceProps', :children => false },
    'table' => { :prop_type => 'HtmlProps' },
    'textarea' => { :prop_type => 'TextAreaProps', :children => false },
    'tbody' => { :prop_type => 'HtmlProps' },
    'td' => { :prop_type => 'TdProps' },
    'th' => { :prop_type => 'ThProps' },
    'thead' => { :prop_type => 'HtmlProps' },
    'tr' => { :prop_type => 'HtmlProps' },
    'ul' => { :prop_type => 'HtmlProps' }
  }
end

def generate_factory
  factories = dom_factory_types
  content = <<HEADER
package react4j.dom;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import react4j.ReactElement;
import react4j.ReactNode;
HEADER
  factories.values.collect { |v| v[:prop_type] }.sort.uniq.each do |prop_type|
    content += "import react4j.dom.proptypes.html.#{prop_type};\n"
  end

  content += <<HEADER

/**
 * DOM provides convenience wrappers around React.createElement for DOM components.
 */
@Generated( "GwtReact" )
public final class DOM
{
  private DOM()
  {
  }

  // Arbitrarily large value as the time will be clamped to the expiration time of the whole tree
  private static final int DEFAULT_TIME_TO_FALLBACK = 1000000000;

  @Nonnull
  public static ReactNode text( @Nonnull final String content )
  {
    return ReactNode.of( content );
  }

  @Nonnull
  public static ReactNode fragment( @Nullable final String key, @Nonnull final ReactNode... children )
  {
    return ReactElement.createFragment( key, children );
  }

  @Nonnull
  public static ReactNode fragment( @Nullable final String key, @Nonnull final Stream<? extends ReactNode> children )
  {
    return fragment( key, toArray( children ) );
  }

  @Nonnull
  public static ReactNode fragment( @Nonnull final ReactNode... children )
  {
    return fragment( null, children );
  }

  @Nonnull
  public static ReactNode fragment( @Nonnull final Stream<? extends ReactNode> children )
  {
    return fragment( null, children );
  }

  @Nonnull
  public static ReactNode suspense( @Nullable final String key,
                                    @Nullable final ReactNode fallback,
                                    final int maxTimeToFallback,
                                    @Nonnull final ReactNode... children )
  {
    return ReactElement.createSuspense( key, fallback, maxTimeToFallback, children );
  }

  @Nonnull
  public static ReactNode suspense( @Nullable final String key,
                                    @Nullable final ReactNode fallback,
                                    final int maxTimeToFallback,
                                    @Nonnull final Stream<? extends ReactNode> children )
  {
    return suspense( key, fallback, maxTimeToFallback, toArray( children ) );
  }

  @Nonnull
  public static ReactNode suspense( @Nullable final ReactNode fallback,
                                    final int maxTimeToFallback,
                                    @Nonnull final ReactNode... children )
  {
    return suspense( null, fallback, maxTimeToFallback, children );
  }

  @Nonnull
  public static ReactNode suspense( @Nullable final ReactNode fallback,
                                    final int maxTimeToFallback,
                                    @Nonnull final Stream<? extends ReactNode> children )
  {
    return suspense( null, fallback, maxTimeToFallback, children );
  }

  @Nonnull
  public static ReactNode suspense( @Nullable final String key,
                                    @Nullable final ReactNode fallback,
                                    @Nonnull final ReactNode... children )
  {
    return suspense( key, fallback, DEFAULT_TIME_TO_FALLBACK, children );
  }

  @Nonnull
  public static ReactNode suspense( @Nullable final String key,
                                    @Nullable final ReactNode fallback,
                                    @Nonnull final Stream<? extends ReactNode> children )
  {
    return suspense( key, fallback, DEFAULT_TIME_TO_FALLBACK, toArray( children ) );
  }

  @Nonnull
  public static ReactNode suspense( @Nullable final ReactNode fallback, @Nonnull final ReactNode... children )
  {
    return suspense( null, fallback, DEFAULT_TIME_TO_FALLBACK, children );
  }

  @Nonnull
  public static ReactNode suspense( @Nullable final ReactNode fallback,
                                    @Nonnull final Stream<? extends ReactNode> children )
  {
    return suspense( null, fallback, DEFAULT_TIME_TO_FALLBACK, toArray( children ) );
  }
HEADER
  factories.each_pair do |key, config|
    prop_type = config[:prop_type]
    children = config[:children].nil? ? true : !!config[:children]
    content += <<HEADER

  @Nonnull
  public static ReactNode #{key}()
  {
    return createElement( "#{key}", null, (ReactNode[]) null );
  }

  @Nonnull
  public static ReactNode #{key}( @Nonnull final #{prop_type} props )
  {
    return createElement( "#{key}", Js.asPropertyMap( props ), (ReactNode[]) null );
  }
HEADER

    if children
      content += <<HEADER

  @Nonnull
  public static ReactNode #{key}( @Nonnull final #{prop_type} props, @Nullable final ReactNode... children )
  {
    return createElement( "#{key}", Js.asPropertyMap( props ), children );
  }

  @Nonnull
  public static ReactNode #{key}( @Nullable final ReactNode... children )
  {
    return createElement( "#{key}", null, children );
  }

  @Nonnull
  public static ReactNode #{key}( @Nonnull final #{prop_type} props, @Nonnull final String content )
  {
    return createElement( "#{key}", Js.asPropertyMap( props ), text( content ) );
  }

  @Nonnull
  public static ReactNode #{key}( @Nonnull final String content )
  {
    return #{key}( ReactNode.of( content ) );
  }

  @Nonnull
  public static ReactNode #{key}( final byte content )
  {
    return #{key}( ReactNode.of( content ) );
  }

  @Nonnull
  public static ReactNode #{key}( final short content )
  {
    return #{key}( ReactNode.of( content ) );
  }

  @Nonnull
  public static ReactNode #{key}( final int content )
  {
    return #{key}( ReactNode.of( content ) );
  }

  @Nonnull
  public static ReactNode #{key}( final long content )
  {
    return #{key}( ReactNode.of( content ) );
  }

  @Nonnull
  public static ReactNode #{key}( final float content )
  {
    return #{key}( ReactNode.of( content ) );
  }

  @Nonnull
  public static ReactNode #{key}( final double content )
  {
    return #{key}( ReactNode.of( content ) );
  }

  @Nonnull
  public static ReactNode #{key}( @Nonnull final #{prop_type} props, @Nonnull final Stream<? extends ReactNode> children )
  {
    return #{key}( props, toArray( children ) );
  }

  @Nonnull
  public static ReactNode #{key}( @Nonnull final Stream<? extends ReactNode> children )
  {
    return #{key}( toArray( children ) );
  }
HEADER
    end
  end

  content += <<FOOTER

  /**
   * Create and return a new ReactElement of the given type with specified children.
   *
   * @param type     A HTML tag name (eg. 'div', 'span', etc)
   * @param props    The props to pass to the element.
   * @param children The child elements.
   * @return the created ReactElement
   */
  @Nonnull
  private static ReactElement createElement( @Nonnull final String type, @Nullable final JsPropertyMap<Object> props, @Nullable final ReactNode... children )
  {
    final JsPropertyMap<Object> actual = JsPropertyMap.of();
    String key = null;
    Object ref = null;
    if ( null != props )
    {
      key = props.has( "key" ) ? Js.asString( props.get( "key" ) ) : null;
      ref = props.has( "ref" ) ? props.get( "ref" ) : null;
      props.forEach( p -> {
        // In future we can probably remove this check when/if components are creating elements directly
        // and can thus guarantee that these keys are not part of props.
        if ( !p.equals( "key" ) && !p.equals( "ref" ) )
        {
          actual.set( p, props.get( p ) );
        }
      } );
    }
    // In a future iteration if we re-write the reconciler we should probably ensure that shape of ReactElement
    // is always consistent and is either null or always an array element.
    if ( null != children && children.length > 0 )
    {
      if ( 1 == children.length )
      {
        actual.set( "children", children[ 0 ] );
      }
      else
      {
        actual.set( "children", children );
      }
    }
    return ReactElement.createHostElement( type, key, ref, actual );
  }

  @Nonnull
  private static ReactNode[] toArray( @Nonnull final Stream<? extends ReactNode> children )
  {
    return Objects.requireNonNull( children ).toArray( ReactNode[]::new );
  }
}
FOOTER

  content
end

def generate_factory_source(project)
  base_source_dir = project._(:generated, :reactgen, :main, :java)
  desc 'Generate the dom factories'
  t = project.task('reactgen') do
    file = "#{base_source_dir}/react4j/dom/DOM.java"
    mkdir_p File.dirname(file)
    IO.write(file, generate_factory)
  end
  dir = project.file(base_source_dir => [t.name])

  project.compile.from dir
  project.iml.main_generated_source_directories << dir
end
