package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.exception.GuiException;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 25.08.12
 * Time: 19:18
 */
public interface Authentificator {
    User getUserByLogin(String login) throws GuiException;
}
