package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.MarketFilter;
import prj.betfair.api.betting.datatypes.TimeRange;
import prj.betfair.api.betting.datatypes.SimpleTypes.OrderStatus;
import prj.betfair.api.betting.datatypes.SimpleTypes.MarketBettingType;

import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(builder = MarketFilter.Builder.class)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class MarketFilter {
  private  Set<String> exchangeIds;
  private  Set<String> eventTypeIds;
  private  Set<MarketBettingType> marketBettingTypes;
  private  String textQuery;
  private  TimeRange marketStartTime;
  private  Set<String> marketCountries;
  private  Boolean bspOnly;
  private  Set<String> eventIds;
  private  Set<String> marketIds;
  private  Set<String> venues;
  private  Set<String> marketTypeCodes;
  private  Boolean turnInPlayEnabled;
  private  Boolean inPlayOnly;
  private  Set<OrderStatus> withOrders;
  private  Set<String> competitionIds;

  public MarketFilter() {
    
  }
  public MarketFilter(Builder builder) {
    this.exchangeIds = builder.exchangeIds;
    this.eventTypeIds = builder.eventTypeIds;
    this.marketBettingTypes = builder.marketBettingTypes;
    this.textQuery = builder.textQuery;
    this.marketStartTime = builder.marketStartTime;
    this.marketCountries = builder.marketCountries;
    this.bspOnly = builder.bspOnly;
    this.eventIds = builder.eventIds;
    this.marketIds = builder.marketIds;
    this.venues = builder.venues;
    this.marketTypeCodes = builder.marketTypeCodes;
    this.turnInPlayEnabled = builder.turnInPlayEnabled;
    this.inPlayOnly = builder.inPlayOnly;
    this.withOrders = builder.withOrders;
    this.competitionIds = builder.competitionIds;
  }

  /**
   * @return textQuery Restrict markets by any text associated with the market such as the Name,
   *         Event, Competition, etc. You can include a wildcard (*) character as long as it is not
   *         the first character.
   */
  public String getTextQuery() {
    return this.textQuery;
  }

  /**
   * @return exchangeIds Restrict markets by the Exchange where the market operates. Note: This is
   *         not currently in use and only entities for the current exchange will be returned.
   */
  public Set<String> getExchangeIds() {
    return this.exchangeIds;
  }

  /**
   * @return eventTypeIds Restrict markets by event type associated with the market. (i.e.,
   *         Football, Hockey, etc)
   */
  public Set<String> getEventTypeIds() {
    return this.eventTypeIds;
  }

  /**
   * @return eventIds Restrict markets by the event id associated with the market.
   */
  public Set<String> getEventIds() {
    return this.eventIds;
  }

  /**
   * @return competitionIds Restrict markets by the competitions associated with the market.
   */
  public Set<String> getCompetitionIds() {
    return this.competitionIds;
  }

  /**
   * @return marketIds Restrict markets by the market id associated with the market.
   */
  public Set<String> getMarketIds() {
    return this.marketIds;
  }

  /**
   * @return venues Restrict markets by the venue associated with the market. Currently only Horse
   *         Racing markets have venues.
   */
  public Set<String> getVenues() {
    return this.venues;
  }

  /**
   * @return bspOnly Restrict to bsp markets only, if True or non-bsp markets if False. If not
   *         specified then returns both BSP and non-BSP markets
   */
  public Boolean getBspOnly() {
    return this.bspOnly;
  }

  /**
   * @return turnInPlayEnabled Restrict to markets that will turn in play if True or will not turn
   *         in play if false. If not specified, returns both.
   */
  public Boolean getTurnInPlayEnabled() {
    return this.turnInPlayEnabled;
  }

  /**
   * @return inPlayOnly Restrict to markets that will turn in play if True or will not turn in play
   *         if false. If not specified, returns both.
   */
  public Boolean getInPlayOnly() {
    return this.inPlayOnly;
  }

  /**
   * @return marketBettingTypes Restrict to markets that match the betting type of the market (i.e.
   *         Odds, Asian Handicap Singles, or Asian Handicap Doubles
   */
  public Set<MarketBettingType> getMarketBettingTypes() {
    return this.marketBettingTypes;
  }

  /**
   * @return marketCountries Restrict to markets that are in the specified country or countries
   */
  public Set<String> getMarketCountries() {
    return this.marketCountries;
  }

  /**
   * @return marketTypeCodes Restrict to markets that match the type of the market (i.e.,
   *         MATCH_ODDS, HALF_TIME_SCORE). You should use this instead of relying on the market name
   *         as the market type codes are the same in all locales
   */
  public Set<String> getMarketTypeCodes() {
    return this.marketTypeCodes;
  }

  /**
   * @return marketStartTime Restrict to markets with a market start time before or after the
   *         specified date
   */
  public TimeRange getMarketStartTime() {
    return this.marketStartTime;
  }

  /**
   * @return withOrders Restrict to markets that I have one or more orders in these status.
   */
  public Set<OrderStatus> getWithOrders() {
    return this.withOrders;
  }

  public static class Builder {
    private Set<String> exchangeIds;
    private Set<String> eventTypeIds;
    private Set<MarketBettingType> marketBettingTypes;
    private String textQuery;
    private TimeRange marketStartTime;
    private Set<String> marketCountries;
    private boolean bspOnly;
    private Set<String> eventIds;
    private Set<String> marketIds;
    private Set<String> venues;
    private Set<String> marketTypeCodes;
    private boolean turnInPlayEnabled;
    private boolean inPlayOnly;
    private Set<OrderStatus> withOrders;
    private Set<String> competitionIds;

    public Builder() {}

    /**
     * Use this function to set textQuery
     * 
     * @param textQuery Restrict markets by any text associated with the market such as the Name,
     *        Event, Competition, etc. You can include a wildcard (*) character as long as it is not
     *        the first character.
     * @return Builder
     */
    public Builder withTextQuery(String textQuery) {
      this.textQuery = textQuery;
      return this;
    }

    /**
     * Use this function to set exchangeIds
     * 
     * @param exchangeIds Restrict markets by the Exchange where the market operates. Note: This is
     *        not currently in use and only entities for the current exchange will be returned.
     * @return Builder
     */
    public Builder withExchangeIds(Set<String> exchangeIds) {
      this.exchangeIds = exchangeIds;
      return this;
    }

    /**
     * Use this function to set eventTypeIds
     * 
     * @param eventTypeIds Restrict markets by event type associated with the market. (i.e.,
     *        Football, Hockey, etc)
     * @return Builder
     */
    public Builder withEventTypeIds(Set<String> eventTypeIds) {
      this.eventTypeIds = eventTypeIds;
      return this;
    }

    /**
     * Use this function to set eventIds
     * 
     * @param eventIds Restrict markets by the event id associated with the market.
     * @return Builder
     */
    public Builder withEventIds(Set<String> eventIds) {
      this.eventIds = eventIds;
      return this;
    }

    /**
     * Use this function to set competitionIds
     * 
     * @param competitionIds Restrict markets by the competitions associated with the market.
     * @return Builder
     */
    public Builder withCompetitionIds(Set<String> competitionIds) {
      this.competitionIds = competitionIds;
      return this;
    }

    /**
     * Use this function to set marketIds
     * 
     * @param marketIds Restrict markets by the market id associated with the market.
     * @return Builder
     */
    public Builder withMarketIds(Set<String> marketIds) {
      this.marketIds = marketIds;
      return this;
    }

    /**
     * Use this function to set venues
     * 
     * @param venues Restrict markets by the venue associated with the market. Currently only Horse
     *        Racing markets have venues.
     * @return Builder
     */
    public Builder withVenues(Set<String> venues) {
      this.venues = venues;
      return this;
    }

    /**
     * Use this function to set bspOnly
     * 
     * @param bspOnly Restrict to bsp markets only, if True or non-bsp markets if False. If not
     *        specified then returns both BSP and non-BSP markets
     * @return Builder
     */
    public Builder withBspOnly(Boolean bspOnly) {
      this.bspOnly = bspOnly;
      return this;
    }

    /**
     * Use this function to set turnInPlayEnabled
     * 
     * @param turnInPlayEnabled Restrict to markets that will turn in play if True or will not turn
     *        in play if false. If not specified, returns both.
     * @return Builder
     */
    public Builder withTurnInPlayEnabled(Boolean turnInPlayEnabled) {
      this.turnInPlayEnabled = turnInPlayEnabled;
      return this;
    }

    /**
     * Use this function to set inPlayOnly
     * 
     * @param inPlayOnly Restrict to markets that will turn in play if True or will not turn in play
     *        if false. If not specified, returns both.
     * @return Builder
     */
    public Builder withInPlayOnly(Boolean inPlayOnly) {
      this.inPlayOnly = inPlayOnly;
      return this;
    }

    /**
     * Use this function to set marketBettingTypes
     * 
     * @param marketBettingTypes Restrict to markets that match the betting type of the market (i.e.
     *        Odds, Asian Handicap Singles, or Asian Handicap Doubles
     * @return Builder
     */
    public Builder withMarketBettingTypes(Set<MarketBettingType> marketBettingTypes) {
      this.marketBettingTypes = marketBettingTypes;
      return this;
    }

    /**
     * Use this function to set marketCountries
     * 
     * @param marketCountries Restrict to markets that are in the specified country or countries
     * @return Builder
     */
    public Builder withMarketCountries(Set<String> marketCountries) {
      this.marketCountries = marketCountries;
      return this;
    }

    /**
     * Use this function to set marketTypeCodes
     * 
     * @param marketTypeCodes Restrict to markets that match the type of the market (i.e.,
     *        MATCH_ODDS, HALF_TIME_SCORE). You should use this instead of relying on the market
     *        name as the market type codes are the same in all locales
     * @return Builder
     */
    public Builder withMarketTypeCodes(Set<String> marketTypeCodes) {
      this.marketTypeCodes = marketTypeCodes;
      return this;
    }

    /**
     * Use this function to set marketStartTime
     * 
     * @param marketStartTime Restrict to markets with a market start time before or after the
     *        specified date
     * @return Builder
     */
    public Builder withMarketStartTime(TimeRange marketStartTime) {
      this.marketStartTime = marketStartTime;
      return this;
    }

    /**
     * Use this function to set withOrders
     * 
     * @param withOrders Restrict to markets that I have one or more orders in these status.
     * @return Builder
     */
    public Builder withWithOrders(Set<OrderStatus> withOrders) {
      this.withOrders = withOrders;
      return this;
    }

    public MarketFilter build() {
      return new MarketFilter(this);
    }
  }
}
