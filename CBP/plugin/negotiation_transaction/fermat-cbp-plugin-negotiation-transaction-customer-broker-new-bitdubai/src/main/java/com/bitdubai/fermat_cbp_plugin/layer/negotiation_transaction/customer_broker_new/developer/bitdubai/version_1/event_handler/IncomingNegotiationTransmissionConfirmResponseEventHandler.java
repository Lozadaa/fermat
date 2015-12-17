package com.bitdubai.fermat_cbp_plugin.layer.negotiation_transaction.customer_broker_new.developer.bitdubai.version_1.event_handler;

import com.bitdubai.fermat_api.FermatException;
import com.bitdubai.fermat_api.layer.all_definition.enums.ServiceStatus;
import com.bitdubai.fermat_api.layer.all_definition.events.interfaces.FermatEvent;
import com.bitdubai.fermat_api.layer.dmp_transaction.TransactionServiceNotStartedException;
import com.bitdubai.fermat_cbp_api.all_definition.exceptions.CantSaveEventException;
import com.bitdubai.fermat_cbp_api.layer.network_service.NegotiationTransmission.events.IncomingNegotiationTransmissionConfirmNegotiationEvent;
import com.bitdubai.fermat_cbp_api.layer.network_service.NegotiationTransmission.events.IncomingNegotiationTransmissionConfirmResponseEvent;

/**
 * Created by Yordin Alayn 10.12.15
 */
public class IncomingNegotiationTransmissionConfirmResponseEventHandler extends AbstractNegotiationTransactionEventHandler {

    @Override
    public void handleEvent(FermatEvent fermatEvent) throws FermatException {
        if(this.CustomerBrokerNewServiceEventHandler.getStatus()== ServiceStatus.STARTED) {

            try {
                this.CustomerBrokerNewServiceEventHandler.incomingNegotiationTransactionConfirmResponseEventHandler((IncomingNegotiationTransmissionConfirmResponseEvent) fermatEvent);
            } catch(CantSaveEventException exception){
                throw new CantSaveEventException(exception,"Handling the incomingNegotiationTransactionConfirmResponseEventHandler", "Check the cause");
            } catch(ClassCastException exception){
                //Logger LOG = Logger.getGlobal();
                //LOG.info("EXCEPTION DETECTOR----------------------------------");
                //exception.printStackTrace();
                throw new CantSaveEventException(FermatException.wrapException(exception), "Handling the incomingNegotiationTransactionConfirmResponseEventHandler", "Cannot cast this event");
            } catch(Exception exception){
                throw new CantSaveEventException(exception,"Handling the incomingNegotiationTransactionConfirmResponseEventHandler", "Unexpected exception");
            }

        }else {
            throw new TransactionServiceNotStartedException();
        }
    }
}
