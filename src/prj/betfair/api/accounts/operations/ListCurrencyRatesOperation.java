package prj.betfair.api.accounts.operations;

import java.util.ArrayList;

import prj.betfair.api.accounts.datatypes.CurrencyRate;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * Returns a list of currency rates based on given currency
 */
public class ListCurrencyRatesOperation {
  private final String fromCurrency;
  private final Executor executor;

  public ListCurrencyRatesOperation(Builder builder) {
    this.fromCurrency = builder.fromCurrency;
    this.executor = builder.executor;
  }

  /**
   * @return fromCurrency The currency from which the rates are computed. GBP is used if no value is
   *         passed
   */
  public String getFromCurrency() {
    return this.fromCurrency;
  }

  public ArrayList<CurrencyRate> execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private String fromCurrency;
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

    public ListCurrencyRatesOperation build() {
      return new ListCurrencyRatesOperation(this);
    }
  }

}
