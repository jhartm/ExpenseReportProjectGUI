/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.georgeconsulting.expenseReport;

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
 * @author johnhartmann
 */
@Entity
@Table(name = "ChargeTo", catalog = "expenseReport", schema = "")
@NamedQueries({
    @NamedQuery(name = "ChargeTo.findAll", query = "SELECT c FROM ChargeTo c"),
    @NamedQuery(name = "ChargeTo.findByContractID", query = "SELECT c FROM ChargeTo c WHERE c.contractID = :contractID"),
    @NamedQuery(name = "ChargeTo.findByContract", query = "SELECT c FROM ChargeTo c WHERE c.contract = :contract"),
    @NamedQuery(name = "ChargeTo.findById", query = "SELECT c FROM ChargeTo c WHERE c.id = :id")})
public class ChargeTo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "contractID")
    private String contractID;
    @Column(name = "contract")
    private String contract;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public ChargeTo() {
    }

    public ChargeTo(Integer id) {
        this.id = id;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        String oldContractID = this.contractID;
        this.contractID = contractID;
        changeSupport.firePropertyChange("contractID", oldContractID, contractID);
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        String oldContract = this.contract;
        this.contract = contract;
        changeSupport.firePropertyChange("contract", oldContract, contract);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
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
        if (!(object instanceof ChargeTo)) {
            return false;
        }
        ChargeTo other = (ChargeTo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return contractID + " | " + contract;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
