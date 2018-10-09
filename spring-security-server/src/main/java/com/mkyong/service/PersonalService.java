package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Personal;



public interface PersonalService {
	
	public void addPersonal(Personal personal);

	public List<Personal> getAllPersonal();


}
