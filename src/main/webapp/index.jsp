<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="com.sun.net.httpserver.HttpServer"%>
<%@page import="com.gtm.proxibanquev2.domaine.Conseiller"%>
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
	<%
		if (session.getAttribute("conseillersession") != null) {
			response.sendRedirect("clients.jsp");
		}
	%>
	<!-- ==================================[BLOC CONTAINER]================================== -->
	<div class="container">
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
							<li><a href="index.jsp" class="glyphicon glyphicon-log-in"> Connexion</a></li>
						</ul>
					</div>
					<div class="row menu">
						<ul class="nav navbar-nav navbar-right">
							<li class="active"><a href="index.jsp"
								class="glyphicon glyphicon-home"> Accueil</a></li>
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
			<div class="col-lg-4"></div>
			<div class="col-lg-4 notresize">
				<div class="corps-entete">BIENVENUE</div>
				<div class="corps-contenu">
					<form method="POST" action="LoginServlet">
						<div class="form-group">
							<label for="exampleInputEmail1">Login :</label> <input id="login"
								class="form-control" type="text"
								placeholder="Entrez votre login" name="login">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Password :</label> <input
								id="password" class="form-control" type="password"
								placeholder="Entez votre mot de passe" name="mdp">
						</div>
						<div class="form-check">
							<label class="form-check-label"> <input
								id="checkRememberMe" class="form-check-input" type="checkbox">
								Se souvenir de moi
							</label>
						</div>
						<div class="button-right">
							<button id="buttonConnection" class="btn btn-primary"
								type="submit">Se connecter</button>

						</div>
					</form>
				</div>
			</div>
			<div class="col-lg-4"></div>
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
