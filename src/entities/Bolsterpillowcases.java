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
@Table(name = "bolsterpillowcases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bolsterpillowcases.findAll", query = "SELECT b FROM Bolsterpillowcases b"),
    @NamedQuery(name = "Bolsterpillowcases.findById", query = "SELECT b FROM Bolsterpillowcases b WHERE b.id = :id"),
    @NamedQuery(name = "Bolsterpillowcases.findBySize", query = "SELECT b FROM Bolsterpillowcases b WHERE b.size = :size"),
    @NamedQuery(name = "Bolsterpillowcases.findBySmv", query = "SELECT b FROM Bolsterpillowcases b WHERE b.smv = :smv")})
public class Bolsterpillowcases implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "smv")
    private double smv;

    public Bolsterpillowcases() {
    }

    public Bolsterpillowcases(Integer id) {
        this.id = id;
    }

    public Bolsterpillowcases(Integer id, String size, double smv) {
        this.id = id;
        this.size = size;
        this.smv = smv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        String oldSize = this.size;
        this.size = size;
        changeSupport.firePropertyChange("size", oldSize, size);
    }

    public double getSmv() {
        return smv;
    }

    public void setSmv(double smv) {
        double oldSmv = this.smv;
        this.smv = smv;
        changeSupport.firePropertyChange("smv", oldSmv, smv);
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
        if (!(object instanceof Bolsterpillowcases)) {
            return false;
        }
        Bolsterpillowcases other = (Bolsterpillowcases) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bolsterpillowcases[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
