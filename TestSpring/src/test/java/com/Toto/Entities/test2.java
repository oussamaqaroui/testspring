package com.Toto.Entities;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test2 {

	public static ClassPathXmlApplicationContext context ;
	public static serviceUser serviceUser ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		serviceUser = (serviceUser) context.getBean("serviceUser");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}


	@Test
	public void testAjouter() {
		user user = new user();
		user.setNom("toto");
		user.setPrenom("titi");
		serviceUser.ajouter(user);
		System.out.println("User  : " + user + " added successfully");
	}



	@Test
	public void testUpdate() {
		
		user user = new user();
		user.setNom("ghizlane");
		user.setPrenom("amal");
		user.setId(1);
		serviceUser.update(user);
	}

	@Test
	public void testAfficher() {
		List<user> users = serviceUser.afficher();
		System.out.println("The list of all persons = " + users);
	}

}
