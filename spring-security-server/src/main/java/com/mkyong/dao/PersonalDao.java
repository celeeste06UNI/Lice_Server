package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Personal;

public interface PersonalDao {
	
	public void addPersonal(Personal personal);

	public List<Personal> getAllPersonal();

}