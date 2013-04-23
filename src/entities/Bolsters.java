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
@Table(name = "bolsters")
@NamedQueries({
    @NamedQuery(name = "Bolsters.findAll", query = "SELECT b FROM Bolsters b"),
    @NamedQuery(name = "Bolsters.findById", query = "SELECT b FROM Bolsters b WHERE b.id = :id"),
    @NamedQuery(name = "Bolsters.findByRange", query = "SELECT b FROM Bolsters b WHERE b.range = :range"),
    @NamedQuery(name = "Bolsters.findBySize", query = "SELECT b FROM Bolsters b WHERE b.size = :size"),
    @NamedQuery(name = "Bolsters.findBySmv", query = "SELECT b FROM Bolsters b WHERE b.smv = :smv")})
public class Bolsters implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "`range`")
    private String range;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "smv")
    private double smv;

    public Bolsters() {
    }

    public Bolsters(Integer id) {
        this.id = id;
    }

    public Bolsters(Integer id, String range, String size, double smv) {
        this.id = id;
        this.range = range;
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

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        String oldRange = this.range;
        this.range = range;
        changeSupport.firePropertyChange("range", oldRange, range);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
         String[] arr = size.split("X");
        if (arr.length == 2) {
            Integer.parseInt(arr[0]);
            Integer.parseInt(arr[1]);
            String oldSize = this.size;
            this.size = size;
            changeSupport.firePropertyChange("size", oldSize, size);
        }
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
        if (!(object instanceof Bolsters)) {
            return false;
        }
        Bolsters other = (Bolsters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bolsters[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
