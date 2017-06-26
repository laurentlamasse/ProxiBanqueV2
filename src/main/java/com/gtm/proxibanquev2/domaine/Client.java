package com.gtm.proxibanquev2.domaine;

import javax.persistence.Entity;
import javax.persistence.Id;
public class Client {
	public enum typeClient{particulier, entreprise};
	
	//Propriete
	private String email, adresse;
	
	private int numeroClient;
	private typeClient type;
	
	//Constructeur
	public Client(String email, String adresse, int numeroClient){
		this.email=email;
		this.adresse=adresse;
		this.numeroClient=numeroClient;
		this.type = typeClient.particulier;
	}
	
	//constructeur vide
	public Client(){
		
	}

	
	//Getters setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}

	public typeClient getType() {
		return type;
	}

	public void setType(typeClient type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Client [email=" + email + ", adresse=" + adresse + ", numeroClient=" + numeroClient + ", type=" + type
				+ "]";
	}
	
	
	
}
