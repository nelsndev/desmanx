package br.edu.ifpe.recife.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerDao {

    private static ManagerDao self = null;
    private EntityManagerFactory emf = null;

    public static ManagerDao getInstance() {
        if (self == null) {
            self = new ManagerDao();
        }
        return self;
    }

    private ManagerDao() {
        this.emf = Persistence.createEntityManagerFactory("desmanxPU");
    }

    public void create(Object o) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(o);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    public List read(String query, Class c) {
        EntityManager em = emf.createEntityManager();
        List l = em.createQuery(query, c).getResultList();
        em.close();
        return l;
    }

    public void update(Object o) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Object o) {
        EntityManager em = emf.createEntityManager();
        Object oDelete = o;
        if (!em.contains(o)) {
            oDelete = em.merge(o);
        }
        em.getTransaction().begin();
        em.remove(oDelete);
        em.getTransaction().commit();
        em.close();
    }
}
