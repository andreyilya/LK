package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.SubCategory;
import com.liniyakamnya.ui.utils.Parameters;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author a.radkov
 *         Date: 14.09.12
 */
@Repository(Parameters.SUB_CATEGORY_DAO)
@Transactional
public class SubCategoriEntityDAO extends AbstractEntityDAO<SubCategory>{
    @Override
    public Class<SubCategory> getDomainClass() {
        return SubCategory.class;
    }
}
