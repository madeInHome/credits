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
@Table(name = "tcr_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDPRODUCT")
    private Integer cdproduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DSPRODUCT")
    private String dsproduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VRCOST")
    private long vrcost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VRSALE_PRICE")
    private long vrsalePrice;
    @Size(max = 20)
    @Column(name = "DSCOLOR")
    private String dscolor;
    @Size(max = 20)
    @Column(name = "DSSIZE")
    private String dssize;
    @Column(name = "NMSTOCK")
    private Integer nmstock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACREATE")
    @Temporal(TemporalType.DATE)
    private Date dacreate;
    @Column(name = "DAUPDATE")
    @Temporal(TemporalType.DATE)
    private Date daupdate;
    @JoinColumn(name = "CDBRAND", referencedColumnName = "CDBRAND")
    @ManyToOne(optional = false)
    private Brand cdbrand;
    @JoinColumn(name = "CDOWNER", referencedColumnName = "CDOWNER")
    @ManyToOne(optional = false)
    private Owner cdowner;
    @JoinColumn(name = "CDUSER_CREATE", referencedColumnName = "CDUSER")
    @ManyToOne(optional = false)
    private User cduserCreate;
    @JoinColumn(name = "CDUSER_UPDATE", referencedColumnName = "CDUSER")
    @ManyToOne
    private User cduserUpdate;
    @JoinColumn(name = "CDPRODUCT_TYPE", referencedColumnName = "CDPRODUCT_TYPE")
    @ManyToOne(optional = false)
    private ProductType cdproductType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdproduct")
    private List<CreditDetail> creditDetailList;

    public Product() {
    }

    public Product(Integer cdproduct) {
        this.cdproduct = cdproduct;
    }

    public Product(Integer cdproduct, String dsproduct, long vrcost, long vrsalePrice, Date dacreate) {
        this.cdproduct = cdproduct;
        this.dsproduct = dsproduct;
        this.vrcost = vrcost;
        this.vrsalePrice = vrsalePrice;
        this.dacreate = dacreate;
    }

    public Integer getCdproduct() {
        return cdproduct;
    }

    public void setCdproduct(Integer cdproduct) {
        this.cdproduct = cdproduct;
    }

    public String getDsproduct() {
        return dsproduct;
    }

    public void setDsproduct(String dsproduct) {
        this.dsproduct = dsproduct;
    }

    public long getVrcost() {
        return vrcost;
    }

    public void setVrcost(long vrcost) {
        this.vrcost = vrcost;
    }

    public long getVrsalePrice() {
        return vrsalePrice;
    }

    public void setVrsalePrice(long vrsalePrice) {
        this.vrsalePrice = vrsalePrice;
    }

    public String getDscolor() {
        return dscolor;
    }

    public void setDscolor(String dscolor) {
        this.dscolor = dscolor;
    }

    public String getDssize() {
        return dssize;
    }

    public void setDssize(String dssize) {
        this.dssize = dssize;
    }

    public Integer getNmstock() {
        return nmstock;
    }

    public void setNmstock(Integer nmstock) {
        this.nmstock = nmstock;
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

    public Brand getCdbrand() {
        return cdbrand;
    }

    public void setCdbrand(Brand cdbrand) {
        this.cdbrand = cdbrand;
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

    public ProductType getCdproductType() {
        return cdproductType;
    }

    public void setCdproductType(ProductType cdproductType) {
        this.cdproductType = cdproductType;
    }

    @XmlTransient
    public List<CreditDetail> getCreditDetailList() {
        return creditDetailList;
    }

    public void setCreditDetailList(List<CreditDetail> creditDetailList) {
        this.creditDetailList = creditDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdproduct != null ? cdproduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.cdproduct == null && other.cdproduct != null) || (this.cdproduct != null && !this.cdproduct.equals(other.cdproduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.Product[ cdproduct=" + cdproduct + " ]";
    }
    
}
