package com.gtm.proxibanquev2.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.service.ConseillerService;

/**
 * Servlet implementation class AjoutClientServlet
 */
@WebServlet("/AjoutClientServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ajoutClient(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ajoutClient(request, response);
	}

	protected void ajoutClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConseillerService conseillerService = new ConseillerService();

		String nom = request.getParameter("createNomClient");
		String prenom = request.getParameter("createPrenomClient");
		String adresse = request.getParameter("createAdresseClient");
		String codepostal = request.getParameter("createCodeClient");
		String email = request.getParameter("createEmailClient");
		String ville = request.getParameter("createVilleClient");
		String telephone = request.getParameter("createTelClient");
		int numeroconseiller = Integer.parseInt(request.getParameter("numeroconseiller"));
		int numeroClient = Integer.parseInt(request.getParameter("numeroconseiller"));

		Client clientToAdd = new Client(nom, prenom, adresse, codepostal, email, ville, telephone, numeroconseiller,
				numeroClient);
		conseillerService.ajouterClient(clientToAdd);

	}

}
