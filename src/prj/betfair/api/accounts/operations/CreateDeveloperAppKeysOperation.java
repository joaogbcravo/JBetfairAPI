package prj.betfair.api.accounts.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.accounts.datatypes.DeveloperApp;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * Create 2 application keys for given user; one active and the other delayed
 */
public class CreateDeveloperAppKeysOperation {
  private final Executor executor;
  private final String appName;

  public CreateDeveloperAppKeysOperation(Builder builder) {
    this.executor = builder.executor;
    this.appName = builder.appName;
  }

  /**
   * @return appName A Display name for the application.
   */
  public String getAppName() {
    return this.appName;
  }

  public DeveloperApp execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private String appName;
    private Executor executor;

    /**
     * @param appName : A Display name for the application.
     */
    public Builder(@JsonProperty("appName") String appName) {
      this.appName = appName;
    }

    /**
     * @param executor Executor for this operation
     * @return Builder
     */
    public Builder withExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    public CreateDeveloperAppKeysOperation build() {
      return new CreateDeveloperAppKeysOperation(this);
    }
  }

}
