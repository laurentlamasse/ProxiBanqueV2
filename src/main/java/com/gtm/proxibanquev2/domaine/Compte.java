package com.gtm.proxibanquev2.domaine;

public abstract class Compte {

	//Proprietes
	private int numeroCompte;
	private float solde;
	
	//Constructeur
	public Compte(int numeroCompte, float solde){
		this.numeroCompte=numeroCompte;
		this.solde=solde;
	}
	
	//constructeur vide
	public Compte(){
		
	}

	//Getters setters
	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	
}
