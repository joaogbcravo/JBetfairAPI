package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.PriceSize;
import prj.betfair.api.betting.datatypes.CurrentOrderSummary;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Summary of a current order.
 */
@JsonDeserialize(builder = CurrentOrderSummary.Builder.class)
public class CurrentOrderSummary {
  private final String status;
  private final String persistenceType;
  private final double averagePriceMatched;
  private final PriceSize priceSize;
  private final double sizeCancelled;
  private final double handicap;
  private final String orderType;
  private final long selectionId;
  private final String regulatorCode;
  private final double sizeVoided;
  private final double sizeMatched;
  private final String marketId;
  private final double sizeLapsed;
  private final double bspLiability;
  private final double sizeRemaining;
  private final Date placedDate;
  private final String regulatorAuthCode;
  private final String betId;
  private final String side;
  private final Date matchedDate;

  public CurrentOrderSummary(Builder builder) {
    this.status = builder.status;
    this.persistenceType = builder.persistenceType;
    this.averagePriceMatched = builder.averagePriceMatched;
    this.priceSize = builder.priceSize;
    this.sizeCancelled = builder.sizeCancelled;
    this.handicap = builder.handicap;
    this.orderType = builder.orderType;
    this.selectionId = builder.selectionId;
    this.regulatorCode = builder.regulatorCode;
    this.sizeVoided = builder.sizeVoided;
    this.sizeMatched = builder.sizeMatched;
    this.marketId = builder.marketId;
    this.sizeLapsed = builder.sizeLapsed;
    this.bspLiability = builder.bspLiability;
    this.sizeRemaining = builder.sizeRemaining;
    this.placedDate = builder.placedDate;
    this.regulatorAuthCode = builder.regulatorAuthCode;
    this.betId = builder.betId;
    this.side = builder.side;
    this.matchedDate = builder.matchedDate;
  }

  /**
   * @return betId The bet ID of the original place order.
   */
  public String getBetId() {
    return this.betId;
  }

  /**
   * @return marketId The market id the order is for.
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return selectionId The selection id the order is for.
   */
  public long getSelectionId() {
    return this.selectionId;
  }

  /**
   * @return handicap The handicap of the bet.
   */
  public double getHandicap() {
    return this.handicap;
  }

  /**
   * @return priceSize The price and size of the bet.
   */
  public PriceSize getPriceSize() {
    return this.priceSize;
  }

  /**
   * @return bspLiability Not to be confused with size. This is the liability of a given BSP bet.
   */
  public double getBspLiability() {
    return this.bspLiability;
  }

  /**
   * @return side BACK/LAY
   */
  public String getSide() {
    return this.side;
  }

  /**
   * @return status Either EXECUTABLE (an unmatched amount remains) or EXECUTION_COMPLETE (no
   *         unmatched amount remains).
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * @return persistenceType What to do with the order at turn-in-play.
   */
  public String getPersistenceType() {
    return this.persistenceType;
  }

  /**
   * @return orderType BSP Order type.
   */
  public String getOrderType() {
    return this.orderType;
  }

  /**
   * @return placedDate The date, to the second, the bet was placed.
   */
  public Date getPlacedDate() {
    return this.placedDate;
  }

  /**
   * @return matchedDate The date, to the second, of the last matched bet fragment (where
   *         applicable).
   */
  public Date getMatchedDate() {
    return this.matchedDate;
  }

  /**
   * @return averagePriceMatched The average price matched at. Voided match fragments are removed
   *         from this average calculation.
   */
  public double getAveragePriceMatched() {
    return this.averagePriceMatched;
  }

  /**
   * @return sizeMatched The current amount of this bet that was matched.
   */
  public double getSizeMatched() {
    return this.sizeMatched;
  }

  /**
   * @return sizeRemaining The current amount of this bet that is unmatched.
   */
  public double getSizeRemaining() {
    return this.sizeRemaining;
  }

  /**
   * @return sizeLapsed The current amount of this bet that was lapsed.
   */
  public double getSizeLapsed() {
    return this.sizeLapsed;
  }

  /**
   * @return sizeCancelled The current amount of this bet that was cancelled.
   */
  public double getSizeCancelled() {
    return this.sizeCancelled;
  }

  /**
   * @return sizeVoided The current amount of this bet that was voided.
   */
  public double getSizeVoided() {
    return this.sizeVoided;
  }

  /**
   * @return regulatorAuthCode The regulator authorisation code.
   */
  public String getRegulatorAuthCode() {
    return this.regulatorAuthCode;
  }

  /**
   * @return regulatorCode The regulator Code.
   */
  public String getRegulatorCode() {
    return this.regulatorCode;
  }

