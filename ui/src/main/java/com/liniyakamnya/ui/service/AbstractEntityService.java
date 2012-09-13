package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.entities.Identifiable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
@Transactional
public abstract class AbstractEntityService<T extends Identifiable> implements EntityService<T> {
    @Autowired
    EmailService emailService;

    @Override
    public void create(T entity) {
        emailService.protocolAction(getCreateAction());
        getEntityDAO().create(entity);
    }

    @Override
    public Long update(T entity) {
        emailService.protocolAction(getUpdateAction());
        return getEntityDAO().update(entity);
    }

    @Override
    public Long safeOrUpdate(T entity) {
        emailService.protocolAction(getCreateAction());
        return getEntityDAO().safeOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityDAO().delete(entity);
        emailService.protocolAction(getDeleteAction());
    }

    @Override
    public void delete(Long id) {
        getEntityDAO().delete(id);
        emailService.protocolAction(getDeleteAction());
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
