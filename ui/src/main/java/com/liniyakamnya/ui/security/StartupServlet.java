package com.liniyakamnya.ui.security;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.dao.RoleConfigurator;

import javax.inject.Named;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 22:15
 */
public class StartupServlet extends HttpServlet {
    @Autowired
    RoleConfigurator roleEntityDAO;

    @Autowired
    @Named(value = Parameters.ROLE_DAO)
    EntityDAO<Role> rolesEntityDAO;

    @Autowired
    @Named(value = Parameters.USER_DAO)
    EntityDAO<User> userEntityDAO;

    @Override
    public void init(ServletConfig config)
            throws ServletException {
        super.init();

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());

        roleEntityDAO.initRoles();

        if (userEntityDAO.getAll().isEmpty()) {
            User user = new User();
            user.setLogin("admin");
            user.setPassword("admin");
            user.setRoles(rolesEntityDAO.getAll());
            userEntityDAO.safeOrUpdate(user);
        }
    }
}
