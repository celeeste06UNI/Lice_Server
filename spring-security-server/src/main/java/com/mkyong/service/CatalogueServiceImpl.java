package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.CatalogueDao;
import com.mkyong.model.Catalogue;
import com.mkyong.model.Organization;

@Service
@Transactional
public class CatalogueServiceImpl implements CatalogueService{
	
	@Autowired
	private CatalogueDao catalogueDao;
	
	@Transactional
	public void addCatalogue(Catalogue catalogue) {
		System.out.println(catalogue);
		catalogueDao.addCatalogue(catalogue);
		
	}
	@Transactional
	public List<Catalogue> getAllCatalogue() {
		List<Catalogue> list= new ArrayList<Catalogue>();
		list=catalogueDao.getAllCatalogue();
		return list;
	}

}
