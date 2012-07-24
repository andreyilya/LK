package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;
import com.liniyakamnya.engine.entities.SubCategory;

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
        SubCategoryEntityDAO entityDAO = new SubCategoryEntityDAO();
        for (SubCategory subCategory : entity.getSubCategories()) {
            entityDAO.delete(subCategory);
        }

        super.delete(entity);
    }

    @Override
    public void delete(Long id) {
        SubCategoryEntityDAO entityDAO = new SubCategoryEntityDAO();
        for (SubCategory subCategory : findById(id).getSubCategories()) {
            entityDAO.delete(subCategory);
        }

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
