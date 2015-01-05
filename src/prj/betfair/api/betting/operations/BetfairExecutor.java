package prj.betfair.api.betting.operations;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

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
import prj.betfair.api.betting.navigation.NavigationItem;
import prj.betfair.api.login.ApplicationToken;

public class BetfairExecutor implements Executor {
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
  private static final String BASE_PATH = "https://api.betfair.com/exchange/betting/rest/v1.0";

  private Client client;
  private ApplicationToken applicationToken;

  public BetfairExecutor(Client client) {
    this.client = client;
  }

  public BetfairExecutor() {
    client = ClientBuilder.newClient(new ClientConfig().register(new JacksonFeature()));
  }

  @Override
  public CancelExecutionReport execute(CancelOrdersOperation operation) throws APINGException {
    return this.<CancelOrdersOperation>post(operation, CANCEL_ORDERS).readEntity(
        new GenericType<CancelExecutionReport>() {});
  }

  @Override
  public ClearedOrderSummaryReport execute(ListClearedOrdersOperation operation)
      throws APINGException {
    return this.<ListClearedOrdersOperation>post(operation, LIST_CLEARED_ORDERS).readEntity(
        new GenericType<ClearedOrderSummaryReport>() {});
  }

  @Override
  public ArrayList<CompetitionResult> execute(ListCompetitionsOperation operation)
      throws APINGException {
    return this.<ListCompetitionsOperation>post(operation, LIST_COMPETITIONS).readEntity(
        new GenericType<ArrayList<CompetitionResult>>() {});

  }

  @Override
  public ArrayList<CountryCodeResult> execute(ListCountriesOperation operation)
      throws APINGException {
    return this.<ListCountriesOperation>post(operation, LIST_COUNTRIES).readEntity(
        new GenericType<ArrayList<CountryCodeResult>>() {});
  }

  @Override
  public CurrentOrderSummaryReport execute(ListCurrentOrdersOperation operation)
      throws APINGException {
    return this.<ListCurrentOrdersOperation>post(operation, LIST_CURRENT_ORDERS).readEntity(
        new GenericType<CurrentOrderSummaryReport>() {});

  }

  @Override
  public ArrayList<EventResult> execute(ListEventsOperation operation) throws APINGException {
    return this.<ListEventsOperation>post(operation, LIST_EVENTS).readEntity(
        new GenericType<ArrayList<EventResult>>() {});

  }

  @Override
  public ArrayList<EventTypeResult> execute(ListEventTypesOperation operation)
      throws APINGException {
    return this.<ListEventTypesOperation>post(operation, LIST_EVENT_TYPES).readEntity(
        new GenericType<ArrayList<EventTypeResult>>() {});
  }

  @Override
  public ArrayList<MarketBook> execute(ListMarketBookOperation operation) throws APINGException {
    return this.<ListMarketBookOperation>post(operation, LIST_MARKET_BOOK).readEntity(
        new GenericType<ArrayList<MarketBook>>() {});

    /*
     * ObjectMapper mapper = new ObjectMapper(); try { return mapper.readValue(new
     * File("./marketBook.txt"), mapper.getTypeFactory().constructCollectionType( ArrayList.class,
     * MarketBook.class)); } catch (IOException e) { // TODO Auto-generated catch block
     * e.printStackTrace(); System.exit(0); } return null;
     */
  }

  @Override
  public ArrayList<MarketCatalogue> execute(ListMarketCatalogueOperation operation)
      throws APINGException {
    return this.<ListMarketCatalogueOperation>post(operation, LIST_MARKET_CATALOGUE).readEntity(
        new GenericType<ArrayList<MarketCatalogue>>() {});

  }

  @Override
  public ArrayList<MarketProfitAndLoss> execute(ListMarketProfitAndLossOperation operation)
      throws APINGException {
    return this.<ListMarketProfitAndLossOperation>post(operation, LIST_MARKET_PROFIT_AND_LOSS)
        .readEntity(new GenericType<ArrayList<MarketProfitAndLoss>>() {});

  }

  @Override
  public ArrayList<MarketTypeResult> execute(ListMarketTypesOperation operation)
      throws APINGException {
    return this.<ListMarketTypesOperation>post(operation, LIST_MARKET_TYPES).readEntity(
        new GenericType<ArrayList<MarketTypeResult>>() {});

  }

  @Override
  public ArrayList<TimeRangeResult> execute(ListTimeRangesOperation operation)
      throws APINGException {
    return this.<ListTimeRangesOperation>post(operation, LIST_TIME_RANGES).readEntity(
        new GenericType<ArrayList<TimeRangeResult>>() {});

  }

  @Override
  public ArrayList<VenueResult> execute(ListVenuesOperation operation) throws APINGException {
    return this.<ListVenuesOperation>post(operation, LIST_VENUES).readEntity(
        new GenericType<ArrayList<VenueResult>>() {});
  }

  @Override
  public PlaceExecutionReport execute(PlaceOrdersOperation operation) throws APINGException {
    return this.<PlaceOrdersOperation>post(operation, PLACE_ORDERS).readEntity(
        new GenericType<PlaceExecutionReport>() {});

  }

  @Override
  public ReplaceExecutionReport execute(ReplaceOrdersOperation operation) throws APINGException {
    return this.<ReplaceOrdersOperation>post(operation, REPLACE_ORDERS).readEntity(
        new GenericType<ReplaceExecutionReport>() {});

  }

  @Override
  public UpdateExecutionReport execute(UpdateOrdersOperation operation) throws APINGException {
    return this.<UpdateOrdersOperation>post(operation, UPDATE_ORDERS).readEntity(
        new GenericType<UpdateExecutionReport>() {});

  }

  @Override
  public NavigationItem getNavigationData() throws APINGException {
    return this.get(MENU).readEntity(NavigationItem.class);
  }

  private Response get(String path) throws APINGException {
    Response resp =
        client.target(path).request(MediaType.TEXT_PLAIN_TYPE)
            .header("Accept", " application/json")
            .header("X-Application", applicationToken.getProduct())
            .header("X-Authentication", applicationToken.getToken())
            .header("content-type", "application/json").get();
    /* Handle bad request */
    if (resp.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
      ExceptionWrapper e = resp.readEntity(ExceptionWrapper.class);
      throw new APINGException(e.getDetail().getAPINGException().getErrorCode());
    }
    return resp;
  }

  private <T> Response post(T operation, String path) throws APINGException {
    Response resp =
        client.target(BASE_PATH).path(path).request(MediaType.TEXT_PLAIN_TYPE)
            .header("Accept", " application/json")
            .header("X-Application", applicationToken.getProduct())
            .header("X-Authentication", applicationToken.getToken())
            .header("content-type", "application/json")
            .post(Entity.entity(operation, MediaType.APPLICATION_JSON_TYPE));

    /* Handle bad request */
    if (resp.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {

      ExceptionWrapper e = resp.readEntity(ExceptionWrapper.class);
      throw new APINGException(e.getDetail().getAPINGException().getErrorCode());

    }
    return resp;
  }

  @Override
  public ApplicationToken getApplicationToken() {
    return applicationToken;
  }

  @Override
  public void setApplicationToken(ApplicationToken applicationToken) {
    this.applicationToken = applicationToken;
  }
}
