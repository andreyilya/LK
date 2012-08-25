package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Authority;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 22:38
 */
public class AuthorityEntityDAO extends AbstractEntityDAO<Authority>{


	@Override
	public Class<Authority> getDomainClass() {
		return Authority.class;
	}
}
