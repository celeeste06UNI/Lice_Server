package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Personal;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;

public interface PersonalDao {
	
	public void addPersonal(Personal personal);

	public List<Personal> getAllPersonal();

	public void addUser(User user);

	public void addUserRole(UserRole userRole);

}