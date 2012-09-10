package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.User;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Transactional
public abstract class AbstractEntityDAO<T extends Serializable> implements EntityDAO<T> {

	private static final String POINT_SEPARATOR = "\\.";
	private static final String ALL = ".all";
	private static final Logger logger = Logger.getLogger(AbstractEntityDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Long id) {
		try {
			sessionFactory.getCurrentSession().delete(findById(id));
		} catch (ObjectNotFoundException e) {
			 logger.warn("Object with id " + id + " not found");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Long safeOrUpdate(T entity) {
		return (Long) sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) sessionFactory.getCurrentSession().get(
				getDomainClass(), id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {

		String[] parts = getDomainClass().getName().toLowerCase().split(POINT_SEPARATOR);
		String domainClass = parts[parts.length - 1];
		return sessionFactory.getCurrentSession().getNamedQuery(domainClass + ALL)
				.list();
	}

	public abstract Class<T> getDomainClass();

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
