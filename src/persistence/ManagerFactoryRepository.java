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
public class ManagerFactoryRepository {
    private EntityManagerFactory managerFactory;
    
    public ManagerFactoryRepository() {
        
        
    }
    public void createEntityManagerFactory(){
    managerFactory = Persistence.createEntityManagerFactory("Proyecto2PU");
    }
    public EntityManager createEntityManager(){
        return managerFactory.createEntityManager();
    }

    public EntityManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public void setManagerFactory(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }
    
    
}
