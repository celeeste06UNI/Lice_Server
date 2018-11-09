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

import com.mkyong.model.DataModel;
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
	public List<DataModel> getAllDatamodel(){
		List<DataModel> list = new ArrayList<DataModel>();
		list = mdService.getAllDatamodel();
		return list;
	}
	
	@RequestMapping(value = "/getAllNameDatamodel", method = RequestMethod.GET)
	public List<String> getAllNameDatamodel(){
		List<String> list = new ArrayList<String>();
		list = mdService.getAllNameDatamodel();
		return list;
	}
	
	@RequestMapping(value = "/getdmdByIdDatamodel", method = RequestMethod.GET)
	public List<String> getdmdByIdDatamodel(@RequestParam(value = "id_datamodel") Integer id_datamodel){
		List<String> list = new ArrayList<String>();
		list = mdService.getdmdByIdDatamodel(id_datamodel);
		return list;
	}
	
	@RequestMapping(value = "/getAttributesByTable", method = RequestMethod.GET)
	public List<String> getAttributesByTable(@RequestParam(value = "table_name") String table_name){
		List<String> list = new ArrayList<String>();
		list = mdService.getAttributesByTable(table_name);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}

}
