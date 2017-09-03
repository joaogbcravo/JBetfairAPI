package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.MarketDescription;
import prj.betfair.api.betting.datatypes.MarketLineRangeInfo;
import prj.betfair.api.betting.datatypes.PriceLadderDescription;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Market definition
 */
@JsonDeserialize(builder = MarketDescription.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketDescription {
  private final boolean discountAllowed;
  private final Date marketTime;
  private final Date suspendTime;
  private final String clarifications;
  private final String regulator;
  private final String rules;
  private final String marketType;
  private final double marketBaseRate;
  private final boolean persistenceEnabled;
  private final Date settleTime;
  private final String wallet;
  private final boolean turnInPlayEnabled;
  private final boolean bspMarket;
  private final String bettingType;
  private final boolean rulesHasDate;
  private final double eachWayDivisor;
  private final MarketLineRangeInfo lineRangeInfo;
  private final PriceLadderDescription priceLadderDescription;

  public MarketDescription(Builder builder) {
    this.discountAllowed = builder.discountAllowed;
    this.marketTime = builder.marketTime;
    this.suspendTime = builder.suspendTime;
    this.clarifications = builder.clarifications;
    this.regulator = builder.regulator;
    this.rules = builder.rules;
    this.marketType = builder.marketType;
    this.marketBaseRate = builder.marketBaseRate;
    this.persistenceEnabled = builder.persistenceEnabled;
    this.settleTime = builder.settleTime;
    this.wallet = builder.wallet;
    this.turnInPlayEnabled = builder.turnInPlayEnabled;
    this.bspMarket = builder.bspMarket;
    this.bettingType = builder.bettingType;
    this.rulesHasDate = builder.rulesHasDate;
    this.eachWayDivisor = builder.eachWayDivisor;
    this.lineRangeInfo = builder.lineRangeInfo;
    this.priceLadderDescription = builder.priceLadderDescription;
  }

  /**
   * @return persistenceEnabled persistenceMarket
   */
  public boolean getPersistenceEnabled() {
    return this.persistenceEnabled;
  }

  /**
   * @return bspMarket bspMarket
   */
  public boolean getBspMarket() {
    return this.bspMarket;
  }

  /**
   * @return marketTime marketTime
   */
  public Date getMarketTime() {
    return this.marketTime;
  }

  /**
   * @return suspendTime marketSuspendTime
   */
  public Date getSuspendTime() {
    return this.suspendTime;
  }

  /**
   * @return settleTime settled time
   */
  public Date getSettleTime() {
    return this.settleTime;
  }

  /**
   * @return bettingType bettingType
   */
  public String getBettingType() {
    return this.bettingType;
  }

  /**
   * @return turnInPlayEnabled canTurnInPlay
   */
  public boolean getTurnInPlayEnabled() {
    return this.turnInPlayEnabled;
  }

  /**
   * @return marketType market base type
   */
  public String getMarketType() {
    return this.marketType;
  }

  /**
   * @return regulator the market regulator
   */
  public String getRegulator() {
    return this.regulator;
  }

  /**
   * @return marketBaseRate
   */
  public double getMarketBaseRate() {
    return this.marketBaseRate;
  }

  /**
   * @return discountAllowed
   */
  public boolean getDiscountAllowed() {
    return this.discountAllowed;
  }

  /**
   * @return wallet
   */
  public String getWallet() {
    return this.wallet;
  }

  /**
   * @return rules
   */
  public String getRules() {
    return this.rules;
  }

  /**
   * @return rulesHasDate
   */
  public boolean getRulesHasDate() {
    return this.rulesHasDate;
  }

  /**
   * @return clarifications
   */
  public String getClarifications() {
    return this.clarifications;
  }

  /**
   * @return eachWayDivisor
   */
  public double getEachWayDivisor() {
    return eachWayDivisor;
  }

  /**
   * @return lineRangeInfo
   */
  public MarketLineRangeInfo getLineRangeInfo() {
    return lineRangeInfo;
  }

  /**
   * @return priceLadderDescription
   */
  public PriceLadderDescription getPriceLadderDescription() {
    return priceLadderDescription;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private boolean discountAllowed;
    private Date marketTime;
    private Date suspendTime;
    private String clarifications;
    private String regulator;
    private String rules;
    private String marketType;
    private double marketBaseRate;
    private boolean persistenceEnabled;
    private Date settleTime;
    private String wallet;
    private boolean turnInPlayEnabled;
    private boolean bspMarket;
    private String bettingType;
    private boolean rulesHasDate;
    private double eachWayDivisor;
    private MarketLineRangeInfo lineRangeInfo;
    private PriceLadderDescription priceLadderDescription;

    /**
     * @param discountAllowed
     * @param marketTime : marketTime
     * @param suspendTime : marketSuspendTime
     * @param marketType : market base type
     * @param marketBaseRate
     * @param persistenceEnabled : persistenceMarket
     * @param regulator : the market regulator
     * @param turnInPlayEnabled : canTurnInPlay
     * @param bspMarket : bspMarket
     * @param bettingType : bettingType
     */
    public Builder(@JsonProperty("discountAllowed") boolean discountAllowed,
        @JsonProperty("marketTime") Date marketTime, @JsonProperty("suspendTime") Date suspendTime,
        @JsonProperty("marketType") String marketType,
        @JsonProperty("marketBaseRate") double marketBaseRate,
        @JsonProperty("persistenceEnabled") boolean persistenceEnabled,
        @JsonProperty("regulator") String regulator,
        @JsonProperty("turnInPlayEnabled") boolean turnInPlayEnabled,
        @JsonProperty("bspMarket") boolean bspMarket,
        @JsonProperty("bettingType") String bettingType) {
      this.discountAllowed = discountAllowed;
      this.marketTime = marketTime;
      this.suspendTime = suspendTime;
      this.marketType = marketType;
      this.marketBaseRate = marketBaseRate;
      this.persistenceEnabled = persistenceEnabled;
      this.regulator = regulator;
      this.turnInPlayEnabled = turnInPlayEnabled;
      this.bspMarket = bspMarket;
      this.bettingType = bettingType;
    }

    /**
     * Use this function to set settleTime
     *
     * @param settleTime settled time
     * @return Builder
     */
    public Builder withSettleTime(Date settleTime) {
      this.settleTime = settleTime;
      return this;
    }

    /**
     * Use this function to set wallet
     *
     * @param wallet
     * @return Builder
     */
    public Builder withWallet(String wallet) {
      this.wallet = wallet;
      return this;
    }

    /**
     * Use this function to set rules
     *
     * @param rules
     * @return Builder
     */
    public Builder withRules(String rules) {
      this.rules = rules;
      return this;
    }

    /**
     * Use this function to set rulesHasDate
     *
     * @param rulesHasDate
     * @return Builder
     */
    public Builder withRulesHasDate(boolean rulesHasDate) {
      this.rulesHasDate = rulesHasDate;
      return this;
    }

    /**
     * Use this function to set clarifications
     *
     * @param clarifications
     * @return Builder
     */
    public Builder withClarifications(String clarifications) {
      this.clarifications = clarifications;
      return this;
    }

    /**
     * Use this function to set eachWayDivisor
     *
     * @param eachWayDivisor
     * @return Builder
     */
    public Builder withEachWayDivisor(double eachWayDivisor) {
      this.eachWayDivisor = eachWayDivisor;
      return this;
    }

    /**
     * Use this function to set lineRangeInfo
     *
     * @param lineRangeInfo
     * @return Builder
     */
    public Builder withLineRangeInfo(MarketLineRangeInfo lineRangeInfo) {
      this.lineRangeInfo = lineRangeInfo;
      return this;
    }

    /**
     * Use this function to set priceLadderDescription
     *
     * @param priceLadderDescription
     * @return Builder
     */
    public Builder withPriceLadderDescription(PriceLadderDescription priceLadderDescription) {
      this.priceLadderDescription = priceLadderDescription;
      return this;
    }

    public MarketDescription build() {
      return new MarketDescription(this);
    }
  }
}
