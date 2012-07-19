package com.liniyakamnya.engine.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

    @Column
    public boolean isCreateUser() {
        return createUser;
    }

    public void setCreateUser(boolean createUser) {
        this.createUser = createUser;
    }

    @Column
    public boolean isUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(boolean updateUser) {
        this.updateUser = updateUser;
    }

    @Column
    public boolean isDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(boolean deleteUser) {
        this.deleteUser = deleteUser;
    }

    @Column
    public boolean isCreateNote() {
        return createNote;
    }

    public void setCreateNote(boolean createNote) {
        this.createNote = createNote;
    }

    @Column
    public boolean isUpdateNote() {
        return updateNote;
    }

    public void setUpdateNote(boolean updateNote) {
        this.updateNote = updateNote;
    }

    @Column
    public boolean isDeleteNote() {
        return deleteNote;
    }

    public void setDeleteNote(boolean deleteNote) {
        this.deleteNote = deleteNote;
    }

    @Column
    public boolean isCreateCategory() {
        return createCategory;
    }

    public void setCreateCategory(boolean createCategory) {
        this.createCategory = createCategory;
    }

    @Column
    public boolean isUpdateCategory() {
        return updateCategory;
    }

    public void setUpdateCategory(boolean updateCategory) {
        this.updateCategory = updateCategory;
    }

    @Column
    public boolean isDeleteCategory() {
        return deleteCategory;
    }

    public void setDeleteCategory(boolean deleteCategory) {
        this.deleteCategory = deleteCategory;
    }

    @Column
    public boolean isCreateSubCategory() {
        return createSubCategory;
    }

    public void setCreateSubCategory(boolean createSubCategory) {
        this.createSubCategory = createSubCategory;
    }

    @Column
    public boolean isUpdateSubCategory() {
        return updateSubCategory;
    }

    public void setUpdateSubCategory(boolean updateSubCategory) {
        this.updateSubCategory = updateSubCategory;
    }

    @Column
    public boolean isDeleteSubCategory() {
        return deleteSubCategory;
    }

    public void setDeleteSubCategory(boolean deleteSubCategory) {
        this.deleteSubCategory = deleteSubCategory;
    }
}
