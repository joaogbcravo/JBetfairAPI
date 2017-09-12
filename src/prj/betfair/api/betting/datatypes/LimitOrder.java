package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import prj.betfair.api.betting.datatypes.SimpleTypes.PersistenceType;
import prj.betfair.api.betting.datatypes.SimpleTypes.TimeInForce;

/***
 * Place a new LIMIT order (simple exchange bet for immediate execution)
 */
@JsonDeserialize(builder = LimitOrder.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LimitOrder {
  private final double price;
  private final PersistenceType persistenceType;
  private final double size;
  private final TimeInForce timeInForce;

  public LimitOrder(Builder builder) {
    this.price = builder.price;
    this.persistenceType = builder.persistenceType;
    this.size = builder.size;
    this.timeInForce = builder.timeInForce;
  }

  /**
   * @return size The size of the bet.
   */
  public double getSize() {
    return this.size;
  }

  /**
   * @return price The limit price
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * @return persistenceType What to do with the order at turn-in-play
   */
  public PersistenceType getPersistenceType() {
    return this.persistenceType;
  }

  /**
   * @return timeInForce - The type of TimeInForce value to use. This value takes precedence over any PersistenceType value chosen.
     If this attribute is populated along with the PersistenceType field, then the PersistenceType will be
     ignored. When using FILL_OR_KILL for a Line market the Volume Weighted Average Price (VWAP) functionality is disabled
   */
  public TimeInForce getTimeInForce() {
    return timeInForce;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private double price;
    private PersistenceType persistenceType;
    private double size;
    private TimeInForce timeInForce;

    /**
     * @param price : The limit price
     * @param persistenceType : What to do with the order at turn-in-play
     * @param size : The size of the bet.
     */
    public Builder(@JsonProperty("price") double price,
        @JsonProperty("persistenceType") PersistenceType persistenceType,
        @JsonProperty("size") double size) {
      this.price = price;
      this.persistenceType = persistenceType;
      this.size = size;
    }

    /**
     * Use this function to set timeInForce
     *
     * @param timeInForce : The type of TimeInForce value to use.
     * @return Builder
     */
    public Builder withTimeInForce(TimeInForce timeInForce) {
      this.timeInForce = timeInForce;
      return this;
    }

    public LimitOrder build() {
      return new LimitOrder(this);
    }
  }
}
