package com.gtm.proxibanquev2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class ClientDAO {

	public boolean addClientBase(Client client) { // Teste ok

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(client);
			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "INSERT INTO `Client` "
					+ "(`nom`, `prenom`, `email`,`ville`,`adresse`,`codePostal`,`telephone`,`numeroClient`,`numeroConseiller`)VALUES"
					+ "(?,?,?,?,?,?,?,?,?)";

			pst = cn.prepareStatement(sql);

			pst.setString(1, client.getNom());
			pst.setString(2, client.getPrenom());
			pst.setString(3, client.getEmail());
			pst.setString(4, client.getVille());
			pst.setString(5, client.getAdresse());
			pst.setString(6, client.getCodepostal());
			pst.setString(7, client.getTelephone());
			pst.setInt(8, client.getNumeroClient());
			pst.setInt(9, client.getNumeroconseiller());

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

	
	
	public boolean removeClientBase(Client client) { // Teste ok

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
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
	
	

	public boolean updateClientBase(Client client) {//Teste en dur ok

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			
			String sql = "UPDATE `client` SET nom=?,prenom =?, email=?, ville=?, adresse=?,codePostal=?,telephone=?,numeroClient=?, numeroConseiller=? WHERE numeroClient=" + client.getNumeroClient();

			pst = cn.prepareStatement(sql);

			pst.setString(1, client.getNom());
			pst.setString(2, client.getPrenom());
			pst.setString(3, client.getEmail());
			pst.setString(4, client.getVille());
			pst.setString(5, client.getAdresse());
			pst.setString(6, client.getCodepostal());
			pst.setString(7, client.getTelephone());
			pst.setInt(8, client.getNumeroClient());
			pst.setInt(9, client.getNumeroconseiller());

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

	public List<Client> getListeCLient() { //Fonctionne
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

			String sql = "SELECT * FROM `client` WHERE 1 ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Client tempoclient = new Client(rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"),
						rs.getString("codePostal"), rs.getString("email"), rs.getString("ville"),
						rs.getString("telephone"), rs.getInt("numeroConseiller"), rs.getInt("numeroClient"));
				listeclient.add(tempoclient);

			}
		} catch (SQLException e) {
			System.out.println("SQL EXCEPTION");

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

	public Client getCLient(int idclient) {

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

			String sql = "SELECT * FROM `client` WHERE `numeroClient`=?";
			// String sql = "SELECT * FROM `client` WHERE `id`=?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, idclient);
			System.out.println("avant lr rs");

			rs = pst.executeQuery(sql); // Bug ICI
			System.out.println("avant le next");

			rs.next();

			// System.out.println("Le client est cherché et l'ID est " +
			// idclient);

			System.out.println("avant le client");

			client = new Client(rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"),
					rs.getString("codePostal"), rs.getString("email"), rs.getString("ville"), rs.getString("telephone"),
					rs.getInt("numeroConseiller"), rs.getInt("numeroClient"));

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

	public ArrayList<Client> getListeCLientConseiller(Conseiller conseiller) { //testé en dur, fonctionne
		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Client> listeclientConseiller = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);

			String sql = "SELECT * FROM `client` WHERE `numeroConseiller`=?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, conseiller.getId());
			System.out.println("Dans le try"+  conseiller. getId());

			rs = pst.executeQuery();

			while (rs.next()) {

				Client tempoclient = new Client(rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"),
						rs.getString("codePostal"), rs.getString("email"), rs.getString("ville"),
						rs.getString("telephone"), rs.getInt("numeroConseiller"), rs.getInt("numeroClient"));
				listeclientConseiller.add(tempoclient);

			}
		} catch (SQLException e) {
			System.out.println("SQL EXCEPTION");

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
		return listeclientConseiller;
	}

}
