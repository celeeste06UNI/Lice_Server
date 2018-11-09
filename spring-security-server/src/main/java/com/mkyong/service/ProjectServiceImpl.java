package com.mkyong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.PersonalDao;
import com.mkyong.dao.ProjectDao;
import com.mkyong.model.Project;
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectDao projectDao;

	public void addProject(Project project) {
		projectDao.addProject(project);
		
	}

}
