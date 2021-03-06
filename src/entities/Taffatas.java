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
@Table(name = "taffatas")
@NamedQueries({
    @NamedQuery(name = "Taffatas.findAll", query = "SELECT t FROM Taffatas t"),
    @NamedQuery(name = "Taffatas.findById", query = "SELECT t FROM Taffatas t WHERE t.id = :id"),
    @NamedQuery(name = "Taffatas.findByName", query = "SELECT t FROM Taffatas t WHERE t.name = :name"),
    @NamedQuery(name = "Taffatas.findByPrice", query = "SELECT t FROM Taffatas t WHERE t.price = :price"),
    @NamedQuery(name = "Taffatas.findByWidth", query = "SELECT t FROM Taffatas t WHERE t.width = :width")})
public class Taffatas implements Serializable {
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

    public Taffatas() {
    }

    public Taffatas(Integer id) {
        this.id = id;
    }

    public Taffatas(Integer id, String name, double price, double width) {
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
        if (!(object instanceof Taffatas)) {
            return false;
        }
        Taffatas other = (Taffatas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celciusadmin.Taffatas[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
