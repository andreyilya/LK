package com.liniyakamnya.ui.security;

import com.liniyakamnya.ui.dao.RoleEntityDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 22:15
 */
public class StartupServlet extends HttpServlet {
	@Override
	public void init()
			throws ServletException {
		super.init();
		WebApplicationContext springContext =
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		RoleEntityDAO entityDAO = (RoleEntityDAO) springContext.getBean("roleDao");
		entityDAO.initRoles();
	}
}
