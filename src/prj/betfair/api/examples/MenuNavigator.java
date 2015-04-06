package prj.betfair.api.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import prj.betfair.api.betting.datatypes.ExchangePrices;
import prj.betfair.api.betting.datatypes.MarketBook;
import prj.betfair.api.betting.datatypes.PriceProjection;
import prj.betfair.api.betting.datatypes.Runner;
import prj.betfair.api.betting.datatypes.SimpleTypes.PriceData;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.betting.navigation.Item;
import prj.betfair.api.betting.navigation.MarketItem;
import prj.betfair.api.betting.operations.OperationBuilder;

public class MenuNavigator {
  private Item currentItem;
  private final Item root;
  private final OperationBuilder opf;
  
  public MenuNavigator(Item rootItem, OperationBuilder operationFactory) {
    this.root = rootItem;
    this.currentItem = root;
    this.opf = operationFactory;
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
    System.out.println(currentItem);
    if(currentItem.getChildren() != null){
      int i = 0;
      for(Item item : currentItem.getChildren()) {
        System.out.println("["+ ++i +"] "+item);
      }
    }
    if(currentItem instanceof MarketItem) {
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
