package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: Asus
 * Date: 18.07.12
 * Time: 22:08
 */
public class UserEntityDAOTest {
    private static UserEntityDAO entityDAO = new UserEntityDAO();

    @Test
    public void testCreate() throws Exception {
        entityDAO.create(new User());
    }

    @Test
    public void testSafeOrUpdate() throws Exception {
        User user = entityDAO.safeOrUpdate(new User());

        assertNotNull(user.getId());
    }

    @Test
    public void testGetAll() throws Exception {
        List<User> users = entityDAO.getAll();

        assertTrue(users.size() > 0);
    }

    @Test
    public void testComplexCreate() {
        User user = new User();
        user.setEmail("email");
        user.setLogin("login");
        user.setPassword("pass");

        User created = entityDAO.safeOrUpdate(new User());

        assertEquals(created.getEmail(), user.getEmail());
        assertEquals(created.getLogin(), user.getLogin());
        assertEquals(created.getPassword(), user.getPassword());
    }
}
