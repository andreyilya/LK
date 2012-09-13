package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.Category;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

/**
 * @author a.radkov
 *         Date: 13.09.12
 */
@Service(Parameters.CATEGORY_SERVICE)
@Transactional
public class CategoryEntityService  extends AbstractEntityService<Category> {
    @Autowired
    @Named(Parameters.CATEGORY_DAO)
    private EntityDAO<Category> noteEntityDAO;


    @Override
    public EntityDAO<Category> getEntityDAO() {
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
