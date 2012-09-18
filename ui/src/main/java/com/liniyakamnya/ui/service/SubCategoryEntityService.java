package com.liniyakamnya.ui.service;

import com.liniyakamnya.ui.dao.EntityDAO;
import com.liniyakamnya.ui.entities.Actions;
import com.liniyakamnya.ui.entities.Category;
import com.liniyakamnya.ui.entities.SubCategory;
import com.liniyakamnya.ui.utils.Parameters;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author a.radkov
 *         Date: 13.09.12
 */
@Service(Parameters.SUB_CATEGORY_SERVICE)
@Transactional
public class SubCategoryEntityService extends AbstractEntityService<SubCategory> {
    @Inject
    @Named(Parameters.SUB_CATEGORY_DAO)
    private EntityDAO<SubCategory> subCategoryEntityDAO;

	@Inject
	@Named(Parameters.CATEGORY_DAO)
	private EntityDAO<Category> categoryEntityDAO;

	@Override
	public void delete(Long id) {
		SubCategory subCategory =  subCategoryEntityDAO.findById(id);
		Category category = subCategory.getCategory();
		category.getSubCategories().remove(subCategory);
		categoryEntityDAO.update(category);
	}

    @Override
    public Long update(SubCategory entity) {
        SubCategory subCategory = findById(entity.getId());
        subCategory.setUsdPrice(entity.getUsdPrice());
        subCategory.setRubPrice(entity.getRubPrice());
        subCategory.setName(entity.getName());
        return super.update(subCategory);
    }

    @Override
    public EntityDAO<SubCategory> getEntityDAO() {
        return subCategoryEntityDAO;
    }

    @Override
    public Actions getCreateAction() {
        return Actions.CREATE_SUB_CATEGORY;
    }

    @Override
    public Actions getUpdateAction() {
        return Actions.UPDATE_SUB_CATEGORY;
    }

    @Override
    public Actions getDeleteAction() {
        return Actions.DELETE_SUB_CATEGORY;
    }
}
