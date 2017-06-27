package com.gtm.proxibanquev2.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.service.ConseillerService;
import com.gtm.proxibanquev2.service.GerantService;

/**
 * Servlet implementation class CreerConseillerServlet
 */
public class CreerConseillerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerConseillerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		creerConseiller(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		creerConseiller(request, response);
	}

	protected void creerConseiller(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conseiller conseiller;
		
		//TODO
		String id =request.getParameter("");
		String login= request.getParameter("");
		String mdp =request.getParameter("");
		
		GerantService service = new GerantService();
		conseiller= service.creerConseiller();
		
		//A voir: page de retour avec confirmation de la création du conseiller

		
		RequestDispatcher dispatcher=null;
		dispatcher= request.getRequestDispatcher("/confirmationcreationconseiller.html");
		dispatcher.forward(request, response);
				}
	
}
