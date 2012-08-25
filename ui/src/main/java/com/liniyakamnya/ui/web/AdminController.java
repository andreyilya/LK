package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.dao.EntityDAO;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 23:26
 */
@Controller
public class AdminController {

	@Autowired
	private EntityDAO userEntityDAO;

	@RequestMapping("/admin")
	public String listUsers(Map<String, Object> map) {

		map.put("userList", userEntityDAO.getAll());
		return "admin";
	}
}
