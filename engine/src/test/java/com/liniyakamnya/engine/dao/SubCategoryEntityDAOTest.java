package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;
import com.liniyakamnya.engine.entities.SubCategory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
		SubCategory subCategory =  new SubCategory();
		subCategory.setName("name");
        entityDAO.create(subCategory);
    }

    @Test
    public void testSafeOrUpdate() throws Exception {
        Category category = new Category();
        category.setName("testCategory");
        Category createdCategory = categoryEntityDAO.safeOrUpdate(category);

        SubCategory subCategory = new SubCategory();
        subCategory.setName("testSubCategory");
        SubCategory createdSubCategory = entityDAO.safeOrUpdate(subCategory);

        createdCategory.getSubCategories().add(createdSubCategory);
        Category updatedCategory = categoryEntityDAO.safeOrUpdate(createdCategory);

        assertNotNull(createdSubCategory);

        assertTrue(updatedCategory.getSubCategories().size() > 0);

        categoryEntityDAO.delete(updatedCategory);
    }

    @Test
    public void testSafeOrUpdateCascadeDeleteSubCategory() throws Exception {
        Category category = new Category();
        category.setName("testCategory3");

        SubCategory subCategory = new SubCategory();
        subCategory.setName("testSubCategory3");

        SubCategory createdSubCategory = entityDAO.safeOrUpdate(subCategory);

        assertNotNull(createdSubCategory);

        entityDAO.delete(createdSubCategory);
        assertNull(entityDAO.findById(createdSubCategory.getId()));
    }

    @Test
    public void testSafeOrUpdateCascadeDeleteSubCategory2() throws Exception {
        Category category = new Category();
        category.setName("testCategory3");

        SubCategory subCategory = new SubCategory();
        subCategory.setName("testSubCategory3");

        SubCategory createdSubCategory = entityDAO.safeOrUpdate(subCategory);
        category.getSubCategories().add(createdSubCategory);
        Category createdCategory = categoryEntityDAO.safeOrUpdate(category);

        assertEquals(category.getName(), createdCategory.getName());
        assertNotNull(createdSubCategory);
        assertTrue(createdCategory.getSubCategories().size() > 0);

        categoryEntityDAO.delete(createdCategory);
        assertNull(entityDAO.findById(createdSubCategory.getId()));
        assertNull(categoryEntityDAO.findById(createdCategory.getId()));
    }

    @Test
    public void testFindById() throws Exception {
		SubCategory subCategory =  new SubCategory();
		subCategory.setName("name");
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
