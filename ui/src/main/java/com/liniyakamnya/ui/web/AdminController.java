package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.utils.Paramerers;
import com.liniyakamnya.ui.utils.URLs;
import java.util.Map;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 23:26
 */
@Controller
public class AdminController {

	private static final String USER = "user";
	private static final String USER_ID = "userId";

	@Autowired
	@Named(Paramerers.USER_DAO)
	private EntityDAO<User> userEntityDAO;

	@Autowired
	@Named(Paramerers.ROLE_DAO)
	private EntityDAO<Role> roleEntityDAO;

	@RequestMapping(URLs.ADMIN)
	public String listUsers(Map<String, Object> map) {
		map.put(Paramerers.USER, new User());
		map.put(Paramerers.ACTIONS, Actions.values());
		map.put(Paramerers.ROLES, roleEntityDAO.getAll());
		map.put(Paramerers.USER_LIST, userEntityDAO.getAll());
		return URLs.ADMIN_PAGE;
	}

	@RequestMapping(value = URLs.ADD, method = RequestMethod.POST)
	public
	@ResponseBody
	String addUser(@ModelAttribute(USER) User user,
				 BindingResult result) {
        user.getRoles().add(roleEntityDAO.findById(Long.parseLong(user.getRoless().split(",")[0])));
		return userEntityDAO.safeOrUpdate(user).toString();
	}

	@RequestMapping(URLs.DELETE_USER)
	public
	@ResponseBody
	String deleteUser(@PathVariable(USER_ID) Long userId) {

		userEntityDAO.delete(userId);
		return URLs.ADMIN_REDIRECT;
	}
}
