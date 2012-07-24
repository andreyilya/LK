package com.liniyakamnya.engine.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author a.radkov
 *         Date: 19.07.12
 */
@Embeddable
public class ActionsForEmail {
    private boolean createUser;
    private boolean updateUser;
    private boolean deleteUser;

    private boolean createNote = true;
    private boolean updateNote = true;
    private boolean deleteNote = true;

    private boolean createCategory;
    private boolean updateCategory;
    private boolean deleteCategory;

    private boolean createSubCategory;
    private boolean updateSubCategory;
    private boolean deleteSubCategory;

    private transient Map<Actions, Boolean> actions = new HashMap<Actions, Boolean>();

    @Column
    public boolean isCreateUser() {
        return createUser;
    }

    public void setCreateUser(boolean createUser) {
        this.createUser = createUser;
        actions.put(Actions.CREATE_USER, createUser);
    }

    @Column
    public boolean isUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(boolean updateUser) {
        this.updateUser = updateUser;
        actions.put(Actions.UPDATE_USER, updateUser);
    }

    @Column
    public boolean isDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(boolean deleteUser) {
        this.deleteUser = deleteUser;
        actions.put(Actions.DELETE_USER, deleteUser);
    }

    @Column
    public boolean isCreateNote() {
        return createNote;
    }

    public void setCreateNote(boolean createNote) {
        this.createNote = createNote;
        actions.put(Actions.CREATE_NOTE, createNote);
    }

    @Column
    public boolean isUpdateNote() {
        return updateNote;
    }

    public void setUpdateNote(boolean updateNote) {
        this.updateNote = updateNote;
        actions.put(Actions.UPDATE_NOTE, updateNote);
    }

    @Column
    public boolean isDeleteNote() {
        return deleteNote;
    }

    public void setDeleteNote(boolean deleteNote) {
        this.deleteNote = deleteNote;
        actions.put(Actions.UPDATE_NOTE, deleteNote);
    }

    @Column
    public boolean isCreateCategory() {
        return createCategory;
    }

    public void setCreateCategory(boolean createCategory) {
        this.createCategory = createCategory;
        actions.put(Actions.CREATE_CATEGORY, createCategory);
    }

    @Column
    public boolean isUpdateCategory() {
        return updateCategory;
    }

    public void setUpdateCategory(boolean updateCategory) {
        this.updateCategory = updateCategory;
        actions.put(Actions.UPDATE_CATEGORY, updateCategory);
    }

    @Column
    public boolean isDeleteCategory() {
        return deleteCategory;
    }

    public void setDeleteCategory(boolean deleteCategory) {
        this.deleteCategory = deleteCategory;
        actions.put(Actions.DELETE_CATEGORY, deleteCategory);
    }

    @Column
    public boolean isCreateSubCategory() {
        return createSubCategory;
    }

    public void setCreateSubCategory(boolean createSubCategory) {
        this.createSubCategory = createSubCategory;
        actions.put(Actions.CREATE_SUB_CATEGORY, createSubCategory);
    }

    @Column
    public boolean isUpdateSubCategory() {
        return updateSubCategory;
    }

    public void setUpdateSubCategory(boolean updateSubCategory) {
        this.updateSubCategory = updateSubCategory;
        actions.put(Actions.UPDATE_SUB_CATEGORY, updateSubCategory);
    }

    @Column
    public boolean isDeleteSubCategory() {
        return deleteSubCategory;
    }

    public void setDeleteSubCategory(boolean deleteSubCategory) {
        this.deleteSubCategory = deleteSubCategory;
        actions.put(Actions.DELETE_SUB_CATEGORY, deleteSubCategory);
    }

    public boolean isProtocol(Actions action) {
        return actions.get(action);
    }
}
