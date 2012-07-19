package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
        Long id = entityDAO.safeOrUpdate(new Category()).getId();

        assertNotNull(entityDAO.findById(id));
    }

    @Test
    public void testGetAll() throws Exception {
        List<Category> categories = entityDAO.getAll();

        assertTrue(categories.size() > 0);
    }

    @Test
    public void testComplexCreate() {
        Category category = new Category();
        category.setName("category");

        Category created = entityDAO.safeOrUpdate(category);

        assertNull(created.getSubCategories());
        assertEquals(created.getName(), category.getName());
    }
}
