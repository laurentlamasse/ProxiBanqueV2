package com.gtm.proxibanquev2.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class ConseillerDAO {

	public Conseiller addConseillerBase(Conseiller conseiller) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(conseiller);
		Conseiller conseiller2 = em.find(Conseiller.class, conseiller.getId());

		tx.commit();

		System.out.println("Voici le client inséré" + conseiller);

		em.close();
		emf.close();
		return conseiller2;

	}

	public boolean removeConseilleBase(Conseiller conseiller) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.remove(conseiller); // Pas sur de la méthode

		tx.commit();

		System.out.println("Voici le conseiller supprimé" + conseiller);

		em.close();
		emf.close();

		return true;
	}

	public Collection<Conseiller> getListeConseiller() {

		Collection<Conseiller> resultat;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from Conseiller");
		resultat = query.getResultList();
		tx.commit();

		// System.out.println("Voici l'humain inséré :" + humain);

		em.close();
		emf.close();

		return resultat;

	}

	public Conseiller getOneConseiller(Conseiller conseiller) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Conseiller conseiller2 = em.find(Conseiller.class, conseiller.getId());

		tx.commit();

		em.close();
		emf.close();

		return conseiller2;

	}
	
	public Conseiller getConseillerFromLogin (String login){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Conseiller conseiller = em.find(Conseiller.class, login);

		tx.commit();

		em.close();
		emf.close();

		return conseiller;
		
		
	}

}
