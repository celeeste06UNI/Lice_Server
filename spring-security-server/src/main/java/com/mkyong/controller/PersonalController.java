package com.mkyong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.model.Personal;
import com.mkyong.service.PersonalService;
@RestController
@RequestMapping(value = "/personal")
public class PersonalController {

	private static final Logger logger = Logger.getLogger(PersonalController.class);

	public PersonalController() {
		System.out.println("PersonalController()");
	}

	@Autowired
	private PersonalService personalService;

	@RequestMapping(value = "/")
	public String helloWorld(){
		return "Hello World!";
	
}

	@RequestMapping(value = "/savePersonal", method = RequestMethod.POST)
	public void savePersonal(@RequestParam(value = "id") int id,
            @RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
            @RequestParam(value = "address") String address, @RequestParam(value = "telephone") String telephone) 
            		throws ServletException, IOException, Exception {
		Personal personal = new Personal(id, name, email, address,telephone);
		personalService.addPersonal(personal);
		
    }
	
	@RequestMapping(value = "/getAllPersonal", method = RequestMethod.GET, produces = "application/json")
	public List<Personal> getAllPersonal(){
		List<Personal> list= new ArrayList<Personal>();
		list=personalService.getAllPersonal();
		return list;
		
		
	}
}

