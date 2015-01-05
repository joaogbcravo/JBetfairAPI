package prj.betfair.api.login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ApplicationToken {
  private final String product;
  private final String token;
  private final String status;
  private final String error;

  @JsonCreator
  public ApplicationToken(@JsonProperty("product") String product,
      @JsonProperty("token") String token, @JsonProperty("status") String status,
      @JsonProperty("error") String error) {
    this.product = product;
    this.token = token;
    this.status = status;
    this.error = error;
  }

  /**
   * @return a string representation of the product
   */
  public String getProduct() {
    return product;
  }

  /**
   * @return the applicationToken retrieved at login
   */
  public String getToken() {
    return token;
  }

  /**
   * @return status of this token
   */
  public String getStatus() {
    return status;
  }

  /**
   * @return any error message retrieved at login
   */
  public String getError() {
    return error;
  }
}
