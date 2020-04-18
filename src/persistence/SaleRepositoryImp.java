/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Sale;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author copad
 */
public class SaleRepositoryImp extends RepositoryBase<Sale> implements SaleRepository{

    public SaleRepositoryImp(EntityManager entityManager) {
        super(entityManager, Sale.class);
    }

    @Override
    public List<Sale> findAll() {
        List q= entityManager.createNativeQuery("SELECT * FROM sale ", this.cls).getResultList();
        return q;
    }


    
}
