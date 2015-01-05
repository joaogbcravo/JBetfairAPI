package prj.betfair.api.betting.operations;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.datatypes.MarketFilter;
import prj.betfair.api.betting.datatypes.MarketTypeResult;
import prj.betfair.api.betting.exceptions.APINGException;

/***
 * Returns a list of market types (i.e. MATCH_ODDS, NEXT_GOAL) associated with the markets selected
 * by the MarketFilter. The market types are always the same, regardless of locale.
 */
public class ListMarketTypesOperation {
  private final MarketFilter filter;
  private final String locale;
  private final Executor executor;

  public ListMarketTypesOperation(Builder builder) {
    this.filter = builder.filter;
    this.locale = builder.locale;
    this.executor = builder.executor;
  }

  /**
   * @return filter The filter to select desired markets. All markets that match the criteria in the
   *         filter are selected.
   */
  public MarketFilter getFilter() {
    return this.filter;
  }

  /**
   * @return locale The language used for the response. If not specified, the default is returned.
   */
  public String getLocale() {
    return this.locale;
  }

  public ArrayList<MarketTypeResult> execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private MarketFilter filter;
    private String locale;
    private Executor executor;

    /**
     * @param filter : The filter to select desired markets. All markets that match the criteria in
     *        the filter are selected.
     */
    public Builder(@JsonProperty("filter") MarketFilter filter) {
      this.filter = filter;
    }

    /**
     * Use this function to set locale
     * 
     * @param locale The language used for the response. If not specified, the default is returned.
     * @return Builder
     */
    public Builder withLocale(String locale) {
      this.locale = locale;
      return this;
    }

    /**
     * @param executor Executor for this operation
     * @return Builder
     */
    public Builder withExecutor(Executor executor) {
      this.executor = executor;
      return this;
    }

    public ListMarketTypesOperation build() {
      return new ListMarketTypesOperation(this);
    }
  }

}
