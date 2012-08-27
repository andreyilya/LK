package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.utils.Paramerers;
import com.liniyakamnya.ui.utils.URLs;
import java.util.Map;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	@Named("userDao")
	private EntityDAO userEntityDAO;

	@RequestMapping(URLs.INDEX)
	public String listUsers(Map<String, Object> map) {

		map.put(Paramerers.userList, userEntityDAO.getAll());
		return URLs.INDEX_PAGE;
	}

	@RequestMapping("/")
	public String home() {
		return URLs.INDEX_REDIRECT;
	}

//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addContact(@ModelAttribute("contact") Contact contact,
//			BindingResult result) {
//
//		contactService.addContact(contact);
//
//		return "redirect:/index";
//	}

//	@RequestMapping("/delete/{contactId}")
//	public String deleteContact(@PathVariable("contactId") Integer contactId) {
//
//		contactService.removeContact(contactId);
//
//		return "redirect:/index";
//	}
}
