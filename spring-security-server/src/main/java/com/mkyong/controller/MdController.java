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

import com.mkyong.model.DataModelDecript;
import com.mkyong.model.Personal;
import com.mkyong.service.mdService;

@RestController
@RequestMapping(value = "/datam")
public class MdController {
	
	@Autowired
	private mdService mdService;
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public void uploadFile(@RequestParam(value = "path") String path, @RequestParam("sistemabbdd") String sistemabbdd,
			@RequestParam("version") String version)
			throws ServletException, IOException, Exception {
		mdService.uploadFile(path, sistemabbdd,version);
	}
	
	@RequestMapping(value = "/getAllDatamodel", method = RequestMethod.GET)
	public void getAllDatamodel(){
		List<DataModelDecript> list = new ArrayList<DataModelDecript>();
		list = mdService.getAllDatamodel();
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@RequestMapping(value = "/getAllNameDatamodel", method = RequestMethod.GET)
	public List<String> getAllNameDatamodel(){
		List<String> list = new ArrayList<String>();
		list = mdService.getAllNameDatamodel();
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}
	

}
