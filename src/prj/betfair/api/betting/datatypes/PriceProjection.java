package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.PriceProjection;
import prj.betfair.api.betting.datatypes.ExBestOffersOverrides;
import prj.betfair.api.betting.datatypes.SimpleTypes.PriceData;
import java.util.HashSet;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Selection criteria of the returning price data
 */
@JsonDeserialize(builder = PriceProjection.Builder.class)
public class PriceProjection {
  private final boolean virtualise;
  private final boolean rolloverStakes;
  private final ExBestOffersOverrides exBestOffersOverrides;
  private final HashSet<PriceData> priceData;

  public PriceProjection(Builder builder) {
    this.virtualise = builder.virtualise;
    this.rolloverStakes = builder.rolloverStakes;
    this.exBestOffersOverrides = builder.exBestOffersOverrides;
    this.priceData = builder.priceData;
  }

  /**
   * @return priceData The basic price data you want to receive in the response.
   */
  public HashSet<PriceData> getPriceData() {
    return this.priceData;
  }

  /**
   * @return exBestOffersOverrides Options to alter the default representation of best offer prices
   *         Applicable to EX_BEST_OFFERS priceData selection
   */
  public ExBestOffersOverrides getExBestOffersOverrides() {
    return this.exBestOffersOverrides;
  }

  /**
   * @return virtualise Indicates if the returned prices should include virtual prices. Applicable
   *         to EX_BEST_OFFERS and EX_ALL_OFFERS priceData selections, default value is false.
   */
  public boolean getVirtualise() {
    return this.virtualise;
  }

  /**
   * @return rolloverStakes Indicates if the volume returned at each price point should be the
   *         absolute value or a cumulative sum of volumes available at the price and all better
   *         prices. If unspecified defaults to false. Applicable to EX_BEST_OFFERS and
   *         EX_ALL_OFFERS price projections. Not supported as yet.
   */
  public boolean getRolloverStakes() {
    return this.rolloverStakes;
  }

  public static class Builder {
    private boolean virtualise;
    private boolean rolloverStakes;
    private ExBestOffersOverrides exBestOffersOverrides;
    private HashSet<PriceData> priceData;

    public Builder() {}

    /**
     * Use this function to set priceData
     * 
     * @param priceData The basic price data you want to receive in the response.
     * @return Builder
     */
    public Builder withPriceData(HashSet<PriceData> priceData) {
      this.priceData = priceData;
      return this;
    }

    /**
     * Use this function to set exBestOffersOverrides
     * 
     * @param exBestOffersOverrides Options to alter the default representation of best offer prices
     *        Applicable to EX_BEST_OFFERS priceData selection
     * @return Builder
     */
    public Builder withExBestOffersOverrides(ExBestOffersOverrides exBestOffersOverrides) {
      this.exBestOffersOverrides = exBestOffersOverrides;
      return this;
    }

    /**
     * Use this function to set virtualise
     * 
     * @param virtualise Indicates if the returned prices should include virtual prices. Applicable
     *        to EX_BEST_OFFERS and EX_ALL_OFFERS priceData selections, default value is false.
     * @return Builder
     */
    public Builder withVirtualise(boolean virtualise) {
      this.virtualise = virtualise;
      return this;
    }

    /**
     * Use this function to set rolloverStakes
     * 
     * @param rolloverStakes Indicates if the volume returned at each price point should be the
     *        absolute value or a cumulative sum of volumes available at the price and all better
     *        prices. If unspecified defaults to false. Applicable to EX_BEST_OFFERS and
     *        EX_ALL_OFFERS price projections. Not supported as yet.
     * @return Builder
     */
    public Builder withRolloverStakes(boolean rolloverStakes) {
      this.rolloverStakes = rolloverStakes;
      return this;
    }

    public PriceProjection build() {
      return new PriceProjection(this);
    }
  }
}
