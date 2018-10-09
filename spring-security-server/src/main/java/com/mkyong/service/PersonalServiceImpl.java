package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.PersonalDao;
import com.mkyong.model.Personal;


@Service
@Transactional
public class PersonalServiceImpl implements PersonalService {
	
	//En este caso no tenemos que crear un DAO porque es el cliente sino que tenemos que hacer la llamadas
	//a los servicios del servidor

	@Autowired
	private PersonalDao personalDao;

	@Transactional
	public void addPersonal(Personal personal) {
		personalDao.addPersonal(personal);
	}
	
	@Transactional
	public List<Personal> getAllPersonal(){
		List<Personal> list= new ArrayList<Personal>();
		list=personalDao.getAllPersonal();
		return list;
		
	}


}
