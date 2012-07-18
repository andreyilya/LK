package com.liniyakamnya.engine.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public interface EntityDAO<T extends Serializable> {
    void create(Object entity);

    void update(Object entity);

    T safeOrUpdate(T entity);

    void delete(Object entity);

    void delete(Long id);

    T findById(Long id);

    List<T> getAll();
}
