package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.RunnerDescription;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = RunnerDescription.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunnerDescription {
  private final String runnerName;
  private final Map<String, String> metadata;

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
  public Map<String, String> getMetadata() {
    return this.metadata;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String runnerName;
    private Map<String, String> metadata;

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
    public Builder withMetadata(Map<String, String> metadata) {
      this.metadata = metadata;
      return this;
    }

    public RunnerDescription build() {
      return new RunnerDescription(this);
    }
  }
}
