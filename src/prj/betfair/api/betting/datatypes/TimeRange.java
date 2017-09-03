package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.TimeRange;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * TimeRange
 */
@JsonDeserialize(builder = TimeRange.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeRange {
  private final Date to;
  private final Date from;

  public TimeRange(Builder builder) {
    this.to = builder.to;
    this.from = builder.from;
  }

  /**
   * @return from from, format: ISO 8601)
   */
  public Date getFrom() {
    return this.from;
  }

  /**
   * @return to to, format: ISO 8601
   */
  public Date getTo() {
    return this.to;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private Date to;
    private Date from;

    public Builder() {}

    /**
     * Use this function to set from
     * 
     * @param from from, format: ISO 8601)
     * @return Builder
     */
    public Builder withFrom(Date from) {
      this.from = from;
      return this;
    }

    /**
     * Use this function to set to
     * 
     * @param to to, format: ISO 8601
     * @return Builder
     */
    public Builder withTo(Date to) {
      this.to = to;
      return this;
    }

    public TimeRange build() {
      return new TimeRange(this);
    }
  }
}
