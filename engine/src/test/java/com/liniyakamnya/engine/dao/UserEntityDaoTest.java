package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.User;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public class UserEntityDaoTest {
    @Test
    public void testCreate() throws Exception {
        UserEntityDao userEntityDao = new UserEntityDao();
       userEntityDao.create(new User());
        assertTrue(true);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}
