package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Role;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 22:38
 */
public class RoleEntityDAO extends AbstractEntityDAO<Role>{

	@Override
	public Class<Role> getDomainClass() {
		return Role.class;
	}
}
