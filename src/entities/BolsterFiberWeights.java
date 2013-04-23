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
@Table(name = "bolster_fiber_weights")
@NamedQueries({
    @NamedQuery(name = "BolsterFiberWeights.findAll", query = "SELECT b FROM BolsterFiberWeights b"),
    @NamedQuery(name = "BolsterFiberWeights.findById", query = "SELECT b FROM BolsterFiberWeights b WHERE b.id = :id"),
    @NamedQuery(name = "BolsterFiberWeights.findByName", query = "SELECT b FROM BolsterFiberWeights b WHERE b.name = :name"),
    @NamedQuery(name = "BolsterFiberWeights.findByP516", query = "SELECT b FROM BolsterFiberWeights b WHERE b.p516 = :p516"),
    @NamedQuery(name = "BolsterFiberWeights.findByA", query = "SELECT b FROM BolsterFiberWeights b WHERE b.a = :a"),
    @NamedQuery(name = "BolsterFiberWeights.findByA1", query = "SELECT b FROM BolsterFiberWeights b WHERE b.a1 = :a1"),
    @NamedQuery(name = "BolsterFiberWeights.findByA2", query = "SELECT b FROM BolsterFiberWeights b WHERE b.a2 = :a2"),
    @NamedQuery(name = "BolsterFiberWeights.findByA3", query = "SELECT b FROM BolsterFiberWeights b WHERE b.a3 = :a3"),
    @NamedQuery(name = "BolsterFiberWeights.findByA4", query = "SELECT b FROM BolsterFiberWeights b WHERE b.a4 = :a4")})
public class BolsterFiberWeights implements Serializable {
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
    @Column(name = "3p5_16")
    private double p516;
    @Basic(optional = false)
    @Column(name = "4_18")
    private double a;
    @Basic(optional = false)
    @Column(name = "8_18")
    private double a1;
    @Basic(optional = false)
    @Column(name = "8_24")
    private double a2;
    @Basic(optional = false)
    @Column(name = "8_40")
    private double a3;
    @Basic(optional = false)
    @Column(name = "10_30")
    private double a4;

    public BolsterFiberWeights() {
    }

    public BolsterFiberWeights(Integer id) {
        this.id = id;
    }

    public BolsterFiberWeights(Integer id, String name, double p516, double a, double a1, double a2, double a3, double a4) {
        this.id = id;
        this.name = name;
        this.p516 = p516;
        this.a = a;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
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

    public double getP516() {
        return p516;
    }

    public void setP516(double p516) {
        double oldP516 = this.p516;
        this.p516 = p516;
        changeSupport.firePropertyChange("P516", oldP516, p516);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BolsterFiberWeights)) {
            return false;
        }
        BolsterFiberWeights other = (BolsterFiberWeights) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BolsterFiberWeights[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
