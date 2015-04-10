package prj.betfair.api.betting.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.datatypes.APINGExceptionResult;

public class ExceptionDetail {
  private String exceptionname;
  private APINGExceptionResult apiNgException;

  public ExceptionDetail() {}

  public String getExceptionname() {
    return exceptionname;
  }

  public void setExceptionname(String exceptionName) {
    this.exceptionname = exceptionName;
  }

  public APINGExceptionResult getAPINGException() {
    return apiNgException;
  }

  @JsonProperty("APINGException")
  public void setAPINGException(APINGExceptionResult APINGException) {
    this.apiNgException = APINGException;
  }
  
  @JsonProperty("AccountAPINGException")
  public void setAccountAPINGException(APINGExceptionResult APINGException) {
    this.apiNgException = APINGException;
  }
}
