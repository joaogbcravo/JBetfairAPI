package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.SubscriptionTokenInfo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Subscription token information
 */
@JsonDeserialize(builder = SubscriptionTokenInfo.Builder.class)
public class SubscriptionTokenInfo {
  private final String subscriptionToken;
  private final Date expiryDateTime;
  private final Date cancellationDateTime;
  private final Date activatedDateTime;
  private final Date expiredDateTime;
  private final String subscriptionStatus;

  public SubscriptionTokenInfo(Builder builder) {
    this.subscriptionToken = builder.subscriptionToken;
    this.expiryDateTime = builder.expiryDateTime;
    this.cancellationDateTime = builder.cancellationDateTime;
    this.activatedDateTime = builder.activatedDateTime;
    this.expiredDateTime = builder.expiredDateTime;
    this.subscriptionStatus = builder.subscriptionStatus;
  }

  /**
   * @return subscriptionToken Subscription token
   */
  public String getSubscriptionToken() {
    return this.subscriptionToken;
  }

  /**
   * @return activatedDateTime Subscription Activated date
   */
  public Date getActivatedDateTime() {
    return this.activatedDateTime;
  }

  /**
   * @return expiryDateTime Subscription Expiry date
   */
  public Date getExpiryDateTime() {
    return this.expiryDateTime;
  }

  /**
   * @return expiredDateTime Subscription Expired date
   */
  public Date getExpiredDateTime() {
    return this.expiredDateTime;
  }

  /**
   * @return cancellationDateTime Subscription Cancelled date
   */
  public Date getCancellationDateTime() {
    return this.cancellationDateTime;
  }

  /**
   * @return subscriptionStatus Subscription status
   */
  public String getSubscriptionStatus() {
    return this.subscriptionStatus;
  }

  public static class Builder {
    private String subscriptionToken;
    private Date expiryDateTime;
    private Date cancellationDateTime;
    private Date activatedDateTime;
    private Date expiredDateTime;
    private String subscriptionStatus;

    /**
     * @param subscriptionToken : Subscription token
     */
    public Builder(@JsonProperty("subscriptionToken") String subscriptionToken) {
      this.subscriptionToken = subscriptionToken;
    }

    public SubscriptionTokenInfo build() {
      return new SubscriptionTokenInfo(this);
    }
  }
}
