package com.mkyong.datamodelReader;

import java.util.List;

import org.jdom.Document;
import com.mkyong.model.DataModel;

public interface xmlReader {
	
	public List<DataModel> reader(Document doc);

}
