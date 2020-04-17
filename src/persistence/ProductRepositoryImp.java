/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author copad
 */
public class ProductRepositoryImp extends RepositoryBase<Product> implements ProductRepository{

    public ProductRepositoryImp(EntityManager entityManager) {
        super(entityManager, Product.class);
    }

    @Override
    public List<Product> finedByName(String name) {

        if (name == null || name.isEmpty()) {

        }

        Query q = this.entityManager.createNativeQuery("SELECT * FROM product WHERE Name=? ", this.cls);
        q.setParameter(1, name);
        return q.getResultList();
    }

    @Override
    public List<Product> findAll() {
       List q= entityManager.createNativeQuery("SELECT * FROM product ", Product.class).getResultList();
       return q;
    }
    
}
