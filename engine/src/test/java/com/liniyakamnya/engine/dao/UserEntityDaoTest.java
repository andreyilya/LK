package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.User;
import org.junit.Test;
import static junit.framework.Assert.assertNotNull;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public class UserEntityDaoTest {
    @Test
    public void testCreate() throws Exception {
        UserEntityDAO userEntityDao = new UserEntityDAO();
        User user = userEntityDao.safeOrUpdate(new User());
        assertNotNull(userEntityDao.findById(user.getId()));
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}
