package prj.betfair.api.accounts.datatypes;
import prj.betfair.api.accounts.datatypes.ApplicationSubscription;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
/***

            Application subscription details
        
*/
@JsonDeserialize(builder=ApplicationSubscription.Builder.class)
public class ApplicationSubscription {
   private final String clientReference;
   private final Date expiredDateTime;
   private final Date expiryDateTime;
   private final Date cancellationDateTime;
   private final Date createdDateTime;
   private final String subscriptionToken;
   private final String subscriptionStatus;
   private final Date activationDateTime;
   private final String vendorClientId;
   
   public ApplicationSubscription(Builder builder){
      this.clientReference = builder.clientReference;
      this.expiredDateTime = builder.expiredDateTime;
      this.expiryDateTime = builder.expiryDateTime;
      this.cancellationDateTime = builder.cancellationDateTime;
      this.createdDateTime = builder.createdDateTime;
      this.subscriptionToken = builder.subscriptionToken;
      this.subscriptionStatus = builder.subscriptionStatus;
      this.activationDateTime = builder.activationDateTime;
      this.vendorClientId = builder.vendorClientId;
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
   /**
    * @return vendorClientId Vendor client Id
   */
   public String getVendorClientId() {
      return this.vendorClientId;
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
      private String vendorClientId;
      
      /**
       * @param subscriptionToken : Application key identifier
       */
      public Builder(@JsonProperty("subscriptionToken") String subscriptionToken) {
         this.subscriptionToken = subscriptionToken;
      }
      
      public Builder withClientReference(String clientReference) {
        this.clientReference = clientReference;
        return this;
      }

      public Builder withExpiredDateTime(Date expiredDateTime) {
        this.expiredDateTime = expiredDateTime;
        return this;
      }

      public Builder withExpiryDateTime(Date expiryDateTime) {
        this.expiryDateTime = expiryDateTime;
        return this;
      }

      public Builder withCancellationDateTime(Date cancellationDateTime) {
        this.cancellationDateTime = cancellationDateTime;
        return this;
      }

      public Builder withCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
      }

      public Builder withSubscriptionToken(String subscriptionToken) {
        this.subscriptionToken = subscriptionToken;
        return this;
      }

      public Builder withSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
        return this;
      }

      public Builder withActivationDateTime(Date activationDateTime) {
        this.activationDateTime = activationDateTime;
        return this;
      }

      public Builder setVendorClientId(String vendorClientId) {
        this.vendorClientId = vendorClientId;
        return this;
      }

      public ApplicationSubscription build(){
         return new ApplicationSubscription(this);
      }
   }
}
