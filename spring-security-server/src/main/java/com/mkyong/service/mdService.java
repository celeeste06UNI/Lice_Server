package com.mkyong.service;

import java.util.List;

import com.mkyong.model.DataModel;

public interface mdService {
	
	public void uploadFile(String path, String sistemabbdd, String version);
	
	public List<DataModel> getAllDatamodel();
	
	public List<String> getAllNameDatamodel();

}
