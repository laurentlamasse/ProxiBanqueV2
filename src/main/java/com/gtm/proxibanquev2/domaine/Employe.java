package com.gtm.proxibanquev2.domaine;

public abstract class Employe {
	
	//Proprietes
	private String login, mdp;
	private int id;
	
	//Constructeur
	public Employe(int id, String login, String mdp){
		this.login=login;
		this.mdp=mdp;
		this.id=id;
	}
	
	//Constructeur vide
	public Employe(){
		
	}

	//Getters setters
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
