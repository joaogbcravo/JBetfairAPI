package prj.betfair.api.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import prj.betfair.api.betting.datatypes.CancelExecutionReport;
import prj.betfair.api.betting.datatypes.CurrentOrderSummary;
import prj.betfair.api.betting.datatypes.CurrentOrderSummaryReport;
import prj.betfair.api.betting.datatypes.ExchangePrices;
import prj.betfair.api.betting.datatypes.LimitOrder;
import prj.betfair.api.betting.datatypes.MarketBook;
import prj.betfair.api.betting.datatypes.MarketCatalogue;
import prj.betfair.api.betting.datatypes.MarketFilter;
import prj.betfair.api.betting.datatypes.PlaceExecutionReport;
import prj.betfair.api.betting.datatypes.PlaceInstruction;
import prj.betfair.api.betting.datatypes.PriceProjection;
import prj.betfair.api.betting.datatypes.Runner;
import prj.betfair.api.betting.datatypes.RunnerCatalog;
import prj.betfair.api.betting.datatypes.SimpleTypes.MarketProjection;
import prj.betfair.api.betting.datatypes.SimpleTypes.OrderType;
import prj.betfair.api.betting.datatypes.SimpleTypes.PersistenceType;
import prj.betfair.api.betting.datatypes.SimpleTypes.PriceData;
import prj.betfair.api.betting.datatypes.SimpleTypes.Side;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.betting.navigation.Item;
import prj.betfair.api.betting.navigation.MarketItem;
import prj.betfair.api.betting.operations.OperationFactory;

public class ExchangeNavigator {
  private Item currentItem;
  private final Item root;
  private final OperationFactory opf;
  private final Cli cli;
  private final String marketOptions[] = {"place back bet",
      "place lay bet", "list bets","cancel bet"};

  public ExchangeNavigator(Item rootItem, OperationFactory operationFactory, Cli cli) {
    this.root = rootItem;
    this.currentItem = root;
    this.opf = operationFactory;
    this.cli = cli;
  }

  public boolean isRoot() {
    return (currentItem.getParent() == null);
  }

  public void navigate() {
    Integer selection = null;
    while (true) {
      if (currentItem instanceof MarketItem) {
        printMarketItem((MarketItem) currentItem);
        cli.printOptions(marketOptions);
      } else {
        cli.printOptions(currentItem.getChildren());
      }
      selection = cli.readInteger();
      /* Market item, act on option */
      if (currentItem instanceof MarketItem) {
        switch (selection) {
          case 0:
            currentItem = currentItem.getParent();
            break;
          case 1:
            placeBetOption(Side.BACK);
            break;
          case 2:
            placeBetOption(Side.LAY);
            break;
          case 3:
            printCurrentOrders();
            break;
          case 4:
            cancelBetOption();
            break;
          default:
            System.out.println("selection out of range");
        }
      }

      /* Menu option, move around the menu... */
      else if (selection < currentItem.getChildren().size() && selection > 0) {
        currentItem = currentItem.getChildren().get(selection - 1);
      } else if (selection == 0) {
        /* reached the top item, no reason to stay here... */
        if (currentItem.getParent() == null)
          return;
        currentItem = currentItem.getParent();
      }
    }
  }

  private void printMarketItem(MarketItem marketItem) {
    List<String> marketIds = Arrays.asList(currentItem.getId());
    Set<PriceData> priceDataSet = new HashSet<PriceData>();
    priceDataSet.add(PriceData.EX_BEST_OFFERS);
    PriceProjection p = new PriceProjection.Builder().withPriceData(priceDataSet).build();
    try {
      List<MarketBook> m = opf.listMarketBook(marketIds).withPriceProjection(p).build().execute();
      printMarketBook(m.get(0));
    } catch (APINGException e) {
      e.printStackTrace();
    }
  }

  private void printMarketBook(MarketBook marketBook) {
    MarketCatalogue marketCatalogue = listMarketCatalogue(marketBook.getMarketId());

    if (marketCatalogue == null) {
      System.out.println("failed to fetch marketCatalogue");
      return;
    }

    System.out.format("%-25s %s\n", "isMarketDataDelayed:",
        Boolean.toString(marketBook.getIsMarketDataDelayed()));
    System.out.format("%-25s %s\n", "status:", marketBook.getStatus());
    System.out.format("%-25s %d\n", "betDelay:", marketBook.getBetDelay());
    System.out.format("%-25s %s\n", "bspReconciled:",
        Boolean.toString(marketBook.getBspReconciled()));
    System.out.format("%-25s %s\n", "complete:", Boolean.toString(marketBook.getComplete()));
    System.out.format("%-25s %s\n", "inplay:", Boolean.toString(marketBook.getInplay()));
    System.out.format("%-25s %d\n", "numberOfWinners:", marketBook.getNumberOfWinners());
    System.out.format("%-25s %d\n", "numberOfRunners:", marketBook.getNumberOfRunners());
    System.out
        .format("%-25s %d\n", "numberOfActiveRunners:", marketBook.getNumberOfActiveRunners());

    System.out.format("%-25s %f\n", "totalMatched:", marketBook.getTotalMatched());
    System.out.format("%-25s %f\n", "totalAvailable:", marketBook.getTotalAvailable());
    System.out.format("%-25s %s\n", "crossMatching:",
        Boolean.toString(marketBook.getCrossMatching()));
    System.out.format("%-25s %s\n", "runnersVoidable:",
        Boolean.toString(marketBook.getRunnersVoidable()));
    System.out.format("%-25s %d\n", "version:", marketBook.getVersion());
    System.out.println();
    System.out
        .println("------SELECTION-----------------------|-----------------------BACK --------------------|------------------------LAY---------------------");
    for (Runner r : marketBook.getRunners()) {
      if (r.getEx() != null) {
        System.out.format("%-12d%-25s |", r.getSelectionId(),
            getRunnerName(marketCatalogue.getRunners(), r.getSelectionId()));
        printExchangePrices(r.getEx());
      }
    }
    System.out
        .println("--------------------------------------|------------------------------------------------|------------------------------------------------");
  }

