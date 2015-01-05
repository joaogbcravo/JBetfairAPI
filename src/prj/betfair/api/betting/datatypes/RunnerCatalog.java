package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.RunnerCatalog;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Information about the Runners (selections) in a market
 */
@JsonDeserialize(builder = RunnerCatalog.Builder.class)
public class RunnerCatalog {
  private final double handicap;
  private final String runnerName;
  private final long selectionId;
  private final int sortPriority;
  private final HashMap<String, String> metadata;

  public RunnerCatalog(Builder builder) {
    this.handicap = builder.handicap;
    this.runnerName = builder.runnerName;
    this.selectionId = builder.selectionId;
    this.sortPriority = builder.sortPriority;
    this.metadata = builder.metadata;
  }

  /**
   * @return selectionId The unique id for the selection.
   */
  public long getSelectionId() {
    return this.selectionId;
  }

  /**
   * @return runnerName The name of the runner
   */
  public String getRunnerName() {
    return this.runnerName;
  }

  /**
   * @return handicap The handicap
   */
  public double getHandicap() {
    return this.handicap;
  }

  /**
   * @return sortPriority The sort priority of this runner
   */
  public int getSortPriority() {
    return this.sortPriority;
  }

  /**
   * @return metadata Metadata associated with the runner
   */
  public HashMap<String, String> getMetadata() {
    return this.metadata;
  }

  public static class Builder {
    private double handicap;
    private String runnerName;
    private long selectionId;
    private int sortPriority;
    private HashMap<String, String> metadata;

    /**
     * @param handicap : The handicap
     * @param runnerName : The name of the runner
     * @param selectionId : The unique id for the selection.
     * @param sortPriority : The sort priority of this runner
     */
    public Builder(@JsonProperty("handicap") double handicap,
        @JsonProperty("runnerName") String runnerName,
        @JsonProperty("selectionId") long selectionId,
        @JsonProperty("sortPriority") int sortPriority) {
      this.handicap = handicap;
      this.runnerName = runnerName;
      this.selectionId = selectionId;
      this.sortPriority = sortPriority;
    }

    /**
     * Use this function to set metadata
     * 
     * @param metadata Metadata associated with the runner
     * @return Builder
     */
    public Builder withMetadata(HashMap<String, String> metadata) {
      this.metadata = metadata;
      return this;
    }

    public RunnerCatalog build() {
      return new RunnerCatalog(this);
    }
  }
}
