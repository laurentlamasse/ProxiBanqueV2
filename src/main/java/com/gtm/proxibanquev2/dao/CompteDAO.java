package com.gtm.proxibanquev2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Compte;
import com.gtm.proxibanquev2.domaine.CompteCourant;
import com.gtm.proxibanquev2.domaine.CompteEpargne;
import com.gtm.proxibanquev2.domaine.Virement;

public class CompteDAO {
	
	public boolean addCompteCourant(CompteCourant comptecourant) {//testé en dur, fonctionne

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "INSERT INTO `comptecourant` " + "(`numeroCompte`, `plafond`,`idclient`,`solde`)VALUES" + "(?,?,?,?)";
			pst = cn.prepareStatement(sql);

			pst.setInt(1, comptecourant.getNumeroCompte());
			pst.setInt(2, comptecourant.getDecouvert());
			pst.setInt(3, comptecourant.getNumeroClient());
			pst.setFloat(4, comptecourant.getSolde());

			
			pst.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	public boolean addCompteEpargne(CompteEpargne compteepagne) {//testé en dur, fonctionne

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			// public Client(String email, String adresse, int numeroClient){
			String sql = "INSERT INTO `compteepargne` " + "(`numeroCompte`, `solde`,`numeroClient`,`remuneration`)VALUES" + "(?,?,?,?)";
			pst = cn.prepareStatement(sql);

			pst.setInt(1, compteepagne.getNumeroCompte());
			pst.setFloat(2, compteepagne.getSolde());
			pst.setInt(3, compteepagne.getNumeroClient());
			pst.setFloat(4, compteepagne.getRemuneration());

			
			pst.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	

	
	public boolean modifierCompte(Compte compte) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			// public Client(String email, String adresse, int numeroClient){
			String sql = "UPDATE `Compte` " + "WHERE (`NumeroCompte`, `Solde`)VALUES" + "(?,?)";

			pst = cn.prepareStatement(sql);

			pst.setInt(1, compte.getNumeroCompte());
			pst.setFloat(2, compte.getSolde());
			pst.executeUpdate();
			/*
			int numcomptelu = rs.getInt(1);
			Float soldelu = rs.getFloat(2);
			*/
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
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
	

	public void effectuerVirement(Virement virement) {// virement
	}

	
}
