package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.Match;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * An individual bet Match, or rollup by price or avg price. Rollup depends on the requested
 * MatchProjection
 */
@JsonDeserialize(builder = Match.Builder.class)
public class Match {
  private final Date matchDate;
  private final double price;
  private final String matchId;
  private final String betId;
  private final String side;
  private final double Size;

  public Match(Builder builder) {
    this.matchDate = builder.matchDate;
    this.price = builder.price;
    this.matchId = builder.matchId;
    this.betId = builder.betId;
    this.side = builder.side;
    this.Size = builder.Size;
  }

  /**
   * @return betId Only present if no rollup
   */
  public String getBetId() {
    return this.betId;
  }

  /**
   * @return matchId Only present if no rollup
   */
  public String getMatchId() {
    return this.matchId;
  }

  /**
   * @return side
   */
  public String getSide() {
    return this.side;
  }

  /**
   * @return price Either actual match price or avg match price depending on rollup.
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * @return Size Size matched at in this fragment, or at this price or avg price depending on
   *         rollup
   */
  public double getSize() {
    return this.Size;
  }

  /**
   * @return matchDate Only present if no rollup
   */
  public Date getMatchDate() {
    return this.matchDate;
  }

  public static class Builder {
    private Date matchDate;
    private double price;
    private String matchId;
    private String betId;
    private String side;
    private double Size;

    /**
     * @param price : Either actual match price or avg match price depending on rollup.
     * @param side
     * @param Size : Size matched at in this fragment, or at this price or avg price depending on
     *        rollup
     */
    public Builder(@JsonProperty("price") double price, @JsonProperty("side") String side,
        @JsonProperty("Size") double Size) {
      this.price = price;
      this.side = side;
      this.Size = Size;
    }

    /**
     * Use this function to set betId
     * 
     * @param betId Only present if no rollup
     * @return Builder
     */
    public Builder withBetId(String betId) {
      this.betId = betId;
      return this;
    }

    /**
     * Use this function to set matchId
     * 
     * @param matchId Only present if no rollup
     * @return Builder
     */
    public Builder withMatchId(String matchId) {
      this.matchId = matchId;
      return this;
    }

    /**
     * Use this function to set matchDate
     * 
     * @param matchDate Only present if no rollup
     * @return Builder
     */
    public Builder withMatchDate(Date matchDate) {
      this.matchDate = matchDate;
      return this;
    }

    public Match build() {
      return new Match(this);
    }
  }
}
