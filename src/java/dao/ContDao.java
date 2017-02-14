/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entitiesDB.ContDB;
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
public class ContDao extends AbstractFacade<ContDB> {

    @PersistenceContext(unitName = "server2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContDao() {
        super(ContDB.class);
    }
    
}
