package com.gtm.proxibanquev2.presentation;

import javax.servlet.RequestDispatcher;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.service.ConseillerService;
import com.gtm.proxibanquev2.service.GerantService;
import com.gtm.proxibanquev2.service.LoginService;

public class testCrudDUr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	

	Conseiller conseillertest = new Conseiller(58, "jean","dupont");
	Conseiller conseillerlogin = new Conseiller("jean","dupont");

	Client clienttest = new Client("ici@mail.Com","rue du chat",3005); //	public Client(String email, String adresse, int numeroClient){
	ConseillerService conserv = new ConseillerService();
	GerantService gersev = new GerantService();
	
	//gersev.creerConseiller(conseillertest);
	System.out.println("Voici un test de connection");
	//conserv.ajouterClient(clienttest);
	//conserv.supprimerClient(clienttest);
	LoginService logservice = new LoginService();
	
	
	System.out.println(logservice.checkLogin(conseillertest));
	
	}
}
