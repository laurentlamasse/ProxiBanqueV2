package com.gtm.proxibanquev2.domaine;

import javax.persistence.Entity;
import javax.persistence.Id;
public class Client extends Humain{
	public enum typeClient{particulier, entreprise};
	
	//Propriete
	private String adresse, codepostal, ville, telephone,email;
	private int numeroClient;
	private int numeroconseiller;

	private typeClient type;
	
	//Constructeur

	public Client(String nom, String prenom, String adresse, String codepostal, String email, String ville, String telephone,int numeroconseiller, int numeroClient){
		super(nom,prenom);
		this.codepostal=codepostal;
		this.email=email;
		this.adresse=adresse;
		this.ville=ville;
		this.email=email;
		this.telephone=telephone;
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
		return email;}

	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
		return "Client [nom=" + getNom() + ", prenom=" + getPrenom() + ", adresse=" + adresse + ", codepostal=" + codepostal
				+ ", ville=" + ville + ", telephone=" + telephone + ", email=" + email + ", numeroClient="
				+ numeroClient + ", numeroconseiller=" + numeroconseiller + ", type=" + type + "]";
	}




	
	
	

	
}
