package prj.betfair.api.accounts.operations;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import prj.betfair.api.accounts.datatypes.AccountStatementReport;
import prj.betfair.api.accounts.datatypes.TimeRange;
import prj.betfair.api.accounts.datatypes.SimpleTypes.Wallet;
import prj.betfair.api.accounts.datatypes.SimpleTypes.IncludeItem;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * Get account statement
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class GetAccountStatementOperation {
  private final IncludeItem includeItem;
  private final Integer recordCount;
  private final String locale;
  private final TimeRange itemDateRange;
  private final Wallet wallet;
  private final Executor executor;
  private final Integer fromRecord;

  public GetAccountStatementOperation(Builder builder) {
    this.includeItem = builder.includeItem;
    this.recordCount = builder.recordCount;
    this.locale = builder.locale;
    this.itemDateRange = builder.itemDateRange;
    this.wallet = builder.wallet;
    this.executor = builder.executor;
    this.fromRecord = builder.fromRecord;
  }

  /**
   * @return locale The language to be used where applicable. If not specified, the customer account
   *         default is returned.
   */
  public String getLocale() {
    return this.locale;
  }

  /**
   * @return fromRecord Specifies the first record that will be returned. Records start at index
   *         zero. If not specified then it will default to 0.
   */
  public Integer getFromRecord() {
    return this.fromRecord;
  }

  /**
   * @return recordCount Specifies the maximum number of records to be returned. Note that there is
   *         a page size limit of 100. If not specified then it will default to the page limit size.
   */
  public Integer getRecordCount() {
    return this.recordCount;
  }

  /**
   * @return itemDateRange Return items with an itemDate within this date range. Both from and to
   *         date times are inclusive. If from is not specified then the oldest available items will
   *         be in range. If to is not specified then the latest items will be in range. nb. This
   *         itemDataRange is currently only applied when includeItem is set to ALL or not
   *         specified, else items are NOT bound by itemDate.
   */
  public TimeRange getItemDateRange() {
    return this.itemDateRange;
  }

  /**
   * @return includeItem Which items to include, if not specified then defaults to ALL.
   */
  public IncludeItem getIncludeItem() {
    return this.includeItem;
  }

  /**
   * @return wallet Which wallet to return statementItems for. If unspecified then the UK wallet
   *         will be selected
   */
  public Wallet getWallet() {
    return this.wallet;
  }

  public AccountStatementReport execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private IncludeItem includeItem;
    private Integer recordCount;
    private String locale;
    private TimeRange itemDateRange;
    private Wallet wallet;
    private Integer fromRecord;
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

    public GetAccountStatementOperation build() {
      return new GetAccountStatementOperation(this);
    }
  }

}
