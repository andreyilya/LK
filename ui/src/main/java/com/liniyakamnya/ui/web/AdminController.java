package com.liniyakamnya.ui.web;

import com.google.gson.Gson;
import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.service.EntityService;
import com.liniyakamnya.ui.utils.Parameters;
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
    @Named(Parameters.USER_SERVICE)
	private EntityService<User> userEntityService;

	@Autowired
	@Named(Parameters.ROLE_DAO)
	private EntityDAO<Role> roleEntityDAO;

	@RequestMapping(URLs.ADMIN)
	public String listUsers(Map<String, Object> map) {
		map.put(Parameters.USER, new User());
		map.put(Parameters.ACTIONS, Actions.values());
		map.put(Parameters.ROLES, roleEntityDAO.getAll());
		map.put(Parameters.USER_LIST, userEntityService.getAll());
		return URLs.ADMIN_PAGE;
	}

	@RequestMapping(value = URLs.ADD_USER, method = RequestMethod.POST)
	public
	@ResponseBody
	String addUser(@ModelAttribute(USER) User user,
				   BindingResult result) {
		return userEntityService.safeOrUpdate(user).toString();
	}

	@RequestMapping(value = URLs.UPDATE_USER, method = RequestMethod.POST)
	public
	@ResponseBody
	void updateUser(@ModelAttribute(USER) User user,
					BindingResult result) {
		userEntityService.update(user);
	}

	@RequestMapping(value = URLs.GET_USER)
	public
	@ResponseBody
	ResponseEntity<String> getUser(@PathVariable(USER_ID) Long userId) {
		User user = userEntityService.findById(userId);
		return createJsonResponse(user);
	}

	@RequestMapping(URLs.DELETE_USER)
	public
	@ResponseBody
	String deleteUser(@PathVariable(USER_ID) Long userId) {

		userEntityService.delete(userId);
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
