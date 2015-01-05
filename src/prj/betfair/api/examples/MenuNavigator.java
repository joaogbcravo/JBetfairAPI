package prj.betfair.api.examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import prj.betfair.api.betting.datatypes.ExchangePrices;
import prj.betfair.api.betting.datatypes.MarketBook;
import prj.betfair.api.betting.datatypes.PriceProjection;
import prj.betfair.api.betting.datatypes.Runner;
import prj.betfair.api.betting.datatypes.SimpleTypes.PriceData;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.betting.navigation.NavigationItem;
import prj.betfair.api.betting.operations.OperationBuilder;

public class MenuNavigator {
  private NavigationItem root;
  private NavigationItem currentItem;
  private OperationBuilder opf;

  public MenuNavigator(NavigationItem rootItem, OperationBuilder operationFactory) {
    this.root = rootItem;
    this.currentItem = root;
    this.opf = operationFactory;
  }

  public void setRootItem(NavigationItem rootItem) {
    this.root = rootItem;
  }
  
  public void goToParent() {
    if (!currentItem.equals(root)) {
      currentItem = currentItem.getParent();
    }
    else {
      System.out.println("Goodbye!");
      System.exit(0);
    }
    printCurrentItem();
  }

  public void goToChild(int selection) {
    if (selection <= currentItem.getChildren().size() && selection > 0) {
      currentItem = currentItem.getChildren().get(selection - 1);
    } else {
      System.out.println("Selection out of range!");
    }
    printCurrentItem();
  }

  public void printCurrentItem() {
    if (!currentItem.getName().equals("ROOT")) {
      System.out.format("%-20s %s\n", "name:", currentItem.getName());
      System.out.format("%-20s %s\n", "id:", currentItem.getId());
      if (currentItem.getType().equals("EVENT") || currentItem.getType().equals("RACE")) {
        System.out.println("country: " + currentItem.getCountryCode());
      }
      if (currentItem.getType().equals("RACE")) {
        System.out.format("%-20s %s\n", "venue:", currentItem.getVenue());
        System.out.format("%-20s %s\n", "start time:", currentItem.getStartTime());
      }

      if (currentItem.getType().equals("MARKET")) {
        System.out.format("%-20s %s\n", "start time:", currentItem.getMarketStartTime());
        System.out.format("%-20s %s\n", "number of winners:", currentItem.getNumberOfWinners());
        System.out.format("%-20s %s\n", "exchange id:", currentItem.getExchangeId());
      }
    }
    System.out.println("-------------------------------------");
    int i = 0;

    if (!currentItem.getType().equals("MARKET")) {
      for (NavigationItem item : currentItem.getChildren())
        System.out.format("[%d] %s\n", ++i, item.getName());
    } else {
      ArrayList<String> marketIds = new ArrayList<String>();
      marketIds.add(currentItem.getId());


      Set<PriceData> priceData = new HashSet<PriceData>();
      priceData.add(PriceData.EX_BEST_OFFERS);
      PriceProjection priceProjection =
          new PriceProjection.Builder().withPriceData(priceData).build();

      /* Request a marketbook with the given price projection */
      List<MarketBook> marketBooks = null;
      try {
        marketBooks =
            opf.listMarketBook(marketIds).withPriceProjection(priceProjection).build().execute();
      } catch (APINGException e) {
        e.printStackTrace();
        System.exit(0);
      }

      for (MarketBook book : marketBooks) {
        printMarketBook(book);
      }
    }

    if (!currentItem.getName().equals("ROOT")) {
      System.out.println("[0] Back");
    } else {
      System.out.println("[0] Exit");
    }
  }

  private void printMarketBook(MarketBook marketBook) {
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
        .println("------SELECTION------|-----------------------BACK --------------------|------------------------LAY---------------------");
    for (Runner r : marketBook.getRunners()) {
      if (r.getEx() != null) {
        System.out.format("%-20d |", r.getSelectionId());
        printExchangePrices(r.getEx());
      }
    }
    System.out
        .println("---------------------|------------------------------------------------|------------------------------------------------");
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
