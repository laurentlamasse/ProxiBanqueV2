package com.gtm.proxibanquev2.domaine;

public class Gerant extends Employe{

	public Gerant(int id, String login, String mdp) {
		super(id, login, mdp);
	}

	//constructeur vide
	public Gerant(){
		
	}
	
	@Override
	public String toString() {
		return "Gerant [getLogin()=" + getLogin() + ", getMdp()=" + getMdp() + ", getId()=" + getId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
