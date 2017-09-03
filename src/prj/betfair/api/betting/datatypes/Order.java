package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.Order;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Order.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
  private final String status;
  private final String persistenceType;
  private final double bspLiability;
  private final String orderType;
  private final double price;
  private final double sizeVoided;
  private final double avgPriceMatched;
  private final double sizeCancelled;
  private final double sizeLapsed;
  private final double sizeRemaining;
  private final Date placedDate;
  private final String betId;
  private final String side;
  private final double sizeMatched;
  private final double size;

  public Order(Builder builder) {
    this.status = builder.status;
    this.persistenceType = builder.persistenceType;
    this.bspLiability = builder.bspLiability;
    this.orderType = builder.orderType;
    this.price = builder.price;
    this.sizeVoided = builder.sizeVoided;
    this.avgPriceMatched = builder.avgPriceMatched;
    this.sizeCancelled = builder.sizeCancelled;
    this.sizeLapsed = builder.sizeLapsed;
    this.sizeRemaining = builder.sizeRemaining;
    this.placedDate = builder.placedDate;
    this.betId = builder.betId;
    this.side = builder.side;
    this.sizeMatched = builder.sizeMatched;
    this.size = builder.size;
  }

  /**
   * @return betId
   */
  public String getBetId() {
    return this.betId;
  }

  /**
   * @return orderType BSP Order type.
   */
  public String getOrderType() {
    return this.orderType;
  }

  /**
   * @return status Either EXECUTABLE (an unmatched amount remains) or EXECUTION_COMPLETE (no
   *         unmatched amount remains).
   */
  public String getStatus() {
    return this.status;
  }

  /**
   * @return persistenceType What to do with the order at turn-in-play
   */
  public String getPersistenceType() {
    return this.persistenceType;
  }

  /**
   * @return side
   */
  public String getSide() {
    return this.side;
  }

  /**
   * @return price The price of the bet.
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * @return size The size of the bet.
   */
  public double getSize() {
    return this.size;
  }

  /**
   * @return bspLiability Not to be confused with size. This is the liability of a given BSP bet.
   */
  public double getBspLiability() {
    return this.bspLiability;
  }

  /**
   * @return placedDate The date, to the second, the bet was placed.
   */
  public Date getPlacedDate() {
    return this.placedDate;
  }

  /**
   * @return avgPriceMatched The average price matched at. Voided match fragments are removed from
   *         this average calculation.
   */
  public double getAvgPriceMatched() {
    return this.avgPriceMatched;
  }

  /**
   * @return sizeMatched The current amount of this bet that was matched.
   */
  public double getSizeMatched() {
    return this.sizeMatched;
  }

  /**
   * @return sizeRemaining The current amount of this bet that is unmatched.
   */
  public double getSizeRemaining() {
    return this.sizeRemaining;
  }

  /**
   * @return sizeLapsed The current amount of this bet that was lapsed.
   */
  public double getSizeLapsed() {
    return this.sizeLapsed;
  }

  /**
   * @return sizeCancelled The current amount of this bet that was cancelled.
   */
  public double getSizeCancelled() {
    return this.sizeCancelled;
  }

  /**
   * @return sizeVoided The current amount of this bet that was voided.
   */
  public double getSizeVoided() {
    return this.sizeVoided;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String status;
    private String persistenceType;
    private double bspLiability;
    private String orderType;
    private double price;
    private double sizeVoided;
    private double avgPriceMatched;
    private double sizeCancelled;
    private double sizeLapsed;
    private double sizeRemaining;
    private Date placedDate;
    private String betId;
    private String side;
    private double sizeMatched;
    private double size;

    /**
     * @param status : Either EXECUTABLE (an unmatched amount remains) or EXECUTION_COMPLETE (no
     *        unmatched amount remains).
     * @param persistenceType : What to do with the order at turn-in-play
     * @param bspLiability : Not to be confused with size. This is the liability of a given BSP bet.
     * @param orderType : BSP Order type.
     * @param price : The price of the bet.
     * @param placedDate : The date, to the second, the bet was placed.
     * @param betId
     * @param side
     * @param size : The size of the bet.
     */
    public Builder(@JsonProperty("status") String status,
        @JsonProperty("persistenceType") String persistenceType,
        @JsonProperty("bspLiability") double bspLiability,
        @JsonProperty("orderType") String orderType, @JsonProperty("price") double price,
        @JsonProperty("placedDate") Date placedDate, @JsonProperty("betId") String betId,
        @JsonProperty("side") String side, @JsonProperty("size") double size) {
      this.status = status;
      this.persistenceType = persistenceType;
      this.bspLiability = bspLiability;
      this.orderType = orderType;
      this.price = price;
      this.placedDate = placedDate;
      this.betId = betId;
      this.side = side;
      this.size = size;
    }

    /**
     * Use this function to set avgPriceMatched
     * 
     * @param avgPriceMatched The average price matched at. Voided match fragments are removed from
     *        this average calculation.
     * @return Builder
     */
    public Builder withAvgPriceMatched(double avgPriceMatched) {
      this.avgPriceMatched = avgPriceMatched;
      return this;
    }

    /**
     * Use this function to set sizeMatched
     * 
     * @param sizeMatched The current amount of this bet that was matched.
     * @return Builder
     */
    public Builder withSizeMatched(double sizeMatched) {
      this.sizeMatched = sizeMatched;
      return this;
    }

    /**
     * Use this function to set sizeRemaining
     * 
     * @param sizeRemaining The current amount of this bet that is unmatched.
     * @return Builder
     */
    public Builder withSizeRemaining(double sizeRemaining) {
      this.sizeRemaining = sizeRemaining;
      return this;
    }

    /**
     * Use this function to set sizeLapsed
     * 
     * @param sizeLapsed The current amount of this bet that was lapsed.
     * @return Builder
     */
    public Builder withSizeLapsed(double sizeLapsed) {
      this.sizeLapsed = sizeLapsed;
      return this;
    }

    /**
     * Use this function to set sizeCancelled
     * 
     * @param sizeCancelled The current amount of this bet that was cancelled.
     * @return Builder
     */
    public Builder withSizeCancelled(double sizeCancelled) {
      this.sizeCancelled = sizeCancelled;
      return this;
    }

    /**
     * Use this function to set sizeVoided
     * 
     * @param sizeVoided The current amount of this bet that was voided.
     * @return Builder
     */
    public Builder withSizeVoided(double sizeVoided) {
      this.sizeVoided = sizeVoided;
      return this;
    }

    public Order build() {
      return new Order(this);
    }
  }
}
