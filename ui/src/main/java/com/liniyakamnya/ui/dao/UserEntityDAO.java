package com.liniyakamnya.ui.dao;

import com.liniyakamnya.ui.entities.Role;
import com.liniyakamnya.ui.entities.User;
import com.liniyakamnya.ui.exception.GuiException;

import java.util.ArrayList;
import java.util.List;

import com.liniyakamnya.ui.utils.Parameters;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Repository(Parameters.USER_DAO)
@Transactional
public class UserEntityDAO extends AbstractEntityDAO<User> implements Authentificator {

    private static final String USER_BY_LOGIN = "user.byLogin";
    private static final String LOGIN = "login";


    @Override
    public Long update(User entity) {
        return super.update(entity);
    }

    @Override
    public Long safeOrUpdate(User entity) {
        try {
            getUserByLogin(entity.getLogin());
            return (long) -1;
        } catch (GuiException e) {
            return super.safeOrUpdate(entity);
        }

    }

    @Override
    public User findById(Long id) {
        User user = (User) getSessionFactory().getCurrentSession().get(
                getDomainClass(), id);
        user.setRoles(new ArrayList<Role>(user.getRoles()));
        return user;
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    public User getUserByLogin(String login) throws GuiException {
        try {
            Session session = getSessionFactory().getCurrentSession();
            Query query = session.getNamedQuery(USER_BY_LOGIN);
            query.setString(LOGIN, login);
            List<User> list = query.list();
            return list.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new GuiException(e.getMessage());
        }
    }


    @Override
    public Class<User> getDomainClass() {
        return User.class;
    }
}
