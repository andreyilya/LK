package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;
import com.liniyakamnya.engine.entities.SubCategory;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * User: Asus
 * Date: 19.07.12
 * Time: 0:01
 */
public class SubCategoryEntityDAOTest {
    private static SubCategoryEntityDAO entityDAO = new SubCategoryEntityDAO();
    private static CategoryEntityDAO categoryEntityDAO = new CategoryEntityDAO();

    @Test
    public void testCreate() throws Exception {
        entityDAO.create(new SubCategory());
    }

    @Test
    public void testSafeOrUpdate() throws Exception {
        Category category = new Category();
        category.setName("testCategory");
        Category createdCategory = categoryEntityDAO.safeOrUpdate(category);

        SubCategory subCategory = new SubCategory();
        subCategory.setName("testSubCategory");
        subCategory.setCategory(createdCategory);
        SubCategory createdSubCategory = entityDAO.safeOrUpdate(subCategory);

        createdCategory.setSubCategories(new ArrayList<SubCategory>());
        createdCategory.getSubCategories().add(createdSubCategory);
        Category updatedCategory = categoryEntityDAO.safeOrUpdate(createdCategory);

        assertNotNull(createdSubCategory);
        assertNotNull(createdSubCategory.getCategory());

        assertTrue(updatedCategory.getSubCategories().size() > 0);

        categoryEntityDAO.delete(updatedCategory);
        entityDAO.delete(createdSubCategory);

    }

    @Test
    public void testFindById() throws Exception {
        SubCategory subCategory = new SubCategory();
        Long id = entityDAO.safeOrUpdate(subCategory).getId();
        SubCategory created = entityDAO.findById(id);
        assertNotNull(created);

        deleteSubCategory(created);
    }

    @Test
    public void testGetAll() throws Exception {
        List<SubCategory> categories = entityDAO.getAll();

        assertNotNull(categories);
    }

    private void deleteSubCategory(SubCategory subCategory) {
        entityDAO.delete(subCategory);
    }
}
