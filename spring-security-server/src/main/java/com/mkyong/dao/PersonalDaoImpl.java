package com.mkyong.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Personal;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;

@Repository
public class PersonalDaoImpl implements PersonalDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addPersonal(Personal personal) {
		sessionFactory.getCurrentSession().saveOrUpdate(personal);

	}

	public List<Personal> getAllPersonal() {
		List<Personal> listPersonal = new ArrayList<Personal>();
		listPersonal = sessionFactory.getCurrentSession().createQuery("from Personal").list();
		if (listPersonal != null) {
			return listPersonal;
		} else {
			return null;
		}
	}

	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public void addUserRole(UserRole userRole) {
		sessionFactory.getCurrentSession().saveOrUpdate(userRole);
		
	}
	public void deletePersonal(Integer id) {
		Personal personal = (Personal) sessionFactory.getCurrentSession().load(
				Personal.class, id);
		if (null != personal) {
			this.sessionFactory.getCurrentSession().delete(personal);
		}

	}

	public void deleteUser(String username) {
		User user = (User) sessionFactory.getCurrentSession().load(
				User.class, username);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
		
	}

	public void deleteUserRole(String username) {
		User user = (User) sessionFactory.getCurrentSession().load(
				User.class, username);
		User u1 = new User(user.getUsername(),user.getPassword(), true);
		
		String queryString = "select ur.user_role_id from UserRole ur where user=" + u1;
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<UserRole> UserRole = query.list();
/*			for (UserRole ur : ) {
				System.out.println(id);
			}*/
		
		/*UserRole userRole = (UserRole) sessionFactory.getCurrentSession().load(
				UserRole.class, (Serializable) user);
		
		if (null != userRole) {
			this.sessionFactory.getCurrentSession().delete(userRole);
		}*/
	}

}