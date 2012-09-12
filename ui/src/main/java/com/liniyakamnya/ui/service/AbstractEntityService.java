package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;

import java.io.Serializable;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
public class AbstractEntityService <T extends Serializable> implements EntityService<T> {
    @Override
    public void create(T entity) {
        getEntityDAO().create(entity);
    }

    @Override
    public void update(T entity) {
        getEntityDAO().update(entity);
    }

    @Override
    public Long safeOrUpdate(T entity) {
       return getEntityDAO().safeOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityDAO().safeOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        getEntityDAO().delete(id);
    }

    @Override
    public T findById(Long id) {
       return getEntityDAO().findById(id);
    }

    @Override
    public List<T> getAll() {
        return getEntityDAO().getAll();
    }

    public EntityDAO<T> getEntityDAO(){
        return null;
    }
}
