package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Project;
import com.mkyong.model.ProjectForView;

public interface ProjectDao {
	
	public void addProject(Project project);

	public List<Project> getAllProject();
	
	public List<Project> getOpenProject();
	
	public List<Project> getCloseProject();
	
	public List<Project> getProject(int id);

}
