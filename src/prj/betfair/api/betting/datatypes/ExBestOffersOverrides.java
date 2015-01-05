package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.ExBestOffersOverrides;
import prj.betfair.api.betting.datatypes.SimpleTypes.RollupModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Options to alter the default representation of best offer prices
 */
@JsonDeserialize(builder = ExBestOffersOverrides.Builder.class)
public class ExBestOffersOverrides {
  private final int rollupLimit;
  private final RollupModel rollupModel;
  private final double rollupLiabilityThreshold;
  private final int bestPricesDepth;
  private final int rollupLiabilityFactor;

  public ExBestOffersOverrides(Builder builder) {
    this.rollupLimit = builder.rollupLimit;
    this.rollupModel = builder.rollupModel;
    this.rollupLiabilityThreshold = builder.rollupLiabilityThreshold;
    this.bestPricesDepth = builder.bestPricesDepth;
    this.rollupLiabilityFactor = builder.rollupLiabilityFactor;
  }

  /**
   * @return bestPricesDepth The maximum number of prices to return on each side for each runner. If
   *         unspecified defaults to 3.
   */
  public int getBestPricesDepth() {
    return this.bestPricesDepth;
  }

  /**
   * @return rollupModel The model to use when rolling up available sizes. If unspecified defaults
   *         to STAKE rollup model with rollupLimit of minimum stake in the specified currency.
   */
  public RollupModel getRollupModel() {
    return this.rollupModel;
  }

  /**
   * @return rollupLimit The volume limit to use when rolling up returned sizes. The exact
   *         definition of the limit depends on the rollupModel. If no limit is provided it will use
   *         minimum stake as default the value. Ignored if no rollup model is specified.
   */
  public int getRollupLimit() {
    return this.rollupLimit;
  }

  /**
   * @return rollupLiabilityThreshold Only applicable when rollupModel is MANAGED_LIABILITY. The
   *         rollup model switches from being stake based to liability based at the smallest lay
   *         price which is {@literal >}= rollupLiabilityThreshold.service level default (TBD). Not
   *         supported as yet.
   */
  public double getRollupLiabilityThreshold() {
    return this.rollupLiabilityThreshold;
  }

  /**
   * @return rollupLiabilityFactor Only applicable when rollupModel is MANAGED_LIABILITY.
   *         (rollupLiabilityFactor * rollupLimit) is the minimum liabilty the user is deemed to be
   *         comfortable with. After the rollupLiabilityThreshold price subsequent volumes will be
   *         rolled up to minimum value such that the liability {@literal >}= the minimum
   *         liability.service level default (5). Not supported as yet.
   */
  public int getRollupLiabilityFactor() {
    return this.rollupLiabilityFactor;
  }

  public static class Builder {
    private int rollupLimit;
    private RollupModel rollupModel;
    private double rollupLiabilityThreshold;
    private int bestPricesDepth;
    private int rollupLiabilityFactor;

    public Builder() {}

    /**
     * Use this function to set bestPricesDepth
     * 
     * @param bestPricesDepth The maximum number of prices to return on each side for each runner.
     *        If unspecified defaults to 3.
     * @return Builder
     */
    public Builder withBestPricesDepth(int bestPricesDepth) {
      this.bestPricesDepth = bestPricesDepth;
      return this;
    }

    /**
     * Use this function to set rollupModel
     * 
     * @param rollupModel The model to use when rolling up available sizes. If unspecified defaults
     *        to STAKE rollup model with rollupLimit of minimum stake in the specified currency.
     * @return Builder
     */
    public Builder withRollupModel(RollupModel rollupModel) {
      this.rollupModel = rollupModel;
      return this;
    }

    /**
     * Use this function to set rollupLimit
     * 
     * @param rollupLimit The volume limit to use when rolling up returned sizes. The exact
     *        definition of the limit depends on the rollupModel. If no limit is provided it will
     *        use minimum stake as default the value. Ignored if no rollup model is specified.
     * @return Builder
     */
    public Builder withRollupLimit(int rollupLimit) {
      this.rollupLimit = rollupLimit;
      return this;
    }

    /**
     * Use this function to set rollupLiabilityThreshold
     * 
     * @param rollupLiabilityThreshold Only applicable when rollupModel is MANAGED_LIABILITY. The
     *        rollup model switches from being stake based to liability based at the smallest lay
     *        price which is {@literal >}= rollupLiabilityThreshold.service level default (TBD). Not
     *        supported as yet.
     * @return Builder
     */
    public Builder withRollupLiabilityThreshold(double rollupLiabilityThreshold) {
      this.rollupLiabilityThreshold = rollupLiabilityThreshold;
      return this;
    }

    /**
     * Use this function to set rollupLiabilityFactor
     * 
     * @param rollupLiabilityFactor Only applicable when rollupModel is MANAGED_LIABILITY.
     *        (rollupLiabilityFactor * rollupLimit) is the minimum liabilty the user is deemed to be
     *        comfortable with. After the rollupLiabilityThreshold price subsequent volumes will be
     *        rolled up to minimum value such that the liability {@literal >}= the minimum
     *        liability.service level default (5). Not supported as yet.
     * @return Builder
     */
    public Builder withRollupLiabilityFactor(int rollupLiabilityFactor) {
      this.rollupLiabilityFactor = rollupLiabilityFactor;
      return this;
    }

    public ExBestOffersOverrides build() {
      return new ExBestOffersOverrides(this);
    }
  }
}
