package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.ExchangePrices;
import prj.betfair.api.betting.datatypes.PriceSize;
import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ExchangePrices.Builder.class)
public class ExchangePrices {
  private final List<PriceSize> availableToBack;
  private final List<PriceSize> availableToLay;
  private final List<PriceSize> tradedVolume;

  public ExchangePrices(Builder builder) {
    this.availableToBack = builder.availableToBack;
    this.availableToLay = builder.availableToLay;
    this.tradedVolume = builder.tradedVolume;
  }

  /**
   * @return availableToBack
   */
  public List<PriceSize> getAvailableToBack() {
    return this.availableToBack;
  }

  /**
   * @return availableToLay
   */
  public List<PriceSize> getAvailableToLay() {
    return this.availableToLay;
  }

  /**
   * @return tradedVolume
   */
  public List<PriceSize> getTradedVolume() {
    return this.tradedVolume;
  }

  public static class Builder {
    private List<PriceSize> availableToBack;
    private List<PriceSize> availableToLay;
    private List<PriceSize> tradedVolume;

    public Builder() {}

    /**
     * Use this function to set availableToBack
     * 
     * @param availableToBack
     * @return Builder
     */
    public Builder withAvailableToBack(List<PriceSize> availableToBack) {
      this.availableToBack = availableToBack;
      return this;
    }

    /**
     * Use this function to set availableToLay
     * 
     * @param availableToLay
     * @return Builder
     */
    public Builder withAvailableToLay(List<PriceSize> availableToLay) {
      this.availableToLay = availableToLay;
      return this;
    }

    /**
     * Use this function to set tradedVolume
     * 
     * @param tradedVolume
     * @return Builder
     */
    public Builder withTradedVolume(List<PriceSize> tradedVolume) {
      this.tradedVolume = tradedVolume;
      return this;
    }

    public ExchangePrices build() {
      return new ExchangePrices(this);
    }
  }
}
