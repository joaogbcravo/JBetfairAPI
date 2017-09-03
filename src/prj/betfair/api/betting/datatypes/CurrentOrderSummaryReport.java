package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.CurrentOrderSummaryReport;
import prj.betfair.api.betting.datatypes.CurrentOrderSummary;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * A container representing search results.
 */
@JsonDeserialize(builder = CurrentOrderSummaryReport.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentOrderSummaryReport {
  private final List<CurrentOrderSummary> currentOrders;
  private final boolean moreAvailable;

  public CurrentOrderSummaryReport(Builder builder) {
    this.currentOrders = builder.currentOrders;
    this.moreAvailable = builder.moreAvailable;
  }

  /**
   * @return currentOrders The list of current orders returned by your query. This will be a valid
   *         list (i.e. empty or non-empty but never 'null').
   */
  public List<CurrentOrderSummary> getCurrentOrders() {
    return this.currentOrders;
  }

  /**
   * @return moreAvailable Indicates whether there are further result items beyond this page. Note
   *         that underlying data is highly time-dependent and the subsequent search orders query
   *         might return an empty result.
   */
  public boolean getMoreAvailable() {
    return this.moreAvailable;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private List<CurrentOrderSummary> currentOrders;
    private boolean moreAvailable;

    /**
     * @param currentOrders : The list of current orders returned by your query. This will be a
     *        valid list (i.e. empty or non-empty but never 'null').
     * @param moreAvailable : Indicates whether there are further result items beyond this page.
     *        Note that underlying data is highly time-dependent and the subsequent search orders
     *        query might return an empty result.
     */
    public Builder(@JsonProperty("currentOrders") List<CurrentOrderSummary> currentOrders,
        @JsonProperty("moreAvailable") boolean moreAvailable) {
      this.currentOrders = currentOrders;
      this.moreAvailable = moreAvailable;
    }

    public CurrentOrderSummaryReport build() {
      return new CurrentOrderSummaryReport(this);
    }
  }
}
