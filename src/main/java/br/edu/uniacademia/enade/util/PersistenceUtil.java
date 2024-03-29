/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author COREI7
 */
public class PersistenceUtil {
    
    
    private static final String PERSISTENCE_UNIT_NAME = "ENADE";
    private static EntityManagerFactory FACTORY;
    private static ThreadLocal<EntityManager> MANAGER = new ThreadLocal<EntityManager>();
    private static Session session;

    static {
        if (FACTORY == null) {
            try {
                FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            } catch (Throwable e) {
                System.out.println("A criacao o do EntityManagerFactory falhou: " + e);
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    public static EntityManager getEntityManager() {
        EntityManager em = MANAGER.get();

        if (em == null) {
            em = FACTORY.createEntityManager();
            MANAGER.set(em);
        }
        return em;
    }

    public static void closeEntityManager() {
        EntityManager em = MANAGER.get();

        if (em != null) {
            em.close();
        }
        MANAGER.remove();
    }

    public static Session getSession() {
        if (session == null) {
            session = (Session) getEntityManager().getDelegate();
        }
        return session;
    }
    
}
