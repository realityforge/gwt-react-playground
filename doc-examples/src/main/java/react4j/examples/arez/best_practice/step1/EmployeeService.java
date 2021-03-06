package react4j.examples.arez.best_practice.step1;

import arez.annotations.Action;
import arez.annotations.ArezComponent;
import arez.annotations.Observable;

@ArezComponent
public abstract class EmployeeService
{
  private final RemoteServiceAPI _remote;
  private boolean _loading;
  private String _employeeData;
  private String _errorMessage;

  EmployeeService( final RemoteServiceAPI remote )
  {
    _remote = remote;
  }

  @Action
  public void changeToEmployeeView()
  {
    setLoading( true );
    _remote.loadEmployeeData( data -> {
      setLoading( false );
      setEmployeeData( data );
    }, errorMessage -> {
      setLoading( false );
      setErrorMessage( errorMessage );
    } );
  }

  @Observable
  public boolean isLoading()
  {
    return _loading;
  }

  public void setLoading( final boolean loading )
  {
    _loading = loading;
  }

  @Observable
  public String getEmployeeData()
  {
    return _employeeData;
  }

  public void setEmployeeData( final String employeeData )
  {
    _employeeData = employeeData;
  }

  @Observable
  public String getErrorMessage()
  {
    return _errorMessage;
  }

  public void setErrorMessage( final String errorMessage )
  {
    _errorMessage = errorMessage;
  }
}
