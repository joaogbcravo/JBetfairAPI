package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.PlaceInstruction;
import prj.betfair.api.betting.datatypes.LimitOrder;
import prj.betfair.api.betting.datatypes.LimitOnCloseOrder;
import prj.betfair.api.betting.datatypes.MarketOnCloseOrder;
import prj.betfair.api.betting.datatypes.SimpleTypes.Side;
import prj.betfair.api.betting.datatypes.SimpleTypes.OrderType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.text.MessageFormat;

/***
 * Instruction to place a new order
 */
@JsonDeserialize(builder = PlaceInstruction.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceInstruction {
  private final double handicap;
  private final OrderType orderType;
  private final long selectionId;
  private final LimitOrder limitOrder;
  private final MarketOnCloseOrder marketOnCloseOrder;
  private final LimitOnCloseOrder limitOnCloseOrder;
  private final Side side;

  public PlaceInstruction(Builder builder) {
    this.handicap = builder.handicap;
    this.orderType = builder.orderType;
    this.selectionId = builder.selectionId;
    this.limitOrder = builder.limitOrder;
    this.marketOnCloseOrder = builder.marketOnCloseOrder;
    this.limitOnCloseOrder = builder.limitOnCloseOrder;
    this.side = builder.side;
  }

  /**
   * @return orderType
   */
  public OrderType getOrderType() {
    return this.orderType;
  }

  /**
   * @return selectionId The selection_id.
   */
  public long getSelectionId() {
    return this.selectionId;
  }

  /**
   * @return handicap The handicap applied to the selection, if on an asian-style market.
   */
  public double getHandicap() {
    return this.handicap;
  }

  /**
   * @return side Back or Lay
   */
  public Side getSide() {
    return this.side;
  }

  /**
   * @return limitOrder
   */
  public LimitOrder getLimitOrder() {
    return this.limitOrder;
  }

  /**
   * @return limitOnCloseOrder
   */
  public LimitOnCloseOrder getLimitOnCloseOrder() {
    return this.limitOnCloseOrder;
  }

  /**
   * @return marketOnCloseOrder
   */
  public MarketOnCloseOrder getMarketOnCloseOrder() {
    return this.marketOnCloseOrder;
  }

  @Override
  public String toString() {

    String order = "";

    switch (orderType) {
      case LIMIT:
        order = limitOrder.toString();
        break;
      case LIMIT_ON_CLOSE:
        order = limitOnCloseOrder.toString();
        break;
      case MARKET_ON_CLOSE:
        order = marketOnCloseOrder.toString();
        break;
    }

    return MessageFormat.format("PlaceInstruction: {0} on {1}", order, side);
  }
  
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private double handicap;
    private OrderType orderType;
    private long selectionId;
    private LimitOrder limitOrder;
    private MarketOnCloseOrder marketOnCloseOrder;
    private LimitOnCloseOrder limitOnCloseOrder;
    private Side side;

    /**
     * @param orderType
     * @param selectionId : The selection_id.
     * @param side : Back or Lay
     */
    public Builder(@JsonProperty("orderType") OrderType orderType,
        @JsonProperty("selectionId") long selectionId, @JsonProperty("side") Side side) {
      this.orderType = orderType;
      this.selectionId = selectionId;
      this.side = side;
    }

    /**
     * Use this function to set handicap
     * 
     * @param handicap The handicap applied to the selection, if on an asian-style market.
     * @return Builder
     */
    public Builder withHandicap(double handicap) {
      this.handicap = handicap;
      return this;
    }

    /**
     * Use this function to set limitOrder
     * 
     * @param limitOrder
     * @return Builder
     */
    public Builder withLimitOrder(LimitOrder limitOrder) {
      this.limitOrder = limitOrder;
      return this;
    }

    /**
     * Use this function to set limitOnCloseOrder
     * 
     * @param limitOnCloseOrder
     * @return Builder
     */
    public Builder withLimitOnCloseOrder(LimitOnCloseOrder limitOnCloseOrder) {
      this.limitOnCloseOrder = limitOnCloseOrder;
      return this;
    }

    /**
     * Use this function to set marketOnCloseOrder
     * 
     * @param marketOnCloseOrder
     * @return Builder
     */
    public Builder withMarketOnCloseOrder(MarketOnCloseOrder marketOnCloseOrder) {
      this.marketOnCloseOrder = marketOnCloseOrder;
      return this;
    }

    public PlaceInstruction build() {
      return new PlaceInstruction(this);
    }
  }
}
