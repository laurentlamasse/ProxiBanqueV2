package com.gtm.proxibanquev2.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.service.ConseillerService;

/**
 * Servlet implementation class ModifierClient
 */
public class ModifierClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierClientServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modifierClient(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modifierClient(request, response);
	}

	protected void modifierClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//TODO
		Client client;
		int id =Integer.parseInt(request.getParameter("idClient"));		
		ConseillerService service= new ConseillerService();
		client=service.obtenirClient(id);
		
		/*Passage a la jsp pour modification des informations
		.
		.
		.
		.
		*/
		
		//Application des modifications en passant a la couche service
		Client clientNew = null;
		String nomNew =request.getParameter("NewNomClient");
		String prenomNew= request.getParameter("NewPrenomClient");
		String adresseNew =request.getParameter("NewAdresseClient");
		String codepostalNew= request.getParameter("NewCodeClient");
		String villeNew=request.getParameter("NewVilleClient");
		String telephone= request.getParameter("NewTelClient");
		
		service.modifierClient(clientNew);
		
		HttpSession session=request.getSession();
		
		RequestDispatcher dispatcher=null;
		dispatcher= request.getRequestDispatcher("/confirmationmodificationclient.html");
		dispatcher.forward(request, response);
	}
}
