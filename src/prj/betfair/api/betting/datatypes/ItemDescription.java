package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.ItemDescription;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * This object contains some text which may be useful to render a betting history view. It offers no
 * long-term warranty as to the correctness of the text.
 */
@JsonDeserialize(builder = ItemDescription.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDescription {
  private final Date marketStartTime;
  private final String runnerDesc;
  private final String eventTypeDesc;
  private final int numberOfWinners;
  private final String marketDesc;
  private final String eventDesc;

  public ItemDescription(Builder builder) {
    this.marketStartTime = builder.marketStartTime;
    this.runnerDesc = builder.runnerDesc;
    this.eventTypeDesc = builder.eventTypeDesc;
    this.numberOfWinners = builder.numberOfWinners;
    this.marketDesc = builder.marketDesc;
    this.eventDesc = builder.eventDesc;
  }

  /**
   * @return eventTypeDesc The event type name, translated into the requested locale. Available at
   *         EVENT_TYPE groupBy or lower.
   */
  public String getEventTypeDesc() {
    return this.eventTypeDesc;
  }

  /**
   * @return eventDesc The eventName, or openDate + venue, translated into the requested locale.
   *         Available at EVENT groupBy or lower.
   */
  public String getEventDesc() {
    return this.eventDesc;
  }

  /**
   * @return marketDesc The market name or racing market type ("Win", "To Be Placed (2 places)",
   *         "To Be Placed (5 places)" etc) translated into the requested locale. Available at
   *         MARKET groupBy or lower.
   */
  public String getMarketDesc() {
    return this.marketDesc;
  }

  /**
   * @return marketStartTime The start time of the market (in ISO-8601 format, not translated).
   *         Available at MARKET groupBy or lower.
   */
  public Date getMarketStartTime() {
    return this.marketStartTime;
  }

  /**
   * @return runnerDesc The runner name, maybe including the handicap, translated into the requested
   *         locale. Available at BET groupBy.
   */
  public String getRunnerDesc() {
    return this.runnerDesc;
  }

  /**
   * @return numberOfWinners The numberOfWinners on a market. Available at BET groupBy.
   */
  public int getNumberOfWinners() {
    return this.numberOfWinners;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private Date marketStartTime;
    private String runnerDesc;
    private String eventTypeDesc;
    private int numberOfWinners;
    private String marketDesc;
    private String eventDesc;

    public Builder() {}

    /**
     * Use this function to set eventTypeDesc
     * 
     * @param eventTypeDesc The event type name, translated into the requested locale. Available at
     *        EVENT_TYPE groupBy or lower.
     * @return Builder
     */
    public Builder withEventTypeDesc(String eventTypeDesc) {
      this.eventTypeDesc = eventTypeDesc;
      return this;
    }

    /**
     * Use this function to set eventDesc
     * 
     * @param eventDesc The eventName, or openDate + venue, translated into the requested locale.
     *        Available at EVENT groupBy or lower.
     * @return Builder
     */
    public Builder withEventDesc(String eventDesc) {
      this.eventDesc = eventDesc;
      return this;
    }

    /**
     * Use this function to set marketDesc
     * 
     * @param marketDesc The market name or racing market type ("Win", "To Be Placed (2 places)",
     *        "To Be Placed (5 places)" etc) translated into the requested locale. Available at
     *        MARKET groupBy or lower.
     * @return Builder
     */
    public Builder withMarketDesc(String marketDesc) {
      this.marketDesc = marketDesc;
      return this;
    }

    /**
     * Use this function to set marketStartTime
     * 
     * @param marketStartTime The start time of the market (in ISO-8601 format, not translated).
     *        Available at MARKET groupBy or lower.
     * @return Builder
     */
    public Builder withMarketStartTime(Date marketStartTime) {
      this.marketStartTime = marketStartTime;
      return this;
    }

    /**
     * Use this function to set runnerDesc
     * 
     * @param runnerDesc The runner name, maybe including the handicap, translated into the
     *        requested locale. Available at BET groupBy.
     * @return Builder
     */
    public Builder withRunnerDesc(String runnerDesc) {
      this.runnerDesc = runnerDesc;
      return this;
    }

    /**
     * Use this function to set numberOfWinners
     * 
     * @param numberOfWinners The numberOfWinners on a market. Available at BET groupBy.
     * @return Builder
     */
    public Builder withNumberOfWinners(int numberOfWinners) {
      this.numberOfWinners = numberOfWinners;
      return this;
    }

    public ItemDescription build() {
      return new ItemDescription(this);
    }
  }
}
