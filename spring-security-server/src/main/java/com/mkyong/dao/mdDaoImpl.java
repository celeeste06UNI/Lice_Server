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

	public List<DataModel> getAllDatamodel() {
		List<DataModel> datamodelList = new ArrayList<DataModel>();
		datamodelList = sessionFactory.getCurrentSession().createQuery("from DataModel").list();
		if (datamodelList != null) {
			return datamodelList;
		} else {
			return null;
		}
	}
	
	public List<String> getdmdByIdDatamodel(Integer id_datamodel) {
		List<String> datamodelDecriptList = new ArrayList<String>();
		datamodelDecriptList = sessionFactory.getCurrentSession().createQuery("select distinct table_name from DataModelDecript "
				+ "where id_datamodel="+id_datamodel).list();
		if (datamodelDecriptList != null) {
			return datamodelDecriptList;
		} else {
			return null;
		}
	}
	
	public List<String> getAttributesByTable(String table_name) {
		List<String> datamodelDecriptList = new ArrayList<String>();
		datamodelDecriptList = sessionFactory.getCurrentSession().createQuery("select column_name from DataModelDecript "
				+ "where table_name='"+table_name+"'").list();
		if (datamodelDecriptList != null) {
			return datamodelDecriptList;
		} else {
			return null;
		}
	}

}
