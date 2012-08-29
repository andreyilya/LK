package com.liniyakamnya.ui.entities;

/**
 * @author a.radkov
 *         Date: 24.07.12
 */
public enum Actions {
	CREATE_USER("createUser"),
	CREATE_NOTE("createNote"),
	CREATE_CATEGORY("createCategory"),
	CREATE_SUB_CATEGORY("createSubCategory"),


	UPDATE_USER("updateUser"),
	UPDATE_NOTE("updateNote"),
	UPDATE_CATEGORY("updateCategory"),
	UPDATE_SUB_CATEGORY("updateSubCategory"),

	DELETE_USER("deleteUser"),
	DELETE_NOTE("deleteNote"),
	DELETE_CATEGORY("deleteCategory"),
	DELETE_SUB_CATEGORY("deleteSubCategory");


	private String field;

	private Actions(String field) {
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
