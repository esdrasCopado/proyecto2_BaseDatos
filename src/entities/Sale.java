/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author copad
 */
@Entity
@Table(name = "sale")

public class Sale extends EntityBase implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "discout")
    private float discout;
    @Basic(optional = false)
    @Column(name = "total")
    private float total;
    
    @ManyToOne
    @JoinColumn(name="CostomerID")
    Costumer costomer;
    
    @OneToMany(mappedBy = "sale")
    List<Saleitem> saleItem;

    public List<Saleitem> getSaleItem() {
        return saleItem;
    }

    public void setSaleItem(List<Saleitem> saleItem) {
        this.saleItem = saleItem;
    }
    
    public Costumer getCostomer() {
        return costomer;
    }

    public void setCostomer(Costumer costomer) {
        this.costomer = costomer;
    }
    
    public Sale() {
    }

    public Sale(Integer id) {
        this.id = id;
    }

    public Sale(Integer id, Date date, float discout, float total) {
        this.id = id;
        this.date = date;
        this.discout = discout;
        this.total = total;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getDiscout() {
        return discout;
    }

    public void setDiscout(float discout) {
        this.discout = discout;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "id="+id;
    }
    

    
}
