/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entitiesDB.ClientDB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Israel Dago
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ClientDao extends AbstractFacade<ClientDB> {

    @PersistenceContext(unitName = "server2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientDao() {
        super(ClientDB.class);
    }
    
}
