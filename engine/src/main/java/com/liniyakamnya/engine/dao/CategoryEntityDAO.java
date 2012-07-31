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
    public void create(Category entity) {
        super.create(entity);
    }

    @Override
    public void update(Category entity) {
        super.update(entity);
    }

    @Override
    public void delete(Category entity) {
		// TODO: delete this
        entity.getSubCategories().clear();
        safeOrUpdate(entity);

        super.delete(entity);
    }

    @Override
    public void delete(Long id) {
		// TODO: delete this
        Category entity = findById(id);
        entity.getSubCategories().clear();
        safeOrUpdate(entity);

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
