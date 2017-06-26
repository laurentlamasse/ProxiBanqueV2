package com.gtm.proxibanquev2.presentation;

import javax.servlet.RequestDispatcher;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.domaine.CompteCourant;
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.service.ConseillerService;
import com.gtm.proxibanquev2.service.GerantService;
import com.gtm.proxibanquev2.service.LoginService;

public class testCrudDUr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConseillerService conserv = new ConseillerService();
		GerantService gersev = new GerantService();
		Conseiller conseillerdur = new Conseiller("jean", "dupont", 56, "jedu", "azerty");
		Conseiller conseillerdur3 = new Conseiller("jean", "dupont", 63, "jedu", "azerty");

		System.out.println(conseillerdur);

		System.out.println(conseillerdur3);
		

		Client clientdur = new Client("Alexandre", "Pic", "ValFon", "69290", "apic@objis.net", "Lyon", "061870349", 45,
				958);

		System.out.println(clientdur);
		conserv.ajouterClient(clientdur);
		//gerserv.getListeConseiller();

		// Compte comptest1 = new CompteCourant(5655,658556,500);
		// Compte comptest2 = new CompteCourant(5655,658556,800);

		// conserv.supprimerClient(clienttest2);
		// gersev.creerConseiller(conseillerdur);
		// System.out.println("Voici un test de connection");
		// conserv.ajouterClient(clienttest2);
		// conserv.supprimerClient(clienttest);
		// LoginService logservice = new LoginService();

		// System.out.println(logservice.checkLogin(conseillertest));

	}
}
