package com.mkyong.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Catalogue;
import com.mkyong.service.CatalogueService;


@RestController
@RequestMapping(value = "/catalogue")
public class CatalogueController {
	
	@Autowired
	private CatalogueService catalogueService;

	public CatalogueController() {
	}

	@RequestMapping(value = "/addCatalogue", method = RequestMethod.POST)
	public void addCatalogue(@RequestParam(value = "id_catalogue") int id_catalogue,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description) throws ServletException, IOException, Exception {
		System.out.println("--------------------------"+id_catalogue + name + description);
		Catalogue catalogue = new Catalogue(id_catalogue, name, description);
		catalogueService.addCatalogue(catalogue);
		
	}
}