package com.gtm.proxibanquev2.service;

import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.domaine.Employe;

public class LoginService {

	/**
	 * Methode de la couche service qui permet de verifier le login et le mot de passe du conseiller. Si le login n'existe pas ou que le mot de passe est incorrect, le resultat est faux
	 * @param conseiller Objet de type Conseiller qui ne comporte que le login et le mot de passe (utilise pour la verification uniquement)
	 * @return Boolean qui indique le resultat de la verification
	 */
	public boolean checkLogin(Conseiller conseiller) {
		System.out.println("Dans servicelogin");

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
