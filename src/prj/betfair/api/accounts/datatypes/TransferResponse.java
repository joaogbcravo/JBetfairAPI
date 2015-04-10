package prj.betfair.api.accounts.datatypes;

import prj.betfair.api.accounts.datatypes.TransferResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/***
 * Transfer operation response
 */
@JsonDeserialize(builder = TransferResponse.Builder.class)
public class TransferResponse {
  private final String transactionId;

  public TransferResponse(Builder builder) {
    this.transactionId = builder.transactionId;
  }

  /**
   * @return transactionId The id of the transfer transaction that will be used in tracking the
   *         transfers between the wallets
   */
  public String getTransactionId() {
    return this.transactionId;
  }

  public static class Builder {
    private String transactionId;

    /**
     * @param transactionId : The id of the transfer transaction that will be used in tracking the
     *        transfers between the wallets
     */
    public Builder(@JsonProperty("transactionId") String transactionId) {
      this.transactionId = transactionId;
    }

    public TransferResponse build() {
      return new TransferResponse(this);
    }
  }
}
