package com.Toto.Entities;

import java.util.List;
import java.util.Map;

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
	
	public void update(user u)
	{
		userDao.updateUser(u);
	}
	
	public void remove(user u)
	{
		userDao.remove(u);
	}
	
	public List<user> rechercher(Map<String,Object> Props)
	{
		return userDao.getUsersByAttributes(Props);
	}
	public List<user> afficher()
	{
		return userDao.getAllUsers();
	}
	

}
