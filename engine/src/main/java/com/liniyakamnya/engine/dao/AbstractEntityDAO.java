package com.liniyakamnya.engine.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Transactional
public abstract class AbstractEntityDAO<T extends Serializable> implements EntityDAO<T> {

	@Override
	public void create(T entity) {
		getEntityManager().merge(entity);

	}

	@Override
	public void update(T entity) {
		getEntityManager().merge(entity);
	}

	@Override
	public void delete(T entity) {
		getEntityManager().remove(entity);
	}

	@Override
	public void delete(Long id) {
		getEntityManager().remove(findById(id));
	}

	@Override
	public T safeOrUpdate(T entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public T findById(Long id) {
		return getEntityManager().find(getDomainClass(), id);
	}

	@Override
	public List<T> getAll() {
		CriteriaQuery<T> qq = getCriteriaBuilder().createQuery(getDomainClass());
		Root<T> root = qq.from(getDomainClass());

		return criteriaQuery(qq).getResultList();
	}

	public abstract Class<T> getDomainClass();

	public CriteriaBuilder getCriteriaBuilder() {
		return getEntityManager().getCriteriaBuilder();
	}

	public <T> TypedQuery<T> criteriaQuery(CriteriaQuery<T> criteriaQuery) {
		return getEntityManager().createQuery(criteriaQuery);
	}

	public EntityManager getEntityManager() {
		return EntityManagerHolder.getInstance();
	}
}
