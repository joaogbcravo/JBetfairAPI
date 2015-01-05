package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.MarketTypeResult;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * MarketType Result
 */
@JsonDeserialize(builder = MarketTypeResult.Builder.class)
public class MarketTypeResult {
  private final String marketType;
  private final int marketCount;

  public MarketTypeResult(Builder builder) {
    this.marketType = builder.marketType;
    this.marketCount = builder.marketCount;
  }

  /**
   * @return marketType Market Type
   */
  public String getMarketType() {
    return this.marketType;
  }

  /**
   * @return marketCount Count of markets associated with this marketType
   */
  public int getMarketCount() {
    return this.marketCount;
  }

  public static class Builder {
    private String marketType;
    private int marketCount;

    public Builder() {}

    /**
     * Use this function to set marketType
     * 
     * @param marketType Market Type
     * @return Builder
     */
    public Builder withMarketType(String marketType) {
      this.marketType = marketType;
      return this;
    }

    /**
     * Use this function to set marketCount
     * 
     * @param marketCount Count of markets associated with this marketType
     * @return Builder
     */
    public Builder withMarketCount(int marketCount) {
      this.marketCount = marketCount;
      return this;
    }

    public MarketTypeResult build() {
      return new MarketTypeResult(this);
    }
  }
}
