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
@Table(name = "NhomSanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhomSanPham.findAll", query = "SELECT n FROM NhomSanPham n"),
    @NamedQuery(name = "NhomSanPham.findByMaNhomSp", query = "SELECT n FROM NhomSanPham n WHERE n.maNhomSp = :maNhomSp"),
    @NamedQuery(name = "NhomSanPham.findByTenNhomSp", query = "SELECT n FROM NhomSanPham n WHERE n.tenNhomSp = :tenNhomSp"),
    @NamedQuery(name = "NhomSanPham.findByTrangThai", query = "SELECT n FROM NhomSanPham n WHERE n.trangThai = :trangThai")})
public class NhomSanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNhomSp")
    private Integer maNhomSp;
    @Size(max = 100)
    @Column(name = "TenNhomSp")
    private String tenNhomSp;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maNhomSp")
    private Collection<SanPham> sanPhamCollection;

    public NhomSanPham() {
    }

    public NhomSanPham(Integer maNhomSp) {
        this.maNhomSp = maNhomSp;
    }

    public Integer getMaNhomSp() {
        return maNhomSp;
    }

    public void setMaNhomSp(Integer maNhomSp) {
        this.maNhomSp = maNhomSp;
    }

    public String getTenNhomSp() {
        return tenNhomSp;
    }

    public void setTenNhomSp(String tenNhomSp) {
        this.tenNhomSp = tenNhomSp;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public Collection<SanPham> getSanPhamCollection() {
        return sanPhamCollection;
    }

    public void setSanPhamCollection(Collection<SanPham> sanPhamCollection) {
        this.sanPhamCollection = sanPhamCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNhomSp != null ? maNhomSp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhomSanPham)) {
            return false;
        }
        NhomSanPham other = (NhomSanPham) object;
        if ((this.maNhomSp == null && other.maNhomSp != null) || (this.maNhomSp != null && !this.maNhomSp.equals(other.maNhomSp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NhomSanPham[ maNhomSp=" + maNhomSp + " ]";
    }
    
}
