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
@Table(name = "pillows")
@NamedQueries({
    @NamedQuery(name = "Pillows.findAll", query = "SELECT p FROM Pillows p"),
    @NamedQuery(name = "Pillows.findById", query = "SELECT p FROM Pillows p WHERE p.id = :id"),
    @NamedQuery(name = "Pillows.findByRange", query = "SELECT p FROM Pillows p WHERE p.range = :range"),
    @NamedQuery(name = "Pillows.findByType", query = "SELECT p FROM Pillows p WHERE p.type = :type"),
    @NamedQuery(name = "Pillows.findBySize", query = "SELECT p FROM Pillows p WHERE p.size = :size"),
    @NamedQuery(name = "Pillows.findBySmv", query = "SELECT p FROM Pillows p WHERE p.smv = :smv")})
public class Pillows implements Serializable {
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
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "smv")
    private double smv;

    public Pillows() {
    }

    public Pillows(Integer id) {
        this.id = id;
    }

    public Pillows(Integer id, String range, String type, String size, double smv) {
        this.id = id;
        this.range = range;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
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
        if (!(object instanceof Pillows)) {
            return false;
        }
        Pillows other = (Pillows) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pillows[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
