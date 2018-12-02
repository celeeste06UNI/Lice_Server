package com.mkyong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Catalogue;
import com.mkyong.model.Organization;
import com.mkyong.service.CatalogueService;


@RestController
@RequestMapping(value = "/catalogue")
public class CatalogueController {
	
	@Autowired
	private CatalogueService catalogueService;

	@RequestMapping(value = "/addCatalogue", method = RequestMethod.POST)
	public void addCatalogue(@RequestParam(value = "id_catalogue") int id_catalogue,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description) throws ServletException, IOException, Exception {
		Catalogue catalogue = new Catalogue(id_catalogue, name, description);
		catalogueService.addCatalogue(catalogue);
		
	}
	@RequestMapping(value = "/getAllCatalogue", method = RequestMethod.GET, produces = "application/json")
	public List<Catalogue> getAllCatalogue() {
		List<Catalogue> list = new ArrayList<Catalogue>();
		list = catalogueService.getAllCatalogue();
		return list;

	}
}