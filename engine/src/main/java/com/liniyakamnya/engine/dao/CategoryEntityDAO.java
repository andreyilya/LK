package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;

import java.util.List;
import javax.persistence.Query;

/**
 * User: Asus
 * Date: 17.07.12
 * Time: 21:18
 */
public class CategoryEntityDAO extends AbstractEntityDAO<Category> {

	@Override
	public void create(Category entity) {
		super.create(entity);
	}

	@Override
	public void update(Category entity) {
		super.update(entity);
	}

	@Override
	public void delete(Category entity) {
		super.delete(entity);

		getEntityManager().getTransaction().begin();
		Query query =
				getEntityManager().createNamedQuery("delete.subCategory");
		query.setParameter("id", entity.getId());
		query.executeUpdate();
		getEntityManager().getTransaction().commit();
	}

	@Override
	public void delete(Long id) {
		Category entity = findById(id);
		delete(entity);
	}

	@Override
	public Category safeOrUpdate(Category entity) {
		return super.safeOrUpdate(entity);
	}

	@Override
	public Category findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<Category> getAll() {
		return super.getAll();
	}

	@Override
	public Class<Category> getDomainClass() {
		return Category.class;
	}
}
