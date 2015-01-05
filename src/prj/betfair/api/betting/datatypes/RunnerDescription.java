package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.RunnerDescription;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = RunnerDescription.Builder.class)
public class RunnerDescription {
  private final String runnerName;
  private final HashMap<String, String> metadata;

  public RunnerDescription(Builder builder) {
    this.runnerName = builder.runnerName;
    this.metadata = builder.metadata;
  }

  /**
   * @return runnerName The name of the runner
   */
  public String getRunnerName() {
    return this.runnerName;
  }

  /**
   * @return metadata The metadata for this runner, such as horse racing silks.
   */
  public HashMap<String, String> getMetadata() {
    return this.metadata;
  }

  public static class Builder {
    private String runnerName;
    private HashMap<String, String> metadata;

    /**
     * @param runnerName : The name of the runner
     */
    public Builder(@JsonProperty("runnerName") String runnerName) {
      this.runnerName = runnerName;
    }

    /**
     * Use this function to set metadata
     * 
     * @param metadata The metadata for this runner, such as horse racing silks.
     * @return Builder
     */
    public Builder withMetadata(HashMap<String, String> metadata) {
      this.metadata = metadata;
      return this;
    }

    public RunnerDescription build() {
      return new RunnerDescription(this);
    }
  }
}
