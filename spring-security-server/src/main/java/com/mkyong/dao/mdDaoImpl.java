package com.mkyong.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.DataModel;
import com.mkyong.model.DataModelDecript;
import com.mkyong.model.Personal;

@Repository
public class mdDaoImpl implements mdDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addDecriptDataModel(DataModelDecript dataModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(dataModel);
	}

	public void addDataModel(DataModel dataModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(dataModel);
	}

	public List<Integer> getIdDataModel(String database_name, String version) {
		List<Integer> versiones = new ArrayList<Integer>();
		versiones = sessionFactory.getCurrentSession().createQuery
				("select id_datamodel from DataModel where database_name='"+database_name
						+ "' and version='" + version+"'").list();
		if (versiones != null) {
			return versiones;
		} else {
			return null;
		}
	}

	public List<String> getLastVersion(String database_name) {
		List<String> versiones = new ArrayList<String>();
		versiones = sessionFactory.getCurrentSession()
				.createQuery("select version from DataModel where=" + database_name).list();
		if (versiones != null) {
			return versiones;
		} else {
			return null;
		}
	}

	public List<String> getAllNameDatamodel() {
		List<String> nameDatamodelList = new ArrayList<String>();
		nameDatamodelList = sessionFactory.getCurrentSession()
				.createQuery("select distinct database_name from DataModel").list();
		if (nameDatamodelList != null) {
			return nameDatamodelList;
		} else {
			return null;
		}
	}

	public List<DataModelDecript> getAllDatamodel() {
		List<DataModelDecript> datamodelList = new ArrayList<DataModelDecript>();
		datamodelList = sessionFactory.getCurrentSession().createQuery("from DataModel").list();
		if (datamodelList != null) {
			return datamodelList;
		} else {
			return null;
		}
	}

}
