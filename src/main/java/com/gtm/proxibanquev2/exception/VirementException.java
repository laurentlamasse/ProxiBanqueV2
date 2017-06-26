package com.gtm.proxibanquev2.exception;

public class VirementException extends Exception{

	public VirementException(){
		System.out.println("Le montant viré est supérieur au solde du compte débiteur. \n Veuillez réessayer avec un autre montant.");
	}
}
