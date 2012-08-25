package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.dao.EntityDAO;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	private EntityDAO userEntityDAO;

	@RequestMapping("/index")
	public String listUsers(Map<String, Object> map) {

		map.put("userList", userEntityDAO.getAll());
		return "user";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
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
