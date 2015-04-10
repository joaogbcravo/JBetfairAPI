package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.AccountFundsResponse;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Response for retrieving available to bet.
 */
@JsonDeserialize(builder = AccountFundsResponse.Builder.class)
public class AccountFundsResponse {
  private final int pointsBalance;
  private final String wallet;
  private final double retainedCommission;
  private final double exposureLimit;
  private final double availableToBetBalance;
  private final double discountRate;
  private final double exposure;

  private AccountFundsResponse(Builder builder) {
    this.pointsBalance = builder.pointsBalance;
    this.wallet = builder.wallet;
    this.retainedCommission = builder.retainedCommission;
    this.exposureLimit = builder.exposureLimit;
    this.availableToBetBalance = builder.availableToBetBalance;
    this.discountRate = builder.discountRate;
    this.exposure = builder.exposure;
  }
  /**
   * @return availableToBetBalance Amount available to bet.
   */
  public double getAvailableToBetBalance() {
    return this.availableToBetBalance;
  }

  /**
   * @return exposure Current exposure.
   */
  public double getExposure() {
    return this.exposure;
  }

  /**
   * @return retainedCommission Sum of retained commission.
   */
  public double getRetainedCommission() {
    return this.retainedCommission;
  }

  /**
   * @return exposureLimit Exposure limit.
   */
  public double getExposureLimit() {
    return this.exposureLimit;
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
   * @return wallet The Betfair wallet name.
   */
  public String getWallet() {
    return this.wallet;
  }

  public static class Builder {
    private int pointsBalance;
    private String wallet;
    private double retainedCommission;
    private double exposureLimit;
    private double availableToBetBalance;
    private double discountRate;
    private double exposure;

    public Builder() {}
    public Builder withPointsBalance(int pointsBalance) {
      this.pointsBalance = pointsBalance;
      return this;
    }
    public Builder withWallet(String wallet) {
      this.wallet = wallet;
      return this;
    }
    public Builder withRetainedCommission(double retainedCommission) {
      this.retainedCommission = retainedCommission;
      return this;
    }
    public Builder withExposureLimit(double exposureLimit) {
      this.exposureLimit = exposureLimit;
      return this;
    }
    public Builder withAvailableToBetBalance(double availableToBetBalance) {
      this.availableToBetBalance = availableToBetBalance;
      return this;
    }
    public Builder withDiscountRate(double discountRate) {
      this.discountRate = discountRate;
      return this;
    }
    public Builder withExposure(double exposure) {
      this.exposure = exposure;
      return this;
    }
    public AccountFundsResponse build() {
      return new AccountFundsResponse(this);
    }
  }
}
