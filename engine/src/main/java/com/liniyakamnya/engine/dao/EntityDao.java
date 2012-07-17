package com.liniyakamnya.engine.dao;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public interface EntityDao {
    void create(Object entity);

    void update(Object entity);

    void delete(Object entity);
}
