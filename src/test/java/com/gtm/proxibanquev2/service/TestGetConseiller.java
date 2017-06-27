package com.gtm.proxibanquev2.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

import junit.framework.Assert;

public class TestGetConseiller {

	Conseiller conseillertest,conseillertest2,conseillertest3,conseillertest4;
	Client clienttest;
	ConseillerDAO consDAO;

	@Before
	public void setUpBefore() throws Exception {
		System.out.println("===Initiatlisation===");
		conseillertest =  null;
		clienttest = null;
		consDAO = null;
	}

	@After
	public void tearDownAfter() throws Exception {

		System.out.println("===Fin du test===");
		conseillertest = null;
		clienttest = null;
		consDAO = null;
	}
	

	
	
	@Test
	public void testnotNullGetOneConseiller() {
		
		System.out.println("===test Ajout du conseiller voulu dans la BDD===");
		conseillertest = new Conseiller("Jean", "Hubert", 113, "plop", "plip");
		consDAO = new ConseillerDAO();
		consDAO.addConseillerBase(conseillertest);

		Conseiller conseillerobtenu =  consDAO.getOneConseiller(conseillertest);
		
		assertNotNull(conseillerobtenu);
		System.out.println("Le conseiller obtenu n'est pas un objet nul");

		
	}
	
	@Ignore
	@Test
	public void testEqualsGetOneConseiller() {
		
		System.out.println("===test Ajout du conseiller voulu dans la BDD===");
		consDAO = new ConseillerDAO();
		consDAO.addConseillerBase(conseillertest4);
		System.out.println(conseillertest);

		Conseiller conseillerobtenu =  consDAO.getOneConseiller(conseillertest);
		
		assertEquals( conseillertest, conseillerobtenu);
		System.out.println("Il y a besoin de redefinir le Equals des conseillers");

		
	}
	


}
