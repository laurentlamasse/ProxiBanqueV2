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
							<li><a href="clients.jsp" class="glyphicon glyphicon-log-in"> Connexion</a></li>
						</ul>
					</div>
					<div class="row menu">
						<ul class="nav navbar-nav navbar-right">
							<li class="active"><a href="index.jsp" class="glyphicon glyphicon-home"> Accueil</a></li>
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
		<div class="col-lg-3"></div>
		<div class="col-lg-6">
			<div class="corps-entete">ERREUR</div>
			<div class="corps-contenu error-template">
			<h1>Oops!</h1>
			<h2>404 Not Found</h2>
			<div class="error-details">
			Désolé, une erreur est apparue. La page demandée n'existe pas !<br>
			</div>
			<div class="error-actions">
			<a href="" class="btn btn-primary">
				<i class="icon-home icon-white"></i> Take Me Home </a>
			<a href="" class="btn btn-default">
				<i class="icon-envelope"></i> Contact Support </a>
			</div>
			</div>
		</div>
		<div class="col-lg-3"></div>
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
