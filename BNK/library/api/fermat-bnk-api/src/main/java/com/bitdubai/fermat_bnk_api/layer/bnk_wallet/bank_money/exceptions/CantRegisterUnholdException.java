package com.bitdubai.fermat_bnk_api.layer.bnk_wallet.bank_money.exceptions;

import com.bitdubai.fermat_api.FermatException;

/**
 * Created by memo on 23/11/15.
 */
public class CantRegisterUnholdException  extends FermatException {
    public static final String DEFAULT_MESSAGE = "Falled To Register Debit in Bank Money Transaction Wallet Bank Money.";
    public CantRegisterUnholdException(String message, Exception cause, String context, String possibleReason) {
        super(message, cause, context, possibleReason);
    }
}
