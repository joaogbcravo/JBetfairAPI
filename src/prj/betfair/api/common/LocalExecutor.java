package prj.betfair.api.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

public class LocalExecutor implements Executor {

  protected String navigationDataPath;
  protected String listMarketCatalogueDataPath;
  protected String listMarketBookDataPath;

  @Override
  public CancelExecutionReport execute(CancelOrdersOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ClearedOrderSummaryReport execute(ListClearedOrdersOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<CompetitionResult> execute(ListCompetitionsOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<CountryCodeResult> execute(ListCountriesOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CurrentOrderSummaryReport execute(ListCurrentOrdersOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<EventResult> execute(ListEventsOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<EventTypeResult> execute(ListEventTypesOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<MarketBook> execute(ListMarketBookOperation operation) throws APINGException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(new File(listMarketBookDataPath),
          new TypeReference<ArrayList<MarketBook>>() {});
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(0);
    }
    return null;
  }

  @Override
  public ArrayList<MarketCatalogue> execute(ListMarketCatalogueOperation operation)
      throws APINGException {

    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(new File(listMarketCatalogueDataPath),
          new TypeReference<ArrayList<MarketCatalogue>>() {});
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(0);
    }
    return null;
  }

  @Override
  public ArrayList<MarketProfitAndLoss> execute(ListMarketProfitAndLossOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<MarketTypeResult> execute(ListMarketTypesOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<TimeRangeResult> execute(ListTimeRangesOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<VenueResult> execute(ListVenuesOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PlaceExecutionReport execute(PlaceOrdersOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReplaceExecutionReport execute(ReplaceOrdersOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UpdateExecutionReport execute(UpdateOrdersOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T getNavigationData(Class<T> type) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.readValue(new File(navigationDataPath), type);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(0);
    }
    return null;
  }

  @Override
  public Session getApplicationToken() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setApplicationToken(Session applicationToken) {
    // TODO Auto-generated method stub

  }

  public void setNavigationData(String navigationDataPath) {
    this.navigationDataPath = navigationDataPath;
  }

  public void setListMarketCatalogueDataPath(String path) {
    this.listMarketCatalogueDataPath = path;
  }

  public void setListMarketBookPath(String path) {
    this.listMarketBookDataPath = path;
  }

  @Override
  public TransferResponse execute(TransferFundsOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<CurrencyRate> execute(ListCurrencyRatesOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<DeveloperApp> execute(GetDeveloperAppKeysOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AccountStatementReport execute(GetAccountStatementOperation operation)
      throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AccountFundsResponse execute(GetAccountFundsOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AccountDetailsResponse execute(GetAccountDetailsOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public DeveloperApp execute(CreateDeveloperAppKeysOperation operation) throws APINGException {
    // TODO Auto-generated method stub
    return null;
  }

}
