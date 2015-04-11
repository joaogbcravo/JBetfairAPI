package prj.betfair.api.examples;

import java.util.List;

import prj.betfair.api.accounts.datatypes.AccountDetailsResponse;
import prj.betfair.api.accounts.datatypes.AccountFundsResponse;
import prj.betfair.api.accounts.datatypes.AccountStatementReport;
import prj.betfair.api.accounts.datatypes.CurrencyRate;
import prj.betfair.api.accounts.datatypes.DeveloperApp;
import prj.betfair.api.accounts.datatypes.DeveloperAppVersion;
import prj.betfair.api.accounts.datatypes.StatementItem;
import prj.betfair.api.accounts.operations.GetAccountDetailsOperation;
import prj.betfair.api.accounts.operations.GetAccountFundsOperation;
import prj.betfair.api.accounts.operations.GetAccountStatementOperation;
import prj.betfair.api.accounts.operations.GetDeveloperAppKeysOperation;
import prj.betfair.api.accounts.operations.ListCurrencyRatesOperation;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

public class AccountsNavigator {
  private Executor executor;
  private Cli cli;
  private final String[] options = {"Details", "Funds", "Statement", "Currency rates","Developer app keys"};
  private final int DETAILS_OPTION = 1, FUNDS_OPTION = 2, STATEMENT_OPTION = 3,
      CURRENCY_OPTION = 4, DEVELOPER_APP_KEYS_OPTION = 5;

  public AccountsNavigator(Executor executor, Cli cli) {
    this.executor = executor;
    this.cli = cli;
  }

  public void navigate() {
    Integer selection = null;
    while (true) {
      cli.printOptions(options);
      selection = cli.readInteger();
      switch (selection) {
        case 0:
          return;
        case DETAILS_OPTION:
          getAccountDetails();
          break;
        case FUNDS_OPTION:
          getAccountFunds();
          break;
        case STATEMENT_OPTION:
          getAccountStatement();
          break;
        case CURRENCY_OPTION:
          listCurrencyRates();
          break;
        case DEVELOPER_APP_KEYS_OPTION:
          listAppKeys();
          break;
        default:
          System.out.println("Selection out of range");
          break;
      }
    }
  }

  private void getAccountDetails() {
    try {
      AccountDetailsResponse resp =
          new GetAccountDetailsOperation.Builder().withExecutor(executor).build().execute();
      System.out.format("%-25s %s\n","currency code:", resp.getCurrencyCode());
      System.out.format("%-25s %f\n","discount rate:",  resp.getDiscountRate());
      System.out.format("%-25s %s\n","first name:",  resp.getFirstName());
      System.out.format("%-25s %s\n","last name:",  resp.getLastName());
      System.out.format("%-25s %s\n","locale:",  resp.getLocaleCode());
      System.out.format("%-25s %d\n","points balace:",  resp.getPointsBalance());
      System.out.format("%-25s %s\n","region:",  resp.getRegion());
      System.out.format("%-25s %s\n","timezone:",  resp.getTimezone());
    } catch (APINGException e) {
      e.printStackTrace();
    }
  }

  private void getAccountFunds() {
    try {
      AccountFundsResponse resp =
          new GetAccountFundsOperation.Builder().withExecutor(executor).build().execute();
      System.out.format("%-25s %f\n","available to bet balace:", resp.getAvailableToBetBalance());
      System.out.format("%-25s %f\n","discount rate:", resp.getDiscountRate());
      System.out.format("%-25s %f\n","exposure:", resp.getExposure());
      System.out.format("%-25s %f\n","exposure limit:", resp.getExposureLimit());
      System.out.format("%-25s %d\n","points balance:", resp.getPointsBalance());
      System.out.format("%-25s %f\n","retained commission:", resp.getRetainedCommission());
      System.out.format("%-25s %s\n","wallet:", resp.getWallet());
    } catch (APINGException e) {
      e.printStackTrace();
    }
  }
  private void listAppKeys() {
    try {
      List<DeveloperApp> resp =
          new GetDeveloperAppKeysOperation.Builder().withExecutor(executor).build().execute();
      for(DeveloperApp app : resp) {
        System.out.format("%-25s %s\n","Name:",app.getAppName());
        System.out.format("%-25s %d\n", "ApplicationId:",app.getAppId());
        for(DeveloperAppVersion version : app.getAppVersions()) {
          System.out.println();
          System.out.format("%-25s %s\n","Active:",Boolean.toString(version.getActive()));
          System.out.format("%-25s %s\n","Delay data:",Boolean.toString(version.getDelayData()));
          System.out.format("%-25s %s\n","Owner managed:",Boolean.toString(version.getOwnerManaged()));
          System.out.format("%-25s %s\n","Owner:",version.getOwner());
          System.out.format("%-25s %s\n","Subscription required:",Boolean.toString(version.getSubscriptionRequired()));
          System.out.format("%-25s %s\n","Application key:",version.getApplicationKey());
          System.out.format("%-25s %s\n","Version:",version.getVersion());
          System.out.format("%-25s %d\n","VersionId:",version.getVersionId());
        }
      }
    } catch (APINGException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  private void getAccountStatement() {
    try {
      AccountStatementReport resp =
          new GetAccountStatementOperation.Builder().withExecutor(executor).build().execute();
      System.out.println("STATEMENTS:");
      if (resp.getAccountStatement() != null)
        for (StatementItem statement : resp.getAccountStatement()) {
          System.out.println("---------------------------------------");
          System.out.format("date:%-20s\n", statement.getItemDate());
          System.out.format("amount:%-20f\n", statement.getAmount());
          System.out.format("balance:%20f\n", statement.getBalance());
        }
    } catch (APINGException e) {
      e.printStackTrace();
    }
  }

  private void listCurrencyRates() {
    try {
      List<CurrencyRate> resp =
          new ListCurrencyRatesOperation.Builder().withExecutor(executor).build().execute();
      for (CurrencyRate rate : resp) {
        System.out.format("%s %f\n", rate.getCurrencyCode(), rate.getRate());
      }
    } catch (APINGException e) {
      e.printStackTrace();
    }
  }
}
