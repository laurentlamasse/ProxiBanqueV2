package com.gtm.proxibanquev2.service;

import java.util.List;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.dao.CompteDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.domaine.Virement;
import com.gtm.proxibanquev2.exception.VirementException;

public class ConseillerService {

	/**
	 * Cette methode permet d'effectuer un virement entre deux comptes. Elle renvoie une exception 
	 * si la somme virée est plus importante que le solde du compte débiteur.
	 * @param virement 
	 * @throws VirementException Si la somme viree est plus importante que le solde du compte débiteur,
	 *cette exception est levee. Un message d'erreur est alors renvoye.
	 */
	public void effectuerVirement(Virement virement) throws VirementException {
		float montant= virement.getMontantVirer();
		
		if (virement.getMontantVirer() > virement.getCompteDebite().getSolde())
			throw new VirementException();
		else {
				virement.getCompteDebite().setSolde(virement.getCompteDebite().getSolde() - montant );
				virement.getCompteCredite().setSolde(virement.getCompteCredite().getSolde() + montant);
			 } 
		
		CompteDAO compteDao= new CompteDAO();
		compteDao.effectuerVirement(virement);
	}
	
	
	/**
	 * Cette methode permet d'ajouter un client en base de donnees a partir d'un formulaire rempli dans une page web.
	 * @param client
	 * @return void
	 */
	public void ajouterClient(Client client){
		ClientDAO clientDao = new ClientDAO();
		clientDao.addClientBase(client);
	}
	
	/**
	 * Cette methode permet de supprimer un client present en base de donnees 
	 * @param client
	 * @return void
	 */
	public void supprimerClient(Client client){
		ClientDAO clientDao = new ClientDAO(); 
		clientDao.removeClientBase(client);
	}
	
	/**
	 * Cette methode permet de modifier les informations d'un client enregistre 
	 * en base de donnees
	 * @param client
	 * @return void
	 */
	public void modifierClient(Client client){
		ClientDAO clientDao = new ClientDAO();
		clientDao.updateClientBase(client);
	}
	
	/**
	 * Cette methode permet d'obtenir la liste des clients presents en base de donnees
	 * @return List
	 */
	public List<Client> getListeClient(){
		List<Client> listeClients;
		ClientDAO clientDao= new ClientDAO();
		listeClients= clientDao.getListeCLient();
		return listeClients;
	}
	

	
	

	/**
	 * Cette methode permet d'afficher la liste des comptes d'un client
	 * @param client
	 * @return List
	 */
	public List<Compte> getListeCompte(Client client){
		List<Compte> listeComptes;
		CompteDAO compteDao= new CompteDAO();
		listeComptes= (List<Compte>) compteDao.getListeCompte();
		return listeComptes;
	}
	
	/**
	 * Cette methode, qui prend en parametre un objet compte et un objet client
	 * permet d'ajouter les caracteristiques d'un compte en base de donnees.
	 * @param compte
	 * @param client
	 */
	public void ajoutCompte(Compte compte, Client client){
		
		CompteDAO compteDao = new CompteDAO();
		//compteDao.addCompteBase(client, compte);
	}
	
	/**
	 * Cette methode permet d'obtenir les informations d'un client à partir 
	 * de son identifiant
	 * @param id
	 * @return client
	 */
	public Client obtenirClient(int id){
		//TODO a faire
		Client client = null;
		ClientDAO clientDao=new ClientDAO();
		//client=clientDao.getClient(id);
		return client;
	}
}
