package com.gtm.proxibanquev2.service;

import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.domaine.Employe;

public class LoginService {

	/**
	 * @author LAB
	 * Cette methode effectue la verification du login et du mot de passe entrer par 
	 * un conseiller dans la page de login.
	 * Si un des champs ne correspond pas aux informations presentes en base de donnees,
	 * la methode renvoie un booleen de valeur 'false'. Dans le cas contraire, elle renverra un
	 * booleen de valeur 'true'
	 * @param conseiller
	 * @return boolean
	 */
	
	public boolean checkLogin(Conseiller conseiller) {
		ConseillerDAO cDAO = new ConseillerDAO();
		Conseiller conseildao;
		conseildao = cDAO.getConseillerFromLogin(conseiller.getLogin());

		if(conseildao == null)
			return false;
		
		if (conseiller.getLogin().equals(conseildao.getLogin()) && conseiller.getMdp().equals(conseildao.getMdp()))
			return true;
		else
			return false;

	}
}
