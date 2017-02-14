/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ClientDao;
import dto.ClientDTO;
import entitiesDB.ClientDB;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 *
 * @author Israel Dago
 */
@Stateless
@LocalBean
public class ClientiService{

    @EJB private ClientDao clientDao;
    
    
    public void adaugaClient(ClientDTO clientDTO) {
        clientDao.create(new ClientDB(clientDTO.getNume(), clientDTO.getPrenume(), clientDTO.getCnp()));
    }

  
    public void removeClient(ClientDTO clientDTO) {
       ClientDB clientDB = clientDao.find(clientDTO.getId());
       if(clientDB!=null){
           clientDao.remove(clientDB);
       }
    }

   
    
}
