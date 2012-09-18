package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.entities.Category;
import com.liniyakamnya.ui.service.EntityService;
import com.liniyakamnya.ui.utils.Parameters;
import com.liniyakamnya.ui.utils.URLs;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author a.radkov
 *         Date: 14.09.12
 */
@Controller
public class CategoryController {

    private static final String CATEGORY_ID = "categoryId";
    @Inject
    @Named(Parameters.CATEGORY_SERVICE)
    private EntityService<Category> categoryEntityService;

    @RequestMapping(value = URLs.ADD_CATEGORY, method = RequestMethod.POST)
    public
    @ResponseBody
    String addCategory(@ModelAttribute(Parameters.CATEGORY) Category category,
                       BindingResult result) {
        return categoryEntityService.safeOrUpdate(category).toString();
    }

    @RequestMapping(value = URLs.UPDATE_CATEGORY, method = RequestMethod.POST)
    public
    @ResponseBody
    String updateCategory(@ModelAttribute(Parameters.CATEGORY) Category category,
                          BindingResult result) {
        return categoryEntityService.update(category).toString();
    }

    @RequestMapping(value = URLs.GET_CATEGORY)
    public
    @ResponseBody
    ResponseEntity<String> getCategory(@PathVariable(CATEGORY_ID) Long categoryId) {
        Category category = new Category();
        Category findedCategory = categoryEntityService.findById(categoryId);
        category.setName(findedCategory.getName());
        category.setId(findedCategory.getId());
        return Json.createJsonResponse(category);
    }

    @RequestMapping(value = URLs.DELETE_CATEGORY)
    public String deleteCategory(@PathVariable(CATEGORY_ID) Long categoryId) {
        categoryEntityService.delete(categoryId);
        return URLs.INDEX_REDIRECT;
    }
}
