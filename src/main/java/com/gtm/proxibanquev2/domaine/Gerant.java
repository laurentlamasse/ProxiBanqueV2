package com.gtm.proxibanquev2.domaine;

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
