package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.MarketBook;
import prj.betfair.api.betting.datatypes.Runner;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * The dynamic data in a market
 */
@JsonDeserialize(builder = MarketBook.Builder.class)
public class MarketBook {
  private final String status;
  private final boolean isMarketDataDelayed;
  private final int numberOfRunners;
  private final boolean complete;
  private final boolean bspReconciled;
  private final boolean runnersVoidable;
  private final int betDelay;
  private final String marketId;
  private final boolean crossMatching;
  private final double totalMatched;
  private final long version;
  private final Date lastMatchTime;
  private final int numberOfWinners;
  private final boolean inplay;
  private final int numberOfActiveRunners;
  private final double totalAvailable;
  private final List<Runner> runners;

  public MarketBook(Builder builder) {
    this.status = builder.status;
    this.isMarketDataDelayed = builder.isMarketDataDelayed;
    this.numberOfRunners = builder.numberOfRunners;
    this.complete = builder.complete;
    this.bspReconciled = builder.bspReconciled;
    this.runnersVoidable = builder.runnersVoidable;
    this.betDelay = builder.betDelay;
    this.marketId = builder.marketId;
    this.crossMatching = builder.crossMatching;
    this.totalMatched = builder.totalMatched;
    this.version = builder.version;
    this.lastMatchTime = builder.lastMatchTime;
    this.numberOfWinners = builder.numberOfWinners;
    this.inplay = builder.inplay;
    this.numberOfActiveRunners = builder.numberOfActiveRunners;
    this.totalAvailable = builder.totalAvailable;
    this.runners = builder.runners;
  }

  /**
   * @return marketId The unique identifier for the market
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return isMarketDataDelayed True if the data returned by listMarketBook will be delayed. The
   *         data may be delayed because you are not logged in with a funded account or you are
   *         using an Application Key that does not allow up to date data.
   */
  public boolean getIsMarketDataDelayed() {
    return this.isMarketDataDelayed;
  }

  /**
   * @return status The status of the market, for example ACTIVE, SUSPENDED, SETTLED, etc.
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * @return betDelay The number of seconds an order is held until it is submitted into the market.
   *         Orders are usually delayed when the market is in-play
   */
  public int getBetDelay() {
    return this.betDelay;
  }

  /**
   * @return bspReconciled True if the market starting price has been reconciled
   */
  public boolean getBspReconciled() {
    return this.bspReconciled;
  }

  /**
   * @return complete
   */
  public boolean getComplete() {
    return this.complete;
  }

  /**
   * @return inplay True if the market is currently in play
   */
  public boolean getInplay() {
    return this.inplay;
  }

  /**
   * @return numberOfWinners The number of selections that could be settled as winners
   */
  public int getNumberOfWinners() {
    return this.numberOfWinners;
  }

  /**
   * @return numberOfRunners The number of runners in the market
   */
  public int getNumberOfRunners() {
    return this.numberOfRunners;
  }

  /**
   * @return numberOfActiveRunners The number of runners that are currently active. An active runner
   *         is a selection available for betting
   */
  public int getNumberOfActiveRunners() {
    return this.numberOfActiveRunners;
  }

  /**
   * @return lastMatchTime The most recent time an order was executed
   */
  public Date getLastMatchTime() {
    return this.lastMatchTime;
  }

  /**
   * @return totalMatched The total amount matched. This value is truncated at 2dp.
   */
  public double getTotalMatched() {
    return this.totalMatched;
  }

  /**
   * @return totalAvailable The total amount of orders that remain unmatched. This value is
   *         truncated at 2dp.
   */
  public double getTotalAvailable() {
    return this.totalAvailable;
  }

  /**
   * @return crossMatching True if cross matching is enabled for this market.
   */
  public boolean getCrossMatching() {
    return this.crossMatching;
  }

  /**
   * @return runnersVoidable True if runners in the market can be voided
   */
  public boolean getRunnersVoidable() {
    return this.runnersVoidable;
  }

  /**
   * @return version The version of the market. The version increments whenever the market status
   *         changes, for example, turning in-play, or suspended when a goal score.
   */
  public long getVersion() {
    return this.version;
  }

  /**
   * @return runners Information about the runners (selections) in the market.
   */
  public List<Runner> getRunners() {
    return this.runners;
  }

  public static class Builder {
    private String status;
    private boolean isMarketDataDelayed;
    private int numberOfRunners;
    private boolean complete;
    private boolean bspReconciled;
    private boolean runnersVoidable;
    private int betDelay;
    private String marketId;
    private boolean crossMatching;
    private double totalMatched;
    private long version;
    private Date lastMatchTime;
    private int numberOfWinners;
    private boolean inplay;
    private int numberOfActiveRunners;
    private double totalAvailable;
    private List<Runner> runners;

