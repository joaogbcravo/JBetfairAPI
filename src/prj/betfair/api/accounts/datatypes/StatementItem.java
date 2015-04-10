package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.StatementItem;
import prj.betfair.api.accounts.datatypes.StatementLegacyData;
import prj.betfair.api.accounts.datatypes.SimpleTypes.ItemClass;
import java.util.HashMap;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Summary of a cleared order.
 */
@JsonDeserialize(builder = StatementItem.Builder.class)
public class StatementItem {
  private final Date itemDate;
  private final ItemClass itemClass;
  private final StatementLegacyData legacyData;
  private final double amount;
  private final HashMap<String, String> itemClassData;
  private final double balance;
  private final String refId;

  public StatementItem(Builder builder) {
    this.itemDate = builder.itemDate;
    this.itemClass = builder.itemClass;
    this.legacyData = builder.legacyData;
    this.amount = builder.amount;
    this.itemClassData = builder.itemClassData;
    this.balance = builder.balance;
    this.refId = builder.refId;
  }

  /**
   * @return refId An external reference, eg. equivalent to betId in the case of an exchange bet
   *         statement item.
   */
  public String getRefId() {
    return this.refId;
  }

  /**
   * @return itemDate The date and time of the statement item, eg. equivalent to settledData for an
   *         exchange bet statement item. (in ISO-8601 format, not translated)
   */
  public Date getItemDate() {
    return this.itemDate;
  }

  /**
   * @return amount The amount of money the balance is adjusted by
   */
  public double getAmount() {
    return this.amount;
  }

  /**
   * @return balance Account balance.
   */
  public double getBalance() {
    return this.balance;
  }

  /**
   * @return itemClass Class of statement item. This value will determine which set of keys will be
   *         included in itemClassData
   */
  public ItemClass getItemClass() {
    return this.itemClass;
  }

  /**
   * @return itemClassData Key value pairs describing the current statement item. The set of keys
   *         will be determined by the itemClass
   */
  public HashMap<String, String> getItemClassData() {
    return this.itemClassData;
  }

  /**
   * @return legacyData Set of fields originally returned from APIv6. Provided to facilitate
   *         migration from APIv6 to API-NG, and ultimately onto itemClass and itemClassData
   */
  public StatementLegacyData getLegacyData() {
    return this.legacyData;
  }

  public static class Builder {
    private Date itemDate;
    private ItemClass itemClass;
    private StatementLegacyData legacyData;
    private double amount;
    private HashMap<String, String> itemClassData;
    private double balance;
    private String refId;

    /**
     * @param itemDate : The date and time of the statement item, eg. equivalent to settledData for
     *        an exchange bet statement item. (in ISO-8601 format, not translated)
     */
    public Builder(@JsonProperty("itemDate") Date itemDate) {
      this.itemDate = itemDate;
    }

    /**
     * Use this function to set amount
     * 
     * @param amount The amount of money the balance is adjusted by
     * @return Builder
     */
    public Builder withAmount(double amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Use this function to set balance
     * 
     * @param balance Account balance.
     * @return Builder
     */
    public Builder withBalance(double balance) {
      this.balance = balance;
      return this;
    }

    /**
     * Use this function to set itemClass
     * 
     * @param itemClass Class of statement item. This value will determine which set of keys will be
     *        included in itemClassData
     * @return Builder
     */
    public Builder withItemClass(ItemClass itemClass) {
      this.itemClass = itemClass;
      return this;
    }

    /**
     * Use this function to set itemClassData
     * 
     * @param itemClassData Key value pairs describing the current statement item. The set of keys
     *        will be determined by the itemClass
     * @return Builder
     */
    public Builder withItemClassData(HashMap<String, String> itemClassData) {
      this.itemClassData = itemClassData;
      return this;
    }

    /**
     * Use this function to set legacyData
     * 
     * @param legacyData Set of fields originally returned from APIv6. Provided to facilitate
     *        migration from APIv6 to API-NG, and ultimately onto itemClass and itemClassData
     * @return Builder
     */
    public Builder withLegacyData(StatementLegacyData legacyData) {
      this.legacyData = legacyData;
      return this;
    }

    public StatementItem build() {
      return new StatementItem(this);
    }
  }
}
