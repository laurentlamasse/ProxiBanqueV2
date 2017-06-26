package com.gtm.proxibanquev2.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

import junit.framework.Assert;

public class TestGetConseiller {

	Conseiller conseillertest;
	Client clienttest;
	ConseillerDAO consDAO;

	@Before
	public void setUpBefore() throws Exception {
		System.out.println("===Initiatlisation===");
		conseillertest = null;
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
	public void testGetOneConseiller() {
		
		System.out.println("===test Ajout du conseiller voulu dans la BDD===");
		conseillertest = new Conseiller("Jean", "Hubert", 113, "plop", "plip");
		consDAO = new ConseillerDAO();
		consDAO.addConseillerBase(conseillertest);
		System.out.println(conseillertest);

		Conseiller conseillerobtenu =  consDAO.getOneConseiller(conseillertest);
		
		assertEquals( conseillertest, conseillerobtenu);
		System.out.println("Le assertEquals est renvoyé négatif alors que les objets sont bien identiques, etrange");

		
	}

}
