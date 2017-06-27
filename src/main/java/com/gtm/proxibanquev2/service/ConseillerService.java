package com.gtm.proxibanquev2.service;

import java.util.List;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.dao.CompteDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.domaine.CompteCourant;
import com.gtm.proxibanquev2.domaine.CompteEpargne;
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.exception.VirementException;

public class ConseillerService {

	/**
	 * Cette methode permet d'ajouter un client en base de donnees a partir d'un
	 * formulaire rempli dans une page web.
	 * 
	 * @param client
	 * @return void
	 */
	public void ajouterClient(Client client) {
		ClientDAO clientDao = new ClientDAO();
		clientDao.addClientBase(client);
	}

	/**
	 * Cette methode permet de supprimer un client present en base de donnees
	 * 
	 * @param client
	 * @return void
	 */
	public void supprimerClient(Client client) {
		ClientDAO clientDao = new ClientDAO();
		clientDao.removeClientBase(client);
	}

	/**
	 * Cette methode permet de modifier les informations d'un client enregistre
	 * en base de donnees
	 * 
	 * @param client
	 * @return void
	 */
	public void modifierClient(Client client) {
		ClientDAO clientDao = new ClientDAO();
		clientDao.updateClientBase(client);
	}

	/**
	 * Cette methode permet d'obtenir la liste des clients presents en base de
	 * donnees
	 * 
	 * @return List la liste des clients
	 */
	public List<Client> getListeClient() {
		List<Client> listeClients;
		ClientDAO clientDao = new ClientDAO();
		listeClients = clientDao.getListeCLient();
		return listeClients;
	}
	
	/**
	 * Cette methode permet d'obtenir les informations d'un client Ã  partir de
	 * son identifiant
	 * 
	 * @param id du client
	 * @return client l'objet client retourné par le DAO
	 */
	public Client obtenirClient(int id) {
		// TODO a faire
		Client client = null;
		ClientDAO clientDao = new ClientDAO();
		return client;
	}
	
	/**
	 * 
	 * @param conseiller le conseiller sevant à filtrer les clients
	 * @return la liste de clients appartenants à un conseiller
	 */
	public List<Client> getListeClienFromConseiller(Conseiller conseiller) {
		List<Client> listeClients;
		ClientDAO clientDao = new ClientDAO();
		listeClients = clientDao.getListeCLientConseiller(conseiller);
		return listeClients;
	}
	

	/**
	 * 
	 * @param compte
	 *            le compte courant qui sera transfere pour l'ajout en base
	 */

	public void ajouterComteCourant(CompteCourant compte) {
		CompteDAO compteDao = new CompteDAO();
		compteDao.addCompteCourant(compte);
	}

	/**
	 * 
	 * @param compte
	 *            le compte epargne qui sera transfere pour l'ajout en base
	 */

	public void ajouterComteEpargne(CompteEpargne compte) {
		CompteDAO compteDao = new CompteDAO();
		compteDao.addCompteEpargne(compte);
	}

	/**
	 * 
	 * @param compte
	 *            le compte epargne qui sera transfere pour etre supprime
	 */

	public void suppComteEpargne(CompteEpargne compte) {
		CompteDAO compteDao = new CompteDAO();
		compteDao.removeCompteEpargne(compte);
	}

	/**
	 * 
	 * @param compte
	 *            le compte courant qui sera transfere pour etre supprime
	 */

	public void suppComteCourant(CompteCourant compte) {
		CompteDAO compteDao = new CompteDAO();
		compteDao.removeCompteCourant(compte);
	}

	/**
	 * 
	 * @param idclient
	 *            numeroduClient avec un compteEpargne
	 * @return le compteEpargne retourné par DAO
	 */

	public CompteEpargne getCompteEpargne(int idclient) {
		CompteDAO compteDao = new CompteDAO();
		return compteDao.getCompteEpargneid(idclient);
	}

	/**
	 * 
	 * @param idclient
	 *            numeroduClient avec un compteEpargne
	 * @return le compteCourant retourné par DAO
	 */

	public CompteCourant getCompteCourant(int idclient) {
		CompteDAO compteDao = new CompteDAO();
		return compteDao.getCompteCourantid(idclient);
	}

	
}
