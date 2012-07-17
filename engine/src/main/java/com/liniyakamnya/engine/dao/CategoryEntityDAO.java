package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;

import java.util.List;

/**
 * User: Asus
 * Date: 17.07.12
 * Time: 21:18
 */
public class CategoryEntityDAO extends AbstractEntityDAO<Category> {

    @Override
    public void create(Object entity) {
        super.create(entity);
    }

    @Override
    public void update(Object entity) {
        super.update(entity);
    }

    @Override
    public void delete(Object entity) {
        super.delete(entity);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public Category safeOrUpdate(Category entity) {
        return super.safeOrUpdate(entity);
    }

    @Override
    public Category findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Category> getAll() {
        return super.getAll();
    }

    @Override
    public Class<Category> getDomainClass() {
        return Category.class;
    }
}
