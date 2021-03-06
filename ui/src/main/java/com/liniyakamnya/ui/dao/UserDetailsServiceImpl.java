package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.exception.GuiException;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 20.08.12
 * Time: 18:51
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Inject
    private Authentificator userService;

    /**
     * Load user with authority by username.
     *
     * @param username the string name of the user.
     * @return authentication user object.
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *          in case
     * @throws org.springframework.dao.DataAccessException
     *          in case of data access exception ocurred.
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        try {
            User user = userService.getUserByLogin(username);
            Set<GrantedAuthority> gAuthorities = new HashSet<GrantedAuthority>();
            for (final Role authority : user.getRoles()) {
                gAuthorities.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return authority.getRoleName();
                    }
                });
            }

            return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true,
                    true, true, gAuthorities);
        } catch (GuiException e) {
            throw new UsernameNotFoundException(e.getLocalizedMessage());
        }
    }

}

