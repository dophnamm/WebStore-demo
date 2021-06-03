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
@Table(name = "KhachHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k"),
    @NamedQuery(name = "KhachHang.findByMaKh", query = "SELECT k FROM KhachHang k WHERE k.maKh = :maKh"),
    @NamedQuery(name = "KhachHang.findByTenKh", query = "SELECT k FROM KhachHang k WHERE k.tenKh = :tenKh"),
    @NamedQuery(name = "KhachHang.findByTenTk", query = "SELECT k FROM KhachHang k WHERE k.tenTk = :tenTk"),
    @NamedQuery(name = "KhachHang.findByMatKhau", query = "SELECT k FROM KhachHang k WHERE k.matKhau = :matKhau"),
    @NamedQuery(name = "KhachHang.findByDiaChi", query = "SELECT k FROM KhachHang k WHERE k.diaChi = :diaChi"),
    @NamedQuery(name = "KhachHang.findBySoDienThoai", query = "SELECT k FROM KhachHang k WHERE k.soDienThoai = :soDienThoai"),
    @NamedQuery(name = "KhachHang.findByEmail", query = "SELECT k FROM KhachHang k WHERE k.email = :email"),
    @NamedQuery(name = "KhachHang.findByTrangThai", query = "SELECT k FROM KhachHang k WHERE k.trangThai = :trangThai")})
public class KhachHang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKh")
    private Integer maKh;
    @Size(max = 100)
    @Column(name = "TenKh")
    private String tenKh;
    @Size(max = 50)
    @Column(name = "TenTk")
    private String tenTk;
    @Size(max = 50)
    @Column(name = "MatKhau")
    private String matKhau;
    @Size(max = 100)
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "SoDienThoai")
    private Integer soDienThoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Email")
    private String email;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(mappedBy = "maKh")
    private Collection<DonHang> donHangCollection;
    @OneToMany(mappedBy = "maKh")
    private Collection<UaThich> uaThichCollection;

    public KhachHang() {
    }

    public KhachHang(Integer maKh) {
        this.maKh = maKh;
    }

    public Integer getMaKh() {
        return maKh;
    }

    public void setMaKh(Integer maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getTenTk() {
        return tenTk;
    }

    public void setTenTk(String tenTk) {
        this.tenTk = tenTk;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(Integer soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @XmlTransient
    public Collection<UaThich> getUaThichCollection() {
        return uaThichCollection;
    }

    public void setUaThichCollection(Collection<UaThich> uaThichCollection) {
        this.uaThichCollection = uaThichCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKh != null ? maKh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.maKh == null && other.maKh != null) || (this.maKh != null && !this.maKh.equals(other.maKh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.KhachHang[ maKh=" + maKh + " ]";
    }
    
}
