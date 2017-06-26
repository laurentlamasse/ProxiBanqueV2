package com.gtm.proxibanquev2.domaine;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Conseiller extends Employe{

	public Conseiller(String nom, String prenom, Integer id, String login, String mdp) {
		super(nom, prenom, id, login, mdp);
	}

	public Conseiller(String login, String mdp) {
		super(login, mdp);
	}
	
	
	
	/*public int getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}
*/


	


	@Override
	public String toString() {
		return "Conseiller [id=" + getId() + ", getLogin()=" + getLogin() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + "]";
	}



	
}
