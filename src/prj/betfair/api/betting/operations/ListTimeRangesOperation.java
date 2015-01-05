package prj.betfair.api.betting.operations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.datatypes.MarketFilter;
import prj.betfair.api.betting.datatypes.SimpleTypes.TimeGranularity;
import prj.betfair.api.betting.datatypes.TimeRangeResult;
import prj.betfair.api.betting.exceptions.APINGException;

/***
 * Returns a list of time ranges in the granularity specified in the request (i.e. 3PM to 4PM, Aug
 * 14th to Aug 15th) associated with the markets selected by the MarketFilter.
 */
public class ListTimeRangesOperation {
  private final MarketFilter filter;
  private final TimeGranularity granularity;
  private final Executor executor;

  public ListTimeRangesOperation(Builder builder) {
    this.filter = builder.filter;
    this.granularity = builder.granularity;
    this.executor = builder.executor;
  }

  /**
   * @return filter The filter to select desired markets. All markets that match the criteria in the
   *         filter are selected.
   */
  public MarketFilter getFilter() {
    return this.filter;
  }

  /**
   * @return granularity The granularity of time periods that correspond to markets selected by the
   *         market filter.
   */
  public TimeGranularity getGranularity() {
    return this.granularity;
  }

  public List<TimeRangeResult> execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private MarketFilter filter;
    private TimeGranularity granularity;
    private Executor executor;

    /**
     * @param filter : The filter to select desired markets. All markets that match the criteria in
     *        the filter are selected.
     * @param granularity : The granularity of time periods that correspond to markets selected by
     *        the market filter.
     */
    public Builder(@JsonProperty("filter") MarketFilter filter,
        @JsonProperty("granularity") TimeGranularity granularity) {
      this.filter = filter;
      this.granularity = granularity;
    }

    /**
     * @param executor Executor for this operation
     * @return Builder
     */
    public Builder withExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    public ListTimeRangesOperation build() {
      return new ListTimeRangesOperation(this);
    }
  }

}
