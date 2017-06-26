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

	

	//Conseiller conseillertest = new Conseiller(58, "jean","dupont");
	//Conseiller conseillertest2 = new Conseiller(55, "sisi","lala");

	Conseiller conseillerlogin = new Conseiller("jean","dupont");

	//Client clienttest = new Client("ici@mail.Com","rue du chat",3005); //	public Client(String email, String adresse, int numeroClient){
	//Client clienttest2 = new Client("gigi@mail.Com","rue du tronc",875);
	ConseillerService conserv = new ConseillerService();
	GerantService gersev = new GerantService();
	
	//Compte comptest1 = new CompteCourant(5655,658556,500);
	//Compte comptest2 = new CompteCourant(5655,658556,800);

	
	//conserv.supprimerClient(clienttest2);
	
	//gersev.creerConseiller(conseillertest2);
	//System.out.println("Voici un test de connection");
	//conserv.ajouterClient(clienttest2);
	//conserv.supprimerClient(clienttest);
	LoginService logservice = new LoginService();
	
	
	//System.out.println(logservice.checkLogin(conseillertest));
	
	}
}