  private String getRunnerName(List<RunnerCatalog> runners, long selectionId) {
    for (RunnerCatalog runner : runners) {
      if (runner.getSelectionId() == selectionId)
        return runner.getRunnerName();
    }
    return "unknown";
  }

  private MarketCatalogue listMarketCatalogue(String marketId) {
    Set<String> marketIds = new HashSet<String>();
    Set<MarketProjection> marketProjections = new HashSet<MarketProjection>();
    marketIds.add(marketId);
    marketProjections.add(MarketProjection.RUNNER_DESCRIPTION);

    MarketFilter marketFilter = new MarketFilter.Builder().withMarketIds(marketIds).build();
    try {
      List<MarketCatalogue> marketCatalogues =
          opf.listMarketCatalogue(marketFilter, 1).withMarketProjection(marketProjections).build()
              .execute();

      if (marketCatalogues.size() > 0)
        return marketCatalogues.get(0);
      else
        return null;
    } catch (APINGException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  private void placeBetOption(Side side) {
    Double amount = null;
    Double odds = null;
    Long selectionId = null;

    while (amount == null) {
      System.out.print("Amount to bet: ");
      amount = cli.readDouble();
    }

    while (odds == null) {
      System.out.print("Odds: ");
      odds = cli.readDouble();
    }

    while (selectionId == null) {
      System.out.print("selection: ");
      selectionId = cli.readLong();
    }

    while (true) {
      System.out.println("Place " + side.name() + " " + "bet: " + amount + "@" + odds
          + " on selection " + selectionId + "?");
      System.out.print("y/n:");
      String line = cli.readString();

      if (line.equalsIgnoreCase("n")) {
        return;
      } else if (line.equalsIgnoreCase("y")) {
        break;
      }
    }

    List<PlaceInstruction> placeInstructions = new ArrayList<PlaceInstruction>();
    LimitOrder limitOrder = new LimitOrder.Builder(odds, PersistenceType.PERSIST, amount).build();
    PlaceInstruction placeInstruction =
        new PlaceInstruction.Builder(OrderType.LIMIT, selectionId, side).withLimitOrder(limitOrder)
            .build();

    placeInstructions.add(placeInstruction);
    PlaceExecutionReport result;
    try {
      result =
          opf.placeOrders(((MarketItem) currentItem).getId(), placeInstructions).build().execute();
      System.out.println(result.getStatus());
    } catch (APINGException e) {
      e.printStackTrace();
    }
  }

  private void cancelBetOption() {
    try {
      CancelExecutionReport result =
          opf.cancelOrders().withMarketId(((MarketItem) currentItem).getId()).build().execute();
      System.out.println(result.getStatus());
    } catch (APINGException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private void printCurrentOrders() {
    try {
      CurrentOrderSummaryReport report = opf.listCurrentOrder().build().execute();
      List<CurrentOrderSummary> orderSummaries = report.getCurrentOrders();
      for (CurrentOrderSummary orderSummary : orderSummaries) {
        System.out
            .println("-------------------------------------------------------------------------");
        System.out.format("Selection id: %20s\n", orderSummary.getSelectionId());
        System.out.format("Bet id: %20s\n", orderSummary.getBetId());
        System.out.format("Price/size %20s\n", orderSummary.getPriceSize().getPrice() + "/"
            + orderSummary.getPriceSize().getSize());
        System.out.format("Side: %20s\n", orderSummary.getSide());
        System.out.format("Average price matched: %20f\n", orderSummary.getAveragePriceMatched());
        System.out.format("Placed date: %20s\n", orderSummary.getPlacedDate().toString());
        System.out.format("Matched date: %20s\n", orderSummary.getMatchedDate().toString());
        System.out.format("Size cancelled: %20f\n", orderSummary.getSizeCancelled());
        System.out.format("Size lapsed: %20f\n", orderSummary.getSizeLapsed());
        System.out.format("Size matched: %20f\n", orderSummary.getSizeMatched());
        System.out.format("Size remaining: %20f\n", orderSummary.getSizeRemaining());
        System.out.format("Size voided: %20f\n", orderSummary.getSizeVoided());
        System.out.format("Status %20s\n", orderSummary.getStatus());
      }
    } catch (APINGException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private void printExchangePrices(ExchangePrices prices) {
    String backPricesStr[] = {"-", "-", "-"};
    String layPricesStr[] = {"-", "-", "-"};

    for (int i = 0; i < backPricesStr.length; i++) {
      if (prices.getAvailableToLay() != null) {
        if (i < prices.getAvailableToLay().size()) {
          layPricesStr[i] =
              String.valueOf(prices.getAvailableToLay().get(i).getPrice()) + "@"
                  + String.valueOf(prices.getAvailableToLay().get(i).getSize());
        }
      }
      if (prices.getAvailableToBack() != null) {
        if (i < prices.getAvailableToBack().size()) {
          backPricesStr[i] =
              String.valueOf(prices.getAvailableToBack().get(i).getSize()) + " @ "
                  + String.valueOf(prices.getAvailableToBack().get(i).getPrice());
        }
      }
    }

    System.out.format("%15s %15s %15s | %-15s %-15s %-15s\n", backPricesStr[2], backPricesStr[1],
        backPricesStr[0], layPricesStr[2], layPricesStr[1], layPricesStr[0]);
  }
}
