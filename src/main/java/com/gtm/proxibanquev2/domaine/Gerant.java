package com.gtm.proxibanquev2.domaine;

/**
 * Cette classe herite de la classe Employe, qui est heritee par une autre classe:
 * la classe Conseiller.
 * 
 * @author Stagiaire
 *@param
 *prenom - un String
 *nom - un String
 *id - un int
 *login - un String
 *mdp - un String
 */

public class Gerant extends Employe{

	public Gerant(String prenom, String nom, int id, String login, String mdp) {
		super(prenom, nom, id, login, mdp);
	}

	@Override
	public String toString() {
		return "Gerant [getLogin()=" + getLogin() + ", getMdp()=" + getMdp() + ", getId()=" + getId() + ", getNom()="
				+ getNom() + ", getPrenom()=" + getPrenom() + "]";
	}

	
	
	
	
	
}
