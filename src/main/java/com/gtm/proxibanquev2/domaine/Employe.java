package com.gtm.proxibanquev2.domaine;

public abstract class Employe extends Humain {

	// Proprietes
	private String login, mdp;
	private int id;

	// Constructeur
	public Employe(String nom, String prenom, int id, String login, String mdp) {
		super(nom, prenom);
		this.login = login;
		this.mdp = mdp;
		this.id = id;
	}

	public Employe(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;

	}

	// Getters setters
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
