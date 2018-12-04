package com.mkyong.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Catalogue;
import com.mkyong.model.Organization;

@Repository
public class CatalogueDaoImpl implements CatalogueDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCatalogue(Catalogue catalogue) {
		sessionFactory.getCurrentSession().saveOrUpdate(catalogue);

	}

	public List<Catalogue> getAllCatalogue() {
		List<Catalogue> listCatalogue = new ArrayList<Catalogue>();
		listCatalogue = sessionFactory.getCurrentSession().createQuery("from Catalogue").list();
		if (listCatalogue != null) {
			return listCatalogue;
		} else {
			return null;
		}

	}

	public void deleteCatalogue(Integer id_catalogue) {
		Catalogue catalogue = (Catalogue) sessionFactory.getCurrentSession().load(
				Catalogue.class, id_catalogue);
		if (null != catalogue) {
			this.sessionFactory.getCurrentSession().delete(catalogue);
		}
		
	}

	public List<Catalogue> getCatalogue(Integer id_catalogue) {
		List<Catalogue> list = new ArrayList<Catalogue>();
		list = sessionFactory.getCurrentSession().createQuery("from Catalogue where id_catalogue="+id_catalogue).list();
		return list;
	}

	public void updateCatalogue(Catalogue catalogue) {
		System.out.println("-------------"+catalogue.getId_catalogue());
		sessionFactory.getCurrentSession().update(catalogue);
		
	}
}