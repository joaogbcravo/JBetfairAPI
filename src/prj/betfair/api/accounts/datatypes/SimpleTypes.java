package prj.betfair.api.accounts.datatypes;

public class SimpleTypes {
  public enum SubscriptionStatus {
    ALL, ACTIVATED, UNACTIVATED, CANCELLED, EXPIRED
  }
  public enum Status {
    SUCCESS
  }
  public enum ItemClass {
    UNKNOWN
  }
  public enum Wallet {
    UK, AUSTRALIAN
  }
  public enum IncludeItem {
    ALL, EXCHANGE, POKER_ROOM, DEPOSITS_WITHDRAWALS
  }

}
