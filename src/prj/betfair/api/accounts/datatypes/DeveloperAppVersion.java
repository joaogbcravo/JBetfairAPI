package prj.betfair.api.accounts.datatypes;
import prj.betfair.api.accounts.datatypes.DeveloperAppVersion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
/***

            Describes a version of an external application
        
*/
@JsonDeserialize(builder=DeveloperAppVersion.Builder.class)
public class DeveloperAppVersion {
   private final boolean ownerManaged;
   private final boolean delayData;
   private final String applicationKey;
   private final boolean subscriptionRequired;
   private final long versionId;
   private final String version;
   private final String owner;
   private final boolean active;
   
   public DeveloperAppVersion(Builder builder){
      this.ownerManaged = builder.ownerManaged;
      this.delayData = builder.delayData;
      this.applicationKey = builder.applicationKey;
      this.subscriptionRequired = builder.subscriptionRequired;
      this.versionId = builder.versionId;
      this.version = builder.version;
      this.owner = builder.owner;
      this.active = builder.active;
   }
   /**
    * @return owner The sportex user who owns the specific version of the application
   */
   public String getOwner() {
      return this.owner;
   }
   /**
    * @return versionId The unique Id of the application version
   */
   public long getVersionId() {
      return this.versionId;
   }
   /**
    * @return version The version identifier string such as 1.0, 2.0. Unique for a given application.
   */
   public String getVersion() {
      return this.version;
   }
   /**
    * @return applicationKey The unqiue application key associated with this application version
   */
   public String getApplicationKey() {
      return this.applicationKey;
   }
   /**
    * @return delayData Indicates whether the data exposed by platform services as seen by this application key is delayed or realtime.
   */
   public boolean getDelayData() {
      return this.delayData;
   }
   /**
    * @return subscriptionRequired Indicates whether the application version needs explicit subscription
   */
   public boolean getSubscriptionRequired() {
      return this.subscriptionRequired;
   }
   /**
    * @return ownerManaged Indicates whether the application version needs explicit management by producers. A value of false indicates, this is a version meant for developer use.
   */
   public boolean getOwnerManaged() {
      return this.ownerManaged;
   }
   /**
    * @return active Indicates whether the application version is currently active
   */
   public boolean getActive() {
      return this.active;
   }
   public static class Builder {
      private boolean ownerManaged;
      private boolean delayData;
      private String applicationKey;
      private boolean subscriptionRequired;
      private long versionId;
      private String version;
      private String owner;
      private boolean active;
      
      /**
       * @param ownerManaged : Indicates whether the application version needs explicit management by producers. A value of false indicates, this is a version meant for developer use.
       * @param applicationKey : The unqiue application key associated with this application version
       * @param subscriptionRequired : Indicates whether the application version needs explicit subscription
       * @param versionId : The unique Id of the application version
       * @param version : The version identifier string such as 1.0, 2.0. Unique for a given application.
       * @param owner : The sportex user who owns the specific version of the application
       * @param active : Indicates whether the application version is currently active
       */
      public Builder(@JsonProperty("ownerManaged") boolean ownerManaged, @JsonProperty("applicationKey") String applicationKey, @JsonProperty("subscriptionRequired") boolean subscriptionRequired, @JsonProperty("versionId") long versionId, @JsonProperty("version") String version, @JsonProperty("owner") String owner, @JsonProperty("active") boolean active) {
         this.ownerManaged = ownerManaged;
         this.applicationKey = applicationKey;
         this.subscriptionRequired = subscriptionRequired;
         this.versionId = versionId;
         this.version = version;
         this.owner = owner;
         this.active = active;
      }
      public DeveloperAppVersion build(){
         return new DeveloperAppVersion(this);
      }
   }
}
