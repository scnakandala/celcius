/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author naka
 */
@Entity
@Table(name = "paddings")
@NamedQueries({
    @NamedQuery(name = "Paddings.findAll", query = "SELECT p FROM Paddings p"),
    @NamedQuery(name = "Paddings.findById", query = "SELECT p FROM Paddings p WHERE p.id = :id"),
    @NamedQuery(name = "Paddings.findByName", query = "SELECT p FROM Paddings p WHERE p.name = :name"),
    @NamedQuery(name = "Paddings.findByPrice", query = "SELECT p FROM Paddings p WHERE p.price = :price"),
    @NamedQuery(name = "Paddings.findByWidth", query = "SELECT p FROM Paddings p WHERE p.width = :width")})
public class Paddings implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "width")
    private double width;

    public Paddings() {
    }

    public Paddings(Integer id) {
        this.id = id;
    }

    public Paddings(Integer id, String name, double price, double width) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.width = width;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        double oldWidth = this.width;
        this.width = width;
        changeSupport.firePropertyChange("width", oldWidth, width);
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
        if (!(object instanceof Paddings)) {
            return false;
        }
        Paddings other = (Paddings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celciusadmin.Paddings[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
