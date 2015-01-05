package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.CancelInstruction;
import prj.betfair.api.betting.datatypes.CancelInstructionReport;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = CancelInstructionReport.Builder.class)
public class CancelInstructionReport {
  private final String status;
  private final String errorCode;
  private final CancelInstruction instruction;
  private final double sizeCancelled;
  private final Date cancelledDate;

  public CancelInstructionReport(Builder builder) {
    this.status = builder.status;
    this.errorCode = builder.errorCode;
    this.instruction = builder.instruction;
    this.sizeCancelled = builder.sizeCancelled;
    this.cancelledDate = builder.cancelledDate;
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
  public CancelInstruction getInstruction() {
    return this.instruction;
  }

  /**
   * @return sizeCancelled
   */
  public double getSizeCancelled() {
    return this.sizeCancelled;
  }

  /**
   * @return cancelledDate
   */
  public Date getCancelledDate() {
    return this.cancelledDate;
  }

  public static class Builder {
    private String status;
    private String errorCode;
    private CancelInstruction instruction;
    private double sizeCancelled;
    private Date cancelledDate;

    /**
     * @param status : whether the command succeeded or failed
     * @param cancelledDate
     * @param sizeCancelled
     */
    public Builder(@JsonProperty("status") String status,
        @JsonProperty("cancelledDate") Date cancelledDate,
        @JsonProperty("sizeCancelled") double sizeCancelled) {
      this.status = status;
      this.cancelledDate = cancelledDate;
      this.sizeCancelled = sizeCancelled;
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

    /**
     * Use this function to set instruction
     * 
     * @param instruction The instruction that was requested
     * @return Builder
     */
    public Builder withInstruction(CancelInstruction instruction) {
      this.instruction = instruction;
      return this;
    }

    public CancelInstructionReport build() {
      return new CancelInstructionReport(this);
    }
  }
}
