package com.gtm.proxibanquev2.domaine;

public class Conseiller extends Employe{

	public Conseiller(int id, String login, String mdp) {
		super(id, login, mdp);
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
