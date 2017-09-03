package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.LimitOrder;
import prj.betfair.api.betting.datatypes.SimpleTypes.PersistenceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Place a new LIMIT order (simple exchange bet for immediate execution)
 */
@JsonDeserialize(builder = LimitOrder.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LimitOrder {
  private final double price;
  private final PersistenceType persistenceType;
  private final double size;

  public LimitOrder(Builder builder) {
    this.price = builder.price;
    this.persistenceType = builder.persistenceType;
    this.size = builder.size;
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

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private double price;
    private PersistenceType persistenceType;
    private double size;

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

    public LimitOrder build() {
      return new LimitOrder(this);
    }
  }
}
