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
@Table(name = "cushion_fiber_weights")
@NamedQueries({
    @NamedQuery(name = "CushionFiberWeights.findAll", query = "SELECT c FROM CushionFiberWeights c"),
    @NamedQuery(name = "CushionFiberWeights.findById", query = "SELECT c FROM CushionFiberWeights c WHERE c.id = :id"),
    @NamedQuery(name = "CushionFiberWeights.findByName", query = "SELECT c FROM CushionFiberWeights c WHERE c.name = :name"),
    @NamedQuery(name = "CushionFiberWeights.findByA", query = "SELECT c FROM CushionFiberWeights c WHERE c.a = :a"),
    @NamedQuery(name = "CushionFiberWeights.findByA1", query = "SELECT c FROM CushionFiberWeights c WHERE c.a1 = :a1"),
    @NamedQuery(name = "CushionFiberWeights.findByA2", query = "SELECT c FROM CushionFiberWeights c WHERE c.a2 = :a2"),
    @NamedQuery(name = "CushionFiberWeights.findByA3", query = "SELECT c FROM CushionFiberWeights c WHERE c.a3 = :a3"),
    @NamedQuery(name = "CushionFiberWeights.findByA4", query = "SELECT c FROM CushionFiberWeights c WHERE c.a4 = :a4"),
    @NamedQuery(name = "CushionFiberWeights.findByA5", query = "SELECT c FROM CushionFiberWeights c WHERE c.a5 = :a5")})
public class CushionFiberWeights implements Serializable {
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
    @Column(name = "16_16")
    private double a;
    @Basic(optional = false)
    @Column(name = "17_17")
    private double a1;
    @Basic(optional = false)
    @Column(name = "18_18")
    private double a2;
    @Basic(optional = false)
    @Column(name = "20_20")
    private double a3;
    @Basic(optional = false)
    @Column(name = "24_24")
    private double a4;
    @Basic(optional = false)
    @Column(name = "30_30")
    private double a5;

    public CushionFiberWeights() {
    }

    public CushionFiberWeights(Integer id) {
        this.id = id;
    }

    public CushionFiberWeights(Integer id, String name, double a, double a1, double a2, double a3, double a4, double a5) {
        this.id = id;
        this.name = name;
        this.a = a;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
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

    public double getA() {
        return a;
    }

    public void setA(double a) {
        double oldA = this.a;
        this.a = a;
        changeSupport.firePropertyChange("a", oldA, a);
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        double oldA1 = this.a1;
        this.a1 = a1;
        changeSupport.firePropertyChange("A1", oldA1, a1);
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        double oldA2 = this.a2;
        this.a2 = a2;
        changeSupport.firePropertyChange("A2", oldA2, a2);
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        double oldA3 = this.a3;
        this.a3 = a3;
        changeSupport.firePropertyChange("A3", oldA3, a3);
    }

    public double getA4() {
        return a4;
    }

    public void setA4(double a4) {
        double oldA4 = this.a4;
        this.a4 = a4;
        changeSupport.firePropertyChange("A4", oldA4, a4);
    }

    public double getA5() {
        return a5;
    }

    public void setA5(double a5) {
        double oldA5 = this.a5;
        this.a5 = a5;
        changeSupport.firePropertyChange("A5", oldA5, a5);
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
        if (!(object instanceof CushionFiberWeights)) {
            return false;
        }
        CushionFiberWeights other = (CushionFiberWeights) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CushionFiberWeights[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
