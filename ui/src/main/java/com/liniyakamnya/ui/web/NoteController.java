package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Note;
import com.liniyakamnya.ui.utils.Paramerers;
import com.liniyakamnya.ui.utils.URLs;
import java.util.Map;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoteController {
	private static final String NOTE_ID = "noteId";

	@Autowired
	@Named(Paramerers.noteDao)
	private EntityDAO<Note> noteEntityDAO;

	@RequestMapping(URLs.INDEX)
	public String listNotes(Map<String, Object> map) {
		map.put(Paramerers.noteList, noteEntityDAO.getAll());
		map.put(Paramerers.note, new Note());
		return URLs.INDEX_PAGE;
	}

	@RequestMapping("/")
	public String home() {
		return URLs.INDEX_REDIRECT;
	}


	@RequestMapping(URLs.DELETE_NOTE)
	public
	@ResponseBody
	String deleteNote(@PathVariable(NOTE_ID) Long noteId) {

		noteEntityDAO.delete(noteId);
		return URLs.INDEX_REDIRECT;
	}
}
