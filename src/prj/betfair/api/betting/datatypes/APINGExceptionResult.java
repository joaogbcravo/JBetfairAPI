package prj.betfair.api.betting.datatypes;

public class APINGExceptionResult {
  private String errorCode;
  private String errorDetails;
  private String requestUUID;

  public APINGExceptionResult() {}

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorDetails() {
    return errorDetails;
  }

  public void setErrorDetails(String errorDetails) {
    this.errorDetails = errorDetails;
  }

  public String getRequestUUID() {
    return requestUUID;
  }

  public void setRequestUUID(String requestUUID) {
    this.requestUUID = requestUUID;
  }
}
