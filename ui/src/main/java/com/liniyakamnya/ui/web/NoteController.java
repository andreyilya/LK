package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Note;
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

@Controller
public class NoteController {
	private static final String NOTE_ID = "noteId";
	private static final String NOTE = "NOTE";

	@Autowired
	@Named(Paramerers.NOTE_DAO)
	private EntityDAO<Note> noteEntityDAO;

	@RequestMapping(URLs.INDEX)
	public String listNotes(Map<String, Object> map) {
		map.put(Paramerers.NOTE, new Note());
		map.put(Paramerers.NOTE_LIST, noteEntityDAO.getAll());
		return URLs.INDEX_PAGE;
	}

	@RequestMapping("/")
	public String home() {
		return URLs.INDEX_REDIRECT;
	}


	@RequestMapping(value = URLs.ADD_NOTE, method = RequestMethod.POST)
	public
	@ResponseBody
	String addNote(@ModelAttribute(NOTE) Note note,
				   BindingResult result) {
		return noteEntityDAO.safeOrUpdate(note).toString();
	}


	@RequestMapping(URLs.DELETE_NOTE)
	public
	@ResponseBody
	String deleteNote(@PathVariable(NOTE_ID) Long noteId) {

		noteEntityDAO.delete(noteId);
		return URLs.INDEX_REDIRECT;
	}
}
