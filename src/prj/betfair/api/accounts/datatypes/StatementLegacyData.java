package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.StatementLegacyData;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Summary of a cleared order.
 */
@JsonDeserialize(builder = StatementLegacyData.Builder.class)
public class StatementLegacyData {
  private final long eventId;
  private final Date startDate;
  private final String betType;
  private final double grossBetAmount;
  private final long selectionId;
  private final String marketType;
  private final String winLose;
  private final String commissionRate;
  private final String fullMarketName;
  private final String selectionName;
  private final String marketName;
  private final long eventTypeId;
  private final Date placedDate;
  private final long transactionId;
  private final double avgPrice;
  private final double betSize;
  private final String betCategoryType;
  private final String transactionType;

  public StatementLegacyData(Builder builder) {
    this.eventId = builder.eventId;
    this.startDate = builder.startDate;
    this.betType = builder.betType;
    this.grossBetAmount = builder.grossBetAmount;
    this.selectionId = builder.selectionId;
    this.marketType = builder.marketType;
    this.winLose = builder.winLose;
    this.commissionRate = builder.commissionRate;
    this.fullMarketName = builder.fullMarketName;
    this.selectionName = builder.selectionName;
    this.marketName = builder.marketName;
    this.eventTypeId = builder.eventTypeId;
    this.placedDate = builder.placedDate;
    this.transactionId = builder.transactionId;
    this.avgPrice = builder.avgPrice;
    this.betSize = builder.betSize;
    this.betCategoryType = builder.betCategoryType;
    this.transactionType = builder.transactionType;
  }

  /**
   * @return avgPrice
   */
  public double getAvgPrice() {
    return this.avgPrice;
  }

  /**
   * @return betSize
   */
  public double getBetSize() {
    return this.betSize;
  }

  /**
   * @return betType
   */
  public String getBetType() {
    return this.betType;
  }

  /**
   * @return betCategoryType
   */
  public String getBetCategoryType() {
    return this.betCategoryType;
  }

  /**
   * @return commissionRate
   */
  public String getCommissionRate() {
    return this.commissionRate;
  }

  /**
   * @return eventId
   */
  public long getEventId() {
    return this.eventId;
  }

  /**
   * @return eventTypeId
   */
  public long getEventTypeId() {
    return this.eventTypeId;
  }

  /**
   * @return fullMarketName
   */
  public String getFullMarketName() {
    return this.fullMarketName;
  }

  /**
   * @return grossBetAmount
   */
  public double getGrossBetAmount() {
    return this.grossBetAmount;
  }

  /**
   * @return marketName
   */
  public String getMarketName() {
    return this.marketName;
  }

  /**
   * @return marketType
   */
  public String getMarketType() {
    return this.marketType;
  }

  /**
   * @return placedDate
   */
  public Date getPlacedDate() {
    return this.placedDate;
  }

  /**
   * @return selectionId
   */
  public long getSelectionId() {
    return this.selectionId;
  }

  /**
   * @return selectionName
   */
  public String getSelectionName() {
    return this.selectionName;
  }

  /**
   * @return startDate
   */
  public Date getStartDate() {
    return this.startDate;
  }

  /**
   * @return transactionType
   */
  public String getTransactionType() {
    return this.transactionType;
  }

  /**
   * @return transactionId
   */
  public long getTransactionId() {
    return this.transactionId;
  }

  /**
   * @return winLose
   */
  public String getWinLose() {
    return this.winLose;
  }

  public static class Builder {
    private long eventId;
    private Date startDate;
    private String betType;
    private double grossBetAmount;
    private long selectionId;
    private String marketType;
    private String winLose;
    private String commissionRate;
    private String fullMarketName;
    private String selectionName;
    private String marketName;
    private long eventTypeId;
    private Date placedDate;
    private long transactionId;
    private double avgPrice;
    private double betSize;
    private String betCategoryType;
    private String transactionType;

    public Builder() {}

    public StatementLegacyData build() {
      return new StatementLegacyData(this);
    }
  }
}
