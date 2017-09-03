package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.Event;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Event
 */
@JsonDeserialize(builder = Event.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
  private final String name;
  private final String countryCode;
  private final String venue;
  private final String timezone;
  private final Date openDate;
  private final String id;

  public Event(Builder builder) {
    this.name = builder.name;
    this.countryCode = builder.countryCode;
    this.venue = builder.venue;
    this.timezone = builder.timezone;
    this.openDate = builder.openDate;
    this.id = builder.id;
  }

  /**
   * @return id The unique id for the event
   */
  public String getId() {
    return this.id;
  }

  /**
   * @return name The name of the event
   */
  public String getName() {
    return this.name;
  }

  /**
   * @return countryCode countryCode
   */
  public String getCountryCode() {
    return this.countryCode;
  }

  /**
   * @return timezone timezone
   */
  public String getTimezone() {
    return this.timezone;
  }

  /**
   * @return venue venue
   */
  public String getVenue() {
    return this.venue;
  }

  /**
   * @return openDate openDate
   */
  public Date getOpenDate() {
    return this.openDate;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String name;
    private String countryCode;
    private String venue;
    private String timezone;
    private Date openDate;
    private String id;

    public Builder() {}

    /**
     * Use this function to set id
     * 
     * @param id The unique id for the event
     * @return Builder
     */
    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    /**
     * Use this function to set name
     * 
     * @param name The name of the event
     * @return Builder
     */
    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Use this function to set countryCode
     * 
     * @param countryCode countryCode
     * @return Builder
     */
    public Builder withCountryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Use this function to set timezone
     * 
     * @param timezone timezone
     * @return Builder
     */
    public Builder withTimezone(String timezone) {
      this.timezone = timezone;
      return this;
    }

    /**
     * Use this function to set venue
     * 
     * @param venue venue
     * @return Builder
     */
    public Builder withVenue(String venue) {
      this.venue = venue;
      return this;
    }

    /**
     * Use this function to set openDate
     * 
     * @param openDate openDate
     * @return Builder
     */
    public Builder withOpenDate(Date openDate) {
      this.openDate = openDate;
      return this;
    }

    public Event build() {
      return new Event(this);
    }
  }
}
