/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;


import entities.Provider;
import java.util.List;

/**
 *
 * @author copad
 */
public interface ProviderRepository extends Repository<Provider>{
    List<Provider> findByName(String name);
    List<Provider> findAll();
}
