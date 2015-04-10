package prj.betfair.api.common;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

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
import prj.betfair.api.betting.exceptions.ExceptionWrapper;
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

public class BetfairExecutor implements Executor {
  /* Betting operation endpoints */
  private static final String MENU =
      "https://api.betfair.com/exchange/betting/rest/v1/en/navigation/menu.json";
  private static final String LIST_CLEARED_ORDERS = "listClearedOrders/";
  private static final String LIST_COMPETITIONS = "listCompetitions/";
  private static final String LIST_COUNTRIES = "listCountries/";
  private static final String LIST_CURRENT_ORDERS = "listCurrentOrders/";
  private static final String LIST_EVENTS = "listEvents/";
  private static final String LIST_EVENT_TYPES = "listEventTypes/";
  private static final String LIST_MARKET_BOOK = "listMarketBook/";
  private static final String LIST_MARKET_CATALOGUE = "listMarketCatalogue/";
  private static final String LIST_MARKET_PROFIT_AND_LOSS = "listMarketProfitAndLoss/";
  private static final String LIST_MARKET_TYPES = "listMarketTypes/";
  private static final String LIST_TIME_RANGES = "listTimeRanges/";
  private static final String LIST_VENUES = "listVenues/";
  private static final String CANCEL_ORDERS = "cancelOrders/";
  private static final String PLACE_ORDERS = "placeOrders/";
  private static final String REPLACE_ORDERS = "replaceOrders/";
  private static final String UPDATE_ORDERS = "updateOrders/";
  
  /* Accounts operation endpoints */
  private static final String CREATE_DEVELOPER_APP_KEYS = "createDeveloperAppKeys/";
  private static final String GET_ACCOUNT_DETAILS = "getAccountDetails/";
  private static final String GET_ACCOUNT_FUNDS = "getAccountFunds/";
  private static final String GET_ACCOUNT_STATEMENT = "getAccountStatement/";
  private static final String GET_DEVELOPER_APP_KEYS = "getDeveloperAppKeys/";
  private static final String LIST_CURRENCY_RATES = "listCurrencyRates/";
  private static final String TRANSFER_FUNDS = "transferFunds/";
  
  /* Base Paths */
  private static final String BASE_PATH_BETTING = "https://api.betfair.com/exchange/betting/rest/v1.0";
  private static final String BASE_PATH_ACCOUNTS = "https://api.betfair.com/exchange/account/rest/v1.0";
  /*private static final String BASE_PATH_AU =
      "https://api-au.betfair.com/exchange/betting/rest/v1.0";*/
  private Client client;
  private Session session;
  

  public BetfairExecutor(Session session) {
    client = ClientBuilder.newClient(new ClientConfig().register(new JacksonFeature()));
    this.session = session;
  }

  @Override
  public CancelExecutionReport execute(CancelOrdersOperation operation) throws APINGException {
    return this.<CancelOrdersOperation>post(operation, BASE_PATH_BETTING, CANCEL_ORDERS).readEntity(
        new GenericType<CancelExecutionReport>() {});
  }

  @Override
  public ClearedOrderSummaryReport execute(ListClearedOrdersOperation operation)
      throws APINGException {
    return this.<ListClearedOrdersOperation>post(operation, BASE_PATH_BETTING, LIST_CLEARED_ORDERS).readEntity(
        new GenericType<ClearedOrderSummaryReport>() {});
  }

  @Override
  public ArrayList<CompetitionResult> execute(ListCompetitionsOperation operation)
      throws APINGException {
    return this.<ListCompetitionsOperation>post(operation, BASE_PATH_BETTING, LIST_COMPETITIONS).readEntity(
        new GenericType<ArrayList<CompetitionResult>>() {});

  }

  @Override
  public ArrayList<CountryCodeResult> execute(ListCountriesOperation operation)
      throws APINGException {
    return this.<ListCountriesOperation>post(operation, BASE_PATH_BETTING, LIST_COUNTRIES).readEntity(
        new GenericType<ArrayList<CountryCodeResult>>() {});
  }

