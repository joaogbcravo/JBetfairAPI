package prj.betfair.api.betting.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import prj.betfair.api.betting.datatypes.MarketLicence;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Market Licence
 */
@JsonDeserialize(builder = MarketLicence.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketLicence {
  private final String rules;
  private final String wallet;
  private final String clarifications;
  private final boolean rulesHasDate;

  public MarketLicence(Builder builder) {
    this.rules = builder.rules;
    this.wallet = builder.wallet;
    this.clarifications = builder.clarifications;
    this.rulesHasDate = builder.rulesHasDate;
  }

  /**
   * @return wallet The wallet from which funds will be taken when betting on this market
   */
  public String getWallet() {
    return this.wallet;
  }

  /**
   * @return rules The rules for this market
   */
  public String getRules() {
    return this.rules;
  }

  /**
   * @return rulesHasDate The market's start date and time are relevant to the rules.
   */
  public boolean getRulesHasDate() {
    return this.rulesHasDate;
  }

  /**
   * @return clarifications Clarifications to the rules for the market
   */
  public String getClarifications() {
    return this.clarifications;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private String rules;
    private String wallet;
    private String clarifications;
    private boolean rulesHasDate;

    /**
     * @param wallet : The wallet from which funds will be taken when betting on this market
     */
    public Builder(@JsonProperty("wallet") String wallet) {
      this.wallet = wallet;
    }

    /**
     * Use this function to set rules
     * 
     * @param rules The rules for this market
     * @return Builder
     */
    public Builder withRules(String rules) {
      this.rules = rules;
      return this;
    }

    /**
     * Use this function to set rulesHasDate
     * 
     * @param rulesHasDate The market's start date and time are relevant to the rules.
     * @return Builder
     */
    public Builder withRulesHasDate(boolean rulesHasDate) {
      this.rulesHasDate = rulesHasDate;
      return this;
    }

    /**
     * Use this function to set clarifications
     * 
     * @param clarifications Clarifications to the rules for the market
     * @return Builder
     */
    public Builder withClarifications(String clarifications) {
      this.clarifications = clarifications;
      return this;
    }

    public MarketLicence build() {
      return new MarketLicence(this);
    }
  }
}
