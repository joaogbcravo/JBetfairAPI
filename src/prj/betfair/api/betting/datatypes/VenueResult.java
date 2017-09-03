package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.VenueResult;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Venue Result
 */
@JsonDeserialize(builder = VenueResult.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VenueResult {
  private final String venue;
  private final int marketCount;

  public VenueResult(Builder builder) {
    this.venue = builder.venue;
    this.marketCount = builder.marketCount;
  }

  /**
   * @return venue Venue
   */
  public String getVenue() {
    return this.venue;
  }

  /**
   * @return marketCount Count of markets associated with this Venue
   */
  public int getMarketCount() {
    return this.marketCount;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String venue;
    private int marketCount;

    public Builder() {}

    /**
     * Use this function to set venue
     * 
     * @param venue Venue
     * @return Builder
     */
    public Builder withVenue(String venue) {
      this.venue = venue;
      return this;
    }

    /**
     * Use this function to set marketCount
     * 
     * @param marketCount Count of markets associated with this Venue
     * @return Builder
     */
    public Builder withMarketCount(int marketCount) {
      this.marketCount = marketCount;
      return this;
    }

    public VenueResult build() {
      return new VenueResult(this);
    }
  }
}
