package com.gtm.proxibanquev2.domaine;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Conseiller extends Employe{

	private int id;
	
	public Conseiller(int id, String login, String mdp) {
		super(id, login, mdp);
	}

	public Conseiller( String login, String mdp) {
		super( login, mdp);
	}

	
	//constructeur vide
	public Conseiller(){
		
	}
	@Override
	public String toString() {
		return "Conseiller [getLogin()=" + getLogin() + ", getMdp()=" + getMdp() + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
