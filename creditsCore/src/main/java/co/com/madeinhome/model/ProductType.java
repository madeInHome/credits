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
@Table(name = "tcr_products_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductType.findAll", query = "SELECT p FROM ProductType p")})
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDPRODUCT_TYPE")
    private Integer cdproductType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DSPRODUCT_TYPE")
    private String dsproductType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdproductType")
    private List<Product> productList;

    public ProductType() {
    }

    public ProductType(Integer cdproductType) {
        this.cdproductType = cdproductType;
    }

    public ProductType(Integer cdproductType, String dsproductType, Date dacreate) {
        this.cdproductType = cdproductType;
        this.dsproductType = dsproductType;
        this.dacreate = dacreate;
    }

    public Integer getCdproductType() {
        return cdproductType;
    }

    public void setCdproductType(Integer cdproductType) {
        this.cdproductType = cdproductType;
    }

    public String getDsproductType() {
        return dsproductType;
    }

    public void setDsproductType(String dsproductType) {
        this.dsproductType = dsproductType;
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

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdproductType != null ? cdproductType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductType)) {
            return false;
        }
        ProductType other = (ProductType) object;
        if ((this.cdproductType == null && other.cdproductType != null) || (this.cdproductType != null && !this.cdproductType.equals(other.cdproductType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.ProductType[ cdproductType=" + cdproductType + " ]";
    }
    
}
