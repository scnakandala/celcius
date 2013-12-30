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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author naka
 */
@Entity
@Table(name = "pillowprotector_accessories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PillowprotectorAccessories.findAll", query = "SELECT p FROM PillowprotectorAccessories p"),
    @NamedQuery(name = "PillowprotectorAccessories.findById", query = "SELECT p FROM PillowprotectorAccessories p WHERE p.id = :id"),
    @NamedQuery(name = "PillowprotectorAccessories.findByName", query = "SELECT p FROM PillowprotectorAccessories p WHERE p.name = :name"),
    @NamedQuery(name = "PillowprotectorAccessories.findByDescription", query = "SELECT p FROM PillowprotectorAccessories p WHERE p.description = :description"),
    @NamedQuery(name = "PillowprotectorAccessories.findByPrice", query = "SELECT p FROM PillowprotectorAccessories p WHERE p.price = :price")})
public class PillowprotectorAccessories implements Serializable {
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
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;

    public PillowprotectorAccessories() {
    }

    public PillowprotectorAccessories(Integer id) {
        this.id = id;
    }

    public PillowprotectorAccessories(Integer id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
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
        if (!(object instanceof PillowprotectorAccessories)) {
            return false;
        }
        PillowprotectorAccessories other = (PillowprotectorAccessories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PillowprotectorAccessories[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
