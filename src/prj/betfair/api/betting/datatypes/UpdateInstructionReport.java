package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.UpdateInstruction;
import prj.betfair.api.betting.datatypes.UpdateInstructionReport;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = UpdateInstructionReport.Builder.class)
public class UpdateInstructionReport {
  private final String status;
  private final String errorCode;
  private final UpdateInstruction instruction;

  public UpdateInstructionReport(Builder builder) {
    this.status = builder.status;
    this.errorCode = builder.errorCode;
    this.instruction = builder.instruction;
  }

  /**
   * @return status whether the command succeeded or failed
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * @return errorCode cause of failure, or null if command succeeds
   */
  public String getErrorCode() {
    return this.errorCode;
  }

  /**
   * @return instruction The instruction that was requested
   */
  public UpdateInstruction getInstruction() {
    return this.instruction;
  }

  public static class Builder {
    private String status;
    private String errorCode;
    private UpdateInstruction instruction;

    /**
     * @param status : whether the command succeeded or failed
     * @param instruction : The instruction that was requested
     */
    public Builder(@JsonProperty("status") String status,
        @JsonProperty("instruction") UpdateInstruction instruction) {
      this.status = status;
      this.instruction = instruction;
    }

    /**
     * Use this function to set errorCode
     * 
     * @param errorCode cause of failure, or null if command succeeds
     * @return Builder
     */
    public Builder withErrorCode(String errorCode) {
      this.errorCode = errorCode;
      return this;
    }

    public UpdateInstructionReport build() {
      return new UpdateInstructionReport(this);
    }
  }
}
