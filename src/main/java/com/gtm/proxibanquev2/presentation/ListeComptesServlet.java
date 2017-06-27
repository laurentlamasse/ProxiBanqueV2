package com.gtm.proxibanquev2.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.service.ConseillerService;

/**
 * Servlet implementation class ListeComptesServlet
 */
public class ListeComptesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeComptesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listeComptes(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listeComptes(request, response);
	}
	
	protected void listeComptes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = null;
		List<Compte> listeComptes= new ArrayList<Compte>();
		ConseillerService service = new ConseillerService();
		listeComptes=service.getListeCompte(client);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("listeComptes", listeComptes);
		
		RequestDispatcher dispatcher=null;
		dispatcher= request.getRequestDispatcher("/comptes.jsp");
		dispatcher.forward(request, response);
	}

}
