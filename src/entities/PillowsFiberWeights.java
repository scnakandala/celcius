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
@Table(name = "pillows_fiber_weights")
@NamedQueries({
    @NamedQuery(name = "PillowsFiberWeights.findAll", query = "SELECT p FROM PillowsFiberWeights p"),
    @NamedQuery(name = "PillowsFiberWeights.findById", query = "SELECT p FROM PillowsFiberWeights p WHERE p.id = :id"),
    @NamedQuery(name = "PillowsFiberWeights.findByName", query = "SELECT p FROM PillowsFiberWeights p WHERE p.name = :name"),
    @NamedQuery(name = "PillowsFiberWeights.findByA", query = "SELECT p FROM PillowsFiberWeights p WHERE p.a = :a"),
    @NamedQuery(name = "PillowsFiberWeights.findByA1", query = "SELECT p FROM PillowsFiberWeights p WHERE p.a1 = :a1"),
    @NamedQuery(name = "PillowsFiberWeights.findByA2", query = "SELECT p FROM PillowsFiberWeights p WHERE p.a2 = :a2"),
    @NamedQuery(name = "PillowsFiberWeights.findByA3", query = "SELECT p FROM PillowsFiberWeights p WHERE p.a3 = :a3"),
    @NamedQuery(name = "PillowsFiberWeights.findByA4", query = "SELECT p FROM PillowsFiberWeights p WHERE p.a4 = :a4"),
    @NamedQuery(name = "PillowsFiberWeights.findByA5", query = "SELECT p FROM PillowsFiberWeights p WHERE p.a5 = :a5"),
    @NamedQuery(name = "PillowsFiberWeights.findByA6", query = "SELECT p FROM PillowsFiberWeights p WHERE p.a6 = :a6"),
    @NamedQuery(name = "PillowsFiberWeights.findByA7", query = "SELECT p FROM PillowsFiberWeights p WHERE p.a7 = :a7")})
public class PillowsFiberWeights implements Serializable {
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
    @Column(name = "8_12")
    private double a;
    @Basic(optional = false)
    @Column(name = "10_14")
    private double a1;
    @Basic(optional = false)
    @Column(name = "11_15")
    private double a2;
    @Basic(optional = false)
    @Column(name = "12_18")
    private double a3;
    @Basic(optional = false)
    @Column(name = "16_24")
    private double a4;
    @Basic(optional = false)
    @Column(name = "18_27")
    private double a5;
    @Basic(optional = false)
    @Column(name = "20_30")
    private double a6;
    @Basic(optional = false)
    @Column(name = "20_40")
    private double a7;

    public PillowsFiberWeights() {
    }

    public PillowsFiberWeights(Integer id) {
        this.id = id;
    }

    public PillowsFiberWeights(Integer id, String name, double a, double a1, double a2, double a3, double a4, double a5, double a6, double a7) {
        this.id = id;
        this.name = name;
        this.a = a;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.a7 = a7;
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

    public double getA6() {
        return a6;
    }

    public void setA6(double a6) {
        double oldA6 = this.a6;
        this.a6 = a6;
        changeSupport.firePropertyChange("A6", oldA6, a6);
    }

    public double getA7() {
        return a7;
    }

    public void setA7(double a7) {
        double oldA7 = this.a7;
        this.a7 = a7;
        changeSupport.firePropertyChange("A7", oldA7, a7);
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
        if (!(object instanceof PillowsFiberWeights)) {
            return false;
        }
        PillowsFiberWeights other = (PillowsFiberWeights) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PillowsFiberWeights[id=" + id + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
