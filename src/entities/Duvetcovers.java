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
@Table(name = "duvetcovers")
@NamedQueries({
    @NamedQuery(name = "Duvetcovers.findAll", query = "SELECT d FROM Duvetcovers d"),
    @NamedQuery(name = "Duvetcovers.findById", query = "SELECT d FROM Duvetcovers d WHERE d.id = :id"),
    @NamedQuery(name = "Duvetcovers.findBySize", query = "SELECT d FROM Duvetcovers d WHERE d.size = :size"),
    @NamedQuery(name = "Duvetcovers.findByType", query = "SELECT d FROM Duvetcovers d WHERE d.type = :type"),
    @NamedQuery(name = "Duvetcovers.findBySmv", query = "SELECT d FROM Duvetcovers d WHERE d.smv = :smv")})
public class Duvetcovers implements Serializable {
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
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "smv")
    private double smv;

    public Duvetcovers() {
    }

    public Duvetcovers(Integer id) {
        this.id = id;
    }

    public Duvetcovers(Integer id, String size, String type, double smv) {
        this.id = id;
        this.size = size;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
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
        if (!(object instanceof Duvetcovers)) {
            return false;
        }
        Duvetcovers other = (Duvetcovers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celciusadmin.Duvetcovers[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
