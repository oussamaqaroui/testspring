package com.Toto.Entities;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("serviceUser")
@Transactional
public class serviceUser { 
	
	private userDao userDao;

	public userDao getUserDao() {
		return userDao;
	}

	public void setUserDao(userDao userDao) {
		this.userDao = userDao;
	}
	
	public void ajouter(user u)
	{
		userDao.addUser(u);
	}
	
	public List<user> afficher()
	{
		return userDao.getAllUsers();
	}
	

}
