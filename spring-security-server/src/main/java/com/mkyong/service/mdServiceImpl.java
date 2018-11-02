package com.mkyong.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.OrganizationDao;
import com.mkyong.model.DataModel;
import com.mkyong.readerFile.readerMysql;
import com.mkyong.dao.mdDao;

@Service
@Transactional
public class mdServiceImpl implements mdService{
	
	readerMysql r = new readerMysql();
	@Autowired
	private mdDao md;
	
	@Transactional
	public void uploadFile(String path) {
		ArrayList<DataModel> datamodelList = new ArrayList();
		DataModel dataModel = new DataModel();
		String archivo_xml = path;
		File fichero = new File(archivo_xml);
		Document doc = r.abrirXmlJDOM(fichero);
		datamodelList = r.recorrerJDOMyMostrar(doc);
		for (int i=0; i < datamodelList.size();i++) {
			dataModel = datamodelList.get(i);
			//System.out.println(dataModel);
			md.addDataModel(dataModel);
		}
		
	}
	


}
