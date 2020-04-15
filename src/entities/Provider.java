/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author copad
 */
@Entity
public class Provider extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;


    
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String webSite;



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    @OneToMany(mappedBy = "Provider",cascade = CascadeType.PERSIST)
    List<product> product;

    public List<product> getProduct() {
        return product;
    }

    public void setProduct(List<product> product) {
        this.product = product;
    }
    
    @Override
    public String toString() {
        return "id=" + id + " name=" + name;
    }
    
    

}
