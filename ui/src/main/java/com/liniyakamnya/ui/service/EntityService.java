package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityActions;
import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.Identifiable;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
public interface EntityService<T extends Identifiable> extends EntityActions<T> {
    EntityDAO<T> getEntityDAO();

    Actions getCreateAction();

    Actions getUpdateAction();

    Actions getDeleteAction();
}
