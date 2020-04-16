/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author copad
 */
public class CategoryRepositoryImp extends RepositoryBase<Category> implements CategoryRepository{

    public CategoryRepositoryImp(EntityManager entityManager) {
        super(entityManager, Category.class);
    }

    @Override
    public List<Category> findByName(String name) {
        if(name==null||name.isEmpty()){
            
        }
     
        Query q= this.entityManager.createNativeQuery("SELECT * FROM category WHERE Name=? ",this.cls);
        q.setParameter(1, name);
        return q.getResultList();
    }
    
}
