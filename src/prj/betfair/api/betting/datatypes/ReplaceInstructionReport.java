package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.PlaceInstructionReport;
import prj.betfair.api.betting.datatypes.ReplaceInstructionReport;
import prj.betfair.api.betting.datatypes.CancelInstructionReport;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ReplaceInstructionReport.Builder.class)
public class ReplaceInstructionReport {
  private final String status;
  private final String errorCode;
  private final CancelInstructionReport cancelInstructionReport;
  private final PlaceInstructionReport placeInstructionReport;

  public ReplaceInstructionReport(Builder builder) {
    this.status = builder.status;
    this.errorCode = builder.errorCode;
    this.cancelInstructionReport = builder.cancelInstructionReport;
    this.placeInstructionReport = builder.placeInstructionReport;
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
   * @return cancelInstructionReport Cancelation report for the original order
   */
  public CancelInstructionReport getCancelInstructionReport() {
    return this.cancelInstructionReport;
  }

  /**
   * @return placeInstructionReport Placement report for the new order
   */
  public PlaceInstructionReport getPlaceInstructionReport() {
    return this.placeInstructionReport;
  }

  public static class Builder {
    private String status;
    private String errorCode;
    private CancelInstructionReport cancelInstructionReport;
    private PlaceInstructionReport placeInstructionReport;

    /**
     * @param status : whether the command succeeded or failed
     */
    public Builder(@JsonProperty("status") String status) {
      this.status = status;
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
     * Use this function to set cancelInstructionReport
     * 
     * @param cancelInstructionReport Cancelation report for the original order
     * @return Builder
     */
    public Builder withCancelInstructionReport(CancelInstructionReport cancelInstructionReport) {
      this.cancelInstructionReport = cancelInstructionReport;
      return this;
    }

    /**
     * Use this function to set placeInstructionReport
     * 
     * @param placeInstructionReport Placement report for the new order
     * @return Builder
     */
    public Builder withPlaceInstructionReport(PlaceInstructionReport placeInstructionReport) {
      this.placeInstructionReport = placeInstructionReport;
      return this;
    }

    public ReplaceInstructionReport build() {
      return new ReplaceInstructionReport(this);
    }
  }
}
