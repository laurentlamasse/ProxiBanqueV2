package com.gtm.proxibanquev2.exception;

public class VirementException extends Exception{

	public VirementException(){
		super("Le montant vir� est sup�rieur au solde du compte d�biteur. \n Veuillez r�essayer avec un autre montant.");
	}
}
