package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.RunnerProfitAndLoss;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Profit and loss if selection is wins or loses
 */
@JsonDeserialize(builder = RunnerProfitAndLoss.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunnerProfitAndLoss {
  private final double ifWin;
  private final double ifLose;
  private final long selectionId;

  public RunnerProfitAndLoss(Builder builder) {
    this.ifWin = builder.ifWin;
    this.ifLose = builder.ifLose;
    this.selectionId = builder.selectionId;
  }

  /**
   * @return selectionId The unique identifier for the selection
   */
  public long getSelectionId() {
    return this.selectionId;
  }

  /**
   * @return ifWin Profit and loss for the market if this selection is the winner
   */
  public double getIfWin() {
    return this.ifWin;
  }

  /**
   * @return ifLose Profit and loss for the market if this selection is the loser. Only returned for
   *         multi-winner odds markets.
   */
  public double getIfLose() {
    return this.ifLose;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private double ifWin;
    private double ifLose;
    private long selectionId;

    public Builder() {}

    /**
     * Use this function to set selectionId
     * 
     * @param selectionId The unique identifier for the selection
     * @return Builder
     */
    public Builder withSelectionId(long selectionId) {
      this.selectionId = selectionId;
      return this;
    }

    /**
     * Use this function to set ifWin
     * 
     * @param ifWin Profit and loss for the market if this selection is the winner
     * @return Builder
     */
    public Builder withIfWin(double ifWin) {
      this.ifWin = ifWin;
      return this;
    }

    /**
     * Use this function to set ifLose
     * 
     * @param ifLose Profit and loss for the market if this selection is the loser. Only returned
     *        for multi-winner odds markets.
     * @return Builder
     */
    public Builder withIfLose(double ifLose) {
      this.ifLose = ifLose;
      return this;
    }

    public RunnerProfitAndLoss build() {
      return new RunnerProfitAndLoss(this);
    }
  }
}
