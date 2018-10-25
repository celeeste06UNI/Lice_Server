package com.mkyong.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Organization;
@Repository
public class OrganizationDaoImpl implements OrganizationDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addOrganization(Organization organization) {
		sessionFactory.getCurrentSession().saveOrUpdate(organization);
		
	}

}
