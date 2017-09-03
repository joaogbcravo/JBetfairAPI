package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.LimitOnCloseOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Place a new LIMIT_ON_CLOSE bet
 */
@JsonDeserialize(builder = LimitOnCloseOrder.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LimitOnCloseOrder {
  private final double liability;
  private final double price;

  public LimitOnCloseOrder(Builder builder) {
    this.liability = builder.liability;
    this.price = builder.price;
  }

  /**
   * @return liability The size of the bet.
   */
  public double getLiability() {
    return this.liability;
  }

  /**
   * @return price The limit price of the bet if LOC
   */
  public double getPrice() {
    return this.price;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private double liability;
    private double price;

    /**
     * @param liability : The size of the bet.
     * @param price : The limit price of the bet if LOC
     */
    public Builder(@JsonProperty("liability") double liability, @JsonProperty("price") double price) {
      this.liability = liability;
      this.price = price;
    }

    public LimitOnCloseOrder build() {
      return new LimitOnCloseOrder(this);
    }
  }
}
