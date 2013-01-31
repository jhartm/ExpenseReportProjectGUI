/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.georgeconsulting.expenseReport;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author johnhartmann
 */
@Entity
@Table(name = "TravelExpenseReport", catalog = "expenseReport", schema = "")
@NamedQueries({
    @NamedQuery(name = "TravelExpenseReport.findAll", query = "SELECT t FROM TravelExpenseReport t"),
    @NamedQuery(name = "TravelExpenseReport.findByReportID", query = "SELECT t FROM TravelExpenseReport t WHERE t.reportID = :reportID"),
    @NamedQuery(name = "TravelExpenseReport.findByEmpID", query = "SELECT t FROM TravelExpenseReport t WHERE t.empID = :empID"),
    @NamedQuery(name = "TravelExpenseReport.findByContractID", query = "SELECT t FROM TravelExpenseReport t WHERE t.contractID = :contractID"),
    @NamedQuery(name = "TravelExpenseReport.findByEstAir", query = "SELECT t FROM TravelExpenseReport t WHERE t.estAir = :estAir"),
    @NamedQuery(name = "TravelExpenseReport.findByEstGnd", query = "SELECT t FROM TravelExpenseReport t WHERE t.estGnd = :estGnd"),
    @NamedQuery(name = "TravelExpenseReport.findByEstLodge", query = "SELECT t FROM TravelExpenseReport t WHERE t.estLodge = :estLodge"),
    @NamedQuery(name = "TravelExpenseReport.findByEstPerdiem", query = "SELECT t FROM TravelExpenseReport t WHERE t.estPerdiem = :estPerdiem"),
    @NamedQuery(name = "TravelExpenseReport.findByEstOther", query = "SELECT t FROM TravelExpenseReport t WHERE t.estOther = :estOther"),
    @NamedQuery(name = "TravelExpenseReport.findByEstTotal", query = "SELECT t FROM TravelExpenseReport t WHERE t.estTotal = :estTotal"),
    @NamedQuery(name = "TravelExpenseReport.findByActAir", query = "SELECT t FROM TravelExpenseReport t WHERE t.actAir = :actAir"),
    @NamedQuery(name = "TravelExpenseReport.findByActGnd", query = "SELECT t FROM TravelExpenseReport t WHERE t.actGnd = :actGnd"),
    @NamedQuery(name = "TravelExpenseReport.findByActLodge", query = "SELECT t FROM TravelExpenseReport t WHERE t.actLodge = :actLodge"),
    @NamedQuery(name = "TravelExpenseReport.findByActPerdiem", query = "SELECT t FROM TravelExpenseReport t WHERE t.actPerdiem = :actPerdiem"),
    @NamedQuery(name = "TravelExpenseReport.findByActOther", query = "SELECT t FROM TravelExpenseReport t WHERE t.actOther = :actOther"),
    @NamedQuery(name = "TravelExpenseReport.findByActTotal", query = "SELECT t FROM TravelExpenseReport t WHERE t.actTotal = :actTotal"),
    @NamedQuery(name = "TravelExpenseReport.findByRequestDate", query = "SELECT t FROM TravelExpenseReport t WHERE t.requestDate = :requestDate"),
    @NamedQuery(name = "TravelExpenseReport.findByApprovalDate", query = "SELECT t FROM TravelExpenseReport t WHERE t.approvalDate = :approvalDate"),
    @NamedQuery(name = "TravelExpenseReport.findByCompletionDate", query = "SELECT t FROM TravelExpenseReport t WHERE t.completionDate = :completionDate"),
    @NamedQuery(name = "TravelExpenseReport.findByUploads", query = "SELECT t FROM TravelExpenseReport t WHERE t.uploads = :uploads"),
    @NamedQuery(name = "TravelExpenseReport.findByStatusRequest", query = "SELECT t FROM TravelExpenseReport t WHERE t.statusRequest = :statusRequest"),
    @NamedQuery(name = "TravelExpenseReport.findByStatusReport", query = "SELECT t FROM TravelExpenseReport t WHERE t.statusReport = :statusReport")})

