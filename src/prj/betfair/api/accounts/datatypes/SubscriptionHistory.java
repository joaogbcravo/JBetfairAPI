package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.SubscriptionHistory;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Application subscription history details
 */
@JsonDeserialize(builder = SubscriptionHistory.Builder.class)
public class SubscriptionHistory {
  private final String clientReference;
  private final Date expiredDateTime;
  private final Date expiryDateTime;
  private final Date cancellationDateTime;
  private final Date createdDateTime;
  private final String subscriptionToken;
  private final String subscriptionStatus;
  private final Date activationDateTime;

  public SubscriptionHistory(Builder builder) {
    this.clientReference = builder.clientReference;
    this.expiredDateTime = builder.expiredDateTime;
    this.expiryDateTime = builder.expiryDateTime;
    this.cancellationDateTime = builder.cancellationDateTime;
    this.createdDateTime = builder.createdDateTime;
    this.subscriptionToken = builder.subscriptionToken;
    this.subscriptionStatus = builder.subscriptionStatus;
    this.activationDateTime = builder.activationDateTime;
  }

  /**
   * @return subscriptionToken Application key identifier
   */
  public String getSubscriptionToken() {
    return this.subscriptionToken;
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
   * @return createdDateTime Subscription Create date
   */
  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  /**
   * @return activationDateTime Subscription Activation date
   */
  public Date getActivationDateTime() {
    return this.activationDateTime;
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

  /**
   * @return clientReference Client reference
   */
  public String getClientReference() {
    return this.clientReference;
  }

  public static class Builder {
    private String clientReference;
    private Date expiredDateTime;
    private Date expiryDateTime;
    private Date cancellationDateTime;
    private Date createdDateTime;
    private String subscriptionToken;
    private String subscriptionStatus;
    private Date activationDateTime;

    /**
     * @param subscriptionToken : Application key identifier
     */
    public Builder(@JsonProperty("subscriptionToken") String subscriptionToken) {
      this.subscriptionToken = subscriptionToken;
    }

    public SubscriptionHistory build() {
      return new SubscriptionHistory(this);
    }
  }
}
