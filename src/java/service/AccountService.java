/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ClientDao;
import dao.ContDao;
import dto.ContDTO;
import entitiesDB.ClientDB;
import entitiesDB.ContDB;
import java.util.Date;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import utils.ConvertDate;

/**
 *
 * @author Israel Dago
 */
@Stateless
@LocalBean
public class AccountService {

    @EJB
    private ContDao contDao;
    @EJB
    private ClientDao clientDao;

    private Random random;

    @PostConstruct
    public void init() {
        random = new Random();
    }

    public void addAccount(Integer idClient, String descriereContului) {
        ClientDB clientDB = clientDao.find(idClient);
        if (clientDB != null) {
            ContDB contDB = new ContDB();
            contDB.setIban("RO" + random.nextInt(1000000000));
            contDB.setDescriere(descriereContului);
            contDB.setCreationDate(ConvertDate.toString(new Date()));
            contDB.setClient(clientDB);
            contDB.setActive(true);
            contDao.create(contDB);
        }
    }

    public void removeAccount(Integer contID) {
        if (contDao.find(contID) != null) {
            contDao.remove(contDao.find(contID));
        }
    }

   
    
    
    public void depunereNumar(Double suma, Integer contCreditatID){
        ContDB contDB = contDao.find(contCreditatID);
        contDB.setSold(contDB.getSold() + suma);   
        contDao.edit(contDB);
    }      
    
    public void retragereNumar(Double suma, Integer contDebitatID){
        ContDB contDB = contDao.find(contDebitatID);
        if(contDB.getSold() >= suma){
            contDB.setSold(contDB.getSold() - suma);  
            contDao.edit(contDB);
        }        
    }
    
    
    public void transferNumar(Double suma,Integer contDebitatID, Integer contCreditatID){
        retragereNumar(suma, contDebitatID);
        depunereNumar(suma, contCreditatID);
    }
    
   
}
