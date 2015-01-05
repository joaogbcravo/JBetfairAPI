package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.MarketCatalogue;
import prj.betfair.api.betting.datatypes.RunnerCatalog;
import prj.betfair.api.betting.datatypes.Event;
import prj.betfair.api.betting.datatypes.Competition;
import prj.betfair.api.betting.datatypes.EventType;
import prj.betfair.api.betting.datatypes.MarketDescription;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Information about a market
 */
@JsonDeserialize(builder = MarketCatalogue.Builder.class)
public class MarketCatalogue {
  private final MarketDescription description;
  private final Date marketStartTime;
  private final EventType eventType;
  private final Competition competition;
  private final String marketId;
  private final double totalMatched;
  private final String marketName;
  private final Event event;
  private final List<RunnerCatalog> runners;

  public MarketCatalogue(Builder builder) {
    this.description = builder.description;
    this.marketStartTime = builder.marketStartTime;
    this.eventType = builder.eventType;
    this.competition = builder.competition;
    this.marketId = builder.marketId;
    this.totalMatched = builder.totalMatched;
    this.marketName = builder.marketName;
    this.event = builder.event;
    this.runners = builder.runners;
  }

  /**
   * @return marketId The unique identifier for the market
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return marketName The name of the market
   */
  public String getMarketName() {
    return this.marketName;
  }

  /**
   * @return marketStartTime The time this market starts at, only returned when the
   *         MARKET_START_TIME enum is passed in the marketProjections
   */
  public Date getMarketStartTime() {
    return this.marketStartTime;
  }

  /**
   * @return description Details about the market
   */
  public MarketDescription getDescription() {
    return this.description;
  }

  /**
   * @return totalMatched The total amount of money matched on the market. This value is truncated
   *         at 2dp.
   */
  public double getTotalMatched() {
    return this.totalMatched;
  }

  /**
   * @return runners The runners (selections) contained in the market
   */
  public List<RunnerCatalog> getRunners() {
    return this.runners;
  }

  /**
   * @return eventType The Event Type the market is contained within
   */
  public EventType getEventType() {
    return this.eventType;
  }

  /**
   * @return competition The competition the market is contained within. Usually only applies to
   *         Football competitions
   */
  public Competition getCompetition() {
    return this.competition;
  }

  /**
   * @return event The event the market is contained within
   */
  public Event getEvent() {
    return this.event;
  }

  public static class Builder {
    private MarketDescription description;
    private Date marketStartTime;
    private EventType eventType;
    private Competition competition;
    private String marketId;
    private double totalMatched;
    private String marketName;
    private Event event;
    private List<RunnerCatalog> runners;

    /**
     * @param marketName : The name of the market
     * @param marketId : The unique identifier for the market
     */
    public Builder(@JsonProperty("marketName") String marketName,
        @JsonProperty("marketId") String marketId) {
      this.marketName = marketName;
      this.marketId = marketId;
    }

    /**
     * Use this function to set marketStartTime
     * 
     * @param marketStartTime The time this market starts at, only returned when the
     *        MARKET_START_TIME enum is passed in the marketProjections
     * @return Builder
     */
    public Builder withMarketStartTime(Date marketStartTime) {
      this.marketStartTime = marketStartTime;
      return this;
    }

    /**
     * Use this function to set description
     * 
     * @param description Details about the market
     * @return Builder
     */
    public Builder withDescription(MarketDescription description) {
      this.description = description;
      return this;
    }

    /**
     * Use this function to set totalMatched
     * 
     * @param totalMatched The total amount of money matched on the market. This value is truncated
     *        at 2dp.
     * @return Builder
     */
    public Builder withTotalMatched(double totalMatched) {
      this.totalMatched = totalMatched;
      return this;
    }

    /**
     * Use this function to set runners
     * 
     * @param runners The runners (selections) contained in the market
     * @return Builder
     */
    public Builder withRunners(List<RunnerCatalog> runners) {
      this.runners = runners;
      return this;
    }

    /**
     * Use this function to set eventType
     * 
     * @param eventType The Event Type the market is contained within
     * @return Builder
     */
    public Builder withEventType(EventType eventType) {
      this.eventType = eventType;
      return this;
    }

    /**
     * Use this function to set competition
     * 
     * @param competition The competition the market is contained within. Usually only applies to
     *        Football competitions
     * @return Builder
     */
    public Builder withCompetition(Competition competition) {
      this.competition = competition;
      return this;
    }

    /**
     * Use this function to set event
     * 
     * @param event The event the market is contained within
     * @return Builder
     */
    public Builder withEvent(Event event) {
      this.event = event;
      return this;
    }

    public MarketCatalogue build() {
      return new MarketCatalogue(this);
    }
  }
}
