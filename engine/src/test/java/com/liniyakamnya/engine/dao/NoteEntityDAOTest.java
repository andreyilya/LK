package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Category;
import com.liniyakamnya.engine.entities.Note;
import com.liniyakamnya.engine.entities.SubCategory;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author a.radkov
 *         Date: 19.07.12
 */
public class NoteEntityDAOTest {
	private static CategoryEntityDAO categoryEntityDAO = new CategoryEntityDAO();
	private static SubCategoryEntityDAO subCategoryEntityDAO = new SubCategoryEntityDAO();
	private static NoteEntityDAO noteEntityDAO = new NoteEntityDAO();

	@Test
	public void testCreate() throws Exception {
		noteEntityDAO.create(new Note());
	}


	@Test
	public void testSafeOrUpdate() throws Exception {
		Category category = new Category();
		category.setName("testCategory");
		Category createdCategory = categoryEntityDAO.safeOrUpdate(category);

		SubCategory subCategory = new SubCategory();
		subCategory.setName("testSubCategory");
		subCategory.setCategory(createdCategory);
		SubCategory createdSubCategory = subCategoryEntityDAO.safeOrUpdate(subCategory);

		createdCategory.getSubCategories().add(createdSubCategory);
		Category updatedCategory = categoryEntityDAO.safeOrUpdate(createdCategory);

		Note note = new Note();
		note.setCreatedDate(new Date());
		note.setCategory(updatedCategory);
		note.setSubCategory(createdSubCategory);

		Note createdNote = noteEntityDAO.safeOrUpdate(note);
		assertNotNull(createdNote);
		assertNotNull(createdNote.getCreatedDate());
		assertNotNull(createdNote.getCategory());
		assertNotNull(createdNote.getSubCategory());
		deleteNote(note);
		deleteSubCategory(createdSubCategory);
		categoryEntityDAO.delete(updatedCategory);
	}

	@Test
	public void testFindById() throws Exception {
		Note note = new Note();
		Long id = noteEntityDAO.safeOrUpdate(note).getId();
		Note created = noteEntityDAO.findById(id);
		assertNotNull(created);

		deleteNote(created);
	}


	@Test
	public void testGetAll() throws Exception {
		List<Note> notes = noteEntityDAO.getAll();

		assertNotNull(notes);
	}

	@Test
	public void testGetDomainClass() throws Exception {
		assertEquals(Note.class, noteEntityDAO.getDomainClass());
	}

	private void deleteNote(Note created) {
		noteEntityDAO.delete(created);
	}

	private void deleteSubCategory(SubCategory subCategory) {
		subCategoryEntityDAO.delete(subCategory);
	}
}
