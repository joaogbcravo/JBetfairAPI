package prj.betfair.api.accounts.operations;

import java.util.ArrayList;

import prj.betfair.api.accounts.datatypes.DeveloperApp;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * Get all application keys owned by the given developer/vendor
 */
public class GetDeveloperAppKeysOperation {
  private final Executor executor;

  public GetDeveloperAppKeysOperation(Builder builder) {
    this.executor = builder.executor;
  }

  public ArrayList<DeveloperApp> execute() throws APINGException {
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

    public GetDeveloperAppKeysOperation build() {
      return new GetDeveloperAppKeysOperation(this);
    }
  }

}
