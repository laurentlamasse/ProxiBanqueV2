C'est Alex :
Donc ce qui a �t� modifi� par rapport � hier en quittant objis :

-Couche domaine �normement modifi�e, constructeurs, ToString, attributs ect qui �taient mals indiqu�s/construits/incomplets.
J'esp�re qu'il ne reste rien � modifier ce coup-ci.

-Couche Service : je n'ai pas chang� grand chose de m�moire, peut �tre un appel de fonction

-Tests : j'ai commenc� a faire des tests sur les fonctions de bases du CRUD comme add et remove.
Celles-ci vont bien mais Resultats etranges avec des assertsEquals

-CoucheDAO:
Normalement, sauf typo, tout ce qui est �crit est utilisable, pas de fonction qui renvoie d'erreur de base.
Clients : CRUD complet test� et dur et fonctionnel, retour de tous les clients ou ceux avec une ID de conseiller.
Conseiller : CRUD pas complet, manque la modif du conseiller, pas prioritaire, retour de liste impl�ment�.
Compte : Creation et supression impl�ment�s et test�s en dur et junit, ok (pour les 2 tables Epargne et Courant). 
	-> On peut vraiment �dire un compte comme ca en changeant son montant?
	-> Je n'ai pas encore impl�ment� le filtre en fonction de l'ID client, je cherche la commande pour faire 2 tables en 1ligne

-Login: Fonctionne en dur, quand j'envoie mon Conseiller(login,mdp) j'ai bien mon double retour de true.



Presentation: testCrudUR : est ma feuille de test pour le CRUD, � supprimer avant la fin
AjoutClientServer : fini de rajouter les attributs manquant et fait l'appel du service, pas de dispatcher invoqu�.
AjoutCompteCourant: permet d'ajouter un compte, pas de dispatcher 
ListeClients: renvoie la liste des Clients SANS ID sp�cifique, met en sessions la liste.
LoginServlet: normalement doit fonctionner depuis index.jsp, tests fait en dur mais impossible de lancer un serveur chez moi.
M�me si les servlets ci dessus ne sont pas fini � 100% (les redirections par ex), au moins les listes vont �tre rapidement utilisables.



La BDD est fournie dans le github.

Globalement je n'ai rien touch� pour le virement ni les exceptions.
J'ai rien touch� au front/Web (sauf rajout� une action et une methode au formulaire de login, mais je ne peux pas le tester chez moi)

Comme �a il faudra penser � checker dans le web.xml les servlets et les url patterns insi qu'indiquer la premi�re page de log.

En fonctionnalit�s donc je resume on peut � l'heure actuelle(en th�orie si pas de bug pendant les tests grandeur nature et je n'ai pas fait les formulaires web).
Se loger et enregistre le conseiller en session
CRUD complet client, retourne tous les clients ou une partie seulement en indiquant le conseiller.
Ajout/supression des deux types de comptes dans deux tables s�par�es. Pas de retour ni de modifs.


Comme �a � chaud les prios sont pour les fonctionnalit�es :
-Scanner les comptes en fonction de l'ID client, soit en 2 coups (2 tables), soit en 1.
-le virement, vraiment j'ai pas regard�.
-Tester ce putin de login,pour la petite histoire on a un contructeur Conseiller(login,mdp) mais le toString utilise aussi le id,
du coup j'avais une �tape intermediaire avec un System.out.println de mon conseiller, qui me renvoyait toute le temps un nullpointer,
et la console n'indiquait pas que ca venait du toString, juste l'exception g�n�rale.
-le Service : Des m�thodes dans compteDAO on �t� rajout�s, il faut leur rajouter des m�thodes dans le service.