package com.liniyakamnya.engine.dao;

import com.liniyakamnya.engine.entities.User;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Transactional
@Repository("userDao")
public class UserEntityDAO extends AbstractEntityDAO<User> {
    @Override
    public void create(User entity) {
        super.create(entity);
    }

    @Override
    public void update(User entity) {
        super.update(entity);
    }

    @Override
	public void delete(User entity) {
        super.delete(entity);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public User safeOrUpdate(User entity) {
        return super.safeOrUpdate(entity);
    }

    @Override
    public User findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

	public User getUserByLogin(String login){
		getEntityManager().getTransaction().begin();
		Query query =
				getEntityManager().createNamedQuery("user.byLogin");
		query.setParameter("login", login);
		User user = new User();
		List list = query.getResultList();
		if(!list.isEmpty()) {
			user = (User)list.get(0);
		}
		getEntityManager().getTransaction().commit();
		return user;
	}


    @Override
    public Class<User> getDomainClass() {
        return User.class;
    }
}
