package prj.betfair.api.betting.operations;

import prj.betfair.api.betting.datatypes.TimeRange;
import prj.betfair.api.betting.datatypes.CurrentOrderSummaryReport;
import prj.betfair.api.betting.datatypes.SimpleTypes.OrderProjection;
import prj.betfair.api.betting.datatypes.SimpleTypes.OrderBy;
import prj.betfair.api.betting.datatypes.SimpleTypes.SortDir;

import java.util.Set;

import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

/***
 * Returns a list of your current orders. Optionally you can filter and sort your current orders
 * using the various parameters, setting none of the parameters will return all of your current
 * orders, up to a maximum of 1000 bets, ordered BY_BET and sorted EARLIEST_TO_LATEST. To retrieve
 * more than 1000 orders, you need to make use of the fromRecord and recordCount parameters.
 */
public class ListCurrentOrdersOperation {
  private final OrderBy orderBy;
  private final SortDir sortDir;
  private final int recordCount;
  private final TimeRange dateRange;
  private final TimeRange placedDateRange;
  private final Set<String> marketIds;
  private final Set<String> customerOrderRefs;
  private final Executor executor;
  private final OrderProjection orderProjection;
  private final Set<String> betIds;
  private final int fromRecord;

  public ListCurrentOrdersOperation(Builder builder) {
    this.orderBy = builder.orderBy;
    this.sortDir = builder.sortDir;
    this.recordCount = builder.recordCount;
    this.dateRange = builder.dateRange;
    this.placedDateRange = builder.placedDateRange;
    this.marketIds = builder.marketIds;
    this.customerOrderRefs = builder.customerOrderRefs;
    this.executor = builder.executor;
    this.orderProjection = builder.orderProjection;
    this.betIds = builder.betIds;
    this.fromRecord = builder.fromRecord;
  }

  /**
   * @return betIds Optionally restricts the results to the specified bet IDs.
   */
  public Set<String> getBetIds() {
    return this.betIds;
  }

  /**
   * @return marketIds Optionally restricts the results to the specified market IDs.
   */
  public Set<String> getMarketIds() {
    return this.marketIds;
  }

  /**
   *
   * @return customerOrderRefs Optionally restricts the results to the specified customer Order Refs.
   */
  public Set<String> getCustomerOrderRefs() {
    return customerOrderRefs;
  }

  /**
   * @return orderProjection Optionally restricts the results to the specified order status.
   */
  public OrderProjection getOrderProjection() {
    return this.orderProjection;
  }

  /**
   * @return placedDateRange @Deprecated use dateRange instead. Optionally restricts the results to
   *         be from/to the specified placed date. This date is inclusive, i.e. if an order was
   *         placed on exactly this date (to the millisecond) then it will be included in the
   *         results. If the from is later than the to, no results will be returned.
   */
  public TimeRange getPlacedDateRange() {
    return this.placedDateRange;
  }

  /**
   * @return dateRange Replacement for placedDateRange to allow filtering by other date fields
   *         rather than just placedDate. Optionally restricts the results to be from/to the
   *         specified date, these dates are contextual to the orders being returned and therefore
   *         the dates used to filter on will change to placed, matched, voided or settled dates
   *         depending on the orderBy. This date is inclusive, i.e. if an order was placed on
   *         exactly this date (to the millisecond) then it will be included in the results. If the
   *         from is later than the to, no results will be returned.
   */
  public TimeRange getDateRange() {
    return this.dateRange;
  }

  /**
   * @return orderBy Specifies how the results will be ordered. If no value is passed in, it
   *         defaults to BY_BET. Also acts as a filter such that only orders with a valid value in
   *         the field being ordered by will be returned (i.e. BY_VOID_TIME returns only voided
   *         orders, BY_SETTLED_TIME returns only settled orders and BY_MATCH_TIME returns only
   *         orders with a matched date (voided, settled, matched orders)).
   */
  public OrderBy getOrderBy() {
    return this.orderBy;
  }

  /**
   * @return sortDir Specifies the direction the results will be sorted in. If no value is passed
   *         in, it defaults to EARLIEST_TO_LATEST.
   */
  public SortDir getSortDir() {
    return this.sortDir;
  }

  /**
   * @return fromRecord Specifies the first record that will be returned. Records start at index
   *         zero, not at index one.
   */
  public int getFromRecord() {
    return this.fromRecord;
  }

  /**
   * @return recordCount Specifies how many records will be returned, from the index position
   *         'fromRecord'. Note that there is a page size limit of 1000. A value of zero indicates
   *         that you would like all records (including and from 'fromRecord') up to the limit.
   */
  public int getRecordCount() {
    return this.recordCount;
  }

