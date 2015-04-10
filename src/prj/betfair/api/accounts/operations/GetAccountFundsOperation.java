package prj.betfair.api.accounts.operations;

import prj.betfair.api.accounts.datatypes.AccountFundsResponse;
import prj.betfair.api.accounts.datatypes.SimpleTypes.Wallet;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * Get available to bet amount.
 */
public class GetAccountFundsOperation {
  private final Wallet wallet;
  private final Executor executor;

  public GetAccountFundsOperation(Builder builder) {
    this.wallet = builder.wallet;
    this.executor = builder.executor;
  }

  /**
   * @return wallet Name of the wallet in question.
   */
  public Wallet getWallet() {
    return this.wallet;
  }

  public AccountFundsResponse execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private Wallet wallet;
    private Executor executor;

    public Builder() {}

    /**
     * @param executor Executor for this operation
     * @return Builder
     */
    public Builder withExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    public GetAccountFundsOperation build() {
      return new GetAccountFundsOperation(this);
    }
  }

}
