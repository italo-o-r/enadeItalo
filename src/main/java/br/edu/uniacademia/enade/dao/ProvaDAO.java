/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.dao;

import br.edu.uniacademia.enade.model.Prova;
import br.edu.uniacademia.enade.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author COREI7
 */
public class ProvaDAO {

    public static ProvaDAO provaDAO;

    public static ProvaDAO getInstance() {
        if (provaDAO == null) {
            provaDAO = new ProvaDAO();
        }
        return provaDAO;
    }

    public Prova buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from Prova t where t.idProva =:id ");
        query.setParameter("id", codigo);

        List<Prova> Prova = query.getResultList();
        if (Prova != null && Prova.size() > 0) {
            return Prova.get(0);
        }

        return null;
    }

    public List<Prova> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Prova t");
        return query.getResultList();
    }

    public void remover(Prova Prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(Prova);
        em.getTransaction().commit();
    }

    public Prova atualizar(Prova Prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Prova = em.merge(Prova);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return Prova;
    }

    public void persistir(Prova Prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(Prova);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Prova");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
