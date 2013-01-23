/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.georgeconsulting.expensereport;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "ChargeTo.findByContract", query = "SELECT c FROM ChargeTo c WHERE c.contract = :contract")})
public class ChargeTo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "contractID")
    private Integer contractID;
    @Column(name = "contract")
    private String contract;

    public ChargeTo() {
    }

    public ChargeTo(Integer contractID) {
        this.contractID = contractID;
    }

    public Integer getContractID() {
        return contractID;
    }

    public void setContractID(Integer contractID) {
        Integer oldContractID = this.contractID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractID != null ? contractID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChargeTo)) {
            return false;
        }
        ChargeTo other = (ChargeTo) object;
        if ((this.contractID == null && other.contractID != null) || (this.contractID != null && !this.contractID.equals(other.contractID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return contract;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
