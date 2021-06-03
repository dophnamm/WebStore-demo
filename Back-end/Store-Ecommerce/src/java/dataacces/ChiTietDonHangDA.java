/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacces;

import entities.ChiTietDonHang;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class ChiTietDonHangDA {
     private Session s;
      public ChiTietDonHangDA() {
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
    }
     public List<ChiTietDonHang>getAll(Integer maxResult){
              return s.createCriteria(ChiTietDonHang.class).setMaxResults(maxResult == null ? 1000 : maxResult).list();
    }

    public List<ChiTietDonHang> getProPage1(Integer offset, Integer maxResult) {
        Query q = s.createQuery("from ChiTietDonHang");
        return q.setFirstResult(offset == null ? 0 : offset).setMaxResults(maxResult == null ? 4 : maxResult).list();
    }

    public Long getNumberProductDetail() {
        try {

            List list = s.createQuery("from ChiTietDonHang").list();
            s.getTransaction().commit();
            s.close();
            return (long) list.size();
        } catch (Exception e) {
            s.getTransaction().rollback();
            s.close();
        }
        return 0L;
    }
}
