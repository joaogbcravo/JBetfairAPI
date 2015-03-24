package prj.betfair.api.examples;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.betting.operations.OperationBuilder;
import prj.betfair.api.betting.operations.BetfairExecutor;
import prj.betfair.api.betting.operations.Executor;
import prj.betfair.api.login.ApplicationToken;
import prj.betfair.api.login.BetfairAPI;

/**
 * @author Bjorn Nilsson
 *         <p>
 *         This example application provides a small demo on the navigation feature of the JAVA
 *         Betfair API. To run the example an application key has to be generated for the Betfair
 *         API, see https://api.developer.betfair.com/services/webapps/docs/x/PYAS for more
 *         information on how to do this.
 *         </p>
 */
public class Application {
  public static void main(String args[]) {
    String applKey = "";
    String user = "";
    String passw = "";

    Console c = System.console();

    if (args.length < 2) {
      System.out.println("<applicationKey> <username> | <applicationKey> <username> <password>");
      System.exit(0);
    } else {
      applKey = args[0];
      user = args[1];
      if (args.length > 2)
        passw = args[2];
      else
        passw = String.copyValueOf(c.readPassword("password: "));
    }

    ApplicationToken token = BetfairAPI.login(user, passw, applKey);

    // Create an Executor using the token retrieved at login.
    Executor exec = new BetfairExecutor();
    exec.setApplicationToken(token);

    // Create an OperationBuilder, this is a convenience class to create operation objects
    OperationBuilder opf = new OperationBuilder(exec);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MenuNavigator nav = null;

    // Retrieve navigationData from betfair using the executor and build a MenuNavigator with it.
    try {
      nav = new MenuNavigator(exec.getNavigationData(), opf);
    } catch (APINGException e) {
      e.printStackTrace();
      System.exit(-1);
    }

    // The navigationData download succeeded, print the root item and start navigation
    nav.printCurrentItem();
    while (true) {
      System.out.println("Selection: ");
      try {
        int sel = Integer.parseInt(br.readLine());
        if (sel == 0) {
          nav.goToParent();
        } else {
          nav.goToChild(sel);
        }
      } catch (IOException e) {
        System.out.println("IO Exception");
        System.exit(-1);
      } catch (NumberFormatException e) {
        System.out.println("Incorrect number format");
      }
    }
  }
}
