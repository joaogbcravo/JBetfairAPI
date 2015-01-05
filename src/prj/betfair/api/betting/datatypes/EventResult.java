package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.Event;
import prj.betfair.api.betting.datatypes.EventResult;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Event Result
 */
@JsonDeserialize(builder = EventResult.Builder.class)
public class EventResult {
  private final Event event;
  private final int marketCount;

  public EventResult(Builder builder) {
    this.event = builder.event;
    this.marketCount = builder.marketCount;
  }

  /**
   * @return event Event
   */
  public Event getEvent() {
    return this.event;
  }

  /**
   * @return marketCount Count of markets associated with this event
   */
  public int getMarketCount() {
    return this.marketCount;
  }

  public static class Builder {
    private Event event;
    private int marketCount;

    public Builder() {}

    /**
     * Use this function to set event
     * 
     * @param event Event
     * @return Builder
     */
    public Builder withEvent(Event event) {
      this.event = event;
      return this;
    }

    /**
     * Use this function to set marketCount
     * 
     * @param marketCount Count of markets associated with this event
     * @return Builder
     */
    public Builder withMarketCount(int marketCount) {
      this.marketCount = marketCount;
      return this;
    }

    public EventResult build() {
      return new EventResult(this);
    }
  }
}
