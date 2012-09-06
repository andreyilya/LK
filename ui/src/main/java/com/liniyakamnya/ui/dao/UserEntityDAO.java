package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.exception.GuiException;
import com.liniyakamnya.ui.utils.Paramerers;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Transactional
@Repository(Paramerers.USER_DAO)
@Service(Paramerers.USER_DAO)
public class UserEntityDAO extends AbstractEntityDAO<User> implements Authentificator {

	private static final String USER_BY_LOGIN = "user.byLogin";
	private static final String LOGIN = "login";

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
	public Long safeOrUpdate(User entity) {
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
	public User getUserByLogin(String login) throws GuiException {
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.getNamedQuery(USER_BY_LOGIN);
			query.setString(LOGIN, login);
			List<User> list = query.list();
			return list.get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new GuiException(e.getMessage());
		}
	}


	@Override
	public Class<User> getDomainClass() {
		return User.class;
	}
}
