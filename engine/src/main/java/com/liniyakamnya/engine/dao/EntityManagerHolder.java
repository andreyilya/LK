package com.liniyakamnya.engine.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/**
 * User: a.radkov
 */
public class EntityManagerHolder {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exporter");

    public EntityManagerHolder() {
    }

    public static EntityManager getCurrent() {

        EntityManager em = emf.createEntityManager();
        em.setFlushMode(FlushModeType.COMMIT);
        return em;
    }

}
