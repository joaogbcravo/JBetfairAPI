package prj.betfair.api.accounts.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.accounts.datatypes.TransferResponse;
import prj.betfair.api.accounts.datatypes.SimpleTypes.Wallet;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * Transfer funds between wallets
 */
public class TransferFundsOperation {
  private final Wallet to;
  private final double amount;
  private final Wallet from;
  private final Executor executor;

  public TransferFundsOperation(Builder builder) {
    this.to = builder.to;
    this.amount = builder.amount;
    this.from = builder.from;
    this.executor = builder.executor;
  }

  /**
   * @return from Source wallet
   */
  public Wallet getFrom() {
    return this.from;
  }

  /**
   * @return to Destination wallet
   */
  public Wallet getTo() {
    return this.to;
  }

  /**
   * @return amount Amount to transfer
   */
  public double getAmount() {
    return this.amount;
  }

  public TransferResponse execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private Wallet to;
    private double amount;
    private Wallet from;
    private Executor executor;

    /**
     * @param to : Destination wallet
     * @param amount : Amount to transfer
     * @param from : Source wallet
     */
    public Builder(@JsonProperty("to") Wallet to, @JsonProperty("amount") double amount,
        @JsonProperty("from") Wallet from) {
      this.to = to;
      this.amount = amount;
      this.from = from;
    }

    /**
     * @param executor Executor for this operation
     * @return Builder
     */
    public Builder withExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    public TransferFundsOperation build() {
      return new TransferFundsOperation(this);
    }
  }

}
