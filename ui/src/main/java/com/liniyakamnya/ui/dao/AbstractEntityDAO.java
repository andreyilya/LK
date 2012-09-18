package com.liniyakamnya.ui.dao;

import java.util.List;

import com.liniyakamnya.ui.entities.Identifiable;
import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Transactional
public abstract class AbstractEntityDAO<T extends Identifiable> implements EntityDAO<T> {

    private static final String POINT_SEPARATOR = "\\.";
    private static final String ALL = ".all";
    private static final Logger LOGGER = Logger.getLogger(AbstractEntityDAO.class);
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void create(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public Long update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity.getId();
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void delete(Long id) {
        try {
            //TODO: named query
            sessionFactory.getCurrentSession().delete(findById(id));
        } catch (ObjectNotFoundException e) {
            LOGGER.warn("Object with id " + id + " not found");
        }
    }

    @Override
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
