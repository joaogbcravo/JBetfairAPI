package prj.betfair.api.betting.operations;

import prj.betfair.api.betting.datatypes.TimeRange;
import prj.betfair.api.betting.datatypes.ClearedOrderSummaryReport;
import prj.betfair.api.betting.datatypes.RunnerId;
import prj.betfair.api.betting.datatypes.SimpleTypes.Side;
import prj.betfair.api.betting.datatypes.SimpleTypes.GroupBy;
import prj.betfair.api.betting.datatypes.SimpleTypes.BetStatus;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import prj.betfair.api.betting.exceptions.APINGException;

/***
 * Returns a List of bets based on the bet status, ordered by settled date
 */
public class ListClearedOrdersOperation {
  private final int fromRecord;
  private final Set<String> eventTypeIds;
  private final int recordCount;
  private final String locale;
  private final Set<String> eventIds;
  private final Set<String> marketIds;
  private final GroupBy groupBy;
  private final BetStatus betStatus;
  private final boolean includeItemDescription;
  private final TimeRange settledDateRange;
  private final Executor executor;
  private final Set<String> betIds;
  private final Set<RunnerId> runnerIds;
  private final Side side;

  public ListClearedOrdersOperation(Builder builder) {
    this.fromRecord = builder.fromRecord;
    this.eventTypeIds = builder.eventTypeIds;
    this.recordCount = builder.recordCount;
    this.locale = builder.locale;
    this.eventIds = builder.eventIds;
    this.marketIds = builder.marketIds;
    this.groupBy = builder.groupBy;
    this.betStatus = builder.betStatus;
    this.includeItemDescription = builder.includeItemDescription;
    this.settledDateRange = builder.settledDateRange;
    this.executor = builder.executor;
    this.betIds = builder.betIds;
    this.runnerIds = builder.runnerIds;
    this.side = builder.side;
  }

  /**
   * @return betStatus Restricts the results to the specified status.
   */
  public BetStatus getBetStatus() {
    return this.betStatus;
  }

  /**
   * @return eventTypeIds Optionally restricts the results to the specified Event Type IDs.
   */
  public Set<String> getEventTypeIds() {
    return this.eventTypeIds;
  }

  /**
   * @return eventIds Optionally restricts the results to the specified Event IDs.
   */
  public Set<String> getEventIds() {
    return this.eventIds;
  }

  /**
   * @return marketIds Optionally restricts the results to the specified market IDs.
   */
  public Set<String> getMarketIds() {
    return this.marketIds;
  }

  /**
   * @return runnerIds Optionally restricts the results to the specified Runners.
   */
  public Set<RunnerId> getRunnerIds() {
    return this.runnerIds;
  }

  /**
   * @return betIds Optionally restricts the results to the specified bet IDs.
   */
  public Set<String> getBetIds() {
    return this.betIds;
  }

  /**
   * @return side Optionally restricts the results to the specified side.
   */
  public Side getSide() {
    return this.side;
  }

  /**
   * @return settledDateRange Optionally restricts the results to be from/to the specified settled
   *         date. This date is inclusive, i.e. if an order was placed on exactly this date (to the
   *         millisecond) then it will be included in the results. If the from is later than the to,
   *         no results will be returned.
   */
  public TimeRange getSettledDateRange() {
    return this.settledDateRange;
  }

  /**
   * @return groupBy How to aggregate the lines, if not supplied then the lowest level is returned,
   *         i.e. bet by bet This is only applicable to SETTLED BetStatus.
   */
  public GroupBy getGroupBy() {
    return this.groupBy;
  }

  /**
   * @return includeItemDescription If true then an ItemDescription object is included in the
   *         response.
   */
  public boolean getIncludeItemDescription() {
    return this.includeItemDescription;
  }

  /**
   * @return locale The language used for the itemDescription. If not specified, the customer
   *         account default is returned.
   */
  public String getLocale() {
    return this.locale;
  }

  /**
   * @return fromRecord Specifies the first record that will be returned. Records start at index
   *         zero.
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

  public ClearedOrderSummaryReport execute() throws APINGException {
    return executor.execute(this);
  }

  public static class Builder {
    private int fromRecord;
    private Set<String> eventTypeIds;
    private int recordCount;
    private String locale;
    private Set<String> eventIds;
    private Set<String> betIds;
    private GroupBy groupBy;
    private BetStatus betStatus;
    private boolean includeItemDescription;
    private TimeRange settledDateRange;
    private Set<String> marketIds;
    private Set<RunnerId> runnerIds;
    private Side side;
    private Executor executor;

    /**
     * @param betStatus : Restricts the results to the specified status.
     */
    public Builder(@JsonProperty("betStatus") BetStatus betStatus) {
      this.betStatus = betStatus;
    }

    /**
     * Use this function to set eventTypeIds
     * 
     * @param eventTypeIds Optionally restricts the results to the specified Event Type IDs.
     * @return Builder
     */
    public Builder withEventTypeIds(Set<String> eventTypeIds) {
      this.eventTypeIds = eventTypeIds;
      return this;
    }

    /**
     * Use this function to set eventIds
     * 
     * @param eventIds Optionally restricts the results to the specified Event IDs.
     * @return Builder
     */
    public Builder withEventIds(Set<String> eventIds) {
      this.eventIds = eventIds;
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
     * Use this function to set runnerIds
     * 
     * @param runnerIds Optionally restricts the results to the specified Runners.
     * @return Builder
     */
    public Builder withRunnerIds(Set<RunnerId> runnerIds) {
      this.runnerIds = runnerIds;
      return this;
    }

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
     * Use this function to set side
     * 
     * @param side Optionally restricts the results to the specified side.
     * @return Builder
     */
    public Builder withSide(Side side) {
      this.side = side;
      return this;
    }

    /**
     * Use this function to set settledDateRange
     * 
     * @param settledDateRange Optionally restricts the results to be from/to the specified settled
     *        date. This date is inclusive, i.e. if an order was placed on exactly this date (to the
     *        millisecond) then it will be included in the results. If the from is later than the
     *        to, no results will be returned.
     * @return Builder
     */
    public Builder withSettledDateRange(TimeRange settledDateRange) {
      this.settledDateRange = settledDateRange;
      return this;
    }

    /**
     * Use this function to set groupBy
     * 
     * @param groupBy How to aggregate the lines, if not supplied then the lowest level is returned,
     *        i.e. bet by bet This is only applicable to SETTLED BetStatus.
     * @return Builder
     */
    public Builder withGroupBy(GroupBy groupBy) {
      this.groupBy = groupBy;
      return this;
    }

    /**
     * Use this function to set includeItemDescription
     * 
     * @param includeItemDescription If true then an ItemDescription object is included in the
     *        response.
     * @return Builder
     */
    public Builder withIncludeItemDescription(boolean includeItemDescription) {
      this.includeItemDescription = includeItemDescription;
      return this;
    }

    /**
     * Use this function to set locale
     * 
     * @param locale The language used for the itemDescription. If not specified, the customer
     *        account default is returned.
     * @return Builder
     */
    public Builder withLocale(String locale) {
      this.locale = locale;
      return this;
    }

    /**
     * Use this function to set fromRecord
     * 
     * @param fromRecord Specifies the first record that will be returned. Records start at index
     *        zero.
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

    public ListClearedOrdersOperation build() {
      return new ListClearedOrdersOperation(this);
    }
  }

}
