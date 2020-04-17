/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Saleitem;
import javax.persistence.EntityManager;

/**
 *
 * @author copad
 */
public class SaleItemRepositoryImp extends RepositoryBase<Saleitem> implements SaleItemRepository{

    public SaleItemRepositoryImp(EntityManager entityManager) {
        super(entityManager, Saleitem.class);
    }
    
}
