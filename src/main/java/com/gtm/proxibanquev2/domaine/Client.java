package com.gtm.proxibanquev2.domaine;

import javax.persistence.Entity;
import javax.persistence.Id;
public class Client extends Humain{
	public enum typeClient{particulier, entreprise};
	
	//Propriete
	private String email, adresse;
	
	private int numeroClient;
	private int numeroconseiller;

	private typeClient type;
	
	//Constructeur
	public Client(String nom, String prenom, String email, String adresse, int numeroClient, int numeroconseiller){
		super(nom, prenom);
		this.email=email;
		this.adresse=adresse;
		this.numeroClient=numeroClient;
		this.numeroconseiller = numeroconseiller;
		this.type = typeClient.particulier;

	}
	

	public int getNumeroconseiller() {
		return numeroconseiller;
	}



	public void setNumeroconseiller(int numeroconseiller) {
		this.numeroconseiller = numeroconseiller;
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
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + "]";
	}


	
	
	
	
}
