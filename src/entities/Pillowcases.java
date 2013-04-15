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
@Table(name = "pillowcases")
@NamedQueries({
    @NamedQuery(name = "Pillowcases.findAll", query = "SELECT p FROM Pillowcases p"),
    @NamedQuery(name = "Pillowcases.findById", query = "SELECT p FROM Pillowcases p WHERE p.id = :id"),
    @NamedQuery(name = "Pillowcases.findByType", query = "SELECT p FROM Pillowcases p WHERE p.type = :type"),
    @NamedQuery(name = "Pillowcases.findBySize", query = "SELECT p FROM Pillowcases p WHERE p.size = :size"),
    @NamedQuery(name = "Pillowcases.findBySmv", query = "SELECT p FROM Pillowcases p WHERE p.smv = :smv")})
public class Pillowcases implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "smv")
    private int smv;

    public Pillowcases() {
    }

    public Pillowcases(Integer id) {
        this.id = id;
    }

    public Pillowcases(Integer id, String type, String size, int smv) {
        this.id = id;
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

    public int getSmv() {
        return smv;
    }

    public void setSmv(int smv) {
        int oldSmv = this.smv;
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
        if (!(object instanceof Pillowcases)) {
            return false;
        }
        Pillowcases other = (Pillowcases) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "celciusadmin.Pillowcases[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
