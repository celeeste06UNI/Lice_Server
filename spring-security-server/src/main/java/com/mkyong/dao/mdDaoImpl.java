package com.mkyong.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.DataModel;

@Repository
public class mdDaoImpl implements mdDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addDataModel(DataModel dataModel) {
		System.out.println(dataModel);
		sessionFactory.getCurrentSession().saveOrUpdate(dataModel);
	}

}
