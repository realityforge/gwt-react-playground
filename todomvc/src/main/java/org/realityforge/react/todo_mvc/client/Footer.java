package org.realityforge.react.todo_mvc.client;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.realityforge.react.todo_mvc.client.model.FilterMode;
import react.annotations.ReactComponent;
import react.core.BaseProps;
import react.core.ReactElement;
import react.core.StatelessComponent;
import react.dom.events.MouseEventHandler;
import react.dom.proptypes.html.AnchorProps;
import react.dom.proptypes.html.BtnProps;
import react.dom.proptypes.html.HtmlProps;
import static react.dom.DOM.*;

@ReactComponent
class Footer
  extends StatelessComponent<Footer.Props>
{
  @JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
  static class Props
    extends BaseProps
  {
    int count;
    int completedCount;
    FilterMode filterMode;
    MouseEventHandler onClearCompleted;

    @JsOverlay
    static Props create( @Nonnegative final int count,
                         @Nonnegative final int completedCount,
                         @Nonnull final FilterMode filterMode,
                         @Nonnull final MouseEventHandler onClearCompleted )
    {
      final Props props = new Props();
      props.count = count;
      props.completedCount = completedCount;
      props.filterMode = filterMode;
      props.onClearCompleted = onClearCompleted;
      return props;
    }
  }

  @Override
  protected ReactElement<?, ?> render()
  {
    final String activeTodoWord = "item" + ( props().count == 1 ? "" : "s" );
    final FilterMode filterMode = props().filterMode;
    return
      footer( new HtmlProps().className( "footer" ),
              span( new HtmlProps().className( "todo-count" ),
                    strong( Integer.toString( props().count ) ),
                    text(" " + activeTodoWord + " left")
              ),
              ul( new HtmlProps().className( "filters" ),
                  li( a( new AnchorProps()
                           .className( selected( FilterMode.ALL == filterMode ) )
                           .href( "#" ), "All" )
                  ),
                  li( a( new AnchorProps()
                           .className( selected( FilterMode.ACTIVE == filterMode ) )
                           .href( "#active" ), "Active" )
                  ),
                  li( a( new AnchorProps()
                           .className( selected( FilterMode.COMPLETED == filterMode ) )
                           .href( "#completed" ), "Completed" )
                  )
              ),
              buildClearButton( props() )
      );
  }

  @Nullable
  private ReactElement<?, ?> buildClearButton( @Nonnull final Props props )
  {
    if ( props.completedCount > 0 )
    {
      return button( new BtnProps().className( "clear-completed" ).onClick( props.onClearCompleted ),
                     "Clear Completed" );
    }
    else
    {
      return null;
    }
  }

  private static String selected( final boolean condition )
  {
    return condition ? "selected" : "";
  }
}
