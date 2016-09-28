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
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDPERSON")
    private int person;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDOWNER")
    private int owner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DSUSERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DSPASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDSTATE")
    private int state;
    @Column(name = "DALAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userCreate")
    private List<ProductType> productTypeList;
    @OneToMany(mappedBy = "userUpdate")
    private List<ProductType> productTypeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userCreate")
    private List<Customer> customerList;
    @OneToMany(mappedBy = "userUpdate")
    private List<Customer> customerList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userCreate")
    private List<Owner> ownerList;



    public User() {
    }

    public User(Integer cduser) {
        this.id = cduser;
    }

    public User(Integer cduser, int cdperson, int cdowner, String dsusername, String dspassword, int cdstate) {
        this.id = cduser;
        this.person = cdperson;
        this.owner = cdowner;
        this.username = dsusername;
        this.password = dspassword;
        this.state = cdstate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
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
 

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.User[ cduser=" + id + " ]";
    }
    
}
