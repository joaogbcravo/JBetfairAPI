package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.TimeRange;
import prj.betfair.api.betting.datatypes.TimeRangeResult;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * TimeRange Result
 */
@JsonDeserialize(builder = TimeRangeResult.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeRangeResult {
  private final TimeRange timeRange;
  private final int marketCount;

  public TimeRangeResult(Builder builder) {
    this.timeRange = builder.timeRange;
    this.marketCount = builder.marketCount;
  }

  /**
   * @return timeRange TimeRange
   */
  public TimeRange getTimeRange() {
    return this.timeRange;
  }

  /**
   * @return marketCount Count of markets associated with this TimeRange
   */
  public int getMarketCount() {
    return this.marketCount;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private TimeRange timeRange;
    private int marketCount;

    public Builder() {}

    /**
     * Use this function to set timeRange
     * 
     * @param timeRange TimeRange
     * @return Builder
     */
    public Builder withTimeRange(TimeRange timeRange) {
      this.timeRange = timeRange;
      return this;
    }

    /**
     * Use this function to set marketCount
     * 
     * @param marketCount Count of markets associated with this TimeRange
     * @return Builder
     */
    public Builder withMarketCount(int marketCount) {
      this.marketCount = marketCount;
      return this;
    }

    public TimeRangeResult build() {
      return new TimeRangeResult(this);
    }
  }
}
