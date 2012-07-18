package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * User: Asus
 * Date: 18.07.12
 * Time: 22:08
 */
public class UserEntityDAOTest {
    @Test
    public void testCreate() throws Exception {
        UserEntityDAO entityDAO = new UserEntityDAO();
        entityDAO.create(new User());
    }

    @Test
    public void testSafeOrUpdate() throws Exception {
        UserEntityDAO entityDAO = new UserEntityDAO();
        User user = entityDAO.safeOrUpdate(new User());

        assertNotNull(user.getId());
    }

    @Test
    public void testGetAll() throws Exception {
        UserEntityDAO entityDAO = new UserEntityDAO();
        List<User> users = entityDAO.getAll();
    }
}
