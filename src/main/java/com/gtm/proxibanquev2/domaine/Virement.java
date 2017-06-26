package com.gtm.proxibanquev2.domaine;

public class Virement {

	//Proprietes
	private int numCompteDebite, numCompteCredite;
	float montantVirer;
	
	//Constructeur
	public Virement(int numCompteDebite, int numCompteCredite, float montantVirer){
		this.numCompteDebite=numCompteDebite;
		this.numCompteCredite=numCompteCredite;
		this.montantVirer=montantVirer;
	}
	
	//Constructeur vide
	public Virement(){
		
	}

	//Getters setters
	public int getNumCompteDebite() {
		return numCompteDebite;
	}

	public void setNumCompteDebite(int numCompteDebite) {
		this.numCompteDebite = numCompteDebite;
	}

	public int getNumCompteCredite() {
		return numCompteCredite;
	}

	public void setNumCompteCredite(int numCompteCredite) {
		this.numCompteCredite = numCompteCredite;
	}

	public float getMontantVirer() {
		return montantVirer;
	}

	public void setMontantVirer(float montantVirer) {
		this.montantVirer = montantVirer;
	}

	@Override
	public String toString() {
		return "Transaction [numCompteDebite=" + numCompteDebite + ", numCompteCredite=" + numCompteCredite
				+ ", montantVirer=" + montantVirer + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
