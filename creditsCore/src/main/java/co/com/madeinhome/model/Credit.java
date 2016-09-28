/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.madeinhome.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "tcr_credits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credit.findAll", query = "SELECT c FROM Credit c")})
public class Credit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDCREDIT")
    private Integer cdcredit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACREDIT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dacredit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NMQUOTES")
    private int nmquotes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NMTERM")
    private int nmterm;
    @Column(name = "DAFIRST_PAYMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dafirstPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VRQUOTE")
    private long vrquote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACREATE")
    @Temporal(TemporalType.DATE)
    private Date dacreate;
    @Column(name = "DAUPDATE")
    @Temporal(TemporalType.DATE)
    private Date daupdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdcredit")
    private List<CreditDetail> creditDetailList;
    @JoinColumn(name = "CDCUSTOMER", referencedColumnName = "CDCUSTOMER")
    @ManyToOne(optional = false)
    private Customer cdcustomer;
    @JoinColumn(name = "CDOWNER", referencedColumnName = "CDOWNER")
    @ManyToOne(optional = false)
    private Owner cdowner;
    @JoinColumn(name = "CDPAYMENT_PERIOD", referencedColumnName = "CDPAYMENT_PERIOD")
    @ManyToOne(optional = false)
    private PaymentPeriod cdpaymentPeriod;
    @JoinColumn(name = "CDUSER_CREATE", referencedColumnName = "CDUSER")
    @ManyToOne(optional = false)
    private User cduserCreate;
    @JoinColumn(name = "CDUSER_UPDATE", referencedColumnName = "CDUSER")
    @ManyToOne
    private User cduserUpdate;

    public Credit() {
    }

    public Credit(Integer cdcredit) {
        this.cdcredit = cdcredit;
    }

    public Credit(Integer cdcredit, Date dacredit, int nmquotes, int nmterm, long vrquote, Date dacreate) {
        this.cdcredit = cdcredit;
        this.dacredit = dacredit;
        this.nmquotes = nmquotes;
        this.nmterm = nmterm;
        this.vrquote = vrquote;
        this.dacreate = dacreate;
    }

    public Integer getCdcredit() {
        return cdcredit;
    }

    public void setCdcredit(Integer cdcredit) {
        this.cdcredit = cdcredit;
    }

    public Date getDacredit() {
        return dacredit;
    }

    public void setDacredit(Date dacredit) {
        this.dacredit = dacredit;
    }

    public int getNmquotes() {
        return nmquotes;
    }

    public void setNmquotes(int nmquotes) {
        this.nmquotes = nmquotes;
    }

    public int getNmterm() {
        return nmterm;
    }

    public void setNmterm(int nmterm) {
        this.nmterm = nmterm;
    }

    public Date getDafirstPayment() {
        return dafirstPayment;
    }

    public void setDafirstPayment(Date dafirstPayment) {
        this.dafirstPayment = dafirstPayment;
    }

    public long getVrquote() {
        return vrquote;
    }

    public void setVrquote(long vrquote) {
        this.vrquote = vrquote;
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

    @XmlTransient
    public List<CreditDetail> getCreditDetailList() {
        return creditDetailList;
    }

    public void setCreditDetailList(List<CreditDetail> creditDetailList) {
        this.creditDetailList = creditDetailList;
    }

    public Customer getCdcustomer() {
        return cdcustomer;
    }

    public void setCdcustomer(Customer cdcustomer) {
        this.cdcustomer = cdcustomer;
    }

    public Owner getCdowner() {
        return cdowner;
    }

    public void setCdowner(Owner cdowner) {
        this.cdowner = cdowner;
    }

    public PaymentPeriod getCdpaymentPeriod() {
        return cdpaymentPeriod;
    }

    public void setCdpaymentPeriod(PaymentPeriod cdpaymentPeriod) {
        this.cdpaymentPeriod = cdpaymentPeriod;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdcredit != null ? cdcredit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credit)) {
            return false;
        }
        Credit other = (Credit) object;
        if ((this.cdcredit == null && other.cdcredit != null) || (this.cdcredit != null && !this.cdcredit.equals(other.cdcredit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.Credit[ cdcredit=" + cdcredit + " ]";
    }
    
}
