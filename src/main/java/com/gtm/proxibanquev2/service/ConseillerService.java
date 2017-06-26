package com.gtm.proxibanquev2.service;

import java.util.List;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.dao.CompteDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.domaine.Virement;

import exception.VirementException;

public class ConseillerService {

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
	
	public void ajouterClient(Client client){
		ClientDAO clientDao = new ClientDAO();
		clientDao.addClientBase(client);
	}
	
	public void supprimerClient(Client client){
		ClientDAO clientDao = new ClientDAO(); 
		clientDao.removeClientBase(client);
	}
	
	public void modifierClient(Client client){
		ClientDAO clientDao = new ClientDAO();
		clientDao.updateClientBase(client);
	}
	
	public List<Client> getListeClient(){
		List<Client> listeClients;
		ClientDAO clientDao= new ClientDAO();
		listeClients= clientDao.getListeClient();
		return listeClients;
	}
	
	public List<Compte> getListeCompte(Client client){
		List<Compte> listeComptes;
		CompteDAO compteDao= new CompteDAO();
		listeComptes= compteDao.getListeCompte(client);
		return listeComptes;
	}
	
	public void ajoutCompte(Compte compte, Client client){
		
		CompteDAO compteDao = new CompteDAO();
		compteDao.addCompteBase(client, compte);
	}
	
	public Client obtenirClient(int id){
		Client client;
		ClientDAO clientDao=new ClientDAO();
		client=clientDao.getClient(id);
		return client;
	}
}
