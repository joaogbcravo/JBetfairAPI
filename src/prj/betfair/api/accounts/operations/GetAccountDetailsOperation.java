package prj.betfair.api.accounts.operations;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import prj.betfair.api.accounts.datatypes.AccountDetailsResponse;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.EmptyBeanSerializer;
import prj.betfair.api.common.Executor;

/***
 * Get Account details.
 */
@JsonSerialize(using = EmptyBeanSerializer.class)
public class GetAccountDetailsOperation {
  private final Executor executor;

  public GetAccountDetailsOperation(Builder builder) {
    this.executor = builder.executor;
  }

  public AccountDetailsResponse execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
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

    public GetAccountDetailsOperation build() {
      return new GetAccountDetailsOperation(this);
    }
  }

}
