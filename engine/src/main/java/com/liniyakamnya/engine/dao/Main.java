package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.User;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
public class Main {
    public static void main(String[] args){
        UserEntityDao userEntityDao = new UserEntityDao();
        userEntityDao.create(new User());
    }
}
