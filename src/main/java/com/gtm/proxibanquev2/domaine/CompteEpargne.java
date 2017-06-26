package com.gtm.proxibanquev2.domaine;

public class CompteEpargne extends Compte {
	
	//Proprietes
	private float remuneration;
	
	//Constructeur
	public CompteEpargne(int numeroCompte, float solde, float remuneration, int numeroClient) {
		super(numeroCompte, solde, numeroClient);
		this.remuneration=remuneration;
	}
	
	//Constructeur vide
	public CompteEpargne(){
		
	}

	//Getters setters 
	public float getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(float remuneration) {
		this.remuneration = remuneration;
	}
	
	

	@Override
	public String toString() {
		return "CompteEpargne [remuneration=" + remuneration + ", getNumeroCompte()=" + getNumeroCompte()
				+ ", getSolde()=" + getSolde() + ", getClass()=" + getClass() + "]";
	}

	
	
	
}
