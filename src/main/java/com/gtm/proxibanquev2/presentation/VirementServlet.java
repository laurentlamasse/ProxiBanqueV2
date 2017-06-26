package com.gtm.proxibanquev2.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.domaine.Virement;
import com.gtm.proxibanquev2.service.ConseillerService;

/**
 * Servlet implementation class VirementServlet
 */
public class VirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VirementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		virement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		virement(request, response);
	}
	
	protected void virement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instanciation de ConseillerService et recuperation des valeurs entrees en formulaire
		ConseillerService service = new ConseillerService();
		String numDebite=request.getParameter("debiteurVirement");
		String numCredite=request.getParameter("crediteurVirement");	
		int montant=Integer.parseInt(request.getParameter("sommeVirement"));	
		
		//Instanciation d'un objet virement
		//Compte compteDebite=new Compte(numDebite,compteDebite.getSolde());
		//Compte compteCredite= new Compte(numCredite,compteCredite.getSolde());
	//	Virement virement=new Virement(montant,compteCredite ,compteDebite);
		
		//Passage à la couche service
		//service.effectuerVirement(virement);
		
	}
		
}
