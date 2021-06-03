/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacces;

import entities.DonHang;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class DonHangDA {
      private Session s;
      public DonHangDA() {
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
    }
    
    public List<DonHang>getAll(Integer maxResult){
              return s.createCriteria(DonHang.class).setMaxResults(maxResult == null ? 1000 : maxResult).list();
    }

    public List<DonHang> getProPage1(Integer offset, Integer maxResult) {
        Query q = s.createQuery("from DonHang where trangThai = 1");
        return q.setFirstResult(offset == null ? 0 : offset).setMaxResults(maxResult == null ? 4 : maxResult).list();
    }

    public Long getNumberProductDetail() {
        try {

            List list = s.createQuery("from DonHang  where trangThai = 1").list();
            s.getTransaction().commit();
            s.close();
            return (long) list.size();
        } catch (Exception e) {
            s.getTransaction().rollback();
            s.close();
        }
        return 0L;
    }
    public List<DonHang> search(String tenKh)
    {
        Query q=s.createQuery("select dh from DonHang dh where dh.tenKh like :tenKh");
        q.setParameter("tenKh", "%"+ tenKh+"%");
        return q.list();
    }
    
   
}
