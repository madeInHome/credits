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
@Table(name = "tcr_persons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDPERSON")
    private Integer cdperson;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDPERSON_TYPE")
    private int cdpersonType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CDDOCUMENT_TYPE")
    private int cddocumentType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CDDOCUMENT")
    private String cddocument;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DSNAMES")
    private String dsnames;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DSLAST_NAMES")
    private String dslastNames;
    @Size(max = 200)
    @Column(name = "DSBUSINESS_NAME")
    private String dsbusinessName;
    @Size(max = 20)
    @Column(name = "DSTELEPHONE")
    private String dstelephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DSCELL_PHONE")
    private String dscellPhone;
    @Size(max = 200)
    @Column(name = "DSADDRESS")
    private String dsaddress;
    @Size(max = 100)
    @Column(name = "DSEMAIL")
    private String dsemail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACREATE")
    @Temporal(TemporalType.DATE)
    private Date dacreate;
    @Column(name = "DAUPDATE")
    @Temporal(TemporalType.DATE)
    private Date daupdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdperson")
    private List<Customer> customerList;
    @OneToMany(mappedBy = "cdperson")
    private List<Owner> ownerList;
    @JoinColumn(name = "CDUSER_CREATE", referencedColumnName = "CDUSER")
    @ManyToOne(optional = false)
    private User cduserCreate;
    @JoinColumn(name = "CDUSER_UPDATE", referencedColumnName = "CDUSER")
    @ManyToOne
    private User cduserUpdate;

    public Person() {
    }

    public Person(Integer cdperson) {
        this.cdperson = cdperson;
    }

    public Person(Integer cdperson, int cdpersonType, int cddocumentType, String cddocument, String dsnames, String dslastNames, String dscellPhone, Date dacreate) {
        this.cdperson = cdperson;
        this.cdpersonType = cdpersonType;
        this.cddocumentType = cddocumentType;
        this.cddocument = cddocument;
        this.dsnames = dsnames;
        this.dslastNames = dslastNames;
        this.dscellPhone = dscellPhone;
        this.dacreate = dacreate;
    }

    public Integer getCdperson() {
        return cdperson;
    }

    public void setCdperson(Integer cdperson) {
        this.cdperson = cdperson;
    }

    public int getCdpersonType() {
        return cdpersonType;
    }

    public void setCdpersonType(int cdpersonType) {
        this.cdpersonType = cdpersonType;
    }

    public int getCddocumentType() {
        return cddocumentType;
    }

    public void setCddocumentType(int cddocumentType) {
        this.cddocumentType = cddocumentType;
    }

    public String getCddocument() {
        return cddocument;
    }

    public void setCddocument(String cddocument) {
        this.cddocument = cddocument;
    }

    public String getDsnames() {
        return dsnames;
    }

    public void setDsnames(String dsnames) {
        this.dsnames = dsnames;
    }

    public String getDslastNames() {
        return dslastNames;
    }

    public void setDslastNames(String dslastNames) {
        this.dslastNames = dslastNames;
    }

    public String getDsbusinessName() {
        return dsbusinessName;
    }

    public void setDsbusinessName(String dsbusinessName) {
        this.dsbusinessName = dsbusinessName;
    }

    public String getDstelephone() {
        return dstelephone;
    }

    public void setDstelephone(String dstelephone) {
        this.dstelephone = dstelephone;
    }

    public String getDscellPhone() {
        return dscellPhone;
    }

    public void setDscellPhone(String dscellPhone) {
        this.dscellPhone = dscellPhone;
    }

    public String getDsaddress() {
        return dsaddress;
    }

    public void setDsaddress(String dsaddress) {
        this.dsaddress = dsaddress;
    }

    public String getDsemail() {
        return dsemail;
    }

    public void setDsemail(String dsemail) {
        this.dsemail = dsemail;
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

    @XmlTransient
    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public void setOwnerList(List<Owner> ownerList) {
        this.ownerList = ownerList;
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
        hash += (cdperson != null ? cdperson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.cdperson == null && other.cdperson != null) || (this.cdperson != null && !this.cdperson.equals(other.cdperson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.Person[ cdperson=" + cdperson + " ]";
    }
    
}
