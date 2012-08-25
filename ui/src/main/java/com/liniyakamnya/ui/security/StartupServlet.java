package com.liniyakamnya.ui.security;

import com.liniyakamnya.ui.dao.UserEntityDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public void doGet(HttpServletRequest reqest, HttpServletResponse response)
			throws ServletException, IOException {
		WebApplicationContext springContext =
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		UserEntityDAO entityDAO = (UserEntityDAO) springContext.getBean("UserEntityDAO");
		System.out.print(entityDAO.getAll().get(0));
	}
}
