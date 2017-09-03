package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.ClearedOrderSummary;
import prj.betfair.api.betting.datatypes.ItemDescription;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Summary of a cleared order.
 */
@JsonDeserialize(builder = ClearedOrderSummary.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClearedOrderSummary {
  private final String eventId;
  private final String persistenceType;
  private final Date settledDate;
  private final double priceMatched;
  private final double sizeSettled;
  private final double handicap;
  private final String orderType;
  private final long selectionId;
  private final boolean priceReduced;
  private final int betCount;
  private final ItemDescription itemDescription;
  private final String marketId;
  private final double commission;
  private final double profit;
  private final String eventTypeId;
  private final double priceRequested;
  private final Date placedDate;
  private final String betId;
  private final String side;
  private final double sizeCancelled;

  public ClearedOrderSummary(Builder builder) {
    this.eventId = builder.eventId;
    this.persistenceType = builder.persistenceType;
    this.settledDate = builder.settledDate;
    this.priceMatched = builder.priceMatched;
    this.sizeSettled = builder.sizeSettled;
    this.handicap = builder.handicap;
    this.orderType = builder.orderType;
    this.selectionId = builder.selectionId;
    this.priceReduced = builder.priceReduced;
    this.betCount = builder.betCount;
    this.itemDescription = builder.itemDescription;
    this.marketId = builder.marketId;
    this.commission = builder.commission;
    this.profit = builder.profit;
    this.eventTypeId = builder.eventTypeId;
    this.priceRequested = builder.priceRequested;
    this.placedDate = builder.placedDate;
    this.betId = builder.betId;
    this.side = builder.side;
    this.sizeCancelled = builder.sizeCancelled;
  }

  /**
   * @return eventTypeId The id of the event type bet on. Available at EVENT_TYPE groupBy level or
   *         lower.
   */
  public String getEventTypeId() {
    return this.eventTypeId;
  }

  /**
   * @return eventId The id of the event bet on. Available at EVENT groupBy level or lower.
   */
  public String getEventId() {
    return this.eventId;
  }

  /**
   * @return marketId The id of the market bet on. Available at MARKET groupBy level or lower.
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return selectionId The id of the selection bet on. Available at RUNNER groupBy level or lower.
   */
  public long getSelectionId() {
    return this.selectionId;
  }

  /**
   * @return handicap The id of the market bet on. Available at MARKET groupBy level or lower.
   */
  public double getHandicap() {
    return this.handicap;
  }

  /**
   * @return betId The id of the bet. Available at BET groupBy level.
   */
  public String getBetId() {
    return this.betId;
  }

  /**
   * @return placedDate The date the bet order was placed by the customer. Only available at BET
   *         groupBy level.
   */
  public Date getPlacedDate() {
    return this.placedDate;
  }

  /**
   * @return persistenceType The turn in play persistence state of the order at bet placement time.
   *         This field will be empty or omitted on true SP bets. Only available at BET groupBy
   *         level.
   */
  public String getPersistenceType() {
    return this.persistenceType;
  }

  /**
   * @return orderType The type of bet (e.g standard limited-liability Exchange bet (LIMIT), a
   *         standard BSP bet (MARKET_ON_CLOSE), or a minimum-accepted-price BSP bet
   *         (LIMIT_ON_CLOSE)). If the bet has a OrderType of MARKET_ON_CLOSE and a persistenceType
   *         of MARKET_ON_CLOSE then it is a bet which has transitioned from LIMIT to
   *         MARKET_ON_CLOSE. Only available at BET groupBy level.
   */
  public String getOrderType() {
    return this.orderType;
  }

  /**
   * @return side Whether the bet was a back or lay bet. Available at SIDE groupBy level or lower.
   */
  public String getSide() {
    return this.side;
  }

  /**
   * @return itemDescription A container for all the anciliary data and localised text valid for
   *         this Item
   */
  public ItemDescription getItemDescription() {
    return this.itemDescription;
  }

  /**
   * @return priceRequested The average requested price across all settled bet orders under this
   *         Item. Available at SIDE groupBy level or lower.
   */
  public double getPriceRequested() {
    return this.priceRequested;
  }

  /**
   * @return settledDate The date and time the bet order was settled by Betfair. Available at SIDE
   *         groupBy level or lower.
   */
  public Date getSettledDate() {
    return this.settledDate;
  }

  /**
   * @return betCount The number of actual bets within this grouping (will be 1 for BET groupBy)
   */
  public int getBetCount() {
    return this.betCount;
  }

  /**
   * @return commission The cumulative amount of commission paid by the customer across all bets
   *         under this Item, in the account currency. Available at EXCHANGE, EVENT_TYPE, EVENT and
   *         MARKET level groupings only.
   */
  public double getCommission() {
    return this.commission;
  }

  /**
   * @return priceMatched The average matched price across all settled bets or bet fragments under
   *         this Item. Available at SIDE groupBy level or lower.
   */
  public double getPriceMatched() {
    return this.priceMatched;
  }

  /**
   * @return priceReduced If true, then the matched price was affected by a reduction factor due to
   *         of a runner removal from this Horse Racing market.
   */
  public boolean getPriceReduced() {
    return this.priceReduced;
  }

  /**
   * @return sizeSettled The cumulative bet size that was settled as matched or voided under this
   *         Item, in the account currency. Available at SIDE groupBy level or lower.
   */
  public double getSizeSettled() {
    return this.sizeSettled;
  }

  /**
   * @return profit The profit or loss (negative profit) gained on this line, in the account
   *         currency
   */
  public double getProfit() {
    return this.profit;
  }

  /**
   * @return sizeCancelled The amount of the bet that was available to be matched, before
   *         cancellation or lapsing, in the account currency
   */
  public double getSizeCancelled() {
    return this.sizeCancelled;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String eventId;
    private String persistenceType;
    private Date settledDate;
    private double priceMatched;
    private double sizeSettled;
    private double handicap;
    private String orderType;
    private long selectionId;
    private boolean priceReduced;
    private int betCount;
    private ItemDescription itemDescription;
    private String marketId;
    private double commission;
    private double profit;
    private String eventTypeId;
    private double priceRequested;
    private Date placedDate;
    private String betId;
    private String side;
    private double sizeCancelled;

    public Builder() {}

    /**
     * Use this function to set eventTypeId
     * 
     * @param eventTypeId The id of the event type bet on. Available at EVENT_TYPE groupBy level or
     *        lower.
     * @return Builder
     */
    public Builder withEventTypeId(String eventTypeId) {
      this.eventTypeId = eventTypeId;
      return this;
    }

    /**
     * Use this function to set eventId
     * 
     * @param eventId The id of the event bet on. Available at EVENT groupBy level or lower.
     * @return Builder
     */
    public Builder withEventId(String eventId) {
      this.eventId = eventId;
      return this;
    }

    /**
     * Use this function to set marketId
     * 
     * @param marketId The id of the market bet on. Available at MARKET groupBy level or lower.
     * @return Builder
     */
    public Builder withMarketId(String marketId) {
      this.marketId = marketId;
      return this;
    }

    /**
     * Use this function to set selectionId
     * 
     * @param selectionId The id of the selection bet on. Available at RUNNER groupBy level or
     *        lower.
     * @return Builder
     */
    public Builder withSelectionId(long selectionId) {
      this.selectionId = selectionId;
      return this;
    }

    /**
     * Use this function to set handicap
     * 
     * @param handicap The id of the market bet on. Available at MARKET groupBy level or lower.
     * @return Builder
     */
    public Builder withHandicap(double handicap) {
      this.handicap = handicap;
      return this;
    }

    /**
     * Use this function to set betId
     * 
     * @param betId The id of the bet. Available at BET groupBy level.
     * @return Builder
     */
    public Builder withBetId(String betId) {
      this.betId = betId;
      return this;
    }

    /**
     * Use this function to set placedDate
     * 
     * @param placedDate The date the bet order was placed by the customer. Only available at BET
     *        groupBy level.
     * @return Builder
     */
    public Builder withPlacedDate(Date placedDate) {
      this.placedDate = placedDate;
      return this;
    }

    /**
     * Use this function to set persistenceType
     * 
     * @param persistenceType The turn in play persistence state of the order at bet placement time.
     *        This field will be empty or omitted on true SP bets. Only available at BET groupBy
     *        level.
     * @return Builder
     */
    public Builder withPersistenceType(String persistenceType) {
      this.persistenceType = persistenceType;
      return this;
    }

    /**
     * Use this function to set orderType
     * 
     * @param orderType The type of bet (e.g standard limited-liability Exchange bet (LIMIT), a
     *        standard BSP bet (MARKET_ON_CLOSE), or a minimum-accepted-price BSP bet
     *        (LIMIT_ON_CLOSE)). If the bet has a OrderType of MARKET_ON_CLOSE and a persistenceType
     *        of MARKET_ON_CLOSE then it is a bet which has transitioned from LIMIT to
     *        MARKET_ON_CLOSE. Only available at BET groupBy level.
     * @return Builder
     */
    public Builder withOrderType(String orderType) {
      this.orderType = orderType;
      return this;
    }

    /**
     * Use this function to set side
     * 
     * @param side Whether the bet was a back or lay bet. Available at SIDE groupBy level or lower.
     * @return Builder
     */
    public Builder withSide(String side) {
      this.side = side;
      return this;
    }

    /**
     * Use this function to set itemDescription
     * 
     * @param itemDescription A container for all the anciliary data and localised text valid for
     *        this Item
     * @return Builder
     */
    public Builder withItemDescription(ItemDescription itemDescription) {
      this.itemDescription = itemDescription;
      return this;
    }

    /**
     * Use this function to set priceRequested
     * 
     * @param priceRequested The average requested price across all settled bet orders under this
     *        Item. Available at SIDE groupBy level or lower.
     * @return Builder
     */
    public Builder withPriceRequested(double priceRequested) {
      this.priceRequested = priceRequested;
      return this;
    }

    /**
     * Use this function to set settledDate
     * 
     * @param settledDate The date and time the bet order was settled by Betfair. Available at SIDE
     *        groupBy level or lower.
     * @return Builder
     */
    public Builder withSettledDate(Date settledDate) {
      this.settledDate = settledDate;
      return this;
    }

    /**
     * Use this function to set betCount
     * 
     * @param betCount The number of actual bets within this grouping (will be 1 for BET groupBy)
     * @return Builder
     */
    public Builder withBetCount(int betCount) {
      this.betCount = betCount;
      return this;
    }

    /**
     * Use this function to set commission
     * 
     * @param commission The cumulative amount of commission paid by the customer across all bets
     *        under this Item, in the account currency. Available at EXCHANGE, EVENT_TYPE, EVENT and
     *        MARKET level groupings only.
     * @return Builder
     */
    public Builder withCommission(double commission) {
      this.commission = commission;
      return this;
    }

    /**
     * Use this function to set priceMatched
     * 
     * @param priceMatched The average matched price across all settled bets or bet fragments under
     *        this Item. Available at SIDE groupBy level or lower.
     * @return Builder
     */
    public Builder withPriceMatched(double priceMatched) {
      this.priceMatched = priceMatched;
      return this;
    }

    /**
     * Use this function to set priceReduced
     * 
     * @param priceReduced If true, then the matched price was affected by a reduction factor due to
     *        of a runner removal from this Horse Racing market.
     * @return Builder
     */
    public Builder withPriceReduced(boolean priceReduced) {
      this.priceReduced = priceReduced;
      return this;
    }

    /**
     * Use this function to set sizeSettled
     * 
     * @param sizeSettled The cumulative bet size that was settled as matched or voided under this
     *        Item, in the account currency. Available at SIDE groupBy level or lower.
     * @return Builder
     */
    public Builder withSizeSettled(double sizeSettled) {
      this.sizeSettled = sizeSettled;
      return this;
    }

    /**
     * Use this function to set profit
     * 
     * @param profit The profit or loss (negative profit) gained on this line, in the account
     *        currency
     * @return Builder
     */
    public Builder withProfit(double profit) {
      this.profit = profit;
      return this;
    }

    /**
     * Use this function to set sizeCancelled
     * 
     * @param sizeCancelled The amount of the bet that was available to be matched, before
     *        cancellation or lapsing, in the account currency
     * @return Builder
     */
    public Builder withSizeCancelled(double sizeCancelled) {
      this.sizeCancelled = sizeCancelled;
      return this;
    }

    public ClearedOrderSummary build() {
      return new ClearedOrderSummary(this);
    }
  }
}
