package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.User;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Transactional
@Repository("userDao")
@Service
public class UserEntityDAO extends AbstractEntityDAO<User> implements Authentificator{
	@Override
	public void create(User entity) {
		super.create(entity);
	}

	@Override
	public void update(User entity) {
		super.update(entity);
	}

	@Override
	public void delete(User entity) {
		super.delete(entity);
	}

	@Override
	public void delete(Long id) {
		super.delete(id);
	}

	@Override
	public User safeOrUpdate(User entity) {
		return super.safeOrUpdate(entity);
	}

	@Override
	public User findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<User> getAll() {
		return super.getAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByLogin(String login) {
		Session session = getSessionFactory().getCurrentSession();
		org.hibernate.Query query = session.getNamedQuery("user.byLogin");
		query.setString("login", login);
		List<User> list = query.list();
		User userByLogin = new User();
		//TODO: normal logic!
		userByLogin.setEmail("wer");
		if (!list.isEmpty()) {
			userByLogin = list.get(0);
		}
		return userByLogin;
	}


	@Override
	public Class<User> getDomainClass() {
		return User.class;
	}
}
