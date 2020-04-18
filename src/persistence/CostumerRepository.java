/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entities.Costumer;
import java.util.List;

/**
 *
 * @author copad
 */
public interface CostumerRepository extends Repository<Costumer>{
    List<Costumer> findByName(String name);
    List<Costumer> findAll();
}
