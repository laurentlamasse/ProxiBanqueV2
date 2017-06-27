package com.gtm.proxibanquev2.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.exception.ConseillerException;
import com.gtm.proxibanquev2.service.GerantService;
import com.gtm.proxibanquev2.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			traitement(req, resp);
		} catch (ConseillerException e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			traitement(request, response);
		} catch (ConseillerException e) {
			System.out.println(e);
		}

	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ConseillerException {

		// Valeurs du formulaire
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		Conseiller conseiller = new Conseiller(login, mdp);

		// Service
		LoginService logservice = new LoginService();

		// Session
		HttpSession session = request.getSession();
		
		//Dispatcher
		RequestDispatcher dispatcher;
		session.setAttribute("conseillersession", null);
		
		// Verification password
		if (logservice.checkLogin(conseiller) == true) {
			// Recuperer le conseiller dans la base de donnees
			conseiller = new GerantService().getConseillerFromLogin(login);
			if (conseiller == null)
				throw new ConseillerException();
			session.setAttribute("conseillersession", conseiller);
		}
		
		dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}
}