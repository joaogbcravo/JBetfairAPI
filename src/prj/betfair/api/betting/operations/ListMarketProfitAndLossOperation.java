package prj.betfair.api.betting.operations;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.datatypes.MarketProfitAndLoss;
import prj.betfair.api.betting.exceptions.APINGException;

/***
 * Retrieve profit and loss for a given list of markets. The values are calculated using matched
 * bets and optionally settled bets. Only odds markets are implemented, markets of other types are
 * silently ignored.
 */
public class ListMarketProfitAndLossOperation {
  private final boolean netOfCommission;
  private final Executor executor;
  private final boolean includeBspBets;
  private final boolean includeSettledBets;
  private final Set<String> marketIds;

  public ListMarketProfitAndLossOperation(Builder builder) {
    this.netOfCommission = builder.netOfCommission;
    this.executor = builder.executor;
    this.includeBspBets = builder.includeBspBets;
    this.includeSettledBets = builder.includeSettledBets;
    this.marketIds = builder.marketIds;
  }

  /**
   * @return marketIds List of markets to calculate profit and loss
   */
  public Set<String> getMarketIds() {
    return this.marketIds;
  }

  /**
   * @return includeSettledBets Option to include settled bets (partially settled markets only).
   *         Defaults to false if not specified.
   */
  public boolean getIncludeSettledBets() {
    return this.includeSettledBets;
  }

  /**
   * @return includeBspBets Option to include BSP bets. Defaults to false if not specified.
   */
  public boolean getIncludeBspBets() {
    return this.includeBspBets;
  }

  /**
   * @return netOfCommission Option to return profit and loss net of users current commission rate
   *         for this market including any special tariffs. Defaults to false if not specified.
   */
  public boolean getNetOfCommission() {
    return this.netOfCommission;
  }

  public List<MarketProfitAndLoss> execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private boolean netOfCommission;
    private boolean includeBspBets;
    private boolean includeSettledBets;
    private Set<String> marketIds;
    private Executor executor;

    /**
     * @param marketIds : List of markets to calculate profit and loss
     */
    public Builder(@JsonProperty("marketIds") Set<String> marketIds) {
      this.marketIds = marketIds;
    }

    /**
     * @param executor Executor for this operation
     * @return Builder
     */
    public Builder withExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    public ListMarketProfitAndLossOperation build() {
      return new ListMarketProfitAndLossOperation(this);
    }
  }

}
