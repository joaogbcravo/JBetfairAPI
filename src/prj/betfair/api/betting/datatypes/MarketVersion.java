package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.MarketVersion;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Market version
 */
@JsonDeserialize(builder = MarketVersion.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketVersion {
  private final long version;

  public MarketVersion(Builder builder) {
    this.version = builder.version;
  }

  /**
   * @return version A non-monotonically increasing number indicating market changes
   */
  public long getVersion() {
    return this.version;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private long version;

    public Builder() {}

    /**
     * Use this function to set version
     * 
     * @param version A non-monotonically increasing number indicating market changes
     * @return Builder
     */
    public Builder withVersion(long version) {
      this.version = version;
      return this;
    }

    public MarketVersion build() {
      return new MarketVersion(this);
    }
  }
}
