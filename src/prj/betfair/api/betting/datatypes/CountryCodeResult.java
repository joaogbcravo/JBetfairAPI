package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.CountryCodeResult;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * CountryCode Result
 */
@JsonDeserialize(builder = CountryCodeResult.Builder.class)
public class CountryCodeResult {
  private final int marketCount;
  private final String countryCode;

  public CountryCodeResult(Builder builder) {
    this.marketCount = builder.marketCount;
    this.countryCode = builder.countryCode;
  }

  /**
   * @return countryCode Country Code
   */
  public String getCountryCode() {
    return this.countryCode;
  }

  /**
   * @return marketCount Count of markets associated with this Country Code
   */
  public int getMarketCount() {
    return this.marketCount;
  }

  public static class Builder {
    private int marketCount;
    private String countryCode;

    public Builder() {}

    /**
     * Use this function to set countryCode
     * 
     * @param countryCode Country Code
     * @return Builder
     */
    public Builder withCountryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Use this function to set marketCount
     * 
     * @param marketCount Count of markets associated with this Country Code
     * @return Builder
     */
    public Builder withMarketCount(int marketCount) {
      this.marketCount = marketCount;
      return this;
    }

    public CountryCodeResult build() {
      return new CountryCodeResult(this);
    }
  }
}
