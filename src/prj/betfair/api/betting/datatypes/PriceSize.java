package prj.betfair.api.betting.datatypes;

import prj.betfair.api.betting.datatypes.PriceSize;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = PriceSize.Builder.class)
public class PriceSize {
  private final double price;
  private final double size;

  public PriceSize(Builder builder) {
    this.price = builder.price;
    this.size = builder.size;
  }

  /**
   * @return price
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * @return size
   */
  public double getSize() {
    return this.size;
  }

  public static class Builder {
    private double price;
    private double size;

    /**
     * @param price
     * @param size
     */
    public Builder(@JsonProperty("price") double price, @JsonProperty("size") double size) {
      this.price = price;
      this.size = size;
    }

    public PriceSize build() {
      return new PriceSize(this);
    }
  }
}
