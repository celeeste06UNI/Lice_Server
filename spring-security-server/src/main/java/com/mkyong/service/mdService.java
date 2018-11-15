package com.mkyong.service;

import java.util.List;

import com.mkyong.model.DataModel;
import com.mkyong.model.DataModelDecript;

public interface mdService {
	
	public void uploadFile(String path, String sistemabbdd, String version);
	
	public List<DataModel> getAllDatamodel();
	
	public List<String> getAllNameDatamodel();
	
	public List<String> getdmdByIdDatamodel(Integer id_datamodel);
	
	public List<String> getAttributesByTable(String table_name);
	
	public void deleteDataModel(String database_name, String version);

}
