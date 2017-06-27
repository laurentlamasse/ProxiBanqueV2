package com.gtm.proxibanquev2.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gtm.proxibanquev2.dao.ClientDAO;
import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.service.ConseillerService;
import com.gtm.proxibanquev2.service.LoginService;

/**
 * Servlet implementation class ListeClientsServlet
 */
@WebServlet("/ListeClientServlet")
public class ListeClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeClientsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;
		ConseillerService clientService = new ConseillerService();
		HttpSession session = request.getSession();
		Conseiller conseiller = (Conseiller)session.getAttribute("conseillersession");
		ArrayList<Client> listeClients = new ArrayList(clientService.getListeClienFromConseiller(conseiller));
		session.setAttribute("listeClients", listeClients);
		dispatcher = request.getRequestDispatcher("clients.jsp");
		dispatcher.forward(request, response);
	}
}