package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: Asus
 * Date: 17.07.12
 * Time: 21:57
 */
public class CategoryEntityDAOTest {
    @Test
    public void testCreate() throws Exception {
        CategoryEntityDAO entityDAO = new CategoryEntityDAO();
        entityDAO.safeOrUpdate(new Category());
        assertTrue(true);
    }
}
