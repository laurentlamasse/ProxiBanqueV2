package com.gtm.proxibanquev2.service;

import com.gtm.proxibanquev2.dao.ConseillerDAO;
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.domaine.Employe;

public class LoginService {

	public boolean checkLogin(Conseiller conseiller) {
		ConseillerDAO cDAO = new ConseillerDAO();
		Conseiller conseildao;
		conseildao = cDAO.getConseillerFromLogin(conseiller.getLogin());
		System.out.println("Conseiller cherché " + conseiller);

		System.out.println("Conseiller trouvé " + conseildao);

		if (conseiller.getLogin().equals(conseildao.getLogin()) == true
				&& conseiller.getMdp().equals(conseildao.getMdp())== true)
			return true;
		else
			return false;

	}
}
