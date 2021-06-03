/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "QuanTri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuanTri.findAll", query = "SELECT q FROM QuanTri q"),
    @NamedQuery(name = "QuanTri.findByMaQt", query = "SELECT q FROM QuanTri q WHERE q.maQt = :maQt"),
    @NamedQuery(name = "QuanTri.findByTenQt", query = "SELECT q FROM QuanTri q WHERE q.tenQt = :tenQt"),
    @NamedQuery(name = "QuanTri.findByTaiKhoan", query = "SELECT q FROM QuanTri q WHERE q.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "QuanTri.findByMatKhau", query = "SELECT q FROM QuanTri q WHERE q.matKhau = :matKhau"),
    @NamedQuery(name = "QuanTri.findByTrangThai", query = "SELECT q FROM QuanTri q WHERE q.trangThai = :trangThai")})
public class QuanTri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaQt")
    private Integer maQt;
    @Size(max = 100)
    @Column(name = "TenQt")
    private String tenQt;
    @Size(max = 100)
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    @Size(max = 100)
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "TrangThai")
    private Boolean trangThai;

    public QuanTri() {
    }

    public QuanTri(Integer maQt) {
        this.maQt = maQt;
    }

    public Integer getMaQt() {
        return maQt;
    }

    public void setMaQt(Integer maQt) {
        this.maQt = maQt;
    }

    public String getTenQt() {
        return tenQt;
    }

    public void setTenQt(String tenQt) {
        this.tenQt = tenQt;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQt != null ? maQt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuanTri)) {
            return false;
        }
        QuanTri other = (QuanTri) object;
        if ((this.maQt == null && other.maQt != null) || (this.maQt != null && !this.maQt.equals(other.maQt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.QuanTri[ maQt=" + maQt + " ]";
    }
    
}
