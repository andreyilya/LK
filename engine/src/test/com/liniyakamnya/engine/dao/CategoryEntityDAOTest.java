package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * User: Asus
 * Date: 18.07.12
 * Time: 23:58
 */
public class CategoryEntityDAOTest {
    private static CategoryEntityDAO entityDAO = new CategoryEntityDAO();

    @Test
    public void testCreate() throws Exception {
        entityDAO.create(new Category());
    }

    @Test
    public void testFindById() throws Exception {
        Category category = new Category();
        Long id = entityDAO.safeOrUpdate(category).getId();
        Category created = entityDAO.findById(id);
        assertNotNull(created);

        deleteCategory(created);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Category> categories = entityDAO.getAll();

        assertNotNull(categories);
    }

    @Test
    public void testComplexCreate() {
        Category category = new Category();
        category.setName("category");

        Category created = entityDAO.safeOrUpdate(category);

        assertNull(created.getSubCategories());
        assertEquals(created.getName(), category.getName());
        deleteCategory(created);
    }

    private void deleteCategory(Category category) {
        entityDAO.delete(category);
    }
}
