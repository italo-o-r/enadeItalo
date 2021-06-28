/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.dao;


import br.edu.uniacademia.enade.model.Usuario;
import br.edu.uniacademia.enade.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author COREI7
 */
public class UsuarioDAO {

    public static UsuarioDAO UsuarioDAO;

    public static UsuarioDAO getInstance() {
        if (UsuarioDAO == null) {
            UsuarioDAO = new UsuarioDAO();
        }
        return UsuarioDAO;
    }

    public Usuario buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from Usuario t where t.idUsuario =:id ");
        query.setParameter("id", codigo);

        List<Usuario> Usuario = query.getResultList();
        if (Usuario != null && Usuario.size() > 0) {
            return Usuario.get(0);
        }

        return null;
    }

    public List<Usuario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Usuario t");
        return query.getResultList();
    }

    public void remover(Usuario Usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(Usuario);
        em.getTransaction().commit();
    }

    public Usuario atualizar(Usuario Usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Usuario = em.merge(Usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return Usuario;
    }

    public void persistir(Usuario Usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(Usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Usuario");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
