package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.exception.GuiException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 20.08.12
 * Time: 18:51
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private Authentificator userService;

	/**
	 * Load user with authority by username.
	 *
	 * @param username the string name of the user.
	 * @return authentication user object.
	 * @throws org.springframework.security.core.userdetails.UsernameNotFoundException in case
	 * @throws org.springframework.dao.DataAccessException       in case of data access exception ocurred.
	 */
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		try {
			User user = userService.getUserByLogin(username);
			final String email = user.getEmail();
			Set<GrantedAuthority> gAuthorities = new HashSet<GrantedAuthority>();
//			for (final String authority : user.getAuthorites()) {
//				gAuthorities.add(new GrantedAuthority() {
//					@Override
//					public String getAuthority() {
//						return authority;
//					}
//				});
//			}

			gAuthorities.add(new GrantedAuthority() {
					@Override
					public String getAuthority() {

						return email;
					}
				});

			return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true, true, true, gAuthorities);
		} catch (GuiException e) {
			throw new UsernameNotFoundException(e.getLocalizedMessage());
		}
	}

}

