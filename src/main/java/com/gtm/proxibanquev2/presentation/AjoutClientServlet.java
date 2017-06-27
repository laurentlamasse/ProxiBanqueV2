package com.gtm.proxibanquev2.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajout(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajout(request, response);
	}

	protected void ajout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom =request.getParameter("createNomClient");
		String prenom= request.getParameter("createPrenomClient");
		String adresse =request.getParameter("createAdresseClient");
		String codepostal= request.getParameter("createCodeClient");
		String ville=request.getParameter("createVilleClient");
		String email= request.getParameter("createEmail");
		String telephone= request.getParameter("createTelClient");
		
		HttpSession session = request.getSession();
		Conseiller conseiller = (Conseiller)session.getAttribute("conseillersession");
		
		int numConseiller= conseiller.getId();
		int numClient= Integer.parseInt(request.getParameter("createNumeroClient"));
		
		Client client=new Client(nom, prenom, adresse, codepostal, email, ville, telephone, numConseiller, numClient);
		ConseillerService service = new ConseillerService();
		service.ajouterClient(client);
		
		RequestDispatcher dispatcher;
		dispatcher= request.getRequestDispatcher("creerClient.jsp");
		dispatcher.forward(request, response);
	}
	
}