    /**
     * @param isMarketDataDelayed : True if the data returned by listMarketBook will be delayed. The
     *        data may be delayed because you are not logged in with a funded account or you are
     *        using an Application Key that does not allow up to date data.
     * @param marketId : The unique identifier for the market
     */
    public Builder(@JsonProperty("isMarketDataDelayed") boolean isMarketDataDelayed,
        @JsonProperty("marketId") String marketId) {
      this.isMarketDataDelayed = isMarketDataDelayed;
      this.marketId = marketId;
    }

    /**
     * Use this function to set status
     * 
     * @param status The status of the market, for example ACTIVE, SUSPENDED, SETTLED, etc.
     * @return Builder
     */
    public Builder withStatus(String status) {
      this.status = status;
      return this;
    }

    /**
     * Use this function to set betDelay
     * 
     * @param betDelay The number of seconds an order is held until it is submitted into the market.
     *        Orders are usually delayed when the market is in-play
     * @return Builder
     */
    public Builder withBetDelay(int betDelay) {
      this.betDelay = betDelay;
      return this;
    }

    /**
     * Use this function to set bspReconciled
     * 
     * @param bspReconciled True if the market starting price has been reconciled
     * @return Builder
     */
    public Builder withBspReconciled(boolean bspReconciled) {
      this.bspReconciled = bspReconciled;
      return this;
    }

    /**
     * Use this function to set complete
     * 
     * @param complete
     * @return Builder
     */
    public Builder withComplete(boolean complete) {
      this.complete = complete;
      return this;
    }

    /**
     * Use this function to set inplay
     * 
     * @param inplay True if the market is currently in play
     * @return Builder
     */
    public Builder withInplay(boolean inplay) {
      this.inplay = inplay;
      return this;
    }

    /**
     * Use this function to set numberOfWinners
     * 
     * @param numberOfWinners The number of selections that could be settled as winners
     * @return Builder
     */
    public Builder withNumberOfWinners(int numberOfWinners) {
      this.numberOfWinners = numberOfWinners;
      return this;
    }

    /**
     * Use this function to set numberOfRunners
     * 
     * @param numberOfRunners The number of runners in the market
     * @return Builder
     */
    public Builder withNumberOfRunners(int numberOfRunners) {
      this.numberOfRunners = numberOfRunners;
      return this;
    }

    /**
     * Use this function to set numberOfActiveRunners
     * 
     * @param numberOfActiveRunners The number of runners that are currently active. An active
     *        runner is a selection available for betting
     * @return Builder
     */
    public Builder withNumberOfActiveRunners(int numberOfActiveRunners) {
      this.numberOfActiveRunners = numberOfActiveRunners;
      return this;
    }

    /**
     * Use this function to set lastMatchTime
     * 
     * @param lastMatchTime The most recent time an order was executed
     * @return Builder
     */
    public Builder withLastMatchTime(Date lastMatchTime) {
      this.lastMatchTime = lastMatchTime;
      return this;
    }

    /**
     * Use this function to set totalMatched
     * 
     * @param totalMatched The total amount matched. This value is truncated at 2dp.
     * @return Builder
     */
    public Builder withTotalMatched(double totalMatched) {
      this.totalMatched = totalMatched;
      return this;
    }

    /**
     * Use this function to set totalAvailable
     * 
     * @param totalAvailable The total amount of orders that remain unmatched. This value is
     *        truncated at 2dp.
     * @return Builder
     */
    public Builder withTotalAvailable(double totalAvailable) {
      this.totalAvailable = totalAvailable;
      return this;
    }

    /**
     * Use this function to set crossMatching
     * 
     * @param crossMatching True if cross matching is enabled for this market.
     * @return Builder
     */
    public Builder withCrossMatching(boolean crossMatching) {
      this.crossMatching = crossMatching;
      return this;
    }

    /**
     * Use this function to set runnersVoidable
     * 
     * @param runnersVoidable True if runners in the market can be voided
     * @return Builder
     */
    public Builder withRunnersVoidable(boolean runnersVoidable) {
      this.runnersVoidable = runnersVoidable;
      return this;
    }

    /**
     * Use this function to set version
     * 
     * @param version The version of the market. The version increments whenever the market status
     *        changes, for example, turning in-play, or suspended when a goal score.
     * @return Builder
     */
    public Builder withVersion(long version) {
      this.version = version;
      return this;
    }

    /**
     * Use this function to set runners
     * 
     * @param runners Information about the runners (selections) in the market.
     * @return Builder
     */
    public Builder withRunners(List<Runner> runners) {
      this.runners = runners;
      return this;
    }

    public MarketBook build() {
      return new MarketBook(this);
    }
  }
}
