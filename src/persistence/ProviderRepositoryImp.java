/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import entities.Product;
import entities.Provider;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author copad
 */
public class ProviderRepositoryImp extends RepositoryBase<Provider> implements ProviderRepository{

    public ProviderRepositoryImp(EntityManager entityManager) {
        super(entityManager, Provider.class);
    }

    @Override
    public List<Provider> findByName(String name) {
        
        if (name == null || name.isEmpty()) {

        }

        Query q = this.entityManager.createNativeQuery("SELECT * FROM provider WHERE Name=? ", this.cls);
        q.setParameter(1, name);
        return q.getResultList();
    }

    @Override
    public List<Provider> findAll() {
        List q=entityManager.createNativeQuery("SELECT * FROM provider ",Provider.class).getResultList();
        return q;
    }







    
}
