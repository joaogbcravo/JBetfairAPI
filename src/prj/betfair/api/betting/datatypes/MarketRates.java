package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.MarketRates;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Market Rates
 */
@JsonDeserialize(builder = MarketRates.Builder.class)
public class MarketRates {
  private final boolean discountAllowed;
  private final double marketBaseRate;

  public MarketRates(Builder builder) {
    this.discountAllowed = builder.discountAllowed;
    this.marketBaseRate = builder.marketBaseRate;
  }

  /**
   * @return marketBaseRate marketBaseRate
   */
  public double getMarketBaseRate() {
    return this.marketBaseRate;
  }

  /**
   * @return discountAllowed discountAllowed
   */
  public boolean getDiscountAllowed() {
    return this.discountAllowed;
  }

  public static class Builder {
    private boolean discountAllowed;
    private double marketBaseRate;

    /**
     * @param discountAllowed : discountAllowed
     * @param marketBaseRate : marketBaseRate
     */
    public Builder(@JsonProperty("discountAllowed") boolean discountAllowed,
        @JsonProperty("marketBaseRate") double marketBaseRate) {
      this.discountAllowed = discountAllowed;
      this.marketBaseRate = marketBaseRate;
    }

    public MarketRates build() {
      return new MarketRates(this);
    }
  }
}
