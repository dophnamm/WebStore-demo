/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacces;

import entities.ThanhToan;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class ThanhToanDA {
     private Session s;
      public ThanhToanDA() {
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
    }
  
     public List<ThanhToan> getAll(Integer maxResult) {
        return s.createCriteria(ThanhToan.class).setMaxResults(maxResult == null ? 1000 : maxResult).list();
    }

    public List<ThanhToan> getProPage1(Integer offset, Integer maxResult) {
        Query q = s.createQuery("from ThanhToan where trangThai = 1");
        return q.setFirstResult(offset == null ? 0 : offset).setMaxResults(maxResult == null ? 4 : maxResult).list();
    }

    public Long getNumberProductDetail() {
        try {

            List list = s.createQuery("from ThanhToan  where trangThai = 1").list();
            s.getTransaction().commit();
            s.close();
            return (long) list.size();
        } catch (Exception e) {
            s.getTransaction().rollback();
            s.close();
        }
        return 0L;
    }
     public void insert(ThanhToan sp){
        s.save(sp);
        s.getTransaction().commit();
    }
    
    public void update(ThanhToan sp){
        s.merge(sp);
        s.getTransaction().commit();
    }
    
    public void delete(ThanhToan tt)
    {
        s.update(tt);
        s.getTransaction().commit();
    }
    
    public ThanhToan getById(int maSp)
    {
        ThanhToan sp = (ThanhToan) s.load(ThanhToan.class, maSp);
        s.getTransaction().commit();
        return sp;
    }
    
    public List<ThanhToan> search(String tenTt)
    {
        Query q=s.createQuery("select tt from ThanhToan tt where tt.tenTt like :tenTt");
        q.setParameter("tenTt", "%"+ tenTt+"%");
        return q.list();
    }
    
}
