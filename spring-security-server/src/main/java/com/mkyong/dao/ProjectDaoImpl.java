package com.mkyong.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProject(Project project) {
		sessionFactory.getCurrentSession().saveOrUpdate(project);
		
	}

}
