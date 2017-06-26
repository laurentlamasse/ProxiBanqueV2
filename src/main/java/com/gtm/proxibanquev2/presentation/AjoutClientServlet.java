package com.gtm.proxibanquev2.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtm.proxibanquev2.domaine.Client;

/**
 * Servlet implementation class AjoutClientServlet
 */
public class AjoutClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ajout(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ajout(request, response);
	}

	protected void ajout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom =request.getParameter("createNomClient");
		String prenom= request.getParameter("createPrenomClient");
		String adresse =request.getParameter("createAdresseClient");
		String codepostal= request.getParameter("createCodeClient");
		String ville=request.getParameter("createVilleClient");
		String telephone= request.getParameter("createTelClient");
		int numeroClient=1;
		Client client=new Client(nom, prenom, adresse, codepostal, ville, telephone, numeroClient);
	}
	
}