  public static class Builder {
    private String status;
    private String persistenceType;
    private double averagePriceMatched;
    private PriceSize priceSize;
    private double sizeCancelled;
    private double handicap;
    private String orderType;
    private long selectionId;
    private String regulatorCode;
    private double sizeVoided;
    private double sizeMatched;
    private String marketId;
    private double sizeLapsed;
    private double bspLiability;
    private double sizeRemaining;
    private Date placedDate;
    private String regulatorAuthCode;
    private String betId;
    private String side;
    private Date matchedDate;

    /**
     * @param status : Either EXECUTABLE (an unmatched amount remains) or EXECUTION_COMPLETE (no
     *        unmatched amount remains).
     * @param persistenceType : What to do with the order at turn-in-play.
     * @param priceSize : The price and size of the bet.
     * @param handicap : The handicap of the bet.
     * @param orderType : BSP Order type.
     * @param selectionId : The selection id the order is for.
     * @param marketId : The market id the order is for.
     * @param bspLiability : Not to be confused with size. This is the liability of a given BSP bet.
     * @param placedDate : The date, to the second, the bet was placed.
     * @param betId : The bet ID of the original place order.
     * @param side : BACK/LAY
     * @param matchedDate : The date, to the second, of the last matched bet fragment (where
     *        applicable).
     */
    public Builder(@JsonProperty("status") String status,
        @JsonProperty("persistenceType") String persistenceType,
        @JsonProperty("priceSize") PriceSize priceSize, @JsonProperty("handicap") double handicap,
        @JsonProperty("orderType") String orderType, @JsonProperty("selectionId") long selectionId,
        @JsonProperty("marketId") String marketId,
        @JsonProperty("bspLiability") double bspLiability,
        @JsonProperty("placedDate") Date placedDate, @JsonProperty("betId") String betId,
        @JsonProperty("side") String side, @JsonProperty("matchedDate") Date matchedDate) {
      this.status = status;
      this.persistenceType = persistenceType;
      this.priceSize = priceSize;
      this.handicap = handicap;
      this.orderType = orderType;
      this.selectionId = selectionId;
      this.marketId = marketId;
      this.bspLiability = bspLiability;
      this.placedDate = placedDate;
      this.betId = betId;
      this.side = side;
      this.matchedDate = matchedDate;
    }

    /**
     * Use this function to set averagePriceMatched
     * 
     * @param averagePriceMatched The average price matched at. Voided match fragments are removed
     *        from this average calculation.
     * @return Builder
     */
    public Builder withAveragePriceMatched(double averagePriceMatched) {
      this.averagePriceMatched = averagePriceMatched;
      return this;
    }

    /**
     * Use this function to set sizeMatched
     * 
     * @param sizeMatched The current amount of this bet that was matched.
     * @return Builder
     */
    public Builder withSizeMatched(double sizeMatched) {
      this.sizeMatched = sizeMatched;
      return this;
    }

    /**
     * Use this function to set sizeRemaining
     * 
     * @param sizeRemaining The current amount of this bet that is unmatched.
     * @return Builder
     */
    public Builder withSizeRemaining(double sizeRemaining) {
      this.sizeRemaining = sizeRemaining;
      return this;
    }

    /**
     * Use this function to set sizeLapsed
     * 
     * @param sizeLapsed The current amount of this bet that was lapsed.
     * @return Builder
     */
    public Builder withSizeLapsed(double sizeLapsed) {
      this.sizeLapsed = sizeLapsed;
      return this;
    }

    /**
     * Use this function to set sizeCancelled
     * 
     * @param sizeCancelled The current amount of this bet that was cancelled.
     * @return Builder
     */
    public Builder withSizeCancelled(double sizeCancelled) {
      this.sizeCancelled = sizeCancelled;
      return this;
    }

    /**
     * Use this function to set sizeVoided
     * 
     * @param sizeVoided The current amount of this bet that was voided.
     * @return Builder
     */
    public Builder withSizeVoided(double sizeVoided) {
      this.sizeVoided = sizeVoided;
      return this;
    }

    /**
     * Use this function to set regulatorAuthCode
     * 
     * @param regulatorAuthCode The regulator authorisation code.
     * @return Builder
     */
    public Builder withRegulatorAuthCode(String regulatorAuthCode) {
      this.regulatorAuthCode = regulatorAuthCode;
      return this;
    }

    /**
     * Use this function to set regulatorCode
     * 
     * @param regulatorCode The regulator Code.
     * @return Builder
     */
    public Builder withRegulatorCode(String regulatorCode) {
      this.regulatorCode = regulatorCode;
      return this;
    }

    public CurrentOrderSummary build() {
      return new CurrentOrderSummary(this);
    }
  }
}
