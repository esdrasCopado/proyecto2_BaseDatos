/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 *
 * @author copad
 */
@Entity
public class product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof product)) {
            return false;
        }
        product other = (product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.product[ id=" + id + " ]";
    }
    
    @Column(nullable = false)
    String name;
    
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    
    @Column(nullable = false)
    float price;
    
    public void setPrice(float price){
        this.price=price;
    }
    public float getPrice(){
        return price;
    }
    
    @Column(nullable=false)
    int stock;
    
    public void setStock(int stock){
        this.stock=stock;
    }
    
    public int getStock(){
        return stock;
    }

    
    @ManyToOne
    @JoinColumn(name="categoryID")
    Category categoryID;

    public Category getCategory() {
        return categoryID;
    }

    public void setCategory(Category categoryID) {
        this.categoryID = categoryID;
    }
    @JoinColumn(name="name")
    
    
    
}
