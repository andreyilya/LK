package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.utils.Parameters;
import org.apache.commons.lang.StringUtils;
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

    @Autowired
    @Named(Parameters.ROLE_DAO)
    private EntityDAO<Role> roleEntityDAO;

    @Override
    public EntityDAO<User> getEntityDAO() {
        return userEntityDAO;
    }

    @Override
    public void update(User user){
        setRoles(user);
        super.update(user);
    }

    @Override
    public Long safeOrUpdate(User user) {
        setRoles(user);
        return super.safeOrUpdate(user);
    }

    private void setRoles(User user) {
        if (StringUtils.isNotEmpty(user.getRoless())) {
            for (String id : user.getRoless().split(",")) {
                user.getRoles().add(roleEntityDAO.findById(Long.parseLong(id)));
            }
        }

    }
}
