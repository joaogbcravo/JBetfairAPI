package prj.betfair.api.betting.navigation;

public class ItemData {
  private String exchangeId;
  private String id;
  private String marketStartTime;
  private String marketType;
  private String numberOfWinners;
  private String name;
  private String type;
  private String startTime;
  private String venue;
  private String countryCode;

  public String getExchangeId() {
    return exchangeId;
  }

  public void setExchangeId(String exchangeId) {
    this.exchangeId = exchangeId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMarketStartTime() {
    return marketStartTime;
  }

  public void setMarketStartTime(String marketStartTime) {
    this.marketStartTime = marketStartTime;
  }

  public String getMarketType() {
    return marketType;
  }

  public void setMarketType(String marketType) {
    this.marketType = marketType;
  }

  public String getNumberOfWinners() {
    return numberOfWinners;
  }

  public void setNumberOfWinners(String numberOfWinners) {
    this.numberOfWinners = numberOfWinners;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getVenue() {
    return venue;
  }

  public void setVenue(String venue) {
    this.venue = venue;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String toString() {
    return name;
  }

}
