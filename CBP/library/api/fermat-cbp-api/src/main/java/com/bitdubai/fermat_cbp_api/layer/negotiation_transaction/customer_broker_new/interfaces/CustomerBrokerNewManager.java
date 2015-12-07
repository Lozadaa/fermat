package com.bitdubai.fermat_cbp_api.layer.negotiation_transaction.customer_broker_new.interfaces;

import com.bitdubai.fermat_cbp_api.all_definition.enums.NegotiationStatus;
import com.bitdubai.fermat_cbp_api.all_definition.negotiation.Clause;
import com.bitdubai.fermat_cbp_api.all_definition.negotiation.Negotiation;
import com.bitdubai.fermat_cbp_api.layer.negotiation_transaction.customer_broker_new.exceptions.CantCreateCustomerBrokerNewNegotiationTransactionException;
import com.bitdubai.fermat_cbp_api.layer.negotiation_transaction.customer_broker_new.exceptions.CantGetCustomerBrokerNewNegotiationTransactionException;
import com.bitdubai.fermat_cbp_api.layer.negotiation_transaction.customer_broker_new.exceptions.CantGetListCustomerBrokerNewNegotiationTransactionException;
import com.bitdubai.fermat_cbp_api.layer.negotiation_transaction.customer_broker_new.exceptions.CantUpdateStatusCustomerBrokerNewNegotiationTransactionException;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by Yordin Alayn on 23.11.15.
 */
public interface CustomerBrokerNewManager {

    CustomerBrokerNew createCustomerBrokerNewNegotiationTranasction(Negotiation negotiation, Collection<Clause> clauses) throws CantCreateCustomerBrokerNewNegotiationTransactionException;

    void updateStatusCustomerBrokerNewNegotiationTranasction(UUID transactionId, NegotiationStatus statusTransaction) throws CantUpdateStatusCustomerBrokerNewNegotiationTransactionException;

    CustomerBrokerNew getCustomerBrokerNewNegotiationTranasction(UUID transactionId) throws CantGetCustomerBrokerNewNegotiationTransactionException;

    List<CustomerBrokerNew> getAllCustomerBrokerNewNegotiationTranasction() throws CantGetListCustomerBrokerNewNegotiationTransactionException;

}
