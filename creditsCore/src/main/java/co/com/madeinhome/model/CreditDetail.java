/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.madeinhome.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tcr_credits_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditDetail.findAll", query = "SELECT c FROM CreditDetail c")})
public class CreditDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CDCREDIT_DETAIL")
    private Integer cdcreditDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NMQUANTITY")
    private int nmquantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VRSALE_PRICE")
    private long vrsalePrice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORATE")
    private BigDecimal porate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DACREATE")
    @Temporal(TemporalType.DATE)
    private Date dacreate;
    @Column(name = "DAUPDATE")
    @Temporal(TemporalType.DATE)
    private Date daupdate;
    @JoinColumn(name = "CDCREDIT", referencedColumnName = "CDCREDIT")
    @ManyToOne(optional = false)
    private Credit cdcredit;
    @JoinColumn(name = "CDOWNER", referencedColumnName = "CDOWNER")
    @ManyToOne(optional = false)
    private Owner cdowner;
    @JoinColumn(name = "CDPRODUCT", referencedColumnName = "CDPRODUCT")
    @ManyToOne(optional = false)
    private Product cdproduct;
    @JoinColumn(name = "CDUSER_CREATE", referencedColumnName = "CDUSER")
    @ManyToOne(optional = false)
    private User cduserCreate;
    @JoinColumn(name = "CDUSER_UPDATE", referencedColumnName = "CDUSER")
    @ManyToOne
    private User cduserUpdate;

    public CreditDetail() {
    }

    public CreditDetail(Integer cdcreditDetail) {
        this.cdcreditDetail = cdcreditDetail;
    }

    public CreditDetail(Integer cdcreditDetail, int nmquantity, long vrsalePrice, Date dacreate) {
        this.cdcreditDetail = cdcreditDetail;
        this.nmquantity = nmquantity;
        this.vrsalePrice = vrsalePrice;
        this.dacreate = dacreate;
    }

    public Integer getCdcreditDetail() {
        return cdcreditDetail;
    }

    public void setCdcreditDetail(Integer cdcreditDetail) {
        this.cdcreditDetail = cdcreditDetail;
    }

    public int getNmquantity() {
        return nmquantity;
    }

    public void setNmquantity(int nmquantity) {
        this.nmquantity = nmquantity;
    }

    public long getVrsalePrice() {
        return vrsalePrice;
    }

    public void setVrsalePrice(long vrsalePrice) {
        this.vrsalePrice = vrsalePrice;
    }

    public BigDecimal getPorate() {
        return porate;
    }

    public void setPorate(BigDecimal porate) {
        this.porate = porate;
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

    public Credit getCdcredit() {
        return cdcredit;
    }

    public void setCdcredit(Credit cdcredit) {
        this.cdcredit = cdcredit;
    }

    public Owner getCdowner() {
        return cdowner;
    }

    public void setCdowner(Owner cdowner) {
        this.cdowner = cdowner;
    }

    public Product getCdproduct() {
        return cdproduct;
    }

    public void setCdproduct(Product cdproduct) {
        this.cdproduct = cdproduct;
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
        hash += (cdcreditDetail != null ? cdcreditDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditDetail)) {
            return false;
        }
        CreditDetail other = (CreditDetail) object;
        if ((this.cdcreditDetail == null && other.cdcreditDetail != null) || (this.cdcreditDetail != null && !this.cdcreditDetail.equals(other.cdcreditDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.madeinhome.model.CreditDetail[ cdcreditDetail=" + cdcreditDetail + " ]";
    }
    
}
