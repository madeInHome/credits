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
@Table(name = "tcr_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDUSER")
    private Integer cduser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDPERSON")
    private int cdperson;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDOWNER")
    private int cdowner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DSUSERNAME")
    private String dsusername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DSPASSWORD")
    private String dspassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDSTATE")
    private int cdstate;
    @Column(name = "DALAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dalastLogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<ProductType> productTypeList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<ProductType> productTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<Customer> customerList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<Customer> customerList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<Owner> ownerList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<Owner> ownerList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<Person> personList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<Person> personList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<Product> productList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<Product> productList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<PaymentPeriod> paymentPeriodList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<PaymentPeriod> paymentPeriodList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<Payment> paymentList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<Payment> paymentList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<Brand> brandList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<Brand> brandList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<CreditDetail> creditDetailList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<CreditDetail> creditDetailList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cduserCreate")
    private List<Credit> creditList;
    @OneToMany(mappedBy = "cduserUpdate")
    private List<Credit> creditList1;

    public User() {
    }

    public User(Integer cduser) {
        this.cduser = cduser;
    }

    public User(Integer cduser, int cdperson, int cdowner, String dsusername, String dspassword, int cdstate) {
        this.cduser = cduser;
        this.cdperson = cdperson;
        this.cdowner = cdowner;
        this.dsusername = dsusername;
        this.dspassword = dspassword;
        this.cdstate = cdstate;
    }

    public Integer getCduser() {
        return cduser;
    }

    public void setCduser(Integer cduser) {
        this.cduser = cduser;
    }

    public int getCdperson() {
        return cdperson;
    }

    public void setCdperson(int cdperson) {
        this.cdperson = cdperson;
    }

    public int getCdowner() {
        return cdowner;
    }

    public void setCdowner(int cdowner) {
        this.cdowner = cdowner;
    }

    public String getDsusername() {
        return dsusername;
    }

    public void setDsusername(String dsusername) {
        this.dsusername = dsusername;
    }

    public String getDspassword() {
        return dspassword;
    }

    public void setDspassword(String dspassword) {
        this.dspassword = dspassword;
    }

    public int getCdstate() {
        return cdstate;
    }

    public void setCdstate(int cdstate) {
        this.cdstate = cdstate;
    }

    public Date getDalastLogin() {
        return dalastLogin;
    }

    public void setDalastLogin(Date dalastLogin) {
        this.dalastLogin = dalastLogin;
    }

    @XmlTransient
    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }

    @XmlTransient
    public List<ProductType> getProductTypeList1() {
        return productTypeList1;
    }

    public void setProductTypeList1(List<ProductType> productTypeList1) {
        this.productTypeList1 = productTypeList1;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @XmlTransient
    public List<Customer> getCustomerList1() {
        return customerList1;
    }

    public void setCustomerList1(List<Customer> customerList1) {
        this.customerList1 = customerList1;
    }

    @XmlTransient
    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    @XmlTransient
    public List<Owner> getOwnerList1() {
        return ownerList1;
    }

    public void setOwnerList1(List<Owner> ownerList1) {
        this.ownerList1 = ownerList1;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @XmlTransient
    public List<Person> getPersonList1() {
        return personList1;
    }

    public void setPersonList1(List<Person> personList1) {
        this.personList1 = personList1;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @XmlTransient
    public List<Product> getProductList1() {
        return productList1;
    }

    public void setProductList1(List<Product> productList1) {
        this.productList1 = productList1;
    }

    @XmlTransient
    public List<PaymentPeriod> getPaymentPeriodList() {
        return paymentPeriodList;
    }

    public void setPaymentPeriodList(List<PaymentPeriod> paymentPeriodList) {
        this.paymentPeriodList = paymentPeriodList;
    }

    @XmlTransient
    public List<PaymentPeriod> getPaymentPeriodList1() {
        return paymentPeriodList1;
    }

    public void setPaymentPeriodList1(List<PaymentPeriod> paymentPeriodList1) {
        this.paymentPeriodList1 = paymentPeriodList1;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @XmlTransient
    public List<Payment> getPaymentList1() {
        return paymentList1;
    }

    public void setPaymentList1(List<Payment> paymentList1) {
        this.paymentList1 = paymentList1;
    }

    @XmlTransient
    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    @XmlTransient
    public List<Brand> getBrandList1() {
        return brandList1;
    }

    public void setBrandList1(List<Brand> brandList1) {
        this.brandList1 = brandList1;
    }

    @XmlTransient
    public List<CreditDetail> getCreditDetailList() {
        return creditDetailList;
    }

    public void setCreditDetailList(List<CreditDetail> creditDetailList) {
        this.creditDetailList = creditDetailList;
    }

    @XmlTransient
    public List<CreditDetail> getCreditDetailList1() {
        return creditDetailList1;
    }

    public void setCreditDetailList1(List<CreditDetail> creditDetailList1) {
        this.creditDetailList1 = creditDetailList1;
    }

    @XmlTransient
    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

    @XmlTransient
    public List<Credit> getCreditList1() {
        return creditList1;
    }

    public void setCreditList1(List<Credit> creditList1) {
        this.creditList1 = creditList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cduser != null ? cduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.cduser == null && other.cduser != null) || (this.cduser != null && !this.cduser.equals(other.cduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.User[ cduser=" + cduser + " ]";
    }
    
}
