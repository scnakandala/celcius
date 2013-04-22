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
@Table(name = "fibers")
@NamedQueries({
    @NamedQuery(name = "Fibers.findAll", query = "SELECT f FROM Fibers f"),
    @NamedQuery(name = "Fibers.findById", query = "SELECT f FROM Fibers f WHERE f.id = :id"),
    @NamedQuery(name = "Fibers.findByName", query = "SELECT f FROM Fibers f WHERE f.name = :name"),
    @NamedQuery(name = "Fibers.findByPrice", query = "SELECT f FROM Fibers f WHERE f.price = :price"),
    @NamedQuery(name = "Fibers.findByClassic", query = "SELECT f FROM Fibers f WHERE f.classic = :classic"),
    @NamedQuery(name = "Fibers.findBySuper1", query = "SELECT f FROM Fibers f WHERE f.super1 = :super1"),
    @NamedQuery(name = "Fibers.findByGelfeather", query = "SELECT f FROM Fibers f WHERE f.gelfeather = :gelfeather"),
    @NamedQuery(name = "Fibers.findByKapokorganic", query = "SELECT f FROM Fibers f WHERE f.kapokorganic = :kapokorganic")})
public class Fibers implements Serializable {
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
    @Column(name = "classic")
    private boolean classic;
    @Basic(optional = false)
    @Column(name = "super")
    private boolean super1;
    @Basic(optional = false)
    @Column(name = "gelfeather")
    private boolean gelfeather;
    @Basic(optional = false)
    @Column(name = "kapokorganic")
    private boolean kapokorganic;

    public Fibers() {
    }

    public Fibers(Integer id) {
        this.id = id;
    }

    public Fibers(Integer id, String name, double price, boolean classic, boolean super1, boolean gelfeather, boolean kapokorganic) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.classic = classic;
        this.super1 = super1;
        this.gelfeather = gelfeather;
        this.kapokorganic = kapokorganic;
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

    public boolean getClassic() {
        return classic;
    }

    public void setClassic(boolean classic) {
        boolean oldClassic = this.classic;
        this.classic = classic;
        changeSupport.firePropertyChange("classic", oldClassic, classic);
    }

    public boolean getSuper1() {
        return super1;
    }

    public void setSuper1(boolean super1) {
        boolean oldSuper1 = this.super1;
        this.super1 = super1;
        changeSupport.firePropertyChange("super1", oldSuper1, super1);
    }

    public boolean getGelfeather() {
        return gelfeather;
    }

    public void setGelfeather(boolean gelfeather) {
        boolean oldGelfeather = this.gelfeather;
        this.gelfeather = gelfeather;
        changeSupport.firePropertyChange("gelfeather", oldGelfeather, gelfeather);
    }

    public boolean getKapokorganic() {
        return kapokorganic;
    }

    public void setKapokorganic(boolean kapokorganic) {
        boolean oldKapokorganic = this.kapokorganic;
        this.kapokorganic = kapokorganic;
        changeSupport.firePropertyChange("kapokorganic", oldKapokorganic, kapokorganic);
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
        if (!(object instanceof Fibers)) {
            return false;
        }
        Fibers other = (Fibers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fibers[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
