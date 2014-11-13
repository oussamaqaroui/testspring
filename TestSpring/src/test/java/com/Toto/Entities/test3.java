package com.Toto.Entities;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test3 {

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
	public void testRemove() {
		user user = new user();
		user.setId(1);
		user.setNom("guizlane");
		user.setPrenom("amal");
		
		serviceUser.remove(user);
		
	}

	@Test
	public void testRechercher() {
		Map<String,Object> M=new TreeMap<String,Object>();
		M.put("nom", "ouss");
		System.out.println(serviceUser.rechercher(M));
	}

}
