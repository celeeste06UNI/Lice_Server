package com.mkyong.dao;

import java.util.ArrayList;
import java.util.List;

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
	public void deletePersonal(String name) {
		Personal personal = (Personal) sessionFactory.getCurrentSession().load(
				Personal.class, name);
		if (null != personal) {
			this.sessionFactory.getCurrentSession().delete(personal);
		}

	}

}