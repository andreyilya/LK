package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Note;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 31.08.12
 * Time: 18:37
 */
@Transactional
@Repository(Parameters.NOTE_DAO)
public class NoteEntityDAO extends AbstractEntityDAO<Note> {
    @Override
    public Class<Note> getDomainClass() {
        return Note.class;
    }
}
