/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbd;

import dto.ContDTO;
import dto.TransactionDTO;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import service.AccountService;

/**
 *
 * @author Israel Dago
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueueACCOUNTS")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class AccountsListenerMDB implements MessageListener {
    
    @EJB private AccountService service;
    
    @Override
    public void onMessage(Message message) {
        try {
             ContDTO contDTO = message.getBody(ContDTO.class);
             
             if("add".equals(contDTO.getAction())){
                service.addAccount(contDTO.getClient().getId(), contDTO.getDescriere());
            }
            
            if("remove".equals(contDTO.getAction())){
                service.removeAccount(contDTO.getId());
            }
            
            if("depune".equals(contDTO.getAction())){
                TransactionDTO tdto = contDTO.getTransactionDTO();
                if(tdto!=null){
                    service.depunereNumar(tdto.getSuma(), tdto.getContDeCreditatID());
                }
            }
            
            if("retrage".equals(contDTO.getAction())){
                TransactionDTO tdto = contDTO.getTransactionDTO();
                if(tdto!=null){
                    service.retragereNumar(tdto.getSuma(), tdto.getContDeDebitatID());
                }
            }
            
            if("transfer".equals(contDTO.getAction())){
                TransactionDTO tdto = contDTO.getTransactionDTO();
                if(tdto!=null){
                    service.transferNumar(tdto.getSuma(), tdto.getContDeDebitatID(), tdto.getContDeCreditatID());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
