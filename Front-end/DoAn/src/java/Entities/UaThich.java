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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "UaThich")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UaThich.findAll", query = "SELECT u FROM UaThich u"),
    @NamedQuery(name = "UaThich.findByMaUt", query = "SELECT u FROM UaThich u WHERE u.maUt = :maUt")})
public class UaThich implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaUt")
    private Integer maUt;
    @JoinColumn(name = "MaKh", referencedColumnName = "MaKh")
    @ManyToOne
    private KhachHang maKh;
    @JoinColumn(name = "MaSp", referencedColumnName = "MaSp")
    @ManyToOne
    private SanPham maSp;

    public UaThich() {
    }

    public UaThich(Integer maUt) {
        this.maUt = maUt;
    }

    public Integer getMaUt() {
        return maUt;
    }

    public void setMaUt(Integer maUt) {
        this.maUt = maUt;
    }

    public KhachHang getMaKh() {
        return maKh;
    }

    public void setMaKh(KhachHang maKh) {
        this.maKh = maKh;
    }

    public SanPham getMaSp() {
        return maSp;
    }

    public void setMaSp(SanPham maSp) {
        this.maSp = maSp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maUt != null ? maUt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UaThich)) {
            return false;
        }
        UaThich other = (UaThich) object;
        if ((this.maUt == null && other.maUt != null) || (this.maUt != null && !this.maUt.equals(other.maUt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.UaThich[ maUt=" + maUt + " ]";
    }
    
}
