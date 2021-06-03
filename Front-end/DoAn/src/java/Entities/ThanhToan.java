/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "ThanhToan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThanhToan.findAll", query = "SELECT t FROM ThanhToan t"),
    @NamedQuery(name = "ThanhToan.findByMaTt", query = "SELECT t FROM ThanhToan t WHERE t.maTt = :maTt"),
    @NamedQuery(name = "ThanhToan.findByTenTt", query = "SELECT t FROM ThanhToan t WHERE t.tenTt = :tenTt"),
    @NamedQuery(name = "ThanhToan.findByMota", query = "SELECT t FROM ThanhToan t WHERE t.mota = :mota"),
    @NamedQuery(name = "ThanhToan.findByTrangThai", query = "SELECT t FROM ThanhToan t WHERE t.trangThai = :trangThai")})
public class ThanhToan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaTt")
    private Integer maTt;
    @Size(max = 100)
    @Column(name = "TenTt")
    private String tenTt;
    @Size(max = 1073741823)
    @Column(name = "Mota")
    private String mota;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maTt")
    private Collection<DonHang> donHangCollection;

    public ThanhToan() {
    }

    public ThanhToan(Integer maTt) {
        this.maTt = maTt;
    }

    public Integer getMaTt() {
        return maTt;
    }

    public void setMaTt(Integer maTt) {
        this.maTt = maTt;
    }

    public String getTenTt() {
        return tenTt;
    }

    public void setTenTt(String tenTt) {
        this.tenTt = tenTt;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public Collection<DonHang> getDonHangCollection() {
        return donHangCollection;
    }

    public void setDonHangCollection(Collection<DonHang> donHangCollection) {
        this.donHangCollection = donHangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTt != null ? maTt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThanhToan)) {
            return false;
        }
        ThanhToan other = (ThanhToan) object;
        if ((this.maTt == null && other.maTt != null) || (this.maTt != null && !this.maTt.equals(other.maTt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ThanhToan[ maTt=" + maTt + " ]";
    }
    
}
