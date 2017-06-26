package com.gtm.proxibanquev2.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class ClientDAO {

	public Client addClientBase(Client client) {

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

	public boolean removeClientBase(Client client) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.remove(client); // Pas sur de la méthode

		tx.commit();

		System.out.println("Voici le client supprimé" + client);

		em.close();
		emf.close();

		return true;
	}

	public boolean updateClientBase(Client client) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(client); // Pas sur de la méthode

		tx.commit();

		System.out.println("Voici le client supprimé" + client);

		em.close();
		emf.close();
		return true;

	}

	public Collection<Client> getListeCLient() {
		Collection<Client> resultat;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from Client");
		resultat = query.getResultList();
		tx.commit();

		em.close();
		emf.close();

		return resultat;
	}

public Client getCLient(Integer idclient ){
	
	
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	
	Client client = em.find(Client.class, idclient);
       
      
    	tx.commit();


    	em.close();
    	emf.close();
   
        
        
    return client;
	
	
}

public void getListeCLientConseiller(Conseiller conseiller){
	
}


}
