package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.EventType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * EventType
 */
@JsonDeserialize(builder = EventType.Builder.class)
public class EventType {
  private final String id;
  private final String name;

  public EventType(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
  }

  /**
   * @return id id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @return name name
   */
  public String getName() {
    return this.name;
  }

  public static class Builder {
    private String id;
    private String name;

    public Builder() {}

    /**
     * Use this function to set id
     * 
     * @param id id
     * @return Builder
     */
    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    /**
     * Use this function to set name
     * 
     * @param name name
     * @return Builder
     */
    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public EventType build() {
      return new EventType(this);
    }
  }
}
