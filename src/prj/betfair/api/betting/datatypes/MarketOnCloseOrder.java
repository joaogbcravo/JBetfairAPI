package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.MarketOnCloseOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Place a new MARKET_ON_CLOSE bet
 */
@JsonDeserialize(builder = MarketOnCloseOrder.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketOnCloseOrder {
  private final double liability;

  public MarketOnCloseOrder(Builder builder) {
    this.liability = builder.liability;
  }

  /**
   * @return liability The size of the bet.
   */
  public double getLiability() {
    return this.liability;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private double liability;

    /**
     * @param liability : The size of the bet.
     */
    public Builder(@JsonProperty("liability") double liability) {
      this.liability = liability;
    }

    public MarketOnCloseOrder build() {
      return new MarketOnCloseOrder(this);
    }
  }
}
