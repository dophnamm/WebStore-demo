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
@Table(name = "NhaCungCap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhaCungCap.findAll", query = "SELECT n FROM NhaCungCap n"),
    @NamedQuery(name = "NhaCungCap.findByMaNcc", query = "SELECT n FROM NhaCungCap n WHERE n.maNcc = :maNcc"),
    @NamedQuery(name = "NhaCungCap.findByTenNcc", query = "SELECT n FROM NhaCungCap n WHERE n.tenNcc = :tenNcc"),
    @NamedQuery(name = "NhaCungCap.findByTrangThai", query = "SELECT n FROM NhaCungCap n WHERE n.trangThai = :trangThai")})
public class NhaCungCap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNcc")
    private Integer maNcc;
    @Size(max = 50)
    @Column(name = "TenNcc")
    private String tenNcc;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maNcc")
    private Collection<SanPham> sanPhamCollection;

    public NhaCungCap() {
    }

    public NhaCungCap(Integer maNcc) {
        this.maNcc = maNcc;
    }

    public Integer getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(Integer maNcc) {
        this.maNcc = maNcc;
    }

    public String getTenNcc() {
        return tenNcc;
    }

    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
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
        hash += (maNcc != null ? maNcc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhaCungCap)) {
            return false;
        }
        NhaCungCap other = (NhaCungCap) object;
        if ((this.maNcc == null && other.maNcc != null) || (this.maNcc != null && !this.maNcc.equals(other.maNcc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NhaCungCap[ maNcc=" + maNcc + " ]";
    }
    
}
