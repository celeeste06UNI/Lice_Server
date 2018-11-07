package com.mkyong.service;

import java.util.List;

import com.mkyong.model.DataModelDecript;

public interface mdService {
	
	public void uploadFile(String path, String sistemabbdd, String version);
	
	public List<DataModelDecript> getAllDatamodel();
	
	public List<String> getAllNameDatamodel();

}
