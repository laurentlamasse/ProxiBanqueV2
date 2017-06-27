package com.gtm.proxibanquev2.service;

import java.util.Collection;
import java.util.List;

import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class GerantService {

	/**
	 * @author LAB
	 * Cette methode permet a un gerant de creer un conseiller.
	 * Elle ne prend aucun parametre et renvoie un conseiller.
	 * @return Conseiller
	 */
	public boolean creerConseiller(Conseiller conseiller){
		ConseillerDAO conseillerDao = new ConseillerDAO();
		boolean bol;
		bol=conseillerDao.addConseillerBase(conseiller);
		return bol;
	}
	/**
	 * @author LAB
	 * Cette methode permet a un gerant d'afficher la liste des conseillers
	 * presents en base de donnees. Elle ne prend aucun parametre, et renvoie 
	 * une liste de conseillers.
	 * @return List
	 */
	public List <Conseiller> getListeConseiller(){
		//TODO a faire
		List<Conseiller> listeConseiller = null;
		ConseillerDAO conseillerDao = new ConseillerDAO();
		//listeConseiller= conseillerDao.getListeConseiller();
		return listeConseiller;		
	}
	
	/**
	 * 
	 * @param Le conseiller que l'on veut aller chercher dans le DAO
	 * @return conseiller, le conseiller qui vient du DAO
	 */
	public Conseiller  getOneConseiller(Conseiller conseiller){
		//TODO a faire
		ConseillerDAO conseillerDao = new ConseillerDAO();
		Conseiller conseillerger = conseillerDao.getOneConseiller(conseiller);
		return conseillerger;		
	}
	
}
