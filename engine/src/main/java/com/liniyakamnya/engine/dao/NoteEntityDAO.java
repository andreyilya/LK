package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.Note;

import java.util.List;

/**
 * @author a.radkov
 *         Date: 19.07.12
 */
public class NoteEntityDAO extends AbstractEntityDAO<Note> {
    @Override
    public void create(Note entity) {
        super.create(entity);
    }

    @Override
    public void update(Note entity) {
        super.update(entity);
    }

    @Override
    public void delete(Note entity) {
        super.delete(entity);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public Note safeOrUpdate(Note entity) {
        return super.safeOrUpdate(entity);
    }

    @Override
    public Note findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Note> getAll() {
        return super.getAll();
    }

    @Override
    public Class<Note> getDomainClass() {
        return Note.class;
    }
}
