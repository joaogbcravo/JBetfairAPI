package prj.betfair.api.betting.operations;

import java.util.List;
import java.util.Set;

import prj.betfair.api.betting.datatypes.MarketFilter;
import prj.betfair.api.betting.datatypes.PlaceInstruction;
import prj.betfair.api.betting.datatypes.ReplaceInstruction;
import prj.betfair.api.betting.datatypes.SimpleTypes.BetStatus;
import prj.betfair.api.betting.datatypes.SimpleTypes.TimeGranularity;
import prj.betfair.api.betting.datatypes.UpdateInstruction;


/**
 * This class serves holds a collection of factory methods for the betting operations provided
 * within this API. Each method will return a Builder for the corresponding operation with the
 * preset operation executor provided at creation of the OperationBuilderFactory.
 */
public class OperationBuilder {
  private final Executor executor;

  public OperationBuilder(Executor executor) {
    this.executor = executor;
  }

  /**
   * Returns a cancelOrdersOperation builder with the OperationBuilderFactory's executor
   * 
   * @return CancelOrdersOperation.Builder
   */
  public CancelOrdersOperation.Builder cancelOrders() {
    return new CancelOrdersOperation.Builder().withExecutor(executor);
  }

  /**
   * Returns a listClearedOrdersOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListClearedOrdersOperation.Builder
   */
  public ListClearedOrdersOperation.Builder listClearedOrders(BetStatus betStatus) {
    return new ListClearedOrdersOperation.Builder(betStatus).withExecutor(executor);
  }

  /**
   * Returns a listCompetitionsOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListCompetitionsOperation.Builder
   */
  public ListCompetitionsOperation.Builder listCompetitions(MarketFilter marketFilter) {
    return new ListCompetitionsOperation.Builder(marketFilter).withExecutor(executor);
  }

  /**
   * Returns a listCountriesOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListCompetitionsOperation.Builder
   */
  public ListCountriesOperation.Builder listCountries(MarketFilter marketFilter) {
    return new ListCountriesOperation.Builder(marketFilter).withExecutor(executor);
  }

  /**
   * Returns a listCurrentOrdersOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListCurrentOrdersOperation.Builder
   */
  public ListCurrentOrdersOperation.Builder listCurrentOrder() {
    return new ListCurrentOrdersOperation.Builder().withExecutor(executor);
  }

  /**
   * Returns a listEventsOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListEventsOperation.Builder
   */
  public ListEventsOperation.Builder listEvents(MarketFilter marketFilter) {
    return new ListEventsOperation.Builder(marketFilter).withExecutor(executor);
  }

  /**
   * Returns a listEventTypesOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListEventTypesOperation.Builder
   */
  public ListEventTypesOperation.Builder listEventTypes(MarketFilter marketFilter) {
    return new ListEventTypesOperation.Builder(marketFilter).withExecutor(executor);
  }

  /**
   * Returns a listMarketBookOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListMarketBookOperation.Builder
   */
  public ListMarketBookOperation.Builder listMarketBook(List<String> marketIds) {
    return new ListMarketBookOperation.Builder(marketIds).withExecutor(executor);
  }

  /**
   * Returns a listMarketCatalogueOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListMarketCatalogueOperation.Builder
   */
  public ListMarketCatalogueOperation.Builder listMarketCatalogue(MarketFilter marketFilter,
      int maxResults) {
    return new ListMarketCatalogueOperation.Builder(marketFilter, maxResults)
        .withExecutor(executor);
  }

  /**
   * Returns a listMarketProfitAndLossOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListMarketProfitAndLossOperation.Builder
   */
  public ListMarketProfitAndLossOperation.Builder listMarketProfitAndLoss(Set<String> marketIds) {
    return new ListMarketProfitAndLossOperation.Builder(marketIds).withExecutor(executor);
  }

  /**
   * Returns a listMarketTypesOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListMarketTypesOperation.Builder
   */
  public ListMarketTypesOperation.Builder listMarketTypes(MarketFilter marketFilter) {
    return new ListMarketTypesOperation.Builder(marketFilter).withExecutor(executor);
  }

  /**
   * Returns a listTimeRangesOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListTimeRangesOperation.Builder
   */
  public ListTimeRangesOperation.Builder listTimeRanges(MarketFilter marketFilter,
      TimeGranularity granularity) {
    return new ListTimeRangesOperation.Builder(marketFilter, granularity).withExecutor(executor);
  }

  /**
   * Returns a listVenuesOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ListVenuesOperation.Builder
   */
  public ListVenuesOperation.Builder listVenues(MarketFilter marketFilter) {
    return new ListVenuesOperation.Builder(marketFilter).withExecutor(executor);
  }

  /**
   * Returns a placeOrdersOperation builder with the OperationBuilderFactory's executor
   * 
   * @return PlaceOrdersOperation.Builder
   */
  public PlaceOrdersOperation.Builder placeOrders(String marketId,
      List<PlaceInstruction> instructions) {
    return new PlaceOrdersOperation.Builder(instructions, marketId).withExecutor(executor);
  }

  /**
   * Returns a replaceOrdersOperation builder with the OperationBuilderFactory's executor
   * 
   * @return ReplaceOrdersOperation.Builder
   */
  public ReplaceOrdersOperation.Builder replaceOrders(String marketId,
      List<ReplaceInstruction> instructions) {
    return new ReplaceOrdersOperation.Builder(instructions, marketId).withExecutor(executor);
  }

  /**
   * Returns a updateOrdersOperation builder with the OperationBuilderFactory's executor
   * 
   * @return UpdateOrdersOperation.Builder
   */
  public UpdateOrdersOperation.Builder updateOrders(String marketId,
      List<UpdateInstruction> instructions) {
    return new UpdateOrdersOperation.Builder(instructions, marketId).withExecutor(executor);
  }

}
