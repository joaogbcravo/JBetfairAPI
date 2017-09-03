package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.UpdateInstruction;
import prj.betfair.api.betting.datatypes.SimpleTypes.PersistenceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Instruction to update LIMIT bet's persistence of an order that do not affect exposure
 */
@JsonDeserialize(builder = UpdateInstruction.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateInstruction {
  private final String betId;
  private final PersistenceType newPersistenceType;

  public UpdateInstruction(Builder builder) {
    this.betId = builder.betId;
    this.newPersistenceType = builder.newPersistenceType;
  }

  /**
   * @return betId
   */
  public String getBetId() {
    return this.betId;
  }

  /**
   * @return newPersistenceType The new persistence type to update this bet to
   */
  public PersistenceType getNewPersistenceType() {
    return this.newPersistenceType;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String betId;
    private PersistenceType newPersistenceType;

    /**
     * @param betId
     * @param newPersistenceType : The new persistence type to update this bet to
     */
    public Builder(@JsonProperty("betId") String betId,
        @JsonProperty("newPersistenceType") PersistenceType newPersistenceType) {
      this.betId = betId;
      this.newPersistenceType = newPersistenceType;
    }

    public UpdateInstruction build() {
      return new UpdateInstruction(this);
    }
  }
}
