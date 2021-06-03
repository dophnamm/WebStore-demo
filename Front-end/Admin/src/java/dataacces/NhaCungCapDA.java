/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacces;

import entities.NhaCungCap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class NhaCungCapDA {
    private Session s;
      public NhaCungCapDA() {
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
    }
   
    public List<NhaCungCap>getAll(Integer maxResult){
              return s.createCriteria(NhaCungCap.class).setMaxResults(maxResult == null ? 1000 : maxResult).list();
    }

    public List<NhaCungCap> getProPage1(Integer offset, Integer maxResult) {
        Query q = s.createQuery("from NhaCungCap where trangThai = 1");
        return q.setFirstResult(offset == null ? 0 : offset).setMaxResults(maxResult == null ? 4 : maxResult).list();
    }

    public Long getNumberProductDetail() {
        try {

            List list = s.createQuery("from NhaCungCap where trangThai = 1").list();
            s.getTransaction().commit();
            s.close();
            return (long) list.size();
        } catch (Exception e) {
            s.getTransaction().rollback();
            s.close();
        }
        return 0L;
    }
    
     public void insert(NhaCungCap ncc){
        s.save(ncc);
        s.getTransaction().commit();
    }
    
    public void update(NhaCungCap ncc){
        s.merge(ncc);
        s.getTransaction().commit();
    }
    
    public void delete(NhaCungCap ncc)
    {
        s.update(ncc);
        s.getTransaction().commit();
    }
    
    public NhaCungCap getById(int maNcc)
    {
        NhaCungCap ncc = (NhaCungCap) s.load(NhaCungCap.class, maNcc);
        s.getTransaction().commit();
        return ncc;
    }
    
    public List<NhaCungCap> search(String tenNcc)
    {
        Query q=s.createQuery("select ncc from NhaCungCap ncc where ncc.tenNcc like :tenNcc");
        q.setParameter("tenNcc", "%"+ tenNcc+"%");
        return q.list();
    }
}
