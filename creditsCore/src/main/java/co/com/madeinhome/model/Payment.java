/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.madeinhome.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "tcr_payments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDPAYMENT")
    private Integer cdpayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VRAMOUNT")
    private long vramount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAPAYMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dapayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACREATE")
    @Temporal(TemporalType.DATE)
    private Date dacreate;
    @Column(name = "DAUPDATE")
    @Temporal(TemporalType.DATE)
    private Date daupdate;
    @JoinColumn(name = "CDOWNER", referencedColumnName = "CDOWNER")
    @ManyToOne(optional = false)
    private Owner cdowner;
    @JoinColumn(name = "CDUSER_CREATE", referencedColumnName = "CDUSER")
    @ManyToOne(optional = false)
    private User cduserCreate;
    @JoinColumn(name = "CDUSER_UPDATE", referencedColumnName = "CDUSER")
    @ManyToOne
    private User cduserUpdate;
    @JoinColumn(name = "CDCUSTOMER", referencedColumnName = "CDCUSTOMER")
    @ManyToOne(optional = false)
    private Customer cdcustomer;

    public Payment() {
    }

    public Payment(Integer cdpayment) {
        this.cdpayment = cdpayment;
    }

    public Payment(Integer cdpayment, long vramount, Date dapayment, Date dacreate) {
        this.cdpayment = cdpayment;
        this.vramount = vramount;
        this.dapayment = dapayment;
        this.dacreate = dacreate;
    }

    public Integer getCdpayment() {
        return cdpayment;
    }

    public void setCdpayment(Integer cdpayment) {
        this.cdpayment = cdpayment;
    }

    public long getVramount() {
        return vramount;
    }

    public void setVramount(long vramount) {
        this.vramount = vramount;
    }

    public Date getDapayment() {
        return dapayment;
    }

    public void setDapayment(Date dapayment) {
        this.dapayment = dapayment;
    }

    public Date getDacreate() {
        return dacreate;
    }

    public void setDacreate(Date dacreate) {
        this.dacreate = dacreate;
    }

    public Date getDaupdate() {
        return daupdate;
    }

    public void setDaupdate(Date daupdate) {
        this.daupdate = daupdate;
    }

    public Owner getCdowner() {
        return cdowner;
    }

    public void setCdowner(Owner cdowner) {
        this.cdowner = cdowner;
    }

    public User getCduserCreate() {
        return cduserCreate;
    }

    public void setCduserCreate(User cduserCreate) {
        this.cduserCreate = cduserCreate;
    }

    public User getCduserUpdate() {
        return cduserUpdate;
    }

    public void setCduserUpdate(User cduserUpdate) {
        this.cduserUpdate = cduserUpdate;
    }

    public Customer getCdcustomer() {
        return cdcustomer;
    }

    public void setCdcustomer(Customer cdcustomer) {
        this.cdcustomer = cdcustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdpayment != null ? cdpayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.cdpayment == null && other.cdpayment != null) || (this.cdpayment != null && !this.cdpayment.equals(other.cdpayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.Payment[ cdpayment=" + cdpayment + " ]";
    }
    
}
