<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- ENTETE -->
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ProxiBanque</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<!-- CORPS -->
<body>

<!-- ==================================[BLOC CONTAINER]================================== -->
<div class="container">
	<!-- ==================================[BLOC HEADER]================================== -->
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-inverse bg-inverse">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp"><img src="img/logo.png" alt="Logo ProxiBanque"></a>
				</div>
				<div id="navbar1" class="navbar-collapse collapse">
					<div class="row menu">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#" class="glyphicon glyphicon-off"> Déconnexion</a></li>
						</ul>
					</div>
					<div class="row menu">
						<ul class="nav navbar-nav navbar-right">
							<li class="active dropdown">
								<a href="#" class="dropdown-toggle glyphicon glyphicon-credit-card" data-toggle="dropdown" role="button" aria-expanded="false"> Clients <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="clients.jsp">Afficher la liste</a></li>
									<li><a href="creerClient.jsp">Créer un client</a></li>
								</ul>
							</li>
							<li><a href="virement.jsp" class="glyphicon glyphicon-transfer"> Virement</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle glyphicon glyphicon-user" data-toggle="dropdown" role="button" aria-expanded="false"> Conseillers <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Afficher la liste</a></li>
									<li><a href="#">Créer un conseiller</a></li>
								</ul>
							</li>
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
		<div class="col-lg-12">
			<div class="corps-entete">EFFECTUER UN VIREMENT</div>
			<div class="corps-contenu">
				<form method="post" action="ProxyBanqueV2/VirementServlet">
					<div class="form-group">
						<label for="debiteurVirement">Identifiant du compte à débiter</label>
						<input id="debiteurVirement" class="form-control" name="debiteurVirement" type="number" placeholder="Identifiant du débiteur">
					</div>
					<div class="form-group">
						<label for="créditeurVirement">Identifiant du compte à créditer</label>
						<input id="créditeurVirement" class="form-control" name="crediteurVirement" type="number" placeholder="Identifiant du créditeur">
					</div>
					<div class="form-group">
						<label for="sommeVirement">Somme</label>
						<input id="sommeVirement" class="form-control" name="sommeVirement" type="number" placeholder="Entrez la somme de la transaction">
					</div>
					<div class="button-right">
					<button id="buttonCreateClient" class="btn btn-primary" type="submit">Appliquer</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- ==================================[BLOC CORPS]================================== -->
	
	<!-- ==================================[BLOC FOOTER]================================== -->
	<footer>
        <p>© 2017 <a href="http://www.gtm-ingenierie.fr/">GT'M Ingénierie</a>, All rights reserved 2017-2018.</p>
    </footer>
    <!-- ==================================[BLOC FOOTER]================================== -->
</div>
<!-- ==================================[BLOC CONTAINER]================================== -->
</body>
</html>
