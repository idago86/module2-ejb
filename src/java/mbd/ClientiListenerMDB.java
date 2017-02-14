/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbd;

import dto.ClientDTO;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import service.ClientiService;

/**
 *
 * @author Israel Dago
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueueCLIENTI")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ClientiListenerMDB implements MessageListener {
    
    @EJB private ClientiService service;
    
    public ClientiListenerMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {            
            ClientDTO clientDTO = message.getBody(ClientDTO.class);
            
            if("add".equals(clientDTO.getAction())){
                service.adaugaClient(clientDTO);
            }
            
            if("remove".equals(clientDTO.getAction())){
                service.removeClient(clientDTO);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
