package com.liniyakamnya.ui.entities;

/**
 * @author a.radkov
 *         Date: 24.07.12
 */
public enum Actions {
    CREATE_USER("createUser"),
    UPDATE_USER("updateUser"),
    DELETE_USER("deleteUser"),

    CREATE_NOTE("createNote"),
    UPDATE_NOTE("updateNote"),
    DELETE_NOTE("deleteNote"),

    CREATE_CATEGORY("createCategory"),
    UPDATE_CATEGORY("updateCategory"),
    DELETE_CATEGORY("deleteCategory"),

    CREATE_SUB_CATEGORY("createSubCategory"),
    UPDATE_SUB_CATEGORY("updateSubCategory"),
    DELETE_SUB_CATEGORY("deleteSubCategory");
	private  String field;

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
