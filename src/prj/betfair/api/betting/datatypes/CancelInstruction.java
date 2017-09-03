package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.CancelInstruction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Instruction to fully or partially cancel an order (only applies to LIMIT orders)
 */
@JsonDeserialize(builder = CancelInstruction.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelInstruction {
  private final String betId;
  private final double sizeReduction;

  public CancelInstruction(Builder builder) {
    this.betId = builder.betId;
    this.sizeReduction = builder.sizeReduction;
  }

  /**
   * @return betId
   */
  public String getBetId() {
    return this.betId;
  }

  /**
   * @return sizeReduction If supplied then this is a partial cancel
   */
  public double getSizeReduction() {
    return this.sizeReduction;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String betId;
    private double sizeReduction;

    /**
     * @param betId
     */
    public Builder(@JsonProperty("betId") String betId) {
      this.betId = betId;
    }

    /**
     * Use this function to set sizeReduction
     * 
     * @param sizeReduction If supplied then this is a partial cancel
     * @return Builder
     */
    public Builder withSizeReduction(double sizeReduction) {
      this.sizeReduction = sizeReduction;
      return this;
    }

    public CancelInstruction build() {
      return new CancelInstruction(this);
    }
  }
}
