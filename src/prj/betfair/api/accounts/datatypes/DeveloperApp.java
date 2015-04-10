package prj.betfair.api.accounts.datatypes;
import prj.betfair.api.accounts.datatypes.DeveloperApp;
import prj.betfair.api.accounts.datatypes.DeveloperAppVersion;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
/***

            Describes developer/vendor specific application
        
*/
@JsonDeserialize(builder=DeveloperApp.Builder.class)
public class DeveloperApp {
   private final long appId;
   private final ArrayList<DeveloperAppVersion> appVersions;
   private final String appName;
   
   public DeveloperApp(Builder builder){
      this.appId = builder.appId;
      this.appVersions = builder.appVersions;
      this.appName = builder.appName;
   }
   /**
    * @return appName The unique name of the application
   */
   public String getAppName() {
      return this.appName;
   }
   /**
    * @return appId A unique id of this application
   */
   public long getAppId() {
      return this.appId;
   }
   /**
    * @return appVersions The application versions (including application keys)
   */
   public ArrayList<DeveloperAppVersion> getAppVersions() {
      return this.appVersions;
   }
   public static class Builder {
      private long appId;
      private ArrayList<DeveloperAppVersion> appVersions;
      private String appName;
      
      /**
       * @param appId : A unique id of this application
       * @param appVersions : The application versions (including application keys)
       * @param appName : The unique name of the application
       */
      public Builder(@JsonProperty("appId") long appId, @JsonProperty("appVersions") ArrayList<DeveloperAppVersion> appVersions, @JsonProperty("appName") String appName) {
         this.appId = appId;
         this.appVersions = appVersions;
         this.appName = appName;
      }
      public DeveloperApp build(){
         return new DeveloperApp(this);
      }
   }
}
