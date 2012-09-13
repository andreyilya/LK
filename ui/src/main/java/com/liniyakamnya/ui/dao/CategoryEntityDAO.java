package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Category;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 12.09.12
 * Time: 22:59
 */
@Repository(Parameters.CATEGORY_DAO)
@Transactional
public class CategoryEntityDAO extends AbstractEntityDAO<Category> {
    @Override
    public Class<Category> getDomainClass() {
        return Category.class;
    }
}