  @Override
  public CurrentOrderSummaryReport execute(ListCurrentOrdersOperation operation)
      throws APINGException {
    return this.<ListCurrentOrdersOperation>post(operation, BASE_PATH_BETTING, LIST_CURRENT_ORDERS).readEntity(
        new GenericType<CurrentOrderSummaryReport>() {});

  }

  @Override
  public ArrayList<EventResult> execute(ListEventsOperation operation) throws APINGException {
    return this.<ListEventsOperation>post(operation, BASE_PATH_BETTING, LIST_EVENTS).readEntity(
        new GenericType<ArrayList<EventResult>>() {});

  }

  @Override
  public ArrayList<EventTypeResult> execute(ListEventTypesOperation operation)
      throws APINGException {
    return this.<ListEventTypesOperation>post(operation, BASE_PATH_BETTING, LIST_EVENT_TYPES).readEntity(
        new GenericType<ArrayList<EventTypeResult>>() {});
  }

  @Override
  public ArrayList<MarketBook> execute(ListMarketBookOperation operation) throws APINGException {
    return this.<ListMarketBookOperation>post(operation, BASE_PATH_BETTING, LIST_MARKET_BOOK).readEntity(
        new GenericType<ArrayList<MarketBook>>() {});
  }

  @Override
  public ArrayList<MarketCatalogue> execute(ListMarketCatalogueOperation operation)
      throws APINGException {

    return this.<ListMarketCatalogueOperation>post(operation, BASE_PATH_BETTING, LIST_MARKET_CATALOGUE).readEntity(
        new GenericType<ArrayList<MarketCatalogue>>() {});

  }

  @Override
  public ArrayList<MarketProfitAndLoss> execute(ListMarketProfitAndLossOperation operation)
      throws APINGException {
    return this.<ListMarketProfitAndLossOperation>post(operation, BASE_PATH_BETTING, LIST_MARKET_PROFIT_AND_LOSS)
        .readEntity(new GenericType<ArrayList<MarketProfitAndLoss>>() {});

  }

  @Override
  public ArrayList<MarketTypeResult> execute(ListMarketTypesOperation operation)
      throws APINGException {
    return this.<ListMarketTypesOperation>post(operation, BASE_PATH_BETTING, LIST_MARKET_TYPES).readEntity(
        new GenericType<ArrayList<MarketTypeResult>>() {});

  }

  @Override
  public ArrayList<TimeRangeResult> execute(ListTimeRangesOperation operation)
      throws APINGException {
    return this.<ListTimeRangesOperation>post(operation, BASE_PATH_BETTING, LIST_TIME_RANGES).readEntity(
        new GenericType<ArrayList<TimeRangeResult>>() {});

  }

  @Override
  public ArrayList<VenueResult> execute(ListVenuesOperation operation) throws APINGException {
    return this.<ListVenuesOperation>post(operation, BASE_PATH_BETTING, LIST_VENUES).readEntity(
        new GenericType<ArrayList<VenueResult>>() {});
  }

  @Override
  public PlaceExecutionReport execute(PlaceOrdersOperation operation) throws APINGException {
    return this.<PlaceOrdersOperation>post(operation, BASE_PATH_BETTING, PLACE_ORDERS).readEntity(
        new GenericType<PlaceExecutionReport>() {});

  }

  @Override
  public ReplaceExecutionReport execute(ReplaceOrdersOperation operation) throws APINGException {
    return this.<ReplaceOrdersOperation>post(operation, BASE_PATH_BETTING, REPLACE_ORDERS).readEntity(
        new GenericType<ReplaceExecutionReport>() {});

  }

