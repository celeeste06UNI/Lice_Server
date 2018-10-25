package com.mkyong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.OrganizationDao;
import com.mkyong.dao.PersonalDao;
import com.mkyong.model.Organization;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	private OrganizationDao organizationDao;
	
	@Transactional
	public void addOrganization(Organization organization) {
		organizationDao.addOrganization(organization);
		
	}

}
