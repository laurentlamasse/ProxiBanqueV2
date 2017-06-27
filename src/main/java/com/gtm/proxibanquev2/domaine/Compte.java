package com.gtm.proxibanquev2.domaine;
/**
* 
* @author LAB
*La classe Compte est une classe abstraite. Elle est implementee par les classes CompteCourant et CompteEpargne.
*Elle possede son constructeur, des getters setters, une methode toString() afin d'afficher la valeur des parametres.
*
*@param 
*numeroCompte - un int
*solde - un float
*numeroClient - un int
*/
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
