package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.entities.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
public abstract class AbstractEntityService<T extends Serializable> implements EntityService<T> {
    @Autowired
    EmailService emailService;

    @Override
    public void create(T entity) {
        getEntityDAO().create(entity);
        emailService.protocolAction(Actions.DELETE_USER);
    }

    @Override
    public void update(T entity) {
        getEntityDAO().update(entity);
        emailService.protocolAction(Actions.DELETE_USER);
    }

    @Override
    public Long safeOrUpdate(T entity) {
        emailService.protocolAction(Actions.DELETE_USER);
        return getEntityDAO().safeOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityDAO().delete(entity);
        emailService.protocolAction(Actions.DELETE_USER);
    }

    @Override
    public void delete(Long id) {
        getEntityDAO().delete(id);
        emailService.protocolAction(Actions.DELETE_USER);
    }

    @Override
    public T findById(Long id) {
        return getEntityDAO().findById(id);
    }

    @Override
    public List<T> getAll() {
        return getEntityDAO().getAll();
    }

}