  public CurrentOrderSummaryReport execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private OrderBy orderBy;
    private SortDir sortDir;
    private int recordCount;
    private TimeRange dateRange;
    private TimeRange placedDateRange;
    private Set<String> marketIds;
    private Set<String> customerOrderRefs;
    private OrderProjection orderProjection;
    private Set<String> betIds;
    private int fromRecord;
    private Executor executor;

    public Builder() {}

    /**
     * Use this function to set betIds
     * 
     * @param betIds Optionally restricts the results to the specified bet IDs.
     * @return Builder
     */
    public Builder withBetIds(Set<String> betIds) {
      this.betIds = betIds;
      return this;
    }

    /**
     * Use this function to set marketIds
     * 
     * @param marketIds Optionally restricts the results to the specified market IDs.
     * @return Builder
     */
    public Builder withMarketIds(Set<String> marketIds) {
      this.marketIds = marketIds;
      return this;
    }

    /**
     * Use this function to set customerOrderRefs
     *
     * @param customerOrderRefs Optionally restricts the results to the specified Customer Order Refs.
     * @return Builder
     */
    public Builder withCustomerOrderRefs(Set<String> customerOrderRefs) {
      this.customerOrderRefs = customerOrderRefs;
      return this;
    }

    /**
     * Use this function to set orderProjection
     * 
     * @param orderProjection Optionally restricts the results to the specified order status.
     * @return Builder
     */
    public Builder withOrderProjection(OrderProjection orderProjection) {
      this.orderProjection = orderProjection;
      return this;
    }

    /**
     * @deprecated Use this function to set placedDateRange
     * @param placedDateRange use dateRange instead. Optionally restricts the results to be from/to
     *        the specified placed date. This date is inclusive, i.e. if an order was placed on
     *        exactly this date (to the millisecond) then it will be included in the results. If the
     *        from is later than the to, no results will be returned.
     * @return Builder
     */
    @Deprecated
    public Builder withPlacedDateRange(TimeRange placedDateRange) {
      this.placedDateRange = placedDateRange;
      return this;
    }

    /**
     * Use this function to set dateRange
     * 
     * @param dateRange Replacement for placedDateRange to allow filtering by other date fields
     *        rather than just placedDate. Optionally restricts the results to be from/to the
     *        specified date, these dates are contextual to the orders being returned and therefore
     *        the dates used to filter on will change to placed, matched, voided or settled dates
     *        depending on the orderBy. This date is inclusive, i.e. if an order was placed on
     *        exactly this date (to the millisecond) then it will be included in the results. If the
     *        from is later than the to, no results will be returned.
     * @return Builder
     */
    public Builder withDateRange(TimeRange dateRange) {
      this.dateRange = dateRange;
      return this;
    }

    /**
     * Use this function to set orderBy
     * 
     * @param orderBy Specifies how the results will be ordered. If no value is passed in, it
     *        defaults to BY_BET. Also acts as a filter such that only orders with a valid value in
     *        the field being ordered by will be returned (i.e. BY_VOID_TIME returns only voided
     *        orders, BY_SETTLED_TIME returns only settled orders and BY_MATCH_TIME returns only
     *        orders with a matched date (voided, settled, matched orders)).
     * @return Builder
     */
    public Builder withOrderBy(OrderBy orderBy) {
      this.orderBy = orderBy;
      return this;
    }

    /**
     * Use this function to set sortDir
     * 
     * @param sortDir Specifies the direction the results will be sorted in. If no value is passed
     *        in, it defaults to EARLIEST_TO_LATEST.
     * @return Builder
     */
    public Builder withSortDir(SortDir sortDir) {
      this.sortDir = sortDir;
      return this;
    }

    /**
     * Use this function to set fromRecord
     * 
     * @param fromRecord Specifies the first record that will be returned. Records start at index
     *        zero, not at index one.
     * @return Builder
     */
    public Builder withFromRecord(int fromRecord) {
      this.fromRecord = fromRecord;
      return this;
    }

    /**
     * Use this function to set recordCount
     * 
     * @param recordCount Specifies how many records will be returned, from the index position
     *        'fromRecord'. Note that there is a page size limit of 1000. A value of zero indicates
     *        that you would like all records (including and from 'fromRecord') up to the limit.
     * @return Builder
     */
    public Builder withRecordCount(int recordCount) {
      this.recordCount = recordCount;
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

    public ListCurrentOrdersOperation build() {
      return new ListCurrentOrdersOperation(this);
    }
  }

}
