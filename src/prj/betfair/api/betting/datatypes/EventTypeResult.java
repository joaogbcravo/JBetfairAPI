package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.EventType;
import prj.betfair.api.betting.datatypes.EventTypeResult;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * EventType Result
 */
@JsonDeserialize(builder = EventTypeResult.Builder.class)
public class EventTypeResult {
  private final EventType eventType;
  private final int marketCount;

  public EventTypeResult(Builder builder) {
    this.eventType = builder.eventType;
    this.marketCount = builder.marketCount;
  }

  /**
   * @return eventType EventType
   */
  public EventType getEventType() {
    return this.eventType;
  }

  /**
   * @return marketCount Count of markets associated with this eventType
   */
  public int getMarketCount() {
    return this.marketCount;
  }

  public static class Builder {
    private EventType eventType;
    private int marketCount;

    public Builder() {}

    /**
     * Use this function to set eventType
     * 
     * @param eventType EventType
     * @return Builder
     */
    public Builder withEventType(EventType eventType) {
      this.eventType = eventType;
      return this;
    }

    /**
     * Use this function to set marketCount
     * 
     * @param marketCount Count of markets associated with this eventType
     * @return Builder
     */
    public Builder withMarketCount(int marketCount) {
      this.marketCount = marketCount;
      return this;
    }

    public EventTypeResult build() {
      return new EventTypeResult(this);
    }
  }
}
