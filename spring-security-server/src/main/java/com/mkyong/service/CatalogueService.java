package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Catalogue;

public interface CatalogueService {
	
	public void addCatalogue(Catalogue catalogue);
	
	public List<Catalogue> getAllCatalogue();

}
