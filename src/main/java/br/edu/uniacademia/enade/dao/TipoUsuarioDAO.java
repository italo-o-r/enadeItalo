/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.dao;

import br.edu.uniacademia.enade.model.TipoUsuario;
import br.edu.uniacademia.enade.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author COREI7
 */
public class TipoUsuarioDAO {

    public static TipoUsuarioDAO tipoUsuarioDAO;

    public static TipoUsuarioDAO getInstance() {
        if (tipoUsuarioDAO == null) {
            tipoUsuarioDAO = new TipoUsuarioDAO();
        }
        return tipoUsuarioDAO;
    }

    public TipoUsuario buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from TipoUsuario t where t.idTipoUsuario =:id ");
        query.setParameter("id", codigo);

        List<TipoUsuario> tipoUsuario = query.getResultList();
        if (tipoUsuario != null && tipoUsuario.size() > 0) {
            return tipoUsuario.get(0);
        }

        return null;
    }

    public List<TipoUsuario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TipoUsuario t");
        return query.getResultList();
    }

    public void remover(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tipoUsuario)) {
            tipoUsuario = em.merge(tipoUsuario);
        }
        em.remove(tipoUsuario);
        em.getTransaction().commit();
    }

    public TipoUsuario atualizar(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tipoUsuario = em.merge(tipoUsuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return tipoUsuario;
    }

    public void persistir(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(tipoUsuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from TipoUsuario");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}