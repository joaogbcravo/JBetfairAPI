package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import prj.betfair.api.betting.datatypes.SimpleTypes.PriceLadderType;

/***
 * Market definition
 */
@JsonDeserialize(builder = PriceLadderDescription.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceLadderDescription {
    private final PriceLadderType type;

  public PriceLadderDescription(Builder builder) {
    this.type = builder.type;
  }

  /**
   * @return type The type of price ladder.
   */
  public PriceLadderType getType() {
    return type;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private PriceLadderType type;

    /**
     * @param type The type of price ladder.
     */
    public Builder(@JsonProperty("type") PriceLadderType type) {
      this.type = type;
    }

    public PriceLadderDescription build() {
      return new PriceLadderDescription(this);
    }
  }
}
