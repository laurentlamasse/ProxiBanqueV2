package com.gtm.proxibanquev2.domaine;

/**
 * La classe Employe herite de la classe Humain. Elle possede, en plus des attributs 
 * de cette derniere, les attributs login, mdp, et id.
 * @author LAB
 *@param
 *nom - un String
 *prenom - un String
 *id - un int
 *login - un String
 *mdp - un String
 */

public abstract class Employe extends Humain {

	// Proprietes
	private String login, mdp;
	private Integer id;

	// Constructeur
	public Employe(String nom, String prenom, Integer id, String login, String mdp) {
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

	public void setId(Integer id) {
		this.id = id;
	}

}
