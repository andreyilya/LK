package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.security.Roles;
import com.liniyakamnya.ui.utils.Paramerers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 22:38
 */
@Transactional
@Repository
@Service(Paramerers.ROLE_DAO)
public class RoleEntityDAO extends AbstractEntityDAO<Role> implements RoleConfigurator {

    @Override
    public void initRoles() {
        createRoles();
    }

    private void createRoles() {
        if (getAll().isEmpty()) {
            for (Roles role : Roles.values()) {
                Role roleEntity = new Role();
                roleEntity.setRoleName(role.name());
                super.create(roleEntity);
            }
        }
    }

    @Override
    public Class<Role> getDomainClass() {
        return Role.class;
    }
}
