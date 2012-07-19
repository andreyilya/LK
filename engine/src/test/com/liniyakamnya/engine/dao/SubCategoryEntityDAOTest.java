package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.SubCategory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: Asus
 * Date: 19.07.12
 * Time: 0:01
 */
public class SubCategoryEntityDAOTest {
    private static SubCategoryEntityDAO entityDAO = new SubCategoryEntityDAO();

    @Test
    public void testCreate() throws Exception {
        entityDAO.create(new SubCategory());
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
