package com.liniyakamnya.engine.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public interface EntityDAO<T extends Serializable> {
    void create(T entity);

    void update(T entity);

    T safeOrUpdate(T entity);

    void delete(T entity);

    void delete(int id);

    T findById(int id);

    List<T> getAll();
}
