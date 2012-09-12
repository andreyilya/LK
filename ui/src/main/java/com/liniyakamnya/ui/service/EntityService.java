package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityActions;
import com.liniyakamnya.ui.dao.EntityDAO;

import java.io.Serializable;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
public interface EntityService <T extends Serializable> extends EntityActions<T> {
    public EntityDAO<T> getEntityDAO();
}
