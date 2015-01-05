package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.ExchangePrices;
import prj.betfair.api.betting.datatypes.PriceSize;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ExchangePrices.Builder.class)
public class ExchangePrices {
  private final ArrayList<PriceSize> availableToBack;
  private final ArrayList<PriceSize> availableToLay;
  private final ArrayList<PriceSize> tradedVolume;

  public ExchangePrices(Builder builder) {
    this.availableToBack = builder.availableToBack;
    this.availableToLay = builder.availableToLay;
    this.tradedVolume = builder.tradedVolume;
  }

  /**
   * @return availableToBack
   */
  public ArrayList<PriceSize> getAvailableToBack() {
    return this.availableToBack;
  }

  /**
   * @return availableToLay
   */
  public ArrayList<PriceSize> getAvailableToLay() {
    return this.availableToLay;
  }

  /**
   * @return tradedVolume
   */
  public ArrayList<PriceSize> getTradedVolume() {
    return this.tradedVolume;
  }

  public static class Builder {
    private ArrayList<PriceSize> availableToBack;
    private ArrayList<PriceSize> availableToLay;
    private ArrayList<PriceSize> tradedVolume;

    public Builder() {}

    /**
     * Use this function to set availableToBack
     * 
     * @param availableToBack
     * @return Builder
     */
    public Builder withAvailableToBack(ArrayList<PriceSize> availableToBack) {
      this.availableToBack = availableToBack;
      return this;
    }

    /**
     * Use this function to set availableToLay
     * 
     * @param availableToLay
     * @return Builder
     */
    public Builder withAvailableToLay(ArrayList<PriceSize> availableToLay) {
      this.availableToLay = availableToLay;
      return this;
    }

    /**
     * Use this function to set tradedVolume
     * 
     * @param tradedVolume
     * @return Builder
     */
    public Builder withTradedVolume(ArrayList<PriceSize> tradedVolume) {
      this.tradedVolume = tradedVolume;
      return this;
    }

    public ExchangePrices build() {
      return new ExchangePrices(this);
    }
  }
}
