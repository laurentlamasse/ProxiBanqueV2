package com.gtm.proxibanquev2.service;

import com.gtm.proxibanquev2.domaine.Employe;

public class LoginService {

	public boolean checkLogin(Employe employe){
		
		if (("login".equalsIgnoreCase(employe.getLogin()) && "mdp".equals(employe.getMdp())))
			return true;
		else
			return false;
	}
}
