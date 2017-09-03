package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.ClearedOrderSummary;
import prj.betfair.api.betting.datatypes.ClearedOrderSummaryReport;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * A container representing search results.
 */
@JsonDeserialize(builder = ClearedOrderSummaryReport.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClearedOrderSummaryReport {
  private final boolean moreAvailable;
  private final List<ClearedOrderSummary> clearedOrders;

  public ClearedOrderSummaryReport(Builder builder) {
    this.moreAvailable = builder.moreAvailable;
    this.clearedOrders = builder.clearedOrders;
  }

  /**
   * @return clearedOrders The list of cleared orders returned by your query. This will be a valid
   *         list (i.e. empty or non-empty but never 'null').
   */
  public List<ClearedOrderSummary> getClearedOrders() {
    return this.clearedOrders;
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
    private boolean moreAvailable;
    private List<ClearedOrderSummary> clearedOrders;

    /**
     * @param moreAvailable : Indicates whether there are further result items beyond this page.
     *        Note that underlying data is highly time-dependent and the subsequent search orders
     *        query might return an empty result.
     * @param clearedOrders : The list of cleared orders returned by your query. This will be a
     *        valid list (i.e. empty or non-empty but never 'null').
     */
    public Builder(@JsonProperty("moreAvailable") boolean moreAvailable,
        @JsonProperty("clearedOrders") List<ClearedOrderSummary> clearedOrders) {
      this.moreAvailable = moreAvailable;
      this.clearedOrders = clearedOrders;
    }

    public ClearedOrderSummaryReport build() {
      return new ClearedOrderSummaryReport(this);
    }
  }
}
