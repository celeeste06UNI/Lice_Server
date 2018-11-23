package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Project;
import com.mkyong.model.ProjectForView;

public interface ProjectService {
	
	public void addProject(Project project);
	
	public List<ProjectForView> getOpenProjectForView();
	
	public List<Project> getOpenProject();
	
	public List<ProjectForView> getCloseProjectForView();

}
