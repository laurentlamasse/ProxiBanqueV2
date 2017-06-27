package com.gtm.proxibanquev2.service;

import java.util.Collection;
import java.util.List;

import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class GerantService {
	
	public Conseiller creerConseiller(){
		Conseiller conseiller = null;
		ConseillerDAO conseillerDao = new ConseillerDAO();
		conseiller=conseillerDao.addConseillerBase(conseiller);
		return conseiller;
	}

	public List <Conseiller> getListeConseiller(){
		//TODO a faire
		List<Conseiller> listeConseiller = null;
		ConseillerDAO conseillerDao = new ConseillerDAO();
		//listeConseiller= conseillerDao.getListeConseiller();
		return listeConseiller;		
	}
}
