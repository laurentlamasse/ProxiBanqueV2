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

public class TestAjoutConseillerDAO {

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
		clienttest = null;
		clientDAO = null;
		consDAO = null;
	}

	// public Client(String nom, String prenom, String adresse, String
	// codepostal, String ville, String telephone, int numeroClient){

	@Test
	public void addConseillerBase() {

		conseillertest = new Conseiller("Jean", "Hubert", 118, "plop", "plip");
		consDAO = new ConseillerDAO();
		System.out.println("===test d'ajout d'un conseiller dans la base de donnée===");

		assertTrue("Test d'ajout d'un client", consDAO.addConseillerBase(conseillertest));

	}

}