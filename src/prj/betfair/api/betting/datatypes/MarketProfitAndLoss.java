package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.MarketProfitAndLoss;
import prj.betfair.api.betting.datatypes.RunnerProfitAndLoss;
import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Profit and loss in a market
 */
@JsonDeserialize(builder = MarketProfitAndLoss.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketProfitAndLoss {
  private final double commissionApplied;
  private final List<RunnerProfitAndLoss> profitAndLosses;
  private final String marketId;

  public MarketProfitAndLoss(Builder builder) {
    this.commissionApplied = builder.commissionApplied;
    this.profitAndLosses = builder.profitAndLosses;
    this.marketId = builder.marketId;
  }

  /**
   * @return marketId The unique identifier for the market
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return commissionApplied The commission rate applied to P{@literal &}L values. Only returned
   *         if netOfCommision option is requested
   */
  public double getCommissionApplied() {
    return this.commissionApplied;
  }

  /**
   * @return profitAndLosses Calculated profit and loss data.
   */
  public List<RunnerProfitAndLoss> getProfitAndLosses() {
    return this.profitAndLosses;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private double commissionApplied;
    private List<RunnerProfitAndLoss> profitAndLosses;
    private String marketId;

    public Builder() {}

    /**
     * Use this function to set marketId
     * 
     * @param marketId The unique identifier for the market
     * @return Builder
     */
    public Builder withMarketId(String marketId) {
      this.marketId = marketId;
      return this;
    }

    /**
     * Use this function to set commissionApplied
     * 
     * @param commissionApplied The commission rate applied to P{@literal &}L values. Only returned
     *        if netOfCommision option is requested
     * @return Builder
     */
    public Builder withCommissionApplied(double commissionApplied) {
      this.commissionApplied = commissionApplied;
      return this;
    }

    /**
     * Use this function to set profitAndLosses
     * 
     * @param profitAndLosses Calculated profit and loss data.
     * @return Builder
     */
    public Builder withProfitAndLosses(List<RunnerProfitAndLoss> profitAndLosses) {
      this.profitAndLosses = profitAndLosses;
      return this;
    }

    public MarketProfitAndLoss build() {
      return new MarketProfitAndLoss(this);
    }
  }
}
