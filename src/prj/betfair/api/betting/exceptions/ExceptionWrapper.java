package prj.betfair.api.betting.exceptions;

public class ExceptionWrapper {
  private ExceptionDetail detail;
  private String faultCode;
  private String faultString;

  public ExceptionWrapper() {}

  public ExceptionDetail getDetail() {
    return detail;
  }

  public void setDetail(ExceptionDetail detail) {
    this.detail = detail;
  }

  public String getFaultCode() {
    return faultCode;
  }

  public void setFaultcode(String faultCode) {
    this.faultCode = faultCode;
  }

  public String getFaultString() {
    return faultString;
  }

  public void setFaultstring(String faultString) {
    this.faultString = faultString;
  }
}
