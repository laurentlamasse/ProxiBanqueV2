package com.gtm.proxibanquev2.service;

import java.util.Collection;
import java.util.List;

import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class GerantService {
	
	public void creerConseiller(Conseiller conseiller){
		ConseillerDAO conseillerDao = new ConseillerDAO();
		conseillerDao.addConseillerBase(conseiller);
	}

	public List <Conseiller> getListeConseiller(){
		List<Conseiller> listeConseiller = null;
		ConseillerDAO conseillerDao = new ConseillerDAO();
		listeConseiller= conseillerDao.getListeConseiller();
		return listeConseiller;		
	}
}
