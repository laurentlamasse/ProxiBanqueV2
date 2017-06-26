package com.gtm.proxibanquev2.domaine;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Conseiller extends Employe{

	private int id;
	private int idconseiller;
	public Conseiller(String nom, String prenom, int id, String login, String mdp) {
		super(nom, prenom, id, login, mdp);
	}

	public Conseiller(String login, String mdp) {
		super(login, mdp);
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getIdconseiller() {
		return idconseiller;
	}



	public void setIdconseiller(int idconseiller) {
		this.idconseiller = idconseiller;
	}



	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", getLogin()=" + getLogin() + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + "]";
	}



	
}
