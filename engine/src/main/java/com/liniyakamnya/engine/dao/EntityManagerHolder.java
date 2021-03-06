package com.liniyakamnya.engine.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/**
 * User: a.radkov
 */
public final class EntityManagerHolder {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exporter");

    private static EntityManager instance;

    public static synchronized EntityManager getInstance() {
        if (instance == null) {
            instance = getCurrent();
        }

        return instance;
    }

    private EntityManagerHolder() {
    }

    private static EntityManager getCurrent() {
        EntityManager em = emf.createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);
        return em;
    }

}
