/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacces;

import entities.QuangCao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class TinTucDA {
    private Session s;
      public TinTucDA() {
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
    }
    
      public List<QuangCao> getAll(Integer maxResult) {
        return s.createCriteria(QuangCao.class).setMaxResults(maxResult == null ? 1000 : maxResult).list();
    }

    public List<QuangCao> getProPage1(Integer offset, Integer maxResult) {
        Query q = s.createQuery("from QuangCao where trangThai = 1");
        return q.setFirstResult(offset == null ? 0 : offset).setMaxResults(maxResult == null ? 4 : maxResult).list();
    }

    public Long getNumberProductDetail() {
        try {

            List list = s.createQuery("from QuangCao  where trangThai = 1").list();
            s.getTransaction().commit();
            s.close();
            return (long) list.size();
        } catch (Exception e) {
            s.getTransaction().rollback();
            s.close();
        }
        return 0L;
    }
     public void insert(QuangCao qc){
        s.save(qc);
        s.getTransaction().commit();
    }
    
    public void update(QuangCao qc){
        s.merge(qc);
        s.getTransaction().commit();
    }
    
    public void delete(QuangCao qc)
    {
        s.update(qc);
        s.getTransaction().commit();
    }
    
    public QuangCao getById(int maQc)
    {
        QuangCao qc = (QuangCao) s.load(QuangCao.class, maQc);
        s.getTransaction().commit();
        return qc;
    }
    
    public List<QuangCao> search(String tenQc)
    {
        Query q=s.createQuery("select qc from QuangCao qc where qc.tenQc like :tenQc");
        q.setParameter("tenQc", "%"+ tenQc+"%");
        return q.list();
    }
}
