package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.RunnerId;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * This object contains the unique identifier for a runner
 */
@JsonDeserialize(builder = RunnerId.Builder.class)
public class RunnerId {
  private final double handicap;
  private final long selectionId;
  private final String marketId;

  public RunnerId(Builder builder) {
    this.handicap = builder.handicap;
    this.selectionId = builder.selectionId;
    this.marketId = builder.marketId;
  }

  /**
   * @return marketId The id of the market bet on
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return selectionId The id of the selection bet on
   */
  public long getSelectionId() {
    return this.selectionId;
  }

  /**
   * @return handicap The handicap associated with the runner in case of asian handicap markets,
   *         null otherwise.
   */
  public double getHandicap() {
    return this.handicap;
  }

  public static class Builder {
    private double handicap;
    private long selectionId;
    private String marketId;

    /**
     * @param selectionId : The id of the selection bet on
     * @param marketId : The id of the market bet on
     */
    public Builder(@JsonProperty("selectionId") long selectionId,
        @JsonProperty("marketId") String marketId) {
      this.selectionId = selectionId;
      this.marketId = marketId;
    }

    /**
     * Use this function to set handicap
     * 
     * @param handicap The handicap associated with the runner in case of asian handicap markets,
     *        null otherwise.
     * @return Builder
     */
    public Builder withHandicap(double handicap) {
      this.handicap = handicap;
      return this;
    }

    public RunnerId build() {
      return new RunnerId(this);
    }
  }
}
