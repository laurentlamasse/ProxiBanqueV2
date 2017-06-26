package com.gtm.proxibanquev2.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class testLoginDAO {

	Conseiller conseillertest;
	Client clienttest;
	ClientDAO clientDAO;
	ConseillerDAO consDAO;

	@Before
	public void setUpBefore() throws Exception {
		System.out.println("===Initiatlisation===");
		conseillertest = null;
		clienttest = null;
		clientDAO = null;
		consDAO = null;
	}

	@After
	public void tearDownAfter() throws Exception {

		System.out.println("===Fin du test===");
		conseillertest = null;
		clientDAO = null;
		consDAO = null;
	}

	@Test
	public void testGetConseillerFromLogin() {
		String login = "plop";
		conseillertest = new Conseiller("Jean", "Hubert", 47, "plop", "plip");
		System.out.println("===CONSEILLER test");

		
		assertEquals( conseillertest, consDAO.getConseillerFromLogin("jedu"));

		
	}

}
