package com.gtm.proxibanquev2.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gtm.proxibanquev2.dao.CompteDAO;
import com.gtm.proxibanquev2.domaine.CompteCourant;
import com.gtm.proxibanquev2.domaine.CompteEpargne;

public class TestCompteDAO {
	
	CompteCourant compteCouranttest;
	CompteEpargne compteEpargnetest;

	CompteDAO compteDAO;

	@Before
	public  void setUpBefore() throws Exception {
		compteCouranttest = null;
		compteEpargnetest = null;
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
	}

	@Test
	public void testRemoveCompteCourant() {
		CompteCourant compteCouranttest = new CompteCourant (56894,5000,200,958);
		 compteDAO= new CompteDAO();
		 assertTrue("Test d'ajout d'un compteCourant", compteDAO.removeCompteCourant(compteCouranttest));
	}
	
	
	@Test
	public void testAddCompteEpargne() {
		 compteEpargnetest = new CompteEpargne (568475,5000,3,958);
		 compteDAO= new CompteDAO();
		 assertTrue("Test d'ajout d'un compteEpargne", compteDAO.addCompteEpargne(compteEpargnetest));
	}

	@Test
	public void testRemoveCompteEpargne() {
		 compteEpargnetest = new CompteEpargne (568475,5000,3,958);
		 compteDAO= new CompteDAO();
		 assertTrue("Test de supression d'un compteEpargne", compteDAO.removeCompteEpargne(compteEpargnetest));
	}
	

}
