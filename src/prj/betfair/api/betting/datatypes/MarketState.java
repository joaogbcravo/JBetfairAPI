package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.MarketState;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Market definition
 */
@JsonDeserialize(builder = MarketState.Builder.class)
public class MarketState {
  private final String status;
  private final boolean complete;
  private final boolean bspReconciled;
  private final int betDelay;
  private final double totalMatched;
  private final Date lastMatchTime;
  private final boolean inplay;
  private final int numberOfActiveRunners;
  private final double totalAvailable;

  public MarketState(Builder builder) {
    this.status = builder.status;
    this.complete = builder.complete;
    this.bspReconciled = builder.bspReconciled;
    this.betDelay = builder.betDelay;
    this.totalMatched = builder.totalMatched;
    this.lastMatchTime = builder.lastMatchTime;
    this.inplay = builder.inplay;
    this.numberOfActiveRunners = builder.numberOfActiveRunners;
    this.totalAvailable = builder.totalAvailable;
  }

  /**
   * @return status marketStatus
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * @return betDelay betDelay
   */
  public int getBetDelay() {
    return this.betDelay;
  }

  /**
   * @return bspReconciled bspReconciled
   */
  public boolean getBspReconciled() {
    return this.bspReconciled;
  }

  /**
   * @return complete complete
   */
  public boolean getComplete() {
    return this.complete;
  }

  /**
   * @return inplay inplay
   */
  public boolean getInplay() {
    return this.inplay;
  }

  /**
   * @return numberOfActiveRunners numberActiveOfRunners
   */
  public int getNumberOfActiveRunners() {
    return this.numberOfActiveRunners;
  }

  /**
   * @return lastMatchTime lastMatchTime
   */
  public Date getLastMatchTime() {
    return this.lastMatchTime;
  }

  /**
   * @return totalMatched
   */
  public double getTotalMatched() {
    return this.totalMatched;
  }

  /**
   * @return totalAvailable Zero for closed markets
   */
  public double getTotalAvailable() {
    return this.totalAvailable;
  }

  public static class Builder {
    private String status;
    private boolean complete;
    private boolean bspReconciled;
    private int betDelay;
    private double totalMatched;
    private Date lastMatchTime;
    private boolean inplay;
    private int numberOfActiveRunners;
    private double totalAvailable;

    /**
     * @param status : marketStatus
     * @param complete : complete
     * @param bspReconciled : bspReconciled
     * @param betDelay : betDelay
     * @param totalMatched
     * @param lastMatchTime : lastMatchTime
     * @param inplay : inplay
     * @param numberOfActiveRunners : numberActiveOfRunners
     * @param totalAvailable : Zero for closed markets
     */
    public Builder(@JsonProperty("status") String status,
        @JsonProperty("complete") boolean complete,
        @JsonProperty("bspReconciled") boolean bspReconciled,
        @JsonProperty("betDelay") int betDelay, @JsonProperty("totalMatched") double totalMatched,
        @JsonProperty("lastMatchTime") Date lastMatchTime, @JsonProperty("inplay") boolean inplay,
        @JsonProperty("numberOfActiveRunners") int numberOfActiveRunners,
        @JsonProperty("totalAvailable") double totalAvailable) {
      this.status = status;
      this.complete = complete;
      this.bspReconciled = bspReconciled;
      this.betDelay = betDelay;
      this.totalMatched = totalMatched;
      this.lastMatchTime = lastMatchTime;
      this.inplay = inplay;
      this.numberOfActiveRunners = numberOfActiveRunners;
      this.totalAvailable = totalAvailable;
    }

    public MarketState build() {
      return new MarketState(this);
    }
  }
}
