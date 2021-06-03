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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s"),
    @NamedQuery(name = "SanPham.findByMaSp", query = "SELECT s FROM SanPham s WHERE s.maSp = :maSp"),
    @NamedQuery(name = "SanPham.findByTenSp", query = "SELECT s FROM SanPham s WHERE s.tenSp = :tenSp"),
    @NamedQuery(name = "SanPham.findByAnh", query = "SELECT s FROM SanPham s WHERE s.anh = :anh"),
    @NamedQuery(name = "SanPham.findByGia", query = "SELECT s FROM SanPham s WHERE s.gia = :gia"),
    @NamedQuery(name = "SanPham.findByMota", query = "SELECT s FROM SanPham s WHERE s.mota = :mota"),
    @NamedQuery(name = "SanPham.findByTrangThai", query = "SELECT s FROM SanPham s WHERE s.trangThai = :trangThai")})
public class SanPham implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSp")
    private Integer maSp;
    @Size(max = 100)
    @Column(name = "TenSp")
    private String tenSp;
    @Size(max = 1073741823)
    @Column(name = "Anh")
    private String anh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Double gia;
    @Size(max = 1073741823)
    @Column(name = "Mota")
    private String mota;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maSp")
    
    private Collection<UaThich> uaThichCollection;
    @OneToMany(mappedBy = "maSp")
    private Collection<ChiTietDonHang> chiTietDonHangCollection;
    @JoinColumn(name = "MaNcc", referencedColumnName = "MaNcc")
    @ManyToOne
    private NhaCungCap maNcc;
    @JoinColumn(name = "MaNhomSp", referencedColumnName = "MaNhomSp")
    @ManyToOne
    private NhomSanPham maNhomSp;

    public SanPham() {
    }

    public SanPham(Integer maSp) {
        this.maSp = maSp;
    }

    public Integer getMaSp() {
        return maSp;
    }

    public void setMaSp(Integer maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
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
    public Collection<UaThich> getUaThichCollection() {
        return uaThichCollection;
    }

    public void setUaThichCollection(Collection<UaThich> uaThichCollection) {
        this.uaThichCollection = uaThichCollection;
    }

    @XmlTransient
    public Collection<ChiTietDonHang> getChiTietDonHangCollection() {
        return chiTietDonHangCollection;
    }

    public void setChiTietDonHangCollection(Collection<ChiTietDonHang> chiTietDonHangCollection) {
        this.chiTietDonHangCollection = chiTietDonHangCollection;
    }

    public NhaCungCap getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(NhaCungCap maNcc) {
        this.maNcc = maNcc;
    }

    public NhomSanPham getMaNhomSp() {
        return maNhomSp;
    }

    public void setMaNhomSp(NhomSanPham maNhomSp) {
        this.maNhomSp = maNhomSp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSp != null ? maSp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.maSp == null && other.maSp != null) || (this.maSp != null && !this.maSp.equals(other.maSp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.SanPham[ maSp=" + maSp + " ]";
    }
    
}
