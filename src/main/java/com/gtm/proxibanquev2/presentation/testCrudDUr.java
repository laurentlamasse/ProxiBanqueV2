package com.gtm.proxibanquev2.presentation;

import javax.servlet.RequestDispatcher;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.dao.CompteDAO;
import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.domaine.CompteCourant;
import com.gtm.proxibanquev2.domaine.CompteEpargne;
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.service.ConseillerService;
import com.gtm.proxibanquev2.service.GerantService;
import com.gtm.proxibanquev2.service.LoginService;

public class testCrudDUr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientDAO clientDAO = new ClientDAO();
		ConseillerDAO consDAO = new ConseillerDAO();
		ConseillerService conserv = new ConseillerService();
		GerantService gersev = new GerantService();
		CompteDAO compteDAO = new CompteDAO();
		Conseiller conseillerdur = new Conseiller("jean", "dupont", 56, "jedu", "azerty");
		Conseiller conseillerdur3 = new Conseiller("jean", "dupont", 63, "jedu", "azerty");

		Conseiller conseillerexistant = new Conseiller("Jean", "Hubert", 47, "plop", "plip");
		
		CompteCourant compteCouranttest = new CompteCourant (56894,5000,200,958);
		CompteEpargne compteEpargnetest = new CompteEpargne (568475,5000,3,958);

		
		//compteDAO.addCompteCourant(compteCouranttest);
		//compteDAO.addCompteEpargne(compteEpargnetest);
		//compteDAO.removeCompteCourant(compteCouranttest);
		//compteDAO.removeCompteEpargne(compteEpargnetest);

		//System.out.println(conseillerdur);

		//System.out.println(conseillerdur3);
		
		
		//test ajout client
		Client clientdur5 = new Client("Alexandre", "Valentin", "Maracas", "69290", "apic@objis.net", "Lyon", "061870349", 999,
				999);
		//clientDAO.addClientBase(clientdur5);
		//clientDAO.updateClientBase(clientdur5);
		
		//System.out.println(clientDAO.getListeCLientConseiller(conseillerexistant));
		
		//System.out.println(consDAO.getConseillerFromLogin("plop"));
		//System.out.println(clientdur);
		
		//System.out.println(gersev.getListeConseiller());
		
		
		Conseiller conseiller= new Conseiller("plop","plip");
		//System.out.println(conseiller);

		Conseiller conseiller2= new Conseiller("plop","flap");

		LoginService logservice = new LoginService();
		System.out.println(logservice.checkLogin(conseiller));
		System.out.println(logservice.checkLogin(conseiller2));

		
		//System.out.println(conserv.getListeClient());
		//System.out.println(clientDAO.getListeCLient());
		
		//System.out.println(clientDAO.getCLient(958));
		
		
		//System.out.println(gersev.getListeConseiller());
		
		// String login = "plip";
		//String mdp = "plop";
		//Conseiller conseiller= new Conseiller(login,mdp);
		//LoginService logservice = new LoginService();
		
			
		
		
		
		

	}
}
