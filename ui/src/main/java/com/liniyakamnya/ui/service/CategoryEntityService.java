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
    private EntityDAO<Category> categoryEntityDAO;

	@Override
	public Long update(Category entity) {
		Category oldCategory = findById(entity.getId());
		oldCategory.setName(entity.getName());
		return super.update(oldCategory);
	}

	@Override
    public EntityDAO<Category> getEntityDAO() {
        return categoryEntityDAO;
    }

    @Override
    public Actions getCreateAction() {
        return Actions.CREATE_CATEGORY;
    }

    @Override
    public Actions getUpdateAction() {
        return Actions.UPDATE_CATEGORY;
    }

    @Override
    public Actions getDeleteAction() {
        return Actions.DELETE_CATEGORY;
    }
}
