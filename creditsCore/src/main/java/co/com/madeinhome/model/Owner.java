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
@Table(name = "tcr_owners")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o")})
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDOWNER")
    private Integer cdowner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "YNCHECK_CUSTOMER")
    private String yncheckCustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACREATE")
    @Temporal(TemporalType.DATE)
    private Date dacreate;
    @Column(name = "DAUPDATE")
    @Temporal(TemporalType.DATE)
    private Date daupdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdowner")
    private List<ProductType> productTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdowner")
    private List<Customer> customerList;
    @JoinColumn(name = "CDPERSON", referencedColumnName = "CDPERSON")
    @ManyToOne
    private Person cdperson;
    @JoinColumn(name = "CDUSER_CREATE", referencedColumnName = "CDUSER")
    @ManyToOne(optional = false)
    private User cduserCreate;
    @JoinColumn(name = "CDUSER_UPDATE", referencedColumnName = "CDUSER")
    @ManyToOne
    private User cduserUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdowner")
    private List<Product> productList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdowner")
    private List<PaymentPeriod> paymentPeriodList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdowner")
    private List<Payment> paymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdowner")
    private List<Brand> brandList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdowner")
    private List<CreditDetail> creditDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdowner")
    private List<Credit> creditList;

    public Owner() {
    }

    public Owner(Integer cdowner) {
        this.cdowner = cdowner;
    }

    public Owner(Integer cdowner, String yncheckCustomer, Date dacreate) {
        this.cdowner = cdowner;
        this.yncheckCustomer = yncheckCustomer;
        this.dacreate = dacreate;
    }

    public Integer getCdowner() {
        return cdowner;
    }

    public void setCdowner(Integer cdowner) {
        this.cdowner = cdowner;
    }

    public String getYncheckCustomer() {
        return yncheckCustomer;
    }

    public void setYncheckCustomer(String yncheckCustomer) {
        this.yncheckCustomer = yncheckCustomer;
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
    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @XmlTransient
    public List<PaymentPeriod> getPaymentPeriodList() {
        return paymentPeriodList;
    }

    public void setPaymentPeriodList(List<PaymentPeriod> paymentPeriodList) {
        this.paymentPeriodList = paymentPeriodList;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @XmlTransient
    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    @XmlTransient
    public List<CreditDetail> getCreditDetailList() {
        return creditDetailList;
    }

    public void setCreditDetailList(List<CreditDetail> creditDetailList) {
        this.creditDetailList = creditDetailList;
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
        hash += (cdowner != null ? cdowner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if ((this.cdowner == null && other.cdowner != null) || (this.cdowner != null && !this.cdowner.equals(other.cdowner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.Owner[ cdowner=" + cdowner + " ]";
    }
    
}
