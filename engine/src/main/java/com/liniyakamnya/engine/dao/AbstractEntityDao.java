package com.liniyakamnya.engine.dao;

import javax.persistence.EntityManager;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public abstract class AbstractEntityDao implements EntityDao{

    @Override
    public void create(Object entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void update(Object entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void delete(Object entity) {
        getEntityManager().remove(entity);
    }


    public EntityManager getEntityManager() {
        return EntityManagerHolder.getCurrent();
    }
}
