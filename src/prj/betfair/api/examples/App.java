package prj.betfair.api.examples;

import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.betting.navigation.Item;
import prj.betfair.api.betting.operations.OperationFactory;
import prj.betfair.api.common.BetfairExecutor;
import prj.betfair.api.common.Executor;
import prj.betfair.api.session.BetfairAPI;
import prj.betfair.api.session.Session;

/**
 * @author Bjorn Nilsson
 *         <p>
 *         This example application provides a small demo on the navigation feature of the JAVA
 *         Betfair API. To run the example an application key has to be generated for the Betfair
 *         API, see https://api.developer.betfair.com/services/webapps/docs/x/PYAS for more
 *         information on how to do this.
 *         </p>
 */
public class App {

  private static Session login(String args[]) {
    String username = null;
    String password = null;
    String applicationKey = null;
    if (args.length == 3) {
      applicationKey = args[0];
      username = args[1];
      password = args[2];
    } else if (args.length == 2) {
      applicationKey = args[0];
      username = args[1];
      password = String.copyValueOf(System.console().readPassword("password: "));
    } else {
      System.out
          .println("Usage: <applicationKey> <username> | <applicationKey> <username> <password>");
      System.exit(0);
    }
    System.out.print("Logging in... ");
    Session session = BetfairAPI.login(username, password, applicationKey);
    System.out.println(session.getStatus());
    return session;
  }

  public static void main(String args[]) {
    System.out.println("--------------------------------------------------------------------");
    System.out.println("-                                                                  -");
    System.out.println("-                         JBetfairAPI Demo                         -");
    System.out.println("-                                                                  -");
    System.out.println("--------------------------------------------------------------------");
   
    Session session = login(args);
    
    if(!session.getStatus().equals("SUCCESS")) {
      System.out.println("failed to login: " + session.getError());
      System.exit(0);
    }
    Executor executor = new BetfairExecutor(session);
    Item rootItem = null;
    
    try {
      System.out.println("Downloading menu data...");
      rootItem = executor.getNavigationData(Item.class);
    } catch (APINGException e) {
      System.out.println("Failed to build menu");
      System.exit(-1);
    }
    
    OperationFactory operationFactory = new OperationFactory(executor);
    Cli cli = new Cli();
    ExchangeNavigator exchangeNavigator = new ExchangeNavigator(rootItem, operationFactory, cli);
    AccountsNavigator accountsNavigator = new AccountsNavigator(executor, cli);
    
    while (true) {
      System.out.println("[0] Account");
      System.out.println("[1] Exchange");
      System.out.println("[2] Logout and exit");
      Integer sel = cli.readInteger();
      switch (sel) {
        case 0:
          accountsNavigator.navigate();
          break;
        case 1:
          exchangeNavigator.navigate();
          break;
        case 2:
          System.out.println(BetfairAPI.logout(session).getStatus());
          System.out.println("bye!");
          System.exit(0);
      }
    }
  }
}
