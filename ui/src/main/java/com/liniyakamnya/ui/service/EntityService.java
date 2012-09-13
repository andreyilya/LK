package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityActions;
import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.Identifiable;

import java.io.Serializable;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
public interface EntityService <T extends Identifiable> extends EntityActions<T> {
    public EntityDAO<T> getEntityDAO();
    public Actions getCreateAction();
    public Actions getUpdateAction();
    public Actions getDeleteAction();
}
