package com.mkyong.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.model.Catalogue;

public class CatalogueDaoImpl implements CatalogueDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCatalogue(Catalogue catalogue) {
		sessionFactory.getCurrentSession().saveOrUpdate(catalogue);
		
	}

}
