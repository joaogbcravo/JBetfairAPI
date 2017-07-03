package prj.betfair.api.betting.operations;

import com.fasterxml.jackson.annotation.JsonProperty;
import prj.betfair.api.betting.datatypes.PlaceExecutionReport;
import prj.betfair.api.betting.datatypes.PlaceInstruction;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

import java.util.List;

/***
 * Place new orders into market. LIMIT orders below the minimum bet size are allowed if there is an
 * unmatched bet at the same price in the market. This operation is atomic in that all orders will
 * be placed or none will be placed.
 */
public class PlaceOrdersOperation {
  private final List<PlaceInstruction> instructions;
  private final Executor executor;
  private final String customerRef;
  private final String customerStrategyRef;
  private final String marketId;
  private final Boolean async;

  public PlaceOrdersOperation(Builder builder) {
    this.instructions = builder.instructions;
    this.executor = builder.executor;
    this.customerRef = builder.customerRef;
    this.customerStrategyRef = builder.customerStrategyRef;
    this.marketId = builder.marketId;
    this.async = builder.async;
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
  public List<PlaceInstruction> getInstructions() {
    return this.instructions;
  }

  /**
   * @return customerRef Optional parameter allowing the client to pass a unique string (up to 32
   *         chars) that is used to de-dupe mistaken re-submissions.
   */
  public String getCustomerRef() {
    return this.customerRef;
  }

  /**
   * @return customerStrategyRef An optional reference customers can use to specify which strategy has sent the order.
   * The reference will be returned on order change messages through the stream API.
   */
  public String getCustomerStrategyRef() {
    return customerStrategyRef;
  }

  /**
   * @return async An optional flag (not setting equates to false) which specifies if the orders should be placed
   * asynchronously. Orders can be tracked via the Exchange Stream API or or the API-NG by providing a
   * customerOrderRef for each place order. An order's status will be PENDING and no bet ID will be returned.
   */
  public Boolean getAsync() {
    return async;
  }

  public PlaceExecutionReport execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private List<PlaceInstruction> instructions;
    private String customerRef;
    private String customerStrategyRef;
    private String marketId;
    private Boolean async;
    private Executor executor;

    /**
     * @param instructions
     * @param marketId : The market id these orders are to be placed on
     */
    public Builder(@JsonProperty("instructions") List<PlaceInstruction> instructions,
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
     * Use this function to set customerStrategyRef
     *
     * @param customerStrategyRef An optional reference customers can use to specify which strategy has sent the order.
     * The reference will be returned on order change messages through the stream API.
     * @return Builder
     */
    public Builder withCustomerStrategyRef(String customerStrategyRef) {
      this.customerStrategyRef = customerStrategyRef;
      return this;
    }

    /**
     * Use this function to set async
     *
     * @param async An optional flag (not setting equates to false) which specifies if the orders should be placed
     * asynchronously. Orders can be tracked via the Exchange Stream API or or the API-NG by providing a
     * customerOrderRef for each place order. An order's status will be PENDING and no bet ID will be returned.
     * @return Builder
     */
    public Builder withAsync(Boolean async) {
      this.async = async;
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

    public PlaceOrdersOperation build() {
      return new PlaceOrdersOperation(this);
    }
  }

}
