/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Category;
import entities.Costomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author copad
 */
public class CostumerRepositoryImp extends RepositoryBase<Costomer> implements CostumerRepository{

    public CostumerRepositoryImp(EntityManager entityManager) {
        super(entityManager, Costomer.class);
    }

    @Override
    public List<Costomer> findByName(String name) {
                if(name==null||name.isEmpty()){
            
        }
     
        Query q= this.entityManager.createNativeQuery("SELECT * FROM costomer WHERE Name=? ",this.cls);
        q.setParameter(1, name);
        return q.getResultList();
    }


    
}
