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
	private static UserEntityDAO entityDAO = new UserEntityDAO();
	private User user;

	@Test
	public void testSafeOrUpdate() throws Exception {
		User user = new User();
		user.setEmail("liniyakamnya@gmail.com");
		user.setLogin("login");
		user.setPassword("pass");
		User created = entityDAO.safeOrUpdate(user);

		assertNotNull(created);
		assertNotNull(created.getId());
		assertNotNull(created.getActionsForEmail());
		deleteUser(created);
	}

	@Test
	public void testGetAll() throws Exception {
		List<User> users = entityDAO.getAll();

		assertNotNull(users);
	}

	@Test
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
