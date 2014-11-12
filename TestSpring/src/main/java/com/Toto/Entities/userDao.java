package com.Toto.Entities;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED)
public class userDao {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void addUser(user u)
	{
		this.getEntityManager().persist(u);
	}
	
	@SuppressWarnings("unchecked")
	public List<user> getAllUsers()
	{
		Query query=this.getEntityManager().createQuery("SELECT o from user o");
		return query.getResultList();
	}
	
	
}
