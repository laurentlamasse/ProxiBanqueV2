C'est Alex :
Donc ce qui a été modifié par rapport à hier en quittant objis :

-Couche domaine énormement modifiée, constructeurs, ToString, attributs ect qui étaient mals indiqués/construits/incomplets.
J'espère qu'il ne reste rien à modifier ce coup-ci.

-Couche Service : je n'ai pas changé grand chose de mémoire, peut être un appel de fonction

-Tests : j'ai commencé a faire des tests sur les fonctions de bases du CRUD comme add et remove.
Celles-ci vont bien mais Resultats etranges avec des assertsEquals

-CoucheDAO:
Normalement, sauf typo, tout ce qui est écrit est utilisable, pas de fonction qui renvoie d'erreur de base.
Clients : CRUD complet testé et dur et fonctionnel, retour de tous les clients ou ceux avec une ID de conseiller.
Conseiller : CRUD pas complet, manque la modif du conseiller, pas prioritaire, retour de liste implémenté.
Compte : Creation et supression implémentés et testés en dur et junit, ok (pour les 2 tables Epargne et Courant). 
	-> On peut vraiment édire un compte comme ca en changeant son montant?
	-> Je n'ai pas encore implémenté le filtre en fonction de l'ID client, je cherche la commande pour faire 2 tables en 1ligne

-Login: Fonctionne en dur, quand j'envoie mon Conseiller(login,mdp) j'ai bien mon double retour de true.



Presentation: testCrudUR : est ma feuille de test pour le CRUD, à supprimer avant la fin
AjoutClientServer : fini de rajouter les attributs manquant et fait l'appel du service, pas de dispatcher invoqué.
AjoutCompteCourant: permet d'ajouter un compte, pas de dispatcher 
ListeClients: renvoie la liste des Clients SANS ID spécifique, met en sessions la liste.
LoginServlet: normalement doit fonctionner depuis index.jsp, tests fait en dur mais impossible de lancer un serveur chez moi.
Même si les servlets ci dessus ne sont pas fini à 100% (les redirections par ex), au moins les listes vont être rapidement utilisables.



La BDD est fournie dans le github.

Globalement je n'ai rien touché pour le virement ni les exceptions.
J'ai rien touché au front/Web (sauf rajouté une action et une methode au formulaire de login, mais je ne peux pas le tester chez moi)

Comme ça il faudra penser à checker dans le web.xml les servlets et les url patterns insi qu'indiquer la première page de log.

En fonctionnalités donc je resume on peut à l'heure actuelle(en théorie si pas de bug pendant les tests grandeur nature et je n'ai pas fait les formulaires web).
Se loger et enregistre le conseiller en session
CRUD complet client, retourne tous les clients ou une partie seulement en indiquant le conseiller.
Ajout/supression des deux types de comptes dans deux tables séparées. Pas de retour ni de modifs.


Comme ça à chaud les prios sont pour les fonctionnalitées :
-Scanner les comptes en fonction de l'ID client, soit en 2 coups (2 tables), soit en 1.
-le virement, vraiment j'ai pas regardé.
-Tester ce putin de login,pour la petite histoire on a un contructeur Conseiller(login,mdp) mais le toString utilise aussi le id,
du coup j'avais une étape intermediaire avec un System.out.println de mon conseiller, qui me renvoyait toute le temps un nullpointer,
et la console n'indiquait pas que ca venait du toString, juste l'exception générale.
-le Service : Des méthodes dans compteDAO on été rajoutés, il faut leur rajouter des méthodes dans le service.