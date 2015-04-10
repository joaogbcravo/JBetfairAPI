package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.AccountDetailsResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Response for Account details.
 */
@JsonDeserialize(builder = AccountDetailsResponse.Builder.class)
public class AccountDetailsResponse {
  private final String currencyCode;
  private final String firstName;
  private final String lastName;
  private final String localeCode;
  private final String region;
  private final String timezone;
  private final double discountRate;
  private final int pointsBalance;
  private final String countryCode;

  public AccountDetailsResponse(Builder builder) {
    this.pointsBalance = builder.pointsBalance;
    this.firstName = builder.firstName;
    this.localeCode = builder.localeCode;
    this.lastName = builder.lastName;
    this.currencyCode = builder.currencyCode;
    this.discountRate = builder.discountRate;
    this.timezone = builder.timezone;
    this.region = builder.region;
    this.countryCode = builder.countryCode;
  }

  /**
   * @return currencyCode Default user currency Code.
   */
  public String getCurrencyCode() {
    return this.currencyCode;
  }

  /**
   * @return firstName First Name.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * @return lastName Last Name.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * @return localeCode Locale Code.
   */
  public String getLocaleCode() {
    return this.localeCode;
  }

  /**
   * @return region Region.
   */
  public String getRegion() {
    return this.region;
  }

  /**
   * @return timezone User Time Zone.
   */
  public String getTimezone() {
    return this.timezone;
  }

  /**
   * @return discountRate User Discount Rate.
   */
  public double getDiscountRate() {
    return this.discountRate;
  }

  /**
   * @return pointsBalance The Betfair points balance.
   */
  public int getPointsBalance() {
    return this.pointsBalance;
  }
  
  /**
   * @return countryCode The users countryCode.
   */
  public String getCountryCode() {
    return this.countryCode;
  }

  public static class Builder {
    private int pointsBalance;
    private String firstName;
    private String localeCode;
    private String lastName;
    private String currencyCode;
    private double discountRate;
    private String timezone;
    private String region;
    private String countryCode;

    public Builder() {}
    
    public Builder withPointsBalance(int pointsBalance) {
      this.pointsBalance = pointsBalance;
      return this;
    }
    
    public Builder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }
    
    public Builder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }
    
    public Builder withLocaleCode(String localeCode) {
      this.localeCode = localeCode;
      return this;
    }
    
    public Builder withCurrencyCode(String currencyCode) {
      this.currencyCode = currencyCode;
      return this;
    }
    
    public Builder withDiscountRate(double discountRate) {
      this.discountRate = discountRate;
      return this;
    }
    
    public Builder withTimezone(String timezone) {
      this.timezone = timezone;
      return this;
    }
    
    public Builder withRegion(String region) {
      this.region = region;
      return this;
    }
    
    public Builder withCountryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }    
    
    public AccountDetailsResponse build() {
      return new AccountDetailsResponse(this);
    }
  }
}
