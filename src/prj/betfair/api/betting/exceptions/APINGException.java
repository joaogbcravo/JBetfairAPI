package prj.betfair.api.betting.exceptions;

@SuppressWarnings("serial")
public class APINGException extends Exception {
  public APINGException(String message) {
    super(message);
  }

  public APINGException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
