package prj.betfair.api.betting.operations;

import prj.betfair.api.betting.datatypes.MarketCatalogue;
import prj.betfair.api.betting.datatypes.MarketFilter;
import prj.betfair.api.betting.datatypes.SimpleTypes.MarketProjection;
import prj.betfair.api.betting.datatypes.SimpleTypes.MarketSort;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.exceptions.APINGException;

/***
 * Returns a list of information about markets that does not change (or changes very rarely). You
 * use listMarketCatalogue to retrieve the name of the market, the names of selections and other
 * information about markets.
 */
public class ListMarketCatalogueOperation {
  private final MarketSort sort;
  private final Set<MarketProjection> marketProjection;
  private final String locale;
  private final int maxResults;
  private final MarketFilter filter;
  private final Executor executor;

  public ListMarketCatalogueOperation(Builder builder) {
    this.sort = builder.sort;
    this.marketProjection = builder.marketProjection;
    this.locale = builder.locale;
    this.maxResults = builder.maxResults;
    this.filter = builder.filter;
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
   * @return marketProjection The type and amount of data returned about the market.
   */
  public Set<MarketProjection> getMarketProjection() {
    return this.marketProjection;
  }

  /**
   * @return sort The order of the results. Will default to RANK if not passed
   */
  public MarketSort getSort() {
    return this.sort;
  }

  /**
   * @return maxResults limit on the total number of results returned, must be greater than 0 and
   *         less than or equal to 1000
   */
  public int getMaxResults() {
    return this.maxResults;
  }

  /**
   * @return locale The language used for the response. If not specified, the default is returned.
   */
  public String getLocale() {
    return this.locale;
  }

  public List<MarketCatalogue> execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private MarketFilter filter;
    private MarketSort sort;
    private String locale;
    private int maxResults;
    private Set<MarketProjection> marketProjection;
    private Executor executor;

    /**
     * @param filter : The filter to select desired markets. All markets that match the criteria in
     *        the filter are selected.
     * @param maxResults : limit on the total number of results returned, must be greater than 0 and
     *        less than or equal to 1000
     */
    public Builder(@JsonProperty("filter") MarketFilter filter,
        @JsonProperty("maxResults") int maxResults) {
      this.filter = filter;
      this.maxResults = maxResults;
    }

    /**
     * Use this function to set marketProjection
     * 
     * @param marketProjection The type and amount of data returned about the market.
     * @return Builder
     */
    public Builder withMarketProjection(Set<MarketProjection> marketProjection) {
      this.marketProjection = marketProjection;
      return this;
    }

    /**
     * Use this function to set sort
     * 
     * @param sort The order of the results. Will default to RANK if not passed
     * @return Builder
     */
    public Builder withSort(MarketSort sort) {
      this.sort = sort;
      return this;
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

    public ListMarketCatalogueOperation build() {
      return new ListMarketCatalogueOperation(this);
    }
  }

}
