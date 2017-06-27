package com.gtm.proxibanquev2.domaine;


/**
 * La classe CompteCourant herite de la classe abstraite Compte.
 * Elle est composee d'un constructeur, de getters/setters, de la methode toString().
 * Elle possede un attribut, 'decouvert', que ne possede pas la classe Compte.
 * L'autre classe qui herite de la classe Compte est CompteEpargne
 * @author LAB
 *@param
 *numeroCompte - un int
 *solde - un float
 *decouvert - un int
 *numeroClient - un int
 */


public class CompteCourant extends Compte{
	
	//Proprietes
	private int decouvert;
	
	//Constructeur
	public CompteCourant(int numeroCompte, float solde, int decouvert, int numeroClient) {
		super(numeroCompte, solde, numeroClient);
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
				+ getSolde() + "]";
	}


	
	

	
}
