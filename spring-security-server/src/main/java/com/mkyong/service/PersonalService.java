package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Personal;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;



public interface PersonalService {
	
	public void addPersonal(Personal personal);

	public List<Personal> getAllPersonal();

	public void addUser(User user);

	public void addUserRole(UserRole userRole);

	public void enviarEmail(User user);
	
	public void deletePersonal(Integer id);

	public void deleteUser(String username);

	public List<Personal> getPersonal(Integer id);

	public void updatePersonal(Personal personal);



}
