/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Product;
import entities.Saleitem;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author copad
 */
public class SaleItemRepositoryImp extends RepositoryBase<Saleitem> implements SaleItemRepository{

    public SaleItemRepositoryImp(EntityManager entityManager) {
        super(entityManager, Saleitem.class);
    }

    @Override
    public List<Saleitem> findAll() {
        List q= entityManager.createNativeQuery("SELECT * FROM saleitem ", this.cls).getResultList();
        return q;
    }
    
}
