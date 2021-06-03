/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.ChiTietDonHang;
import Entities.DonHang;
import Entities.KhachHang;
import Entities.NhomSanPham;
import Entities.QuangCao;
import Entities.SanPham;
import Entities.ThanhToan;
import Entities.UaThich;
import Entities.VanChuyen;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class ShoppingDA {

    private Session s;

    public ShoppingDA() {
        s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
    }

    // Nhóm sản phẩm
    public List<NhomSanPham> getNhom() {
        Query q = s.createQuery("from NhomSanPham");
        return q.list();
    }

    public List<SanPham> getByNhomSp(int maNhomSp) {
        Query q = s.createQuery("from SanPham where maNhomSp = :maNhomSp");
        q.setLong("maNhomSp", maNhomSp);
        return q.list();
    }

    // Sản phẩm
    public List<SanPham> getAll(Integer maxResult) {
        Query q = s.createQuery("from SanPham where trangThai like '1'");
        return q.setMaxResults(maxResult == null ? 1000 : maxResult).list();
    }

    public List<SanPham> getProPage1(Integer offset, Integer maxResult) {
        Query q = s.createQuery("from SanPham where trangThai like '1'");
        return q.setFirstResult(offset == null ? 0 : offset).setMaxResults(maxResult == null ? 12 : maxResult).list();
    }

    public Long getNumberProductDetail() {
        try {

            List list = s.createQuery("from SanPham where trangThai like '1'").list();
            s.getTransaction().commit();
            s.close();
            return (long) list.size();
        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            s.close();
        }
        return 0L;
    }

    public SanPham getById(int maSp) {
        SanPham sp = (SanPham) s.load(SanPham.class, maSp);
        s.getTransaction().commit();
        return sp;
    }

    public List<SanPham> search(String tensp) {
        Query q = s.createQuery("select s from SanPham s where s.tenSp like :tensp");
        q.setParameter("tensp", "%" + tensp + "%");
        return q.list();
    }

    /// Quảng cáo
    public List<QuangCao> getAllQuangCao() {
        return s.createCriteria(QuangCao.class).list();
    }

    public QuangCao getByIdQuangCao(int maQc) {
        QuangCao qc = (QuangCao) s.load(QuangCao.class, maQc);
        s.getTransaction().commit();
        return qc;
    }

    // Thanh toán
    public List<ThanhToan> getThanhToan() {
        return s.createCriteria(ThanhToan.class).list();
    }

    public ThanhToan getMaThanhToan(int maTt) {
        ThanhToan tt = (ThanhToan) s.load(ThanhToan.class, maTt);
        s.getTransaction().commit();
        return tt;
    }

    // Vận chuyển
    public List<VanChuyen> getVanChuyen() {
        return s.createCriteria(VanChuyen.class).list();
    }

    public VanChuyen getMaVanChuyen(int maVc) {
        VanChuyen vc = (VanChuyen) s.load(VanChuyen.class, maVc);
        s.getTransaction().commit();
        return vc;
    }

    //Khách hàng
    public void insertUser(KhachHang khachHang) {
        s.save(khachHang);
        s.getTransaction().commit();
    }

    public KhachHang getMaKhachHang(int maKh) {
        KhachHang kh = (KhachHang) s.load(KhachHang.class, maKh);
        s.getTransaction().commit();
        return kh;
    }

    public void updateKhachHang(KhachHang kh) {
        s.merge(kh);
        s.getTransaction().commit();
    }

    public List<DonHang> getByKhachHang(int maKh) {
        Query q = s.createQuery("from DonHang where maKh = :maKh");
        q.setLong("maKh", maKh);
        return q.list();
    }

    public List<ChiTietDonHang> getByDonHang(int maDh) {
        Query q = s.createQuery("from ChiTietDonHang where maDh = :maDh");
        q.setLong("maDh", maDh);
        return q.list();
    }

    public KhachHang checkEmail(String email) {
        Query query = s.createQuery("from KhachHang where email = :email");
        query.setString("email", email);
        KhachHang kh = (KhachHang) query.uniqueResult();
        s.getTransaction().commit();
        return kh;
    }
    
    public KhachHang checkTaiKhoan(String tenTk) {
        Query query = s.createQuery("from KhachHang where tenTk = :tenTk");
        query.setString("tenTk", tenTk);
        KhachHang kh = (KhachHang) query.uniqueResult();
        s.getTransaction().commit();
        return kh;
    }
    

    public KhachHang Login(String tenTk, String matKhau) {
        Query query = s.createQuery("from KhachHang where tenTk = :tenTk and matKhau = :matKhau");
        query.setString("tenTk", tenTk);
        query.setString("matKhau", matKhau);
        KhachHang kh = (KhachHang) query.uniqueResult();
        s.getTransaction().commit();
        return kh;
    }

    // Đơn hàng
    public void insertDonHang(DonHang dh) {
        s.save(dh);
        s.getTransaction().commit();
    }

    public void insertChiTietDonHang(ChiTietDonHang ctdh) {
        s.save(ctdh);
        s.getTransaction().commit();

    }

    public DonHang getByIdDonHang(int maDh) {
        return (DonHang) s.get(DonHang.class, maDh);
    }

    // San pham ua thich
    public void insertUaThich(UaThich ut) {
        s.save(ut);
        s.getTransaction().commit();
    }

    public List<UaThich> getUaThichByKhachHang(int maKh) {
        Query q = s.createQuery("from UaThich where maKh = :maKh");
        q.setLong("maKh", maKh);
        return q.list();
    }
    
 
    public List<SanPham> getSanPhamByQuan() {
        Query q = s.createQuery("from SanPham where tenSp like '%Jogger%'");
        return q.list();
    }
    
    public List<SanPham> getSanPhamByAo() {
        Query q = s.createQuery("from SanPham where tenSp like '%Hodie%'");
        return q.list();
    }
    
    public List<SanPham> getSanPhamByGiay() {
        Query q = s.createQuery("from SanPham where tenSp like '%Sneaker%'");
        return q.list();
    }

    public UaThich delete(int maUt) {
        UaThich ut = (UaThich) s.load(UaThich.class, maUt);
        s.delete(ut);
        s.getTransaction().commit();
        return ut;
    }

    // Sản phẩm được yêu thích
}
