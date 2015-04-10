package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.TimeRange;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * TimeRange
 */
@JsonDeserialize(builder = TimeRange.Builder.class)
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

  public static class Builder {
    private Date to;
    private Date from;

    public Builder() {}

    public TimeRange build() {
      return new TimeRange(this);
    }
  }
}
