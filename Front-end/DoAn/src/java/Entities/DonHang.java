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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "DonHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonHang.findAll", query = "SELECT d FROM DonHang d"),
    @NamedQuery(name = "DonHang.findByMaDh", query = "SELECT d FROM DonHang d WHERE d.maDh = :maDh"),
    @NamedQuery(name = "DonHang.findByTenKh", query = "SELECT d FROM DonHang d WHERE d.tenKh = :tenKh"),
    @NamedQuery(name = "DonHang.findByEmail", query = "SELECT d FROM DonHang d WHERE d.email = :email"),
    @NamedQuery(name = "DonHang.findByDiaChi", query = "SELECT d FROM DonHang d WHERE d.diaChi = :diaChi"),
    @NamedQuery(name = "DonHang.findBySoDienThoai", query = "SELECT d FROM DonHang d WHERE d.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "DonHang.findByTongTien", query = "SELECT d FROM DonHang d WHERE d.tongTien = :tongTien"),
    @NamedQuery(name = "DonHang.findByNgayMua", query = "SELECT d FROM DonHang d WHERE d.ngayMua = :ngayMua"),
    @NamedQuery(name = "DonHang.findByTrangThai", query = "SELECT d FROM DonHang d WHERE d.trangThai = :trangThai")})
public class DonHang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDh")
    private Integer maDh;
    @Size(max = 100)
    @Column(name = "TenKh")
    private String tenKh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @Size(max = 100)
    @Column(name = "DiaChi")
    private String diaChi;
    @Size(max = 50)
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TongTien")
    private Double tongTien;
    @Size(max = 50)
    @Column(name = "NgayMua")
    private String ngayMua;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @JoinColumn(name = "MaKh", referencedColumnName = "MaKh")
    @ManyToOne
    private KhachHang maKh;
    @JoinColumn(name = "MaTt", referencedColumnName = "MaTt")
    @ManyToOne
    private ThanhToan maTt;
    @JoinColumn(name = "MaVc", referencedColumnName = "MaVc")
    @ManyToOne
    private VanChuyen maVc;
    @OneToMany(mappedBy = "maDh")
    private Collection<ChiTietDonHang> chiTietDonHangCollection;

    public DonHang() {
    }

    public DonHang(Integer maDh) {
        this.maDh = maDh;
    }

    public Integer getMaDh() {
        return maDh;
    }

    public void setMaDh(Integer maDh) {
        this.maDh = maDh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang getMaKh() {
        return maKh;
    }

    public void setMaKh(KhachHang maKh) {
        this.maKh = maKh;
    }

    public ThanhToan getMaTt() {
        return maTt;
    }

    public void setMaTt(ThanhToan maTt) {
        this.maTt = maTt;
    }

    public VanChuyen getMaVc() {
        return maVc;
    }

    public void setMaVc(VanChuyen maVc) {
        this.maVc = maVc;
    }

    @XmlTransient
    public Collection<ChiTietDonHang> getChiTietDonHangCollection() {
        return chiTietDonHangCollection;
    }

    public void setChiTietDonHangCollection(Collection<ChiTietDonHang> chiTietDonHangCollection) {
        this.chiTietDonHangCollection = chiTietDonHangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDh != null ? maDh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonHang)) {
            return false;
        }
        DonHang other = (DonHang) object;
        if ((this.maDh == null && other.maDh != null) || (this.maDh != null && !this.maDh.equals(other.maDh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.DonHang[ maDh=" + maDh + " ]";
    }
    
}
