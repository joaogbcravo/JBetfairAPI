package prj.betfair.api.betting.operations;

import prj.betfair.api.betting.datatypes.UpdateInstruction;
import prj.betfair.api.betting.datatypes.UpdateExecutionReport;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.exceptions.APINGException;

/***
 * Update non-exposure changing fields
 */
public class UpdateOrdersOperation {
  private final ArrayList<UpdateInstruction> instructions;
  private final Executor executor;
  private final String customerRef;
  private final String marketId;

  public UpdateOrdersOperation(Builder builder) {
    this.instructions = builder.instructions;
    this.executor = builder.executor;
    this.customerRef = builder.customerRef;
    this.marketId = builder.marketId;
  }

  /**
   * @return marketId The market id these orders are to be placed on
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return instructions
   */
  public ArrayList<UpdateInstruction> getInstructions() {
    return this.instructions;
  }

  /**
   * @return customerRef Optional parameter allowing the client to pass a unique string (up to 32
   *         chars) that is used to de-dupe mistaken re-submissions.
   */
  public String getCustomerRef() {
    return this.customerRef;
  }

  public UpdateExecutionReport execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private ArrayList<UpdateInstruction> instructions;
    private String customerRef;
    private String marketId;
    private Executor executor;

    /**
     * @param instructions
     * @param marketId : The market id these orders are to be placed on
     */
    public Builder(@JsonProperty("instructions") ArrayList<UpdateInstruction> instructions,
        @JsonProperty("marketId") String marketId) {
      this.instructions = instructions;
      this.marketId = marketId;
    }

    /**
     * Use this function to set customerRef
     * 
     * @param customerRef Optional parameter allowing the client to pass a unique string (up to 32
     *        chars) that is used to de-dupe mistaken re-submissions.
     * @return Builder
     */
    public Builder withCustomerRef(String customerRef) {
      this.customerRef = customerRef;
      return this;
    }

    /**
     * @param executor Executor for this operation
     * @return Builder
     */
    public Builder withExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    public UpdateOrdersOperation build() {
      return new UpdateOrdersOperation(this);
    }
  }

}