  @Override
  public UpdateExecutionReport execute(UpdateOrdersOperation operation) throws APINGException {
    return this.<UpdateOrdersOperation>post(operation, BASE_PATH_BETTING, UPDATE_ORDERS).readEntity(
        new GenericType<UpdateExecutionReport>() {});
  }
  @Override
  public AccountDetailsResponse execute(GetAccountDetailsOperation operation) throws APINGException {
    return this.<GetAccountDetailsOperation>post(operation, BASE_PATH_ACCOUNTS, GET_ACCOUNT_DETAILS).readEntity(
        new GenericType<AccountDetailsResponse>() {});  
  }
  @Override
  public AccountFundsResponse execute(GetAccountFundsOperation operation) throws APINGException {
    return this.<GetAccountFundsOperation>post(operation, BASE_PATH_ACCOUNTS, GET_ACCOUNT_FUNDS).readEntity(
        new GenericType<AccountFundsResponse>() {});  
  }
  @Override
  public AccountStatementReport execute(GetAccountStatementOperation operation) throws APINGException {
    return this.<GetAccountStatementOperation>post(operation, BASE_PATH_ACCOUNTS, GET_ACCOUNT_STATEMENT).readEntity(
        new GenericType<AccountStatementReport>() {});
  }
  @Override
  public ArrayList<DeveloperApp> execute(GetDeveloperAppKeysOperation operation) throws APINGException {
    return this.<GetDeveloperAppKeysOperation>post(operation, BASE_PATH_ACCOUNTS, GET_DEVELOPER_APP_KEYS).readEntity(
        new GenericType<ArrayList<DeveloperApp>>() {});
  }
  @Override
  public ArrayList<CurrencyRate> execute(ListCurrencyRatesOperation operation) throws APINGException {
    return this.<ListCurrencyRatesOperation>post(operation, BASE_PATH_ACCOUNTS, LIST_CURRENCY_RATES).readEntity(
        new GenericType<ArrayList<CurrencyRate>>() {});
  }
  @Override
  public TransferResponse execute(TransferFundsOperation operation) throws APINGException {
    return this.<TransferFundsOperation>post(operation, BASE_PATH_ACCOUNTS, TRANSFER_FUNDS).readEntity(
        new GenericType<TransferResponse>() {}); 
  }
  @Override
  public DeveloperApp execute(CreateDeveloperAppKeysOperation operation) throws APINGException {
    return this.<CreateDeveloperAppKeysOperation>post(operation, BASE_PATH_ACCOUNTS, CREATE_DEVELOPER_APP_KEYS).readEntity(
        new GenericType<DeveloperApp>() {}); 
  }

  @Override
  public <T> T getNavigationData(Class<T> type) throws APINGException {
    return this.get(MENU).readEntity(type);
  }

  private Response get(String path) throws APINGException {
    Response resp =
        client.target(path).request(MediaType.TEXT_PLAIN_TYPE)
            .header("Accept", " application/json")
            .header("X-Application", session.getProduct())
            .header("X-Authentication", session.getToken())
            .header("content-type", "application/json").get();
    /* Handle bad request */
    if (resp.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
      ExceptionWrapper e = resp.readEntity(ExceptionWrapper.class);
      throw new APINGException(e.getDetail().getAPINGException().getErrorCode());
    }
    return resp;
  }

  private <T> Response post(T operation, String target, String path) throws APINGException {
    Response resp =
        client.target(target).path(path).request(MediaType.TEXT_PLAIN_TYPE)
            .header("Accept", " application/json")
            .header("X-Application", session.getProduct())
            .header("X-Authentication", session.getToken())
            .header("content-type", "application/json")
            .post(Entity.entity(operation, MediaType.APPLICATION_JSON_TYPE));

    /* Handle bad request */
    if (resp.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
      ExceptionWrapper e = resp.readEntity(ExceptionWrapper.class);
      throw new APINGException(e.getDetail().getAPINGException().getErrorCode() +
          " " +e.getDetail().getAPINGException().getErrorDetails());
      
    }
    return resp;
  }

  @Override
  public Session getApplicationToken() {
    return session;
  }

  @Override
  public void setApplicationToken(Session applicationToken) {
    this.session = applicationToken;
  }
}
