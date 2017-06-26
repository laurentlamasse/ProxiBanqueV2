package com.gtm.proxibanquev2.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.domaine.Virement;

public class CompteDAO {

	public void effectuerVirement(Virement virement) {// virement
	}

	public boolean modifierCompte(Compte compte) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(compte); // Pas sur de la méthode

		tx.commit();

		System.out.println("Voici le compte une fois modifié" + compte);

		em.close();
		emf.close();
		return true;
	}

	public Client addCompteBase(Client client, Compte compte) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(client);
		Client client2 = em.find(Client.class, client.getNumeroClient());

		tx.commit();

		System.out.println("Voici le client inséré" + client);

		em.close();
		emf.close();
		return client2;

	}

	public void removeCompte(Client client, Compte compte) {

	}

	public void getListeCompteOneClient(Client client) {

	}

	public void getCompte(Integer numerocompte) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Compte compte = em.find(Compte.class, numerocompte);

		tx.commit();

		em.close();
		emf.close();

	}

	public Collection<Compte> getListeCompte() {

		Collection<Compte> resultat;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from Compte");
		resultat = query.getResultList();
		tx.commit();

		em.close();
		emf.close();

		return resultat;

	}
}
