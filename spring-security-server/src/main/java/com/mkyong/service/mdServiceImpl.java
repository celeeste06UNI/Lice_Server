package com.mkyong.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class mdServiceImpl implements mdService{

	@Transactional
	public void uploadFile(String path) {
		System.out.println("---------------HOOOOOOOOOlaaaaa"+path);
		
	}

}
