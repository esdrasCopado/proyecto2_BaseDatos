/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Product;
import java.util.List;

/**
 *
 * @author copad
 */
public interface ProductRepository extends Repository<Product>{
    List<Product> finedByName(String name);
    List<Product> findAll();
}
