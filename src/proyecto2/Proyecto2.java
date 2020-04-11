/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import entities.Category;
import entities.Sale;
import entities.product;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author copad
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Category category=new Category();
        
        EntityManagerFactory managerFactory=Persistence.createEntityManagerFactory("Proyecto2PU");
        EntityManager entityManager=managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        product p=new product();
        p.setName("cocacola");
        p.setPrice(20);
        p.setStock(200);
        p.setCategory(category);
        
        
        category.setName("refrescos");
        category.setDescription("bebidas carbonatadas con azucar");
        
        Sale sale=new Sale();
        sale.setDiscount(15f);
        
        sale.setDate(new Date(120,20,19));
        sale.setTotal(1500f);
        
        
        entityManager.persist(sale);
        entityManager.persist(category);
        entityManager.persist(p);
        entityManager.getTransaction().commit();
        
    }
    
}
