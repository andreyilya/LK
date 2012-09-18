package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.User;
import java.util.List;

import com.liniyakamnya.ui.utils.Parameters;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Named;

import static org.junit.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 18:14
 */

public class UserEntityDAOTest {
	@Inject
    @Named(Parameters.USER_DAO)
	private static EntityDAO entityDAO;
	private User user;

	@Test
	@Ignore
	public void testSafeOrUpdate() throws Exception {
		User user = new User();
		user.setEmail("liniyakamnya@gmail.com");
		user.setLogin("login");
		user.setPassword("pass");
		//User created = (User)entityDAO.safeOrUpdate(user);

		//assertNotNull(created);
		//assertNotNull(created.getId());
		//assertNotNull(created.getActionsForEmail());
		//deleteUser(created);
	}

	@Test
	@Ignore
	public void testGetAll() throws Exception {
		List<User> users = entityDAO.getAll();

		assertNotNull(users);
	}

	@Test
	@Ignore
	public void testCreate() throws Exception {
		initEmptyUser();
		entityDAO.create(user);
	}

	private void initEmptyUser() {
		user = new User();
		user.setEmail("liniyakamnya@gmail.com");
	}

	private void deleteUser(User user) {
		entityDAO.delete(user);
	}
}

