package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.ReplaceInstruction;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Instruction to replace a LIMIT or LIMIT_ON_CLOSE order at a new price. Original order will be
 * cancelled and a new order placed at the new price for the remaining stake.
 */
@JsonDeserialize(builder = ReplaceInstruction.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplaceInstruction {
  private final String betId;
  private final double newPrice;

  public ReplaceInstruction(Builder builder) {
    this.betId = builder.betId;
    this.newPrice = builder.newPrice;
  }

  /**
   * @return betId
   */
  public String getBetId() {
    return this.betId;
  }

  /**
   * @return newPrice The price to replace the bet at
   */
  public double getNewPrice() {
    return this.newPrice;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String betId;
    private double newPrice;

    /**
     * @param betId
     * @param newPrice : The price to replace the bet at
     */
    public Builder(@JsonProperty("betId") String betId, @JsonProperty("newPrice") double newPrice) {
      this.betId = betId;
      this.newPrice = newPrice;
    }

    public ReplaceInstruction build() {
      return new ReplaceInstruction(this);
    }
  }
}
