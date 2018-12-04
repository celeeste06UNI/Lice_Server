package com.mkyong.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.OrganizationDao;
import com.mkyong.dao.PersonalDao;
import com.mkyong.dao.ProjectDao;
import com.mkyong.dao.mdDao;
import com.mkyong.model.Organization;
import com.mkyong.model.Personal;
import com.mkyong.model.Project;
import com.mkyong.model.ProjectForView;
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private PersonalDao personalDao;
	
	@Autowired
	private OrganizationDao organizationDao;
	
	@Autowired
	private mdDao md;

	public void addProject(Project project) {
		projectDao.addProject(project);
		
	}

	public List<ProjectForView> getOpenProjectForView() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		List<Project> list = new ArrayList<Project>();
		List<ProjectForView> listView = new ArrayList<ProjectForView>();
		Project project;
		ProjectForView projectForView;
		String name_emp;
		String name_org;
		String name_datamodel;
		String start_date;
		String finish_date;
		int rules = 0;
		list = projectDao.getOpenProject();
		for(int i = 0; i<list.size(); i++) {
			project = list.get(i);
			name_emp = personalDao.getPersonal(project.getId_emp()).get(0).getUsername();
			name_org = organizationDao.getOrganization(project.getId_org()).get(0).getName_org();
			name_datamodel = md.getNameDataModelById(project.getId_datamodel()).get(0);
			start_date = sdf.format(project.getStart_date());
			finish_date = sdf.format(project.getFinish_date());
			projectForView = new ProjectForView(name_emp,name_org,name_datamodel,start_date,finish_date,rules);
			listView.add(projectForView);
		}
		
		return listView;
	}
	
	public List<Project> getOpenProject() {
		List<Project> list = new ArrayList<Project>();
		list = projectDao.getOpenProject();
		return list;
	}
	
	public List<ProjectForView> getCloseProjectForView() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		List<Project> list = new ArrayList<Project>();
		List<ProjectForView> listView = new ArrayList<ProjectForView>();
		Project project;
		ProjectForView projectForView;
		String name_emp;
		String name_org;
		String name_datamodel;
		String start_date;
		String finish_date;
		int rules = 0;
		list = projectDao.getCloseProject();
		for(int i = 0; i<list.size(); i++) {
			project = list.get(i);
			name_emp = personalDao.getPersonal(project.getId_emp()).get(0).getUsername();
			name_org = organizationDao.getOrganization(project.getId_org()).get(0).getName_org();
			name_datamodel = md.getNameDataModelById(project.getId_datamodel()).get(0);
			start_date = sdf.format(project.getStart_date());
			finish_date = sdf.format(project.getFinish_date());
			projectForView = new ProjectForView(name_emp,name_org,name_datamodel,start_date,finish_date,rules);
			listView.add(projectForView);
		}
		
		return listView;
	}

	public List<Project> getProject(int id) {
		List<Project> list= new ArrayList<Project>();
		list=projectDao.getProject(id);
		return list;
	}


}