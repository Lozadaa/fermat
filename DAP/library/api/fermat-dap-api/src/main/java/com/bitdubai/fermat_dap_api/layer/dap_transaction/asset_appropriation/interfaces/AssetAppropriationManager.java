package com.bitdubai.fermat_dap_api.layer.dap_transaction.asset_appropriation.interfaces;

import com.bitdubai.fermat_api.layer.all_definition.common.system.interfaces.FermatManager;
import com.bitdubai.fermat_dap_api.layer.all_definition.digital_asset.DigitalAssetMetadata;
import com.bitdubai.fermat_dap_api.layer.all_definition.enums.AppropriationStatus;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.asset_appropriation.exceptions.CantLoadAssetAppropriationTransactionListException;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.exceptions.CantExecuteAppropriationTransactionException;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.exceptions.RecordsNotFoundException;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.exceptions.TransactionAlreadyStartedException;
import com.bitdubai.fermat_dap_api.layer.dap_transaction.common.interfaces.AppropriationTransactionRecord;

import java.util.List;

/**
 * Created by Víctor A. Mars M. (marsvicam@gmail.com) on 12/11/15.
 */
public interface AssetAppropriationManager extends FermatManager {

    /**
     * This method starts the appropriation flow. Saves the information in the database and store
     * the asset in the file system.
     *
     * @param digitalAssetMetadata             the asset to be appropriated and its metadata
     * @param assetUserWalletPublicKey the public key from the asset user wallet where this asset will be debited.
     * @param bitcoinWalletPublicKey   the bitcoin wallet public key where the bitcoins will be sent.
     * @throws CantExecuteAppropriationTransactionException in case something bad happen and the appropriation flow can't start.
     * @throws TransactionAlreadyStartedException           in case for some reason you try to appropriate the same asset twice.
     */
    void appropriateAsset(DigitalAssetMetadata digitalAssetMetadata, String assetUserWalletPublicKey, String bitcoinWalletPublicKey) throws CantExecuteAppropriationTransactionException, TransactionAlreadyStartedException;

    /**
     * Returns an {@link AppropriationTransactionRecord} instance with all its stored values,
     * or throws an exception in case it can't be done.
     *
     * @param digitalAssetMetadata             the asset metadata associated with the appropriation.
     * @param assetUserWalletPublicKey the user asset wallet public key associated with the appropriation
     * @param bitcoinWalletPublicKey   the bitcoin wallet public key where the bitcoins were sent.
     * @return instance of {@link AppropriationTransactionRecord}
     * @throws RecordsNotFoundException                           In case a transaction with these parameters couldn't be found.
     * @throws CantLoadAssetAppropriationTransactionListException
     */
    AppropriationTransactionRecord getTransaction(DigitalAssetMetadata digitalAssetMetadata, String assetUserWalletPublicKey, String bitcoinWalletPublicKey) throws RecordsNotFoundException, CantLoadAssetAppropriationTransactionListException;

    /**
     * After the bitcoins for this appropriation are sent, a genesis address is generated by the asset vault
     * that is associated with this transaction, you can track all the other values searching with this public key.
     *
     * @param genesisTransaction the public key generated by the asset vault.
     * @return instance of {@link AppropriationTransactionRecord}
     * @throws RecordsNotFoundException                           In case there's no transaction registered to that genesis transaction.
     * @throws CantLoadAssetAppropriationTransactionListException
     */
    AppropriationTransactionRecord getTransaction(String genesisTransaction) throws RecordsNotFoundException, CantLoadAssetAppropriationTransactionListException;

    /**
     * Querys all the transactions associated for an user wallet public key.
     *
     * @param assetUserWalletPublicKey The user wallet public key.
     * @return {@link List} instance filled with all the transactions associated or an empty list if there were none.
     * @throws CantLoadAssetAppropriationTransactionListException
     */
    List<AppropriationTransactionRecord> getTransactionsForUserWallet(String assetUserWalletPublicKey) throws CantLoadAssetAppropriationTransactionListException;

    /**
     * Querys all the transactions that are in a certain status.
     *
     * @param status {@link AppropriationStatus} you want to search.
     * @return {@link List} instance filled with all the transactions associated or an empty list if there were none.
     * @throws CantLoadAssetAppropriationTransactionListException
     */
    List<AppropriationTransactionRecord> getTransactionsForStatus(AppropriationStatus status) throws CantLoadAssetAppropriationTransactionListException;


    /**
     * Querys all the transactions associated for an bitcoin wallet public key.
     *
     * @param bitcoinWalletPublicKey The bitcoin wallet public key.
     * @return {@link List} instance filled with all the transactions associated or an empty list if there were none.
     * @throws CantLoadAssetAppropriationTransactionListException
     */
    List<AppropriationTransactionRecord> getTransactionsForBitcoinWallet(String bitcoinWalletPublicKey) throws CantLoadAssetAppropriationTransactionListException;

}
