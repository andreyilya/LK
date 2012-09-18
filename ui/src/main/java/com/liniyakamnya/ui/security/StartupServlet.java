package com.liniyakamnya.ui.security;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.dao.RoleConfigurator;
import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.service.EntityService;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 22:15
 */
public class StartupServlet extends HttpServlet {
    @Inject
    private RoleConfigurator roleEntityDAO;

    @Inject
    @Named(value = Parameters.ROLE_DAO)
    private EntityDAO<Role> rolesEntityDAO;

    @Inject
    @Named(value = Parameters.USER_SERVICE)
    private EntityService<User> userEntityService;

    @Override
    public void init(ServletConfig config)
            throws ServletException {
        super.init();

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());

        roleEntityDAO.initRoles();

        if (userEntityService.getAll().isEmpty()) {
            User user = new User();
            user.setLogin("admin");
            user.setPassword("admin");
            user.setRoles(rolesEntityDAO.getAll());
            userEntityService.safeOrUpdate(user);
        }
    }
}
