package com.mkyong.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Organization;
import com.mkyong.service.OrganizationService;
import com.mkyong.service.mdService;

@RestController
@RequestMapping(value = "/datam")
public class MdController {
	
	@Autowired
	private mdService mdService;
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public void saveOrganization(@RequestParam(value = "path") String path)
			throws ServletException, IOException, Exception {
		mdService.uploadFile(path);
		System.out.println(path);

	}

}
