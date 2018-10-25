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

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(value = "/saveOrganization", method = RequestMethod.POST)
	public void saveOrganization(@RequestParam(value = "id") int id, @RequestParam(value = "cif") int cif,@RequestParam(value = "name_org") String name_org,
			@RequestParam(value = "name_trade") String name_trade, @RequestParam(value = "name_contact") String name_contact,
			@RequestParam(value = "role_contact") String role_contact, @RequestParam(value = "telephone_contact") String telephone_contact) throws ServletException, IOException, Exception {
		Organization organization = new Organization(id, cif,name_org, name_trade, name_contact, role_contact,telephone_contact);
		organizationService.addOrganization(organization);

	}

}
