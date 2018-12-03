package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Catalogue;
import com.mkyong.model.Organization;

public interface CatalogueService {
	
	public void addCatalogue(Catalogue catalogue);
	
	public List<Catalogue> getAllCatalogue();
	
	public void deleteCatalogue(Integer id_catalogue);

	public List<Catalogue> getCatalogue(Integer id_catalogue);
	
	public void updateCatalogue(Catalogue catalogue);

}
