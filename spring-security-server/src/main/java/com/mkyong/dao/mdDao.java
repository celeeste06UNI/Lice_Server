package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.DataModel;
import com.mkyong.model.DataModelDecript;


public interface mdDao {
	
	public void addDecriptDataModel(DataModelDecript decriptDataModel);
	
	public void addDataModel(DataModel dataModel);
	
	public List<DataModel> getAllDatamodel();
	
	public List<String> getAllNameDatamodel();
	
	public List<String> getLastVersion(String database_name);
	
	public List<Integer> getIdDataModel(String database_name, String version);

}
