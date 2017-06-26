package com.gtm.proxibanquev2.domaine;

public class Virement {

	//Proprietes
	Compte compteCredite, compteDebite;
	float montantVirer;
	
	//Constructeur
	public Virement(float montantVirer, Compte compteCredite, Compte compteDebite){
		this.compteCredite=compteCredite;
		this.compteDebite=compteDebite;
		this.montantVirer=montantVirer;
	}
	
	//Constructeur vide
	public Virement(){
		
	}

	public Compte getCompteCredite() {
		return compteCredite;
	}

	public void setCompteCredite(Compte compteCredite) {
		this.compteCredite = compteCredite;
	}

	public Compte getCompteDebite() {
		return compteDebite;
	}

	public void setCompteDebite(Compte compteDebite) {
		this.compteDebite = compteDebite;
	}

	public float getMontantVirer() {
		return montantVirer;
	}

	public void setMontantVirer(float montantVirer) {
		this.montantVirer = montantVirer;
	}

	@Override
	public String toString() {
		return "Virement [compteCredite=" + compteCredite + ", compteDebite=" + compteDebite + ", montantVirer="
				+ montantVirer + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

}
