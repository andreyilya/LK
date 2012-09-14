package com.liniyakamnya.ui.utils;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 23:54
 */
public final class URLs {
    private URLs() {

    }

    public static final String INDEX = "/index";

    public static final String INDEX_REDIRECT = "redirect:/index";
    public static final String INDEX_PAGE = "note";
    public static final String ADMIN = "/admin";

    public static final String ADMIN_PAGE = "admin";
    public static final String ADMIN_REDIRECT = "redirect:/admin";

    public static final String ADD_USER = "/add";
    public static final String DELETE_USER = "/delete/{userId}";
    public static final String UPDATE_USER = "update";
    public static final String GET_USER = "/getUser/{userId}";

    public static final String DELETE_NOTE = "/deleteNote/{noteId}";
    public static final String ADD_NOTE = "/addNote";
    public static final String GET_NOTE = "/getNote/{noteId}";
    public static final String UPDATE_NOTE = "updateNote";

	public static final String ADD_CATEGORY = "addCategory";


}
