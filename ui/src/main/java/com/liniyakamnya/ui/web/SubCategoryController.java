package com.liniyakamnya.ui.web;

import com.liniyakamnya.ui.entities.Category;
import com.liniyakamnya.ui.entities.SubCategory;
import com.liniyakamnya.ui.service.EntityService;
import com.liniyakamnya.ui.utils.Parameters;
import com.liniyakamnya.ui.utils.URLs;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 16.09.12
 * Time: 15:35
 */
@Controller
public class SubCategoryController {
	private static final String SUB_CATEGORY_ID = "subCategoryId";

	@Inject
	@Named(Parameters.SUB_CATEGORY_SERVICE)
	private EntityService<SubCategory> subCategoryEntityService;

	@Inject
	@Named(Parameters.CATEGORY_SERVICE)
	private EntityService<Category> categoryEntityService;

	@RequestMapping(value = URLs.ADD_SUB_CATEGORY, method = RequestMethod.POST)
	public
	@ResponseBody
	String addSubCategory(@ModelAttribute(Parameters.CATEGORY) SubCategory subCategory,
					   BindingResult result) {
        Category category = categoryEntityService.findById(subCategory.getCategory().getId());
        subCategory.setCategory(category);
		return subCategoryEntityService.safeOrUpdate(subCategory).toString();
	}

	@RequestMapping(value = URLs.UPDATE_SUB_CATEGORY, method = RequestMethod.POST)
	public
	@ResponseBody
	String updateSubCategory(@ModelAttribute(Parameters.SUB_CATEGORY) SubCategory subCategory,
							 BindingResult result) {
		return subCategoryEntityService.update(subCategory).toString();
	}

	@RequestMapping(value = URLs.GET_SUB_CATEGORY)
	public
	@ResponseBody
	ResponseEntity<String> getSubCategory(@PathVariable(SUB_CATEGORY_ID) Long subCategoryId) {
		SubCategory subCategory = subCategoryEntityService.findById(subCategoryId);
		return Json.createJsonResponse(subCategory);
	}

	@RequestMapping(value = URLs.DELETE_SUB_CATEGORY)
	public String deleteSubCategory(@PathVariable(SUB_CATEGORY_ID) Long subCategoryId) {

		subCategoryEntityService.delete(subCategoryId);
		return URLs.INDEX_REDIRECT;
	}
}
