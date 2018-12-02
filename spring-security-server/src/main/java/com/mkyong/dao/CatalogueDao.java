package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Catalogue;

public interface CatalogueDao {
	
	public void addCatalogue(Catalogue catalogue);
	
	public List<Catalogue> getAllCatalogue();

}
