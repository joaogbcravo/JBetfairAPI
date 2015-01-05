package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.StartingPrices;
import prj.betfair.api.betting.datatypes.PriceSize;
import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Information about the Betfair Starting Price. Only available in BSP markets
 */
@JsonDeserialize(builder = StartingPrices.Builder.class)
public class StartingPrices {
  private final double nearPrice;
  private final List<PriceSize> backStakeTaken;
  private final double farPrice;
  private final double actualSP;
  private final List<PriceSize> layLiabilityTaken;

  public StartingPrices(Builder builder) {
    this.nearPrice = builder.nearPrice;
    this.backStakeTaken = builder.backStakeTaken;
    this.farPrice = builder.farPrice;
    this.actualSP = builder.actualSP;
    this.layLiabilityTaken = builder.layLiabilityTaken;
  }

  /**
   * @return nearPrice What the starting price would be if the market was reconciled now taking into
   *         account the SP bets as well as unmatched exchange bets on the same selection in the
   *         exchange.
   */
  public double getNearPrice() {
    return this.nearPrice;
  }

  /**
   * @return farPrice What the starting price would be if the market was reconciled now taking into
   *         account only the currently place SP bets. The Far Price is not as complicated but not
   *         as accurate and only accounts for money on the exchange at SP.
   */
  public double getFarPrice() {
    return this.farPrice;
  }

  /**
   * @return backStakeTaken
   */
  public List<PriceSize> getBackStakeTaken() {
    return this.backStakeTaken;
  }

  /**
   * @return layLiabilityTaken
   */
  public List<PriceSize> getLayLiabilityTaken() {
    return this.layLiabilityTaken;
  }

  /**
   * @return actualSP The final BSP price for this runner. Only available for a BSP market that has
   *         been reconciled.
   */
  public double getActualSP() {
    return this.actualSP;
  }

  public static class Builder {
    private double nearPrice;
    private List<PriceSize> backStakeTaken;
    private double farPrice;
    private double actualSP;
    private List<PriceSize> layLiabilityTaken;

    public Builder() {}

    /**
     * Use this function to set nearPrice
     * 
     * @param nearPrice What the starting price would be if the market was reconciled now taking
     *        into account the SP bets as well as unmatched exchange bets on the same selection in
     *        the exchange.
     * @return Builder
     */
    public Builder withNearPrice(double nearPrice) {
      this.nearPrice = nearPrice;
      return this;
    }

    /**
     * Use this function to set farPrice
     * 
     * @param farPrice What the starting price would be if the market was reconciled now taking into
     *        account only the currently place SP bets. The Far Price is not as complicated but not
     *        as accurate and only accounts for money on the exchange at SP.
     * @return Builder
     */
    public Builder withFarPrice(double farPrice) {
      this.farPrice = farPrice;
      return this;
    }

    /**
     * Use this function to set backStakeTaken
     * 
     * @param backStakeTaken
     * @return Builder
     */
    public Builder withBackStakeTaken(List<PriceSize> backStakeTaken) {
      this.backStakeTaken = backStakeTaken;
      return this;
    }

    /**
     * Use this function to set layLiabilityTaken
     * 
     * @param layLiabilityTaken
     * @return Builder
     */
    public Builder withLayLiabilityTaken(List<PriceSize> layLiabilityTaken) {
      this.layLiabilityTaken = layLiabilityTaken;
      return this;
    }

    /**
     * Use this function to set actualSP
     * 
     * @param actualSP The final BSP price for this runner. Only available for a BSP market that has
     *        been reconciled.
     * @return Builder
     */
    public Builder withActualSP(double actualSP) {
      this.actualSP = actualSP;
      return this;
    }

    public StartingPrices build() {
      return new StartingPrices(this);
    }
  }
}
