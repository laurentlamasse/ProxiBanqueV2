package com.gtm.proxibanquev2.service;

import java.sql.SQLException;

import com.gtm.proxibanquev2.dao.CompteDAO;
import com.gtm.proxibanquev2.domaine.CompteCourant;

public class VirementService {

	public boolean effectuerVirement(int idclientdebite, int idclientCredite, float montant) {
		// TODO:

		try {
			CompteDAO compteDAO = new CompteDAO();

			CompteCourant comtpedebite = compteDAO.getCompteCourantid(idclientdebite);
			CompteCourant comtpecredite = compteDAO.getCompteCourantid(idclientCredite);

			float nouveaudebit = comtpedebite.getSolde() - montant;
			float nouveaucredit = comtpedebite.getSolde() + montant;

			compteDAO.modifierCompteCourantMontant(idclientdebite, nouveaudebit);
			compteDAO.modifierCompteCourantMontant(idclientCredite, nouveaucredit);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return false;

	}

}
