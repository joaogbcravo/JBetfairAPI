package prj.betfair.api.betting.operations;

import prj.betfair.api.betting.datatypes.MarketBook;
import prj.betfair.api.betting.datatypes.PriceProjection;
import prj.betfair.api.betting.datatypes.SimpleTypes.MatchProjection;
import prj.betfair.api.betting.datatypes.SimpleTypes.OrderProjection;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.exceptions.APINGException;

/***
 * Returns a list of dynamic data about markets. Dynamic data includes prices, the status of the
 * market, the status of selections, the traded volume, and the status of any orders you have placed
 * in the market.
 */
public class ListMarketBookOperation {
  private final PriceProjection priceProjection;
  private final String locale;
  private final String currencyCode;
  private final ArrayList<String> marketIds;
  private final MatchProjection matchProjection;
  private final Executor executor;
  private final OrderProjection orderProjection;

  public ListMarketBookOperation(Builder builder) {
    this.priceProjection = builder.priceProjection;
    this.locale = builder.locale;
    this.currencyCode = builder.currencyCode;
    this.marketIds = builder.marketIds;
    this.matchProjection = builder.matchProjection;
    this.executor = builder.executor;
    this.orderProjection = builder.orderProjection;
  }

  /**
   * @return marketIds One or more market ids. The number of markets returned depends on the amount
   *         of data you request via the price projection.
   */
  public ArrayList<String> getMarketIds() {
    return this.marketIds;
  }

  /**
   * @return priceProjection The projection of price data you want to receive in the response.
   */
  public PriceProjection getPriceProjection() {
    return this.priceProjection;
  }

  /**
   * @return orderProjection The orders you want to receive in the response.
   */
  public OrderProjection getOrderProjection() {
    return this.orderProjection;
  }

  /**
   * @return matchProjection If you ask for orders, specifies the representation of matches.
   */
  public MatchProjection getMatchProjection() {
    return this.matchProjection;
  }

  /**
   * @return currencyCode A Betfair standard currency code. If not specified, the default currency
   *         code is used.
   */
  public String getCurrencyCode() {
    return this.currencyCode;
  }

  /**
   * @return locale The language used for the response. If not specified, the default is returned.
   */
  public String getLocale() {
    return this.locale;
  }

  public ArrayList<MarketBook> execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private PriceProjection priceProjection;
    private String locale;
    private String currencyCode;
    private ArrayList<String> marketIds;
    private MatchProjection matchProjection;
    private OrderProjection orderProjection;
    private Executor executor;

    /**
     * @param marketIds : One or more market ids. The number of markets returned depends on the
     *        amount of data you request via the price projection.
     */
    public Builder(@JsonProperty("marketIds") ArrayList<String> marketIds) {
      this.marketIds = marketIds;
    }

    /**
     * Use this function to set priceProjection
     * 
     * @param priceProjection The projection of price data you want to receive in the response.
     * @return Builder
     */
    public Builder withPriceProjection(PriceProjection priceProjection) {
      this.priceProjection = priceProjection;
      return this;
    }

    /**
     * Use this function to set orderProjection
     * 
     * @param orderProjection The orders you want to receive in the response.
     * @return Builder
     */
    public Builder withOrderProjection(OrderProjection orderProjection) {
      this.orderProjection = orderProjection;
      return this;
    }

    /**
     * Use this function to set matchProjection
     * 
     * @param matchProjection If you ask for orders, specifies the representation of matches.
     * @return Builder
     */
    public Builder withMatchProjection(MatchProjection matchProjection) {
      this.matchProjection = matchProjection;
      return this;
    }

    /**
     * Use this function to set currencyCode
     * 
     * @param currencyCode A Betfair standard currency code. If not specified, the default currency
     *        code is used.
     * @return Builder
     */
    public Builder withCurrencyCode(String currencyCode) {
      this.currencyCode = currencyCode;
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

    public ListMarketBookOperation build() {
      return new ListMarketBookOperation(this);
    }
  }

}
