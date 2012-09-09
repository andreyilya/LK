package com.liniyakamnya.ui.web;

import com.google.gson.Gson;
import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.utils.Paramerers;
import com.liniyakamnya.ui.utils.URLs;

import java.util.Map;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APPLICATION_JSON = "application/json";

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

	@RequestMapping(value = URLs.ADD_USER, method = RequestMethod.POST)
	public
	@ResponseBody
	String addUser(@ModelAttribute(USER) User user,
				   BindingResult result) {
		//Correctly, it should be moved to service , byt for out small project it`s very lazy
		//to create service lajer. probably, it will be done.
		setRoles(user);
		return userEntityDAO.safeOrUpdate(user).toString();
	}

	private void setRoles(User user) {
		if (StringUtils.isNotEmpty(user.getRoless())) {
			for (String id : user.getRoless().split(",")) {
				user.getRoles().add(roleEntityDAO.findById(Long.parseLong(id)));
			}
		}

	}

	@RequestMapping(value = URLs.UPDATE_USER, method = RequestMethod.POST)
	public
	@ResponseBody
	void updateUser(@ModelAttribute(USER) User user,
					BindingResult result) {
		userEntityDAO.update(user);
	}

	@RequestMapping(value = URLs.GET_USER)
	public
	@ResponseBody
	ResponseEntity<String> getUser(@PathVariable(USER_ID) Long userId) {
		User user = userEntityDAO.findById(userId);
		return createJsonResponse(user);
	}

	@RequestMapping(URLs.DELETE_USER)
	public
	@ResponseBody
	String deleteUser(@PathVariable(USER_ID) Long userId) {

		userEntityDAO.delete(userId);
		return URLs.ADMIN_REDIRECT;
	}

	private ResponseEntity<String> createJsonResponse(Object o) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(CONTENT_TYPE, APPLICATION_JSON);
		Gson gson = new Gson();
		String json = gson.toJson(o);
		return new ResponseEntity<String>(json, headers, HttpStatus.CREATED);
	}

}
