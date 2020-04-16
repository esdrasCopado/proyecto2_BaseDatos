/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author copad
 */
@Entity
public class Product extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Column(nullable = false)
    private float price;

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    @Column(nullable = false)
    private int stock;

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    @ManyToOne
    @JoinColumn(name = "categoryID")
    Category categoryID;

    public Category getCategory() {
        return categoryID;
    }

    public void setCategory(Category categoryID) {
        this.categoryID = categoryID;
    }

    @ManyToOne
    @JoinColumn(name = "providerID")

    Provider provider;

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    @OneToMany(mappedBy = "product")
    List<Saleitem> saleItem;



    @Override
    public String toString() {
        return "id=" + id + " name=" + name;
    }

}



