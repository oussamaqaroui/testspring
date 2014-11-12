package com.Toto.Entities;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class testBase {

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
		user.setNom("blabla");
		user.setPrenom("amal");
		serviceUser.ajouter(user);
		System.out.println("User  : " + user + " added successfully");
	}

	@Test
	public void testAfficher() {
		List<user> users = serviceUser.afficher();
		System.out.println("The list of all persons = " + users);
	}

}
