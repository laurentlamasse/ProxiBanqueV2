package com.gtm.proxibanquev2.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class TestremoveClient {

	Conseiller conseillertest;
	Client clienttest;
	ClientDAO clientDAO;

	@Before
	public void setUpBefore() throws Exception {
		System.out.println("===Initiatlisation===");
		 conseillertest = null;
		 clienttest = null;
		 clientDAO = null;
	}

	@After
	public void tearDownAfter() throws Exception {

		System.out.println("===Fin du test===");
		 conseillertest = null;
		 clienttest = null;
		 clientDAO = null;
	}


	@Test
	public void testRemoveClientBase() {
		clientDAO = new ClientDAO();
		clienttest= new Client("Alexandre", "Pic", "ValFon", "69290", "apic@objis.net", "Lyon", "061870349", 898989,
				898989);		clientDAO = new ClientDAO();
		System.out.println("===test de suppression d'un client===");

		assertTrue("Test de supression du client", clientDAO.removeClientBase(clienttest));
	}

}
