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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "tcr_payment_period")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentPeriod.findAll", query = "SELECT p FROM PaymentPeriod p")})
public class PaymentPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDPAYMENT_PERIOD")
    private Integer cdpaymentPeriod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DSPERIOD")
    private String dsperiod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NMDAYS")
    private int nmdays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACREATE")
    @Temporal(TemporalType.DATE)
    private Date dacreate;
    @Column(name = "DAUPDATE")
    @Temporal(TemporalType.DATE)
    private Date daupdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdpaymentPeriod")
    private List<Customer> customerList;
    @JoinColumn(name = "CDOWNER", referencedColumnName = "CDOWNER")
    @ManyToOne(optional = false)
    private Owner cdowner;
    @JoinColumn(name = "CDUSER_CREATE", referencedColumnName = "CDUSER")
    @ManyToOne(optional = false)
    private User cduserCreate;
    @JoinColumn(name = "CDUSER_UPDATE", referencedColumnName = "CDUSER")
    @ManyToOne
    private User cduserUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdpaymentPeriod")
    private List<Credit> creditList;

    public PaymentPeriod() {
    }

    public PaymentPeriod(Integer cdpaymentPeriod) {
        this.cdpaymentPeriod = cdpaymentPeriod;
    }

    public PaymentPeriod(Integer cdpaymentPeriod, String dsperiod, int nmdays, Date dacreate) {
        this.cdpaymentPeriod = cdpaymentPeriod;
        this.dsperiod = dsperiod;
        this.nmdays = nmdays;
        this.dacreate = dacreate;
    }

    public Integer getCdpaymentPeriod() {
        return cdpaymentPeriod;
    }

    public void setCdpaymentPeriod(Integer cdpaymentPeriod) {
        this.cdpaymentPeriod = cdpaymentPeriod;
    }

    public String getDsperiod() {
        return dsperiod;
    }

    public void setDsperiod(String dsperiod) {
        this.dsperiod = dsperiod;
    }

    public int getNmdays() {
        return nmdays;
    }

    public void setNmdays(int nmdays) {
        this.nmdays = nmdays;
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
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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
        hash += (cdpaymentPeriod != null ? cdpaymentPeriod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentPeriod)) {
            return false;
        }
        PaymentPeriod other = (PaymentPeriod) object;
        if ((this.cdpaymentPeriod == null && other.cdpaymentPeriod != null) || (this.cdpaymentPeriod != null && !this.cdpaymentPeriod.equals(other.cdpaymentPeriod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.PaymentPeriod[ cdpaymentPeriod=" + cdpaymentPeriod + " ]";
    }
    
}
