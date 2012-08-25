package com.liniyakamnya.ui.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */

public abstract class AbstractEntityDAO<T extends Serializable> implements EntityDAO<T> {

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
		sessionFactory.getCurrentSession().delete(findById(id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public T safeOrUpdate(T entity) {
		return (T) sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		return (T) sessionFactory.getCurrentSession().load(
				getDomainClass(), id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {

		//TODO: getDomainClass//String[] parts = getDomainClass().getName().toLowerCase().split(".");
		String domainClass = "user";// parts[parts.length - 1];
		return sessionFactory.getCurrentSession().getNamedQuery(domainClass + ".all")
				.list();
	}

	public abstract Class<T> getDomainClass();

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
