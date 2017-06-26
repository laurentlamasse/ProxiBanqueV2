package com.gtm.proxibanquev2.domaine;

public abstract class Compte {

	//Proprietes
	private int numeroCompte;
	private float solde;
	private int numeroClient;
	
	//Constructeur
	public Compte(int numeroCompte, float solde, int numeroClient){
		this.numeroCompte=numeroCompte;
		this.solde=solde;
		this.numeroClient=numeroClient;
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

	public int getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}
	
	
	
}
