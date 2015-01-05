package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.Competition;
import prj.betfair.api.betting.datatypes.CompetitionResult;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Competition Result
 */
@JsonDeserialize(builder = CompetitionResult.Builder.class)
public class CompetitionResult {
  private final String competitionRegion;
  private final int marketCount;
  private final Competition competition;

  public CompetitionResult(Builder builder) {
    this.competitionRegion = builder.competitionRegion;
    this.marketCount = builder.marketCount;
    this.competition = builder.competition;
  }

  /**
   * @return competition Competition
   */
  public Competition getCompetition() {
    return this.competition;
  }

  /**
   * @return marketCount Count of markets associated with this competition
   */
  public int getMarketCount() {
    return this.marketCount;
  }

  /**
   * @return competitionRegion Region in which this competition is happening
   */
  public String getCompetitionRegion() {
    return this.competitionRegion;
  }

  public static class Builder {
    private String competitionRegion;
    private int marketCount;
    private Competition competition;

    public Builder() {}

    /**
     * Use this function to set competition
     * 
     * @param competition Competition
     * @return Builder
     */
    public Builder withCompetition(Competition competition) {
      this.competition = competition;
      return this;
    }

    /**
     * Use this function to set marketCount
     * 
     * @param marketCount Count of markets associated with this competition
     * @return Builder
     */
    public Builder withMarketCount(int marketCount) {
      this.marketCount = marketCount;
      return this;
    }

    /**
     * Use this function to set competitionRegion
     * 
     * @param competitionRegion Region in which this competition is happening
     * @return Builder
     */
    public Builder withCompetitionRegion(String competitionRegion) {
      this.competitionRegion = competitionRegion;
      return this;
    }

    public CompetitionResult build() {
      return new CompetitionResult(this);
    }
  }
}
