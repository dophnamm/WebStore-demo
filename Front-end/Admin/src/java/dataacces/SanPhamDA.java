/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacces;

import entities.SanPham;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class SanPhamDA {

    private Session s;

    public SanPhamDA() {
        s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
    }

    public List<SanPham> getAll(Integer maxResult) {
        return s.createCriteria(SanPham.class).setMaxResults(maxResult == null ? 1000 : maxResult).list();
    }

    public List<SanPham> getProPage1(Integer offset, Integer maxResult) {
        Query q = s.createQuery("from SanPham where trangThai = 1");
        return q.setFirstResult(offset == null ? 0 : offset).setMaxResults(maxResult == null ? 4 : maxResult).list();
    }

    public Long getNumberProductDetail() {
        try {

            List list = s.createQuery("from SanPham  where trangThai = 1").list();
            s.getTransaction().commit();
            s.close();
            return (long) list.size();
        } catch (Exception e) {
            s.getTransaction().rollback();
            s.close();
        }
        return 0L;
    }

    public void insert(SanPham sp) {
        s.save(sp);
        s.getTransaction().commit();
    }

    public void update(SanPham sp) {
        s.merge(sp);
        s.getTransaction().commit();
    }

    public void delete(SanPham sp) {
        s.update(sp);
        s.getTransaction().commit();
    }

    public SanPham getById(int maSp) {
        SanPham sp = (SanPham) s.load(SanPham.class, maSp);
        s.getTransaction().commit();
        return sp;
    }

    public List<SanPham> search(String tenSp) {
        Query q = s.createQuery("select sp from SanPham sp where sp.tenSp like :tenSp");
        q.setParameter("tenSp", "%" + tenSp + "%");
        return q.list();
    }
}
