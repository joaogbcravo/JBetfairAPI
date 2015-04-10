package prj.betfair.api.examples;

import java.util.List;

import prj.betfair.api.accounts.datatypes.AccountDetailsResponse;
import prj.betfair.api.accounts.datatypes.AccountFundsResponse;
import prj.betfair.api.accounts.datatypes.AccountStatementReport;
import prj.betfair.api.accounts.datatypes.CurrencyRate;
import prj.betfair.api.accounts.datatypes.StatementItem;
import prj.betfair.api.accounts.operations.GetAccountDetailsOperation;
import prj.betfair.api.accounts.operations.GetAccountFundsOperation;
import prj.betfair.api.accounts.operations.GetAccountStatementOperation;
import prj.betfair.api.accounts.operations.ListCurrencyRatesOperation;
import prj.betfair.api.betting.exceptions.APINGException;
import prj.betfair.api.common.Executor;

public class AccountsNavigator {
  private Executor executor;
  private Cli cli;
  private final String[] options = {"Details", "Funds", "Statement", "Currency rates"};

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
        case 1:
          getAccountDetails();
          break;
        case 2:
          getAccountFunds();
          break;
        case 3:
          getAccountStatement();
          break;
        case 4:
          listCurrencyRates();
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
      System.out.format("currency code:%-20s\n", resp.getCurrencyCode());
      System.out.format("discount rate:%-20f\n", resp.getDiscountRate());
      System.out.format("first name:%-20s\n", resp.getFirstName());
      System.out.format("last name:%-20s\n", resp.getLastName());
      System.out.format("locale:%-20s\n", resp.getLocaleCode());
      System.out.format("points balace:%-20d\n", resp.getPointsBalance());
      System.out.format("region:%-20s\n", resp.getRegion());
      System.out.format("timezone:%-20s\n", resp.getTimezone());
    } catch (APINGException e) {
      e.printStackTrace();
    }
  }

  private void getAccountFunds() {
    try {
      AccountFundsResponse resp =
          new GetAccountFundsOperation.Builder().withExecutor(executor).build().execute();
      System.out.format("available to bet balace:%-20f\n", resp.getAvailableToBetBalance());
      System.out.format("discount rate:%-20f\n", resp.getDiscountRate());
      System.out.format("exposure:%-20f\n", resp.getExposure());
      System.out.format("exposure limit:%-20f\n", resp.getExposureLimit());
      System.out.format("points balance:%-20d\n", resp.getPointsBalance());
      System.out.format("retained commission:%-20f\n", resp.getRetainedCommission());
      System.out.format("wallet:%-20s\n", resp.getWallet());
    } catch (APINGException e) {
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
        System.out.format("%s %-20f\n", rate.getCurrencyCode(), rate.getRate());
      }
    } catch (APINGException e) {
      e.printStackTrace();
    }
  }
}
