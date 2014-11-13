package com.Toto.Entities;

import java.util.Iterator;
import java.util.List;




import java.util.Map;
import java.util.Map.Entry;

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
	
	public void updateUser(user u)
	{
		this.getEntityManager().merge(u);
		
	}
	public void remove(user u)
	{
		user a=this.getEntityManager().getReference(user.class, u.getId()); // pour récupérer l'instance attaché a la base
		this.getEntityManager().remove(a);
	}
	
	@SuppressWarnings("rawtypes")
	public List<user>getUsersByAttributes(Map<String,Object> Props)
	{
		/*Syntaxe :
		 * query = entityManager.createQuery("select o from MyTestObject o where o.income = :income and o.age = :age");
		   query.setParameter("income", 50507.0);
	       query.setParameter("age", 12);
		   List<MyTestObject> obs = query.getResultList();
		 */
		
		
		String req=new String("select o from user o where ");
		
		//Construction de la requete
		
		Iterator it=Props.keySet().iterator();
		
		while(it.hasNext())
		{
			String aide =(String)it.next();
			req+="o."+aide+" = :"+aide;
			if(it.hasNext())req+=" and ";
		}
		
		//Creation de la requete 
		Query query=this.getEntityManager().createQuery(req);
		
		//Affectation des parametre
		for(Entry<String,Object> e:Props.entrySet())
		{
			query.setParameter(e.getKey(), e.getValue());
		}
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<user> getAllUsers()
	{
		Query query=this.getEntityManager().createQuery("SELECT o from user o");
		return query.getResultList();
	}
	
	
}
