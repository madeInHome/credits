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
@Table(name = "tcr_customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDCUSTOMER")
    private Integer cdcustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDSTATE")
    private int cdstate;
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
    @JoinColumn(name = "CDPAYMENT_PERIOD", referencedColumnName = "CDPAYMENT_PERIOD")
    @ManyToOne(optional = false)
    private PaymentPeriod cdpaymentPeriod;
    @JoinColumn(name = "CDPERSON", referencedColumnName = "CDPERSON")
    @ManyToOne(optional = false)
    private Person cdperson;
    @JoinColumn(name = "CDUSER_CREATE", referencedColumnName = "CDUSER")
    @ManyToOne(optional = false)
    private User cduserCreate;
    @JoinColumn(name = "CDUSER_UPDATE", referencedColumnName = "CDUSER")
    @ManyToOne
    private User cduserUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdcustomer")
    private List<Payment> paymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdcustomer")
    private List<Credit> creditList;

    public Customer() {
    }

    public Customer(Integer cdcustomer) {
        this.cdcustomer = cdcustomer;
    }

    public Customer(Integer cdcustomer, int cdstate, Date dacreate) {
        this.cdcustomer = cdcustomer;
        this.cdstate = cdstate;
        this.dacreate = dacreate;
    }

    public Integer getCdcustomer() {
        return cdcustomer;
    }

    public void setCdcustomer(Integer cdcustomer) {
        this.cdcustomer = cdcustomer;
    }

    public int getCdstate() {
        return cdstate;
    }

    public void setCdstate(int cdstate) {
        this.cdstate = cdstate;
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

    public PaymentPeriod getCdpaymentPeriod() {
        return cdpaymentPeriod;
    }

    public void setCdpaymentPeriod(PaymentPeriod cdpaymentPeriod) {
        this.cdpaymentPeriod = cdpaymentPeriod;
    }

    public Person getCdperson() {
        return cdperson;
    }

    public void setCdperson(Person cdperson) {
        this.cdperson = cdperson;
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

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @XmlTransient
    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdcustomer != null ? cdcustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cdcustomer == null && other.cdcustomer != null) || (this.cdcustomer != null && !this.cdcustomer.equals(other.cdcustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.Customer[ cdcustomer=" + cdcustomer + " ]";
    }
    
}
