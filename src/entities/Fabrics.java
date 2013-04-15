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
@Table(name = "fabrics")
@NamedQueries({
    @NamedQuery(name = "Fabrics.findAll", query = "SELECT f FROM Fabrics f"),
    @NamedQuery(name = "Fabrics.findById", query = "SELECT f FROM Fabrics f WHERE f.id = :id"),
    @NamedQuery(name = "Fabrics.findByName", query = "SELECT f FROM Fabrics f WHERE f.name = :name"),
    @NamedQuery(name = "Fabrics.findByPrice", query = "SELECT f FROM Fabrics f WHERE f.price = :price"),
    @NamedQuery(name = "Fabrics.findByWidth", query = "SELECT f FROM Fabrics f WHERE f.width = :width"),
    @NamedQuery(name = "Fabrics.findByWidthShrinkage", query = "SELECT f FROM Fabrics f WHERE f.widthShrinkage = :widthShrinkage"),
    @NamedQuery(name = "Fabrics.findByHeightShrinkage", query = "SELECT f FROM Fabrics f WHERE f.heightShrinkage = :heightShrinkage"),
    @NamedQuery(name = "Fabrics.findByClassic", query = "SELECT f FROM Fabrics f WHERE f.classic = :classic"),
    @NamedQuery(name = "Fabrics.findBySuper1", query = "SELECT f FROM Fabrics f WHERE f.super1 = :super1"),
    @NamedQuery(name = "Fabrics.findByPremium", query = "SELECT f FROM Fabrics f WHERE f.premium = :premium"),
    @NamedQuery(name = "Fabrics.findByOther", query = "SELECT f FROM Fabrics f WHERE f.other = :other")})
public class Fabrics implements Serializable {
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
    private int width;
    @Basic(optional = false)
    @Column(name = "width_shrinkage")
    private int widthShrinkage;
    @Basic(optional = false)
    @Column(name = "height_shrinkage")
    private int heightShrinkage;
    @Basic(optional = false)
    @Column(name = "Classic")
    private boolean classic;
    @Basic(optional = false)
    @Column(name = "Super")
    private boolean super1;
    @Basic(optional = false)
    @Column(name = "Premium")
    private boolean premium;
    @Basic(optional = false)
    @Column(name = "Other")
    private boolean other;

    public Fabrics() {
    }

    public Fabrics(Integer id) {
        this.id = id;
    }

    public Fabrics(Integer id, String name, double price, int width, int widthShrinkage, int heightShrinkage, boolean classic, boolean super1, boolean premium, boolean other) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.width = width;
        this.widthShrinkage = widthShrinkage;
        this.heightShrinkage = heightShrinkage;
        this.classic = classic;
        this.super1 = super1;
        this.premium = premium;
        this.other = other;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        int oldWidth = this.width;
        this.width = width;
        changeSupport.firePropertyChange("width", oldWidth, width);
    }

    public int getWidthShrinkage() {
        return widthShrinkage;
    }

    public void setWidthShrinkage(int widthShrinkage) {
        int oldWidthShrinkage = this.widthShrinkage;
        this.widthShrinkage = widthShrinkage;
        changeSupport.firePropertyChange("widthShrinkage", oldWidthShrinkage, widthShrinkage);
    }

    public int getHeightShrinkage() {
        return heightShrinkage;
    }

    public void setHeightShrinkage(int heightShrinkage) {
        int oldHeightShrinkage = this.heightShrinkage;
        this.heightShrinkage = heightShrinkage;
        changeSupport.firePropertyChange("heightShrinkage", oldHeightShrinkage, heightShrinkage);
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

    public boolean getPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        boolean oldPremium = this.premium;
        this.premium = premium;
        changeSupport.firePropertyChange("premium", oldPremium, premium);
    }

    public boolean getOther() {
        return other;
    }

    public void setOther(boolean other) {
        boolean oldOther = this.other;
        this.other = other;
        changeSupport.firePropertyChange("other", oldOther, other);
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
        if (!(object instanceof Fabrics)) {
            return false;
        }
        Fabrics other = (Fabrics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celciusadmin.Fabrics[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
