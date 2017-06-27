package com.gtm.proxibanquev2.exception;

public class ConseillerException extends Exception {

	public ConseillerException() {
		super("Le conseiller n'est pas enregistre dans la base de donnees de ProxiBanque");
	}
}
