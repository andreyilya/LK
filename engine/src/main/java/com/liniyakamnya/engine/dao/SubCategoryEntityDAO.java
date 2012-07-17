package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.SubCategory;

import java.util.List;

/**
 * User: Asus
 * Date: 17.07.12
 * Time: 21:20
 */
public class SubCategoryEntityDAO extends AbstractEntityDAO<SubCategory> {

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
    public SubCategory safeOrUpdate(SubCategory entity) {
        return super.safeOrUpdate(entity);
    }

    @Override
    public SubCategory findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<SubCategory> getAll() {
        return super.getAll();
    }

    @Override
    public Class<SubCategory> getDomainClass() {
        return SubCategory.class;
    }
}
