package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Note;
import com.liniyakamnya.ui.utils.Paramerers;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 31.08.12
 * Time: 18:37
 */
@Transactional
@Repository(Paramerers.noteDao)
@Service(Paramerers.noteDao)
public class NoteEntityDAO extends AbstractEntityDAO<Note>{
	@Override
	public Class<Note> getDomainClass() {
		return Note.class;
	}
}