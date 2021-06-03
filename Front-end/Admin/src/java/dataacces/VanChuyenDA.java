/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacces;

import entities.VanCHuyen;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class VanChuyenDA {
     private Session s;
      public VanChuyenDA() {
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
    }
   
     public List<VanCHuyen> getAll(Integer maxResult) {
        return s.createCriteria(VanCHuyen.class).setMaxResults(maxResult == null ? 1000 : maxResult).list();
    }

    public List<VanCHuyen> getProPage1(Integer offset, Integer maxResult) {
        Query q = s.createQuery("from VanCHuyen where trangThai = 1");
        return q.setFirstResult(offset == null ? 0 : offset).setMaxResults(maxResult == null ? 4 : maxResult).list();
    }

    public Long getNumberProductDetail() {
        try {

            List list = s.createQuery("from VanCHuyen  where trangThai = 1").list();
            s.getTransaction().commit();
            s.close();
            return (long) list.size();
        } catch (Exception e) {
            s.getTransaction().rollback();
            s.close();
        }
        return 0L;
    }
     public void insert(VanCHuyen vc){
        s.save(vc);
        s.getTransaction().commit();
    }
    
    public void update(VanCHuyen vc){
        s.merge(vc);
        s.getTransaction().commit();
    }
    
    public void delete(VanCHuyen vc)
    {
        s.update(vc);
        s.getTransaction().commit();
    }
    
    public VanCHuyen getById(int maVc)
    {
        VanCHuyen vc = (VanCHuyen) s.load(VanCHuyen.class, maVc);
        s.getTransaction().commit();
        return vc;
    }
    
    public List<VanCHuyen> search(String tenVc)
    {
        Query q=s.createQuery("select s from VanCHuyen s where s.tenVc like :tenVc");
        q.setParameter("tenVc", "%"+ tenVc+"%");
        return q.list();
    }
    
}
