package com.mkyong.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Personal;
import com.mkyong.model.Project;
import com.mkyong.model.ProjectForView;
import com.mkyong.service.ProjectService;


@RestController
@RequestMapping(value = "/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public void savePersonal(@RequestParam(value = "id") int id, @RequestParam(value = "id_emp") int id_emp,
			@RequestParam(value = "id_org") int id_org, @RequestParam(value = "id_datamodel") int id_datamodel,
			@RequestParam(value = "start_date") Date start_date, @RequestParam(value = "finish_date") Date finish_date) throws ServletException, IOException, Exception {
		Project project = new Project(id, id_emp, id_org, id_datamodel, start_date, finish_date);
		projectService.addProject(project);
	}
	
	@RequestMapping(value = "/getOpenProjectForView", method = RequestMethod.GET, produces = "application/json")
	public List<ProjectForView> getOpenProjectForView() {
		List<ProjectForView> list = new ArrayList<ProjectForView>();
		list = projectService.getOpenProjectForView();
		return list;
	}
	
	@RequestMapping(value = "/getCloseProjectForView", method = RequestMethod.GET, produces = "application/json")
	public List<ProjectForView> getCloseProjectForView() {
		List<ProjectForView> list = new ArrayList<ProjectForView>();
		list = projectService.getCloseProjectForView();
		return list;
	}
	

}
