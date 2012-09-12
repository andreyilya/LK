package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * @author a.radkov
 *         Date: 12.09.12
 */
@Service
@Transactional
public class UserEntityService extends AbstractEntityService<User> {
    @Autowired
    @Named(Parameters.USER_DAO)
    private EntityDAO<User> userEntityDAO;

    @Override
    public EntityDAO<User> getEntityDAO() {
        return userEntityDAO;
    }
}
