package prj.betfair.api.betting.operations;

import prj.betfair.api.betting.datatypes.ReplaceInstruction;
import prj.betfair.api.betting.datatypes.ReplaceExecutionReport;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * This operation is logically a bulk cancel followed by a bulk place. The cancel is completed first
 * then the new orders are placed. The new orders will be placed atomically in that they will all be
 * placed or none will be placed. In the case where the new orders cannot be placed the
 * cancellations will not be rolled back. See ReplaceInstruction.
 */
public class ReplaceOrdersOperation {
  private final List<ReplaceInstruction> instructions;
  private final Executor executor;
  private final String customerRef;
  private final String marketId;

  public ReplaceOrdersOperation(Builder builder) {
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
  public List<ReplaceInstruction> getInstructions() {
    return this.instructions;
  }

  /**
   * @return customerRef Optional parameter allowing the client to pass a unique string (up to 32
   *         chars) that is used to de-dupe mistaken re-submissions.
   */
  public String getCustomerRef() {
    return this.customerRef;
  }

  public ReplaceExecutionReport execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private List<ReplaceInstruction> instructions;
    private String customerRef;
    private String marketId;
    private Executor executor;

    /**
     * @param instructions
     * @param marketId : The market id these orders are to be placed on
     */
    public Builder(@JsonProperty("instructions") List<ReplaceInstruction> instructions,
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

    public ReplaceOrdersOperation build() {
      return new ReplaceOrdersOperation(this);
    }
  }

}
