package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.CurrencyRate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Currency rate
 */
@JsonDeserialize(builder = CurrencyRate.Builder.class)
public class CurrencyRate {
  private final String currencyCode;
  private final double rate;

  public CurrencyRate(Builder builder) {
    this.currencyCode = builder.currencyCode;
    this.rate = builder.rate;
  }

  /**
   * @return currencyCode Three letter ISO 4217 code
   */
  public String getCurrencyCode() {
    return this.currencyCode;
  }

  /**
   * @return rate Exchange rate for the currency specified in the request
   */
  public double getRate() {
    return this.rate;
  }

  public static class Builder {
    private String currencyCode;
    private double rate;

    public Builder() {}
    
    public Builder withCurrencyCode(String currencyCode) {
      this.currencyCode = currencyCode;
      return this;
    }
    
    public Builder withRate(double rate) {
      this.rate = rate;
      return this;
    }

    public CurrencyRate build() {
      return new CurrencyRate(this);
    }
  }
}
