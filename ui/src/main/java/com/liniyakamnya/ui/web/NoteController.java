package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.entities.Category;
import com.liniyakamnya.ui.entities.Note;
import com.liniyakamnya.ui.entities.SubCategory;
import com.liniyakamnya.ui.service.EntityService;
import com.liniyakamnya.ui.utils.Parameters;
import com.liniyakamnya.ui.utils.URLs;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Controller
public class NoteController {
    private static final String NOTE_ID = "noteId";
    private static final String NOTE = "NOTE";

    @Inject
    @Named(Parameters.NOTE_SERVICE)
    private EntityService<Note> noteEntityService;

    @Inject
    @Named(Parameters.CATEGORY_SERVICE)
    private EntityService<Category> categoryEntityService;

    @RequestMapping(URLs.INDEX)
    public String listNotes(Map<String, Object> map) {
        map.put(Parameters.NOTE, new Note());
        map.put(Parameters.CATEGORY, new Category());
        SubCategory subCategory = new SubCategory();
        subCategory.setCategory(new Category());
        map.put(Parameters.SUB_CATEGORY, subCategory);
        map.put(Parameters.NOTE_LIST, noteEntityService.getAll());
        map.put(Parameters.CATEGORY_LIST, categoryEntityService.getAll());
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
        validateCategoryId(note);
        return noteEntityService.safeOrUpdate(note).toString();
    }

    private void validateCategoryId(Note note) {
        if (note.getCategory().getId() < 0) {
            note.setCategory(null);
        }
    }

    @RequestMapping(value = URLs.UPDATE_NOTE, method = RequestMethod.POST)
    public
    @ResponseBody
    String updateNote(@ModelAttribute(NOTE) Note note,
                      BindingResult result) {
        validateCategoryId(note);
        return noteEntityService.update(note).toString();
    }

    @RequestMapping(URLs.DELETE_NOTE)
    public
    @ResponseBody
    String deleteNote(@PathVariable(NOTE_ID) Long noteId) {

        noteEntityService.delete(noteId);
        return URLs.INDEX_REDIRECT;
    }

    @RequestMapping(value = URLs.GET_NOTE)
    public
    @ResponseBody
    ResponseEntity<String> getNote(@PathVariable(NOTE_ID) Long noteId) {
        Note note = noteEntityService.findById(noteId);
        if (note.getCategory() != null) {
            note.getCategory().setSubCategories(null);
        }
        return Json.createJsonResponse(note);
    }
}
