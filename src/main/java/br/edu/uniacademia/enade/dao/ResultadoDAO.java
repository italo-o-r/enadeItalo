/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.dao;

import br.edu.uniacademia.enade.model.Resultado;
import br.edu.uniacademia.enade.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author COREI7
 */
public class ResultadoDAO {

    public static ResultadoDAO ResultadoDAO;

    public static ResultadoDAO getInstance() {
        if (ResultadoDAO == null) {
            ResultadoDAO = new ResultadoDAO();
        }
        return ResultadoDAO;
    }

    public Resultado buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from Resultado t where t.idResultado =:id ");
        query.setParameter("id", codigo);

        List<Resultado> Resultado = query.getResultList();
        if (Resultado != null && Resultado.size() > 0) {
            return Resultado.get(0);
        }

        return null;
    }

    public List<Resultado> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Resultado t");
        return query.getResultList();
    }

    public void remover(Resultado Resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(Resultado);
        em.getTransaction().commit();
    }

    public Resultado atualizar(Resultado Resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Resultado = em.merge(Resultado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return Resultado;
    }

    public void persistir(Resultado Resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(Resultado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Resultado");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}