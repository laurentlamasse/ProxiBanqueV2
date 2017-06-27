<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="com.sun.net.httpserver.HttpServer"%>
<%@page import="com.gtm.proxibanquev2.domaine.Conseiller"%>
<%@page import="com.gtm.proxibanquev2.domaine.Client"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- ENTETE -->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ProxiBanque</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<!-- CORPS -->
<body>

	<!-- ==================================[BLOC CONTAINER]================================== -->
	<div class="container">
		<%
			if (session.getAttribute("conseillersession") == null) {
				response.sendRedirect("index.jsp");
			}
			Conseiller user = (Conseiller) session.getAttribute("conseillersession");
		%>
		<!-- ==================================[BLOC HEADER]================================== -->
		<div class="row">
			<div class="col-lg-12">
				<nav class="navbar navbar-inverse bg-inverse">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp"><img
						src="img/logo.png" alt="Logo ProxiBanque"></a>
				</div>
				<div id="navbar1" class="navbar-collapse collapse">
					<div class="row menu">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="LogoutServlet" class="glyphicon glyphicon-off">
									<%=" Déconnexion[" + user.getPrenom() + " " + user.getNom() + "]"%>
							</a></li>
						</ul>
					</div>
					<div class="row menu">
						<ul class="nav navbar-nav navbar-right">
							<li class="active dropdown"><a href="#"
								class="dropdown-toggle glyphicon glyphicon-credit-card"
								data-toggle="dropdown" role="button" aria-expanded="false">
									Clients <span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="clients.jsp">Afficher la liste</a></li>
									<li><a href="creerClient.jsp">Créer un client</a></li>
								</ul></li>
							<li><a href="virement.jsp"
								class="glyphicon glyphicon-transfer"> Virement</a></li>
							<li class="dropdown"><a href="#"
								class="dropdown-toggle glyphicon glyphicon-user"
								data-toggle="dropdown" role="button" aria-expanded="false">
									Conseillers <span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Afficher la liste</a></li>
									<li><a href="#">Créer un conseiller</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
				</nav>
			</div>
		</div>
		<!-- ==================================[BLOC HEADER]================================== -->

		<!-- ==================================[BLOC CORPS]================================== -->
		<div class="row espace"></div>

		<div class="row">
			<div class="col-lg-3">
				<div class="corps-entete">RECHERCHE</div>
				<div class="corps-contenu">
					<form method="GET" action="ListeClientServlet">
						<div class="form-group">
							<label for="idClient">Identifiant</label> <input id="idClient"
								class="form-control" name="idClient" type="number"
								placeholder="Entrez l'identifiant">
						</div>
						<div class="form-group">
							<label for="nomClient">Nom</label> <input id="nomClient"
								class="form-control" name="nomClient" type="text"
								placeholder="Entrez le nom">
						</div>
						<div class="form-group">
							<label for="prenomClient">Prénom</label> <input id="prenomClient"
								class="form-control" name="prenomClient" type="text"
								placeholder="Entez le prénom">
						</div>
						<div class="button-right">
							<button id="buttonResearch" class="btn btn-primary" type="submit">Rechercher</button>
						</div>
					</form>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="corps-entete">LISTE DES CLIENTS</div>
				<div class="corps-contenu">

					<table class="table table-striped">
						<thead>
							<th><input id="checkall" type="checkbox" /></th>
							<th>ID</th>
							<th>NOM</th>
							<th>PRÉNOM</th>
							<th>ADRESSE</th>
							<th>CODE POSTAL</th>
							<th>VILLE</th>
							<th>TEL</th>
							<th></th>
							<th></th>
						</thead>
						<tbody>

							<%
								Object resultat = session.getAttribute("listeClients");
								if(resultat != null)
								{
									ArrayList<Client> liste = (ArrayList<Client>) session.getAttribute("listeClients");
									for (Client client : liste) {
										out.print("<tr>" + "<td><input class=\"checkthis\" type=\"checkbox\" /></td>" + "<td>"+ client.getNumeroClient() +"</td>"
												+ "<td>" + client.getNom() + "</td>" + "<td>" + client.getPrenom() + "</td>" + "<td>"
												+ client.getAdresse() + "</td>" + "<td>" + client.getCodepostal() + "</td>" + "<td>"
												+ client.getVille() + "</td>" + "<td>" + client.getTelephone() + "</td>"
												+ "<td><p data-placement=\"top\" data-toggle=\"tooltip\"" + "title=\"Edit\">"
												+ "<button class=\"btn btn-primary btn-xs\" data-title=\"Edit\""
												+ "data-toggle=\"modal\" data-target=\"#edit\">"
												+ "<span class=\"glyphicon glyphicon-pencil\"></span>" + "</button>" + "</p></td>"
												+ "<td><p data-placement=\"top\" data-toggle=\"tooltip\"" + "title=\"Delete\">"
												+ "<button class=\"btn btn-warning btn-xs\" data-title=\"Delete\""
												+ "data-toggle=\"modal\" data-target=\"#delete\">"
												+ "<span class=\"glyphicon glyphicon-trash\"></span>" + "</button>" + "</p></td>"
												+ "</tr>");
									}
								}
							%>

						</tbody>

					</table>

					<div class="clearfix"></div>
					<ul class="pagination pull-right">
						<li class="disabled"><a href="#"><span
								class="glyphicon glyphicon-chevron-left"></span></a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#"><span
								class="glyphicon glyphicon-chevron-right"></span></a></li>
					</ul>
				</div>

			</div>
		</div>
		<!-- ==================================[BLOC CORPS]================================== -->

		<!-- ==================================[BLOC FOOTER]================================== -->
		<footer>
		<p>
			© 2017 <a href="http://www.gtm-ingenierie.fr/">GT'M Ingénierie</a>,
			All rights reserved 2017-2018.
		</p>
		</footer>
		<!-- ==================================[BLOC FOOTER]================================== -->
	</div>
	<!-- ==================================[BLOC CONTAINER]================================== -->
</body>
</html>
