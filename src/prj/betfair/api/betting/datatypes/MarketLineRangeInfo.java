package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.MarketLineRangeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Market Line and Range Info
 */
@JsonDeserialize(builder = MarketLineRangeInfo.Builder.class)
public class MarketLineRangeInfo {
  private final String marketUnit;
  private final double interval;
  private final double minUnitValue;
  private final double maxUnitValue;

  public MarketLineRangeInfo(Builder builder) {
    this.marketUnit = builder.marketUnit;
    this.interval = builder.interval;
    this.minUnitValue = builder.minUnitValue;
    this.maxUnitValue = builder.maxUnitValue;
  }

  /**
   * @return maxUnitValue maxPrice
   */
  public double getMaxUnitValue() {
    return this.maxUnitValue;
  }

  /**
   * @return minUnitValue minPrice
   */
  public double getMinUnitValue() {
    return this.minUnitValue;
  }

  /**
   * @return interval interval
   */
  public double getInterval() {
    return this.interval;
  }

  /**
   * @return marketUnit unit
   */
  public String getMarketUnit() {
    return this.marketUnit;
  }

  public static class Builder {
    private String marketUnit;
    private double interval;
    private double minUnitValue;
    private double maxUnitValue;

    /**
     * @param marketUnit : unit
     * @param interval : interval
     * @param minUnitValue : minPrice
     * @param maxUnitValue : maxPrice
     */
    public Builder(@JsonProperty("marketUnit") String marketUnit,
        @JsonProperty("interval") double interval,
        @JsonProperty("minUnitValue") double minUnitValue,
        @JsonProperty("maxUnitValue") double maxUnitValue) {
      this.marketUnit = marketUnit;
      this.interval = interval;
      this.minUnitValue = minUnitValue;
      this.maxUnitValue = maxUnitValue;
    }

    public MarketLineRangeInfo build() {
      return new MarketLineRangeInfo(this);
    }
  }
}
