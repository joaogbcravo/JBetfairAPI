package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.ReplaceExecutionReport;
import prj.betfair.api.betting.datatypes.ReplaceInstructionReport;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ReplaceExecutionReport.Builder.class)
public class ReplaceExecutionReport {
  private final String status;
  private final String errorCode;
  private final List<ReplaceInstructionReport> instructionReports;
  private final String customerRef;
  private final String marketId;

  public ReplaceExecutionReport(Builder builder) {
    this.status = builder.status;
    this.errorCode = builder.errorCode;
    this.instructionReports = builder.instructionReports;
    this.customerRef = builder.customerRef;
    this.marketId = builder.marketId;
  }

  /**
   * @return customerRef Echo of the customerRef if passed.
   */
  public String getCustomerRef() {
    return this.customerRef;
  }

  /**
   * @return status
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * @return errorCode
   */
  public String getErrorCode() {
    return this.errorCode;
  }

  /**
   * @return marketId Echo of marketId passed
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return instructionReports
   */
  public List<ReplaceInstructionReport> getInstructionReports() {
    return this.instructionReports;
  }

  public static class Builder {
    private String status;
    private String errorCode;
    private List<ReplaceInstructionReport> instructionReports;
    private String customerRef;
    private String marketId;

    /**
     * @param status
     */
    public Builder(@JsonProperty("status") String status) {
      this.status = status;
    }

    /**
     * Use this function to set customerRef
     * 
     * @param customerRef Echo of the customerRef if passed.
     * @return Builder
     */
    public Builder withCustomerRef(String customerRef) {
      this.customerRef = customerRef;
      return this;
    }

    /**
     * Use this function to set errorCode
     * 
     * @param errorCode
     * @return Builder
     */
    public Builder withErrorCode(String errorCode) {
      this.errorCode = errorCode;
      return this;
    }

    /**
     * Use this function to set marketId
     * 
     * @param marketId Echo of marketId passed
     * @return Builder
     */
    public Builder withMarketId(String marketId) {
      this.marketId = marketId;
      return this;
    }

    /**
     * Use this function to set instructionReports
     * 
     * @param instructionReports
     * @return Builder
     */
    public Builder withInstructionReports(List<ReplaceInstructionReport> instructionReports) {
      this.instructionReports = instructionReports;
      return this;
    }

    public ReplaceExecutionReport build() {
      return new ReplaceExecutionReport(this);
    }
  }
}
