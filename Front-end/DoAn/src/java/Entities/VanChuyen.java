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
@Table(name = "VanChuyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VanChuyen.findAll", query = "SELECT v FROM VanChuyen v"),
    @NamedQuery(name = "VanChuyen.findByMaVc", query = "SELECT v FROM VanChuyen v WHERE v.maVc = :maVc"),
    @NamedQuery(name = "VanChuyen.findByTenVc", query = "SELECT v FROM VanChuyen v WHERE v.tenVc = :tenVc"),
    @NamedQuery(name = "VanChuyen.findByGia", query = "SELECT v FROM VanChuyen v WHERE v.gia = :gia"),
    @NamedQuery(name = "VanChuyen.findByMota", query = "SELECT v FROM VanChuyen v WHERE v.mota = :mota"),
    @NamedQuery(name = "VanChuyen.findByTrangThai", query = "SELECT v FROM VanChuyen v WHERE v.trangThai = :trangThai")})
public class VanChuyen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaVc")
    private Integer maVc;
    @Size(max = 100)
    @Column(name = "TenVc")
    private String tenVc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Double gia;
    @Size(max = 1073741823)
    @Column(name = "Mota")
    private String mota;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maVc")
    private Collection<DonHang> donHangCollection;

    public VanChuyen() {
    }

    public VanChuyen(Integer maVc) {
        this.maVc = maVc;
    }

    public Integer getMaVc() {
        return maVc;
    }

    public void setMaVc(Integer maVc) {
        this.maVc = maVc;
    }

    public String getTenVc() {
        return tenVc;
    }

    public void setTenVc(String tenVc) {
        this.tenVc = tenVc;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
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
        hash += (maVc != null ? maVc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VanChuyen)) {
            return false;
        }
        VanChuyen other = (VanChuyen) object;
        if ((this.maVc == null && other.maVc != null) || (this.maVc != null && !this.maVc.equals(other.maVc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.VanChuyen[ maVc=" + maVc + " ]";
    }
    
}
