package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Identifiable;

import java.util.List;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
public interface EntityActions<T extends Identifiable> {
    void create(T entity);

    Long update(T entity);

    Long safeOrUpdate(T entity);

    void delete(T entity);

    void delete(Long id);

    T findById(Long id);

    List<T> getAll();
}
