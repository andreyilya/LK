package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.utils.Paramerers;
import com.liniyakamnya.ui.utils.URLs;
import java.util.Map;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 23:26
 */
@Controller
public class AdminController {

	@Autowired
	@Named("userDao")
	private EntityDAO userEntityDAO;

	@RequestMapping(URLs.ADMIN)
	public String listUsers(Map<String, Object> map) {
		map.put(Paramerers.userList, userEntityDAO.getAll());
		return URLs.ADMIN_PAGE;
	}

	@RequestMapping("/delete/{userId}")
	public
	@ResponseBody
	String deleteUser(@PathVariable("userId") Long userId) {
		userEntityDAO.delete(userId);
		return URLs.ADMIN_REDIRECT;
	}
}
