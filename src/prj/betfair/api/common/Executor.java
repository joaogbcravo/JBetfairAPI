package prj.betfair.api.common;

import java.util.ArrayList;
import java.util.List;

import prj.betfair.api.accounts.datatypes.AccountDetailsResponse;
import prj.betfair.api.accounts.datatypes.AccountFundsResponse;
import prj.betfair.api.accounts.datatypes.AccountStatementReport;
import prj.betfair.api.accounts.datatypes.CurrencyRate;
import prj.betfair.api.accounts.datatypes.DeveloperApp;
import prj.betfair.api.accounts.datatypes.TransferResponse;
import prj.betfair.api.accounts.operations.CreateDeveloperAppKeysOperation;
import prj.betfair.api.accounts.operations.GetAccountDetailsOperation;
import prj.betfair.api.accounts.operations.GetAccountFundsOperation;
import prj.betfair.api.accounts.operations.GetAccountStatementOperation;
import prj.betfair.api.accounts.operations.GetDeveloperAppKeysOperation;
import prj.betfair.api.accounts.operations.ListCurrencyRatesOperation;
import prj.betfair.api.accounts.operations.TransferFundsOperation;
import prj.betfair.api.betting.datatypes.CancelExecutionReport;
import prj.betfair.api.betting.datatypes.ClearedOrderSummaryReport;
import prj.betfair.api.betting.datatypes.CompetitionResult;
import prj.betfair.api.betting.datatypes.CountryCodeResult;
import prj.betfair.api.betting.datatypes.CurrentOrderSummaryReport;
import prj.betfair.api.betting.datatypes.EventResult;
import prj.betfair.api.betting.datatypes.EventTypeResult;
import prj.betfair.api.betting.datatypes.MarketBook;
import prj.betfair.api.betting.datatypes.MarketCatalogue;
import prj.betfair.api.betting.datatypes.MarketProfitAndLoss;
import prj.betfair.api.betting.datatypes.MarketTypeResult;
import prj.betfair.api.betting.datatypes.PlaceExecutionReport;
import prj.betfair.api.betting.datatypes.ReplaceExecutionReport;
import prj.betfair.api.betting.datatypes.TimeRangeResult;
import prj.betfair.api.betting.datatypes.UpdateExecutionReport;
import prj.betfair.api.betting.datatypes.VenueResult;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.betting.operations.CancelOrdersOperation;
import prj.betfair.api.betting.operations.ListClearedOrdersOperation;
import prj.betfair.api.betting.operations.ListCompetitionsOperation;
import prj.betfair.api.betting.operations.ListCountriesOperation;
import prj.betfair.api.betting.operations.ListCurrentOrdersOperation;
import prj.betfair.api.betting.operations.ListEventTypesOperation;
import prj.betfair.api.betting.operations.ListEventsOperation;
import prj.betfair.api.betting.operations.ListMarketBookOperation;
import prj.betfair.api.betting.operations.ListMarketCatalogueOperation;
import prj.betfair.api.betting.operations.ListMarketProfitAndLossOperation;
import prj.betfair.api.betting.operations.ListMarketTypesOperation;
import prj.betfair.api.betting.operations.ListTimeRangesOperation;
import prj.betfair.api.betting.operations.ListVenuesOperation;
import prj.betfair.api.betting.operations.PlaceOrdersOperation;
import prj.betfair.api.betting.operations.ReplaceOrdersOperation;
import prj.betfair.api.betting.operations.UpdateOrdersOperation;
import prj.betfair.api.session.Session;



public interface Executor {

  public abstract CancelExecutionReport execute(CancelOrdersOperation operation)
      throws APINGException;

  public abstract ClearedOrderSummaryReport execute(ListClearedOrdersOperation operation)
      throws APINGException;

  public abstract List<CompetitionResult> execute(ListCompetitionsOperation operation)
      throws APINGException;

  public abstract List<CountryCodeResult> execute(ListCountriesOperation operation)
      throws APINGException;

  public abstract CurrentOrderSummaryReport execute(ListCurrentOrdersOperation operation)
      throws APINGException;

  public abstract List<EventResult> execute(ListEventsOperation operation)
      throws APINGException;

  public abstract List<EventTypeResult> execute(ListEventTypesOperation operation)
      throws APINGException;

  public abstract List<MarketBook> execute(ListMarketBookOperation operation)
      throws APINGException;

  public abstract List<MarketCatalogue> execute(ListMarketCatalogueOperation operation)
      throws APINGException;

  public abstract List<MarketProfitAndLoss> execute(ListMarketProfitAndLossOperation operation)
      throws APINGException;

  public abstract List<MarketTypeResult> execute(ListMarketTypesOperation operation)
      throws APINGException;

  public abstract List<TimeRangeResult> execute(ListTimeRangesOperation operation)
      throws APINGException;

  public abstract List<VenueResult> execute(ListVenuesOperation operation)
      throws APINGException;

  public abstract PlaceExecutionReport execute(PlaceOrdersOperation operation)
      throws APINGException;

  public abstract ReplaceExecutionReport execute(ReplaceOrdersOperation operation)
      throws APINGException;

  public abstract UpdateExecutionReport execute(UpdateOrdersOperation operation)
      throws APINGException;

  public abstract <T> T getNavigationData(Class<T> type) throws APINGException;

  public abstract Session getApplicationToken();

  public abstract void setApplicationToken(Session applicationToken);

  public abstract TransferResponse execute(TransferFundsOperation operation) throws APINGException;

  public abstract ArrayList<CurrencyRate> execute(ListCurrencyRatesOperation operation) throws APINGException;

  public abstract ArrayList<DeveloperApp> execute(GetDeveloperAppKeysOperation operation) throws APINGException;

  public abstract AccountStatementReport execute(GetAccountStatementOperation operation) throws APINGException;

  public abstract AccountFundsResponse execute(GetAccountFundsOperation operation) throws APINGException;

  public abstract AccountDetailsResponse execute(GetAccountDetailsOperation operation) throws APINGException;

  public abstract DeveloperApp execute(CreateDeveloperAppKeysOperation operation) throws APINGException;

}
