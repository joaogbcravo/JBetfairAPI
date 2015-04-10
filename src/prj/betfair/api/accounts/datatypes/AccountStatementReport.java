package prj.betfair.api.accounts.datatypes;
import prj.betfair.api.accounts.datatypes.AccountStatementReport;
import prj.betfair.api.accounts.datatypes.StatementItem;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
/***
A container representing search results.
*/
@JsonDeserialize(builder=AccountStatementReport.Builder.class)
public class AccountStatementReport {
   private final boolean moreAvailable;
   private final ArrayList<StatementItem> accountStatement;
   
   public AccountStatementReport(Builder builder){
      this.moreAvailable = builder.moreAvailable;
      this.accountStatement = builder.accountStatement;
   }
   /**
    * @return accountStatement The list of statement items returned by your request.
   */
   public ArrayList<StatementItem> getAccountStatement() {
      return this.accountStatement;
   }
   /**
    * @return moreAvailable Indicates whether there are further result items beyond this page.
   */
   public boolean getMoreAvailable() {
      return this.moreAvailable;
   }
   public static class Builder {
      private boolean moreAvailable;
      private ArrayList<StatementItem> accountStatement;
      
      /**
       * @param moreAvailable : Indicates whether there are further result items beyond this page.
       * @param accountStatement : The list of statement items returned by your request.
       */
      public Builder(@JsonProperty("moreAvailable") boolean moreAvailable, @JsonProperty("accountStatement") ArrayList<StatementItem> accountStatement) {
         this.moreAvailable = moreAvailable;
         this.accountStatement = accountStatement;
      }
      public AccountStatementReport build(){
         return new AccountStatementReport(this);
      }
   }
}
