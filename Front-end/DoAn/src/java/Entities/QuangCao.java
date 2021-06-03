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
@Table(name = "QuangCao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuangCao.findAll", query = "SELECT q FROM QuangCao q"),
    @NamedQuery(name = "QuangCao.findByMaQc", query = "SELECT q FROM QuangCao q WHERE q.maQc = :maQc"),
    @NamedQuery(name = "QuangCao.findByTenQc", query = "SELECT q FROM QuangCao q WHERE q.tenQc = :tenQc"),
    @NamedQuery(name = "QuangCao.findByAnh", query = "SELECT q FROM QuangCao q WHERE q.anh = :anh"),
    @NamedQuery(name = "QuangCao.findByGia", query = "SELECT q FROM QuangCao q WHERE q.gia = :gia"),
    @NamedQuery(name = "QuangCao.findByNhaSanXuat", query = "SELECT q FROM QuangCao q WHERE q.nhaSanXuat = :nhaSanXuat"),
    @NamedQuery(name = "QuangCao.findByMota", query = "SELECT q FROM QuangCao q WHERE q.mota = :mota"),
    @NamedQuery(name = "QuangCao.findByTrangThai", query = "SELECT q FROM QuangCao q WHERE q.trangThai = :trangThai")})
public class QuangCao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaQc")
    private Integer maQc;
    @Size(max = 100)
    @Column(name = "TenQc")
    private String tenQc;
    @Size(max = 1073741823)
    @Column(name = "Anh")
    private String anh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Gia")
    private Double gia;
    @Size(max = 100)
    @Column(name = "NhaSanXuat")
    private String nhaSanXuat;
    @Size(max = 1073741823)
    @Column(name = "Mota")
    private String mota;
    @Column(name = "TrangThai")
    private Boolean trangThai;

    public QuangCao() {
    }

    public QuangCao(Integer maQc) {
        this.maQc = maQc;
    }

    public Integer getMaQc() {
        return maQc;
    }

    public void setMaQc(Integer maQc) {
        this.maQc = maQc;
    }

    public String getTenQc() {
        return tenQc;
    }

    public void setTenQc(String tenQc) {
        this.tenQc = tenQc;
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

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQc != null ? maQc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuangCao)) {
            return false;
        }
        QuangCao other = (QuangCao) object;
        if ((this.maQc == null && other.maQc != null) || (this.maQc != null && !this.maQc.equals(other.maQc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.QuangCao[ maQc=" + maQc + " ]";
    }
    
}
