package prj.betfair.api.betting.operations;

import prj.betfair.api.betting.datatypes.CancelInstruction;
import prj.betfair.api.betting.datatypes.CancelExecutionReport;

import java.util.List;

import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * Cancel all bets OR cancel all bets on a market OR fully or partially cancel particular orders on
 * a market. Only LIMIT orders an be cancelled or partially cancelled once placed.
 */
public class CancelOrdersOperation {
  private final List<CancelInstruction> instructions;
  private final Executor executor;
  private final String customerRef;
  private final String marketId;

  public CancelOrdersOperation(Builder builder) {
    this.instructions = builder.instructions;
    this.executor = builder.executor;
    this.customerRef = builder.customerRef;
    this.marketId = builder.marketId;
  }

  /**
   * @return marketId If not supplied all bets are cancelled
   */
  public String getMarketId() {
    return this.marketId;
  }

  /**
   * @return instructions All instructions need to be on the same market. If not supplied all bets
   *         on the market (if market id is passed) are fully cancelled
   */
  public List<CancelInstruction> getInstructions() {
    return this.instructions;
  }

  /**
   * @return customerRef Optional parameter allowing the client to pass a unique string (upto 32
   *         chars) that is used to de-dupe mistaken re-submitions.
   */
  public String getCustomerRef() {
    return this.customerRef;
  }

  public CancelExecutionReport execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private List<CancelInstruction> instructions;
    private String customerRef;
    private String marketId;
    private Executor executor;

    public Builder() {}

    /**
     * Use this function to set marketId
     * 
     * @param marketId If not supplied all bets are cancelled
     * @return Builder
     */
    public Builder withMarketId(String marketId) {
      this.marketId = marketId;
      return this;
    }

    /**
     * Use this function to set instructions
     * 
     * @param instructions All instructions need to be on the same market. If not supplied all bets
     *        on the market (if market id is passed) are fully cancelled
     * @return Builder
     */
    public Builder withInstructions(List<CancelInstruction> instructions) {
      this.instructions = instructions;
      return this;
    }

    /**
     * Use this function to set customerRef
     * 
     * @param customerRef Optional parameter allowing the client to pass a unique string (upto 32
     *        chars) that is used to de-dupe mistaken re-submitions.
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

    public CancelOrdersOperation build() {
      return new CancelOrdersOperation(this);
    }
  }

}
