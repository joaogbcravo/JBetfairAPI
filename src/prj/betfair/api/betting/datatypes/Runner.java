package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.Runner;
import prj.betfair.api.betting.datatypes.StartingPrices;
import prj.betfair.api.betting.datatypes.ExchangePrices;
import prj.betfair.api.betting.datatypes.Order;
import prj.betfair.api.betting.datatypes.Match;
import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * The dynamic data about runners in a market
 */
@JsonDeserialize(builder = Runner.Builder.class)
public class Runner {
  private final String status;
  private final double handicap;
  private final long selectionId;
  private final StartingPrices sp;
  private final Date removalDate;
  private final ArrayList<Match> matches;
  private final double totalMatched;
  private final double adjustmentFactor;
  private final ExchangePrices ex;
  private final ArrayList<Order> orders;
  private final double lastPriceTraded;

  public Runner(Builder builder) {
    this.status = builder.status;
    this.handicap = builder.handicap;
    this.selectionId = builder.selectionId;
    this.sp = builder.sp;
    this.removalDate = builder.removalDate;
    this.matches = builder.matches;
    this.totalMatched = builder.totalMatched;
    this.adjustmentFactor = builder.adjustmentFactor;
    this.ex = builder.ex;
    this.orders = builder.orders;
    this.lastPriceTraded = builder.lastPriceTraded;
  }

  /**
   * @return selectionId The unique id of the runner (selection)
   */
  public long getSelectionId() {
    return this.selectionId;
  }

  /**
   * @return handicap The handicap
   */
  public double getHandicap() {
    return this.handicap;
  }

  /**
   * @return status The status of the selection (i.e., ACTIVE, REMOVED, WINNER, LOSER)
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * @return adjustmentFactor The adjustment factor applied if the selection is removed
   */
  public double getAdjustmentFactor() {
    return this.adjustmentFactor;
  }

  /**
   * @return lastPriceTraded The price of the most recent bet matched on this selection
   */
  public double getLastPriceTraded() {
    return this.lastPriceTraded;
  }

  /**
   * @return totalMatched The total amount matched on this runner. This value is truncated at 2dp.
   */
  public double getTotalMatched() {
    return this.totalMatched;
  }

  /**
   * @return removalDate If date and time the runner was removed
   */
  public Date getRemovalDate() {
    return this.removalDate;
  }

  /**
   * @return sp The BSP related prices for this runner
   */
  public StartingPrices getSp() {
    return this.sp;
  }

  /**
   * @return ex The Exchange prices available for this runner
   */
  public ExchangePrices getEx() {
    return this.ex;
  }

  /**
   * @return orders List of orders in the market
   */
  public ArrayList<Order> getOrders() {
    return this.orders;
  }

  /**
   * @return matches List of matches (i.e, orders that have been fully or partially executed)
   */
  public ArrayList<Match> getMatches() {
    return this.matches;
  }

  public static class Builder {
    private String status;
    private double handicap;
    private long selectionId;
    private StartingPrices sp;
    private Date removalDate;
    private ArrayList<Match> matches;
    private double totalMatched;
    private double adjustmentFactor;
    private ExchangePrices ex;
    private ArrayList<Order> orders;
    private double lastPriceTraded;

    /**
     * @param handicap : The handicap
     * @param status : The status of the selection (i.e., ACTIVE, REMOVED, WINNER, LOSER)
     * @param selectionId : The unique id of the runner (selection)
     * @param adjustmentFactor : The adjustment factor applied if the selection is removed
     */
    public Builder(@JsonProperty("handicap") double handicap,
        @JsonProperty("status") String status, @JsonProperty("selectionId") long selectionId,
        @JsonProperty("adjustmentFactor") double adjustmentFactor) {
      this.handicap = handicap;
      this.status = status;
      this.selectionId = selectionId;
      this.adjustmentFactor = adjustmentFactor;
    }

    /**
     * Use this function to set lastPriceTraded
     * 
     * @param lastPriceTraded The price of the most recent bet matched on this selection
     * @return Builder
     */
    public Builder withLastPriceTraded(double lastPriceTraded) {
      this.lastPriceTraded = lastPriceTraded;
      return this;
    }

    /**
     * Use this function to set totalMatched
     * 
     * @param totalMatched The total amount matched on this runner. This value is truncated at 2dp.
     * @return Builder
     */
    public Builder withTotalMatched(double totalMatched) {
      this.totalMatched = totalMatched;
      return this;
    }

    /**
     * Use this function to set removalDate
     * 
     * @param removalDate If date and time the runner was removed
     * @return Builder
     */
    public Builder withRemovalDate(Date removalDate) {
      this.removalDate = removalDate;
      return this;
    }

    /**
     * Use this function to set sp
     * 
     * @param sp The BSP related prices for this runner
     * @return Builder
     */
    public Builder withSp(StartingPrices sp) {
      this.sp = sp;
      return this;
    }

    /**
     * Use this function to set ex
     * 
     * @param ex The Exchange prices available for this runner
     * @return Builder
     */
    public Builder withEx(ExchangePrices ex) {
      this.ex = ex;
      return this;
    }

    /**
     * Use this function to set orders
     * 
     * @param orders List of orders in the market
     * @return Builder
     */
    public Builder withOrders(ArrayList<Order> orders) {
      this.orders = orders;
      return this;
    }

    /**
     * Use this function to set matches
     * 
     * @param matches List of matches (i.e, orders that have been fully or partially executed)
     * @return Builder
     */
    public Builder withMatches(ArrayList<Match> matches) {
      this.matches = matches;
      return this;
    }

    public Runner build() {
      return new Runner(this);
    }
  }
}
