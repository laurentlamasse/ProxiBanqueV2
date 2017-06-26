package com.gtm.proxibanquev2.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class ClientDAO {

	public Client addClientBase(Client client) {

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
			String sql = "INSERT INTO `Client` " + "(`Email`, `Adresse`, `NumeroClient`)VALUES" + "(?,?,?)";

			pst = cn.prepareStatement(sql);

			//pst.setString(1, client.getEmail());
			pst.setString(2, client.getAdresse());
			pst.setInt(3, client.getNumeroClient());
			pst.executeUpdate();
			return client;

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
		return client;
	}

	public boolean removeClientBase(Client client) {

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
			String sql = "DELETE FROM `Client` " + "WHERE `NumeroClient`=?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, client.getNumeroClient());
			pst.executeUpdate();

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
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Client> listeclient = new ArrayList();

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();

			String sql = "SELECT * FROM `Client` WHERE 1 ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Client tempoclient = new Client("nom", "prenom", rs.getString("Adresse"),  "codepostal", "ville" , "telephone", rs.getInt("NumeroClient"));
				listeclient.add(tempoclient);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeclient;
	}

	public Client getCLient(Integer idclient) {

		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Client client = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "SELECT * FROM `Client` WHERE `NumeroClient`=?";

			pst = cn.prepareStatement(sql);
			pst.setInt(1, idclient);
			rs = pst.executeQuery();

			System.out.println("Le client est cherché et l'ID est  " + idclient);

			rs.next();

			String email = rs.getString(1);

			String adresse = rs.getString(2);

			Integer numeroClient = rs.getInt(3);

			String type = rs.getString(4);
			client = new Client("nom", "prenom", adresse,  "codepostal", "ville" , "telephone", numeroClient);

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
		return client;

	}

	public void getListeCLientConseiller(Conseiller conseiller) {
		// TODO Auto-generated method stub
	}

	public List<Client> getListeClient() {
		// TODO Auto-generated method stub
		return null;
	}

}
