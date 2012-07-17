package com.liniyakamnya.engine.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public abstract class AbstractEntityDAO<T extends Serializable> implements EntityDAO<T> {

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

    @Override
    public void delete(Long id) {
        getEntityManager().remove(findById(id));
    }

    @Override
    public T safeOrUpdate(T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public T findById(Long id) {
        return getEntityManager().find(getDomainClass(), id);
    }

    @Override
    public List<T> getAll() {
        CriteriaQuery<T> qq = getCriteriaBuilder().createQuery(getDomainClass());

        return criteriaQuery(qq).getResultList();
    }

    public abstract Class<T> getDomainClass();

    public CriteriaBuilder getCriteriaBuilder() {
        return getEntityManager().getCriteriaBuilder();
    }

    public <T>TypedQuery<T> criteriaQuery(CriteriaQuery<T> criteriaQuery) {
        return getEntityManager().createQuery(criteriaQuery);
    }

    public EntityManager getEntityManager() {
        return EntityManagerHolder.getCurrent();
    }
}