public class TravelExpenseReport implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reportID")
    private Integer reportID;
    @Basic(optional = false)
    @Column(name = "empID")
    private int empID;
    @Column(name = "contractID")
    private String contractID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "estAir")
    private BigDecimal estAir;
    @Column(name = "estGnd")
    private BigDecimal estGnd;
    @Column(name = "estLodge")
    private BigDecimal estLodge;
    @Column(name = "estPerdiem")
    private BigDecimal estPerdiem;
    @Column(name = "estOther")
    private BigDecimal estOther;
    @Column(name = "estTotal")
    private BigDecimal estTotal;
    @Column(name = "actAir")
    private BigDecimal actAir;
    @Column(name = "actGnd")
    private BigDecimal actGnd;
    @Column(name = "actLodge")
    private BigDecimal actLodge;
    @Column(name = "actPerdiem")
    private BigDecimal actPerdiem;
    @Column(name = "actOther")
    private BigDecimal actOther;
    @Column(name = "actTotal")
    private BigDecimal actTotal;
    @Column(name = "requestDate")
    @Temporal(TemporalType.DATE)
    private Date requestDate;
    @Column(name = "approvalDate")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    @Column(name = "completionDate")
    @Temporal(TemporalType.DATE)
    private Date completionDate;
    @Column(name = "uploads")
    private String uploads;
    @Column(name = "statusRequest")
    private Integer statusRequest;
    @Column(name = "statusReport")
    private Integer statusReport;

    public TravelExpenseReport() {
    }

    public TravelExpenseReport(Integer reportID) {
        this.reportID = reportID;
    }

    public TravelExpenseReport(Integer reportID, int empID) {
        this.reportID = reportID;
        this.empID = empID;
    }

    public Integer getReportID() {
        return reportID;
    }

    public void setReportID(Integer reportID) {
        Integer oldReportID = this.reportID;
        this.reportID = reportID;
        changeSupport.firePropertyChange("reportID", oldReportID, reportID);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        int oldEmpID = this.empID;
        this.empID = empID;
        changeSupport.firePropertyChange("empID", oldEmpID, empID);
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        String oldContractID = this.contractID;
        this.contractID = contractID;
        changeSupport.firePropertyChange("contractID", oldContractID, contractID);
    }

    public BigDecimal getEstAir() {
        return estAir;
    }

    public void setEstAir(BigDecimal estAir) {
        BigDecimal oldEstAir = this.estAir;
        this.estAir = estAir;
        changeSupport.firePropertyChange("estAir", oldEstAir, estAir);
    }

    public BigDecimal getEstGnd() {
        return estGnd;
    }

    public void setEstGnd(BigDecimal estGnd) {
        BigDecimal oldEstGnd = this.estGnd;
        this.estGnd = estGnd;
        changeSupport.firePropertyChange("estGnd", oldEstGnd, estGnd);
    }

    public BigDecimal getEstLodge() {
        return estLodge;
    }

    public void setEstLodge(BigDecimal estLodge) {
        BigDecimal oldEstLodge = this.estLodge;
        this.estLodge = estLodge;
        changeSupport.firePropertyChange("estLodge", oldEstLodge, estLodge);
    }

    public BigDecimal getEstPerdiem() {
        return estPerdiem;
    }

    public void setEstPerdiem(BigDecimal estPerdiem) {
        BigDecimal oldEstPerdiem = this.estPerdiem;
        this.estPerdiem = estPerdiem;
        changeSupport.firePropertyChange("estPerdiem", oldEstPerdiem, estPerdiem);
    }

    public BigDecimal getEstOther() {
        return estOther;
    }

    public void setEstOther(BigDecimal estOther) {
        BigDecimal oldEstOther = this.estOther;
        this.estOther = estOther;
        changeSupport.firePropertyChange("estOther", oldEstOther, estOther);
    }

    public BigDecimal getEstTotal() {
        return estTotal;
    }

    public void setEstTotal(BigDecimal estTotal) {
        BigDecimal oldEstTotal = this.estTotal;
        this.estTotal = estTotal;
        changeSupport.firePropertyChange("estTotal", oldEstTotal, estTotal);
    }

    public BigDecimal getActAir() {
        return actAir;
    }

    public void setActAir(BigDecimal actAir) {
        BigDecimal oldActAir = this.actAir;
        this.actAir = actAir;
        changeSupport.firePropertyChange("actAir", oldActAir, actAir);
    }

    public BigDecimal getActGnd() {
        return actGnd;
    }

    public void setActGnd(BigDecimal actGnd) {
        BigDecimal oldActGnd = this.actGnd;
        this.actGnd = actGnd;
        changeSupport.firePropertyChange("actGnd", oldActGnd, actGnd);
    }

    public BigDecimal getActLodge() {
        return actLodge;
    }

    public void setActLodge(BigDecimal actLodge) {
        BigDecimal oldActLodge = this.actLodge;
        this.actLodge = actLodge;
        changeSupport.firePropertyChange("actLodge", oldActLodge, actLodge);
    }

    public BigDecimal getActPerdiem() {
        return actPerdiem;
    }

    public void setActPerdiem(BigDecimal actPerdiem) {
        BigDecimal oldActPerdiem = this.actPerdiem;
        this.actPerdiem = actPerdiem;
        changeSupport.firePropertyChange("actPerdiem", oldActPerdiem, actPerdiem);
    }

    public BigDecimal getActOther() {
        return actOther;
    }

    public void setActOther(BigDecimal actOther) {
        BigDecimal oldActOther = this.actOther;
        this.actOther = actOther;
        changeSupport.firePropertyChange("actOther", oldActOther, actOther);
    }

    public BigDecimal getActTotal() {
        return actTotal;
    }

    public void setActTotal(BigDecimal actTotal) {
        BigDecimal oldActTotal = this.actTotal;
        this.actTotal = actTotal;
        changeSupport.firePropertyChange("actTotal", oldActTotal, actTotal);
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        Date oldRequestDate = this.requestDate;
        this.requestDate = requestDate;
        changeSupport.firePropertyChange("requestDate", oldRequestDate, requestDate);
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        Date oldApprovalDate = this.approvalDate;
        this.approvalDate = approvalDate;
        changeSupport.firePropertyChange("approvalDate", oldApprovalDate, approvalDate);
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        Date oldCompletionDate = this.completionDate;
        this.completionDate = completionDate;
        changeSupport.firePropertyChange("completionDate", oldCompletionDate, completionDate);
    }

    public String getUploads() {
        return uploads;
    }

    public void setUploads(String uploads) {
        String oldUploads = this.uploads;
        this.uploads = uploads;
        changeSupport.firePropertyChange("uploads", oldUploads, uploads);
    }

    public Integer getStatusRequest() {
        return statusRequest;
    }

    public void setStatusRequest(Integer statusRequest) {
        Integer oldStatusRequest = this.statusRequest;
        this.statusRequest = statusRequest;
        changeSupport.firePropertyChange("statusRequest", oldStatusRequest, statusRequest);
    }

    public Integer getStatusReport() {
        return statusReport;
    }

    public void setStatusReport(Integer statusReport) {
        Integer oldStatusReport = this.statusReport;
        this.statusReport = statusReport;
        changeSupport.firePropertyChange("statusReport", oldStatusReport, statusReport);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportID != null ? reportID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TravelExpenseReport)) {
            return false;
        }
        TravelExpenseReport other = (TravelExpenseReport) object;
        if ((this.reportID == null && other.reportID != null) || (this.reportID != null && !this.reportID.equals(other.reportID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.georgeconsulting.expenseReport.TravelExpenseReport[ reportID=" + reportID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
