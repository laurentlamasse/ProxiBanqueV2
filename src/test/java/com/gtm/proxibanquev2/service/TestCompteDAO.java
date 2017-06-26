package com.gtm.proxibanquev2.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gtm.proxibanquev2.dao.CompteDAO;
import com.gtm.proxibanquev2.domaine.CompteCourant;

public class TestCompteDAO {
	
	CompteCourant compteCouranttest;
	CompteDAO compteDAO;

	@Before
	public  void setUpBefore() throws Exception {
		compteCouranttest = null;
		compteDAO= null;
	}

	@After
	public  void tearDownAfter() throws Exception {
		compteCouranttest = null;
		compteDAO= null;
	}

	@Test
	public void testAddCompteCourant() {
		 compteCouranttest = new CompteCourant (56894,5000,200,958);
		 compteDAO= new CompteDAO();
		 assertTrue("Test d'ajout d'un compteCourant", compteDAO.addCompteCourant(compteCouranttest));
		//fail("Not yet implemented");
	}

	@Test
	public void testRemoveCompteCourant() {
		CompteCourant compteCouranttest = new CompteCourant (56894,5000,200,958);
		 compteDAO= new CompteDAO();
		 assertTrue("Test d'ajout d'un compteCourant", compteDAO.removeCompteCourant(compteCouranttest));
		//fail("Not yet implemented");
	}

}
