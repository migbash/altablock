package blockmatrix.model;

import java.security.PublicKey;

import blockmatrix.helpers.StringUtil;

public class Transaction_Output {

    // __________________
    // Class Variables

    String id;                                      // 'this' transaction-output ID
    PublicKey recipient;                            // new owner of these coins
    float value;                                    // amount of coins they now own
    private String parentTransactionId;             // id of the transaction this output was created in

    // __________________
    // Class Constructor

    public Transaction_Output(PublicKey recipient, float value, String parentTransactionId) {
        this.recipient = recipient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StringUtil.apply_Sha256(StringUtil.getStringFromKey(recipient) +
                                                Float.toString(value) +
                                                parentTransactionId);
    }

    // __________________
    // Class Methods

    boolean is_Transaction_Mine(PublicKey publicKey) { return (publicKey.equals(recipient)); }

    // __________________
    // Getters

    public String getId(){ return this.id; }
    public PublicKey getRecipient() { return this.recipient; }
    public float getValue() { return this.value; }
    public String getParentTransactionId() { return this.parentTransactionId; }
}
