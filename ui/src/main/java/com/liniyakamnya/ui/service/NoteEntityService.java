package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.Note;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 12.09.12
 * Time: 23:01
 */
@Service(Parameters.NOTE_SERVICE)
@Transactional
public class NoteEntityService extends AbstractEntityService<Note> {
    @Inject
    @Named(Parameters.NOTE_DAO)
    private EntityDAO<Note> noteEntityDAO;


    @Override
    public EntityDAO<Note> getEntityDAO() {
        return noteEntityDAO;
    }

    @Override
    public Actions getCreateAction() {
        return Actions.CREATE_NOTE;
    }

    @Override
    public Actions getUpdateAction() {
        return Actions.UPDATE_NOTE;
    }

    @Override
    public Actions getDeleteAction() {
        return Actions.DELETE_NOTE;
    }
}
