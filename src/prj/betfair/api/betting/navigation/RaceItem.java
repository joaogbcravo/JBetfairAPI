package prj.betfair.api.betting.navigation;


import java.util.Date;

public class RaceItem extends BaseItem {
  private Date startTime;
  private String venue;
  private String countryCode;

  public Date getStartTime() {
    return startTime;
  }
  public String getVenue() {
    return venue;
  }
  public String getCountryCode() {
    return countryCode;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
  public void setVenue(String venue) {
    this.venue = venue;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }
  

}
