package com.bitdubai.fermat_ccp_plugin.layer.crypto_transaction.outgoing_draft.developer.bitdubai.version_1.enums;

import com.bitdubai.fermat_api.layer.all_definition.exceptions.InvalidParameterException;

/**
 * Created by eze on 2015.09.21..
 */
public enum TransactionState {


    NEW("NEW"),
    DEBITED_IN_WALLET ("DIW"),
    SENT_TO_CRYPTO_VOULT("STCV"),
    SUCCESSFUL_SIG("SS"),
    COMPLETED("COM"),
    CANCELED("CLD");


    private final String code;

    TransactionState(String code){
        this.code = code;
    }

    public String getCode() {return this.code;}

    public static TransactionState getByCode(String code) throws InvalidParameterException {
        switch (code){
            case "NEW":  return TransactionState.NEW;
            case "DIW":  return TransactionState.DEBITED_IN_WALLET;
            case "STCV": return TransactionState.SENT_TO_CRYPTO_VOULT;
            case "SS":   return TransactionState.SUCCESSFUL_SIG;
            case "CLD":  return TransactionState.CANCELED;
            default:
                /**
                 * If we try to cpmvert am invalid string.
                 */
                throw new InvalidParameterException(code);
        }
    }
}
