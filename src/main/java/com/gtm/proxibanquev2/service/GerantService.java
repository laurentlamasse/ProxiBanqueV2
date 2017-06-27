package com.gtm.proxibanquev2.service;

import java.util.Collection;
import java.util.List;

import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class GerantService {
	
	public boolean creerConseiller(Conseiller conseiller){
		ConseillerDAO conseillerDao = new ConseillerDAO();
		boolean bol;
		bol=conseillerDao.addConseillerBase(conseiller);
		return bol;
	}

	public List <Conseiller> getListeConseiller(){
		//TODO a faire
		List<Conseiller> listeConseiller = null;
		ConseillerDAO conseillerDao = new ConseillerDAO();
		//listeConseiller= conseillerDao.getListeConseiller();
		return listeConseiller;		
	}
}
