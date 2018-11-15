package com.mkyong.dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Personal;
import com.mkyong.model.Project;
import com.mkyong.model.ProjectForView;

@Repository
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProject(Project project) {
		sessionFactory.getCurrentSession().saveOrUpdate(project);
		
	}

	public List<Project> getAllProject() {
		List<Project> listProject = new ArrayList<Project>();
		listProject = sessionFactory.getCurrentSession().createQuery("from Project").list();
		if (listProject != null) {
			return listProject;
		} else {
			return null;
		}
	}
	
	public List<Project> getOpenProject() {
		java.util.Date date = new Date();
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
		List<Project> listProject = new ArrayList<Project>();
		listProject = sessionFactory.getCurrentSession().createQuery("from Project where finish_date>='" +
				sqlStartDate + "'").list();
		if (listProject != null) {
			return listProject;
		} else {
			return null;
		}
	}
	
	public List<Project> getCloseProject() {
		java.util.Date date = new Date();
		java.sql.Date sqlFinishDate = new java.sql.Date(date.getTime()); 
		List<Project> listProject = new ArrayList<Project>();
		listProject = sessionFactory.getCurrentSession().createQuery("from Project where finish_date<'" +
				sqlFinishDate + "'").list();
		if (listProject != null) {
			return listProject;
		} else {
			return null;
		}
	}


}
