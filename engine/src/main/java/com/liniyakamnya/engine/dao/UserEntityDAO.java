package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.User;

import java.util.List;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public class UserEntityDAO extends AbstractEntityDAO<User> {
    @Override
    public void create(User entity) {
        super.create(entity);
    }

    @Override
    public void update(User entity) {
        super.update(entity);
    }

    @Override
    public void delete(User entity) {
        super.delete(entity);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public User safeOrUpdate(User entity) {
        return super.safeOrUpdate(entity);
    }

    @Override
    public User findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public Class<User> getDomainClass() {
        return User.class;
    }
}
