package com.gtm.proxibanquev2.domaine;

public class CompteCourant extends Compte{
	
	//Proprietes
	private int decouvert;
	
	//Constructeur
	public CompteCourant(int numeroCompte, float solde, int decouvert) {
		super(numeroCompte, solde);
		this.decouvert=decouvert;
	}
	
	//Constructeur vide
	public CompteCourant(){
		
	}

	//Getters setters 
	public int getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", getNumeroCompte()=" + getNumeroCompte() + ", getSolde()="
				+ getSolde() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
