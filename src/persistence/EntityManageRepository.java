/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author copad
 */
public class EntityManageRepository {
    
    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;
    
    
    public EntityManageRepository(){
    managerFactory = Persistence.createEntityManagerFactory("Proyecto2PU");
    entityManager = managerFactory.createEntityManager();
    }
    
    
    public EntityManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    
    
}
