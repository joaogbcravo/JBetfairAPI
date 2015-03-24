package prj.betfair.api.betting.navigation;
import java.util.Date;

public class MarketItem extends BaseItem{
  private String exchangeId;
  private Date marketStartTime;
  private String marketType;
  private int numberOfWinners;
  
  public MarketItem() {}
  public String getExchangeId() {
    return exchangeId;
  }
  public Date getMarketStartTime() {
    return marketStartTime;
  }
  public String getMarketType() {
    return marketType;
  }
  public int getNumberOfWinners() {
    return numberOfWinners;
  }
  public void setExchangeId(String exchangeId) {
    this.exchangeId = exchangeId;
  }
  public void setMarketStartTime(Date marketStartTime) {
    this.marketStartTime = marketStartTime;
  }
  public void setMarketType(String marketType) {
    this.marketType = marketType;
  }
  public void setNumberOfWinners(int numberOfWinners) {
    this.numberOfWinners = numberOfWinners;
  }
  
}
