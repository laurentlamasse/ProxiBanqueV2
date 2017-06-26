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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

public class ConseillerDAO {

	public boolean addConseillerBase(Conseiller conseiller) {//Testé

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			
			String sql = "INSERT INTO `conseiller` " + "(`nom`, `prenom`, `id`,`login`,`mdp`)VALUES" + "(?,?,?,?,?)";
			pst = cn.prepareStatement(sql);

			pst.setString(1, conseiller.getNom());
			pst.setString(2, conseiller.getPrenom());
			pst.setInt(3, conseiller.getId());
			pst.setString(4, conseiller.getLogin());
			pst.setString(5, conseiller.getMdp());

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

	

	public boolean removeConseilleBase(Conseiller conseiller) { //testé Junit
		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			
			String sql = "DELETE FROM `conseiller` " + "WHERE `id`=?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, conseiller.getId());
			
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

	public List<Conseiller> getListeConseiller() { //testé en dur

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Conseiller> listeconseiller = new ArrayList<Conseiller>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();

			String sql = "SELECT * FROM `conseiller` WHERE 1 ";
			rs = st.executeQuery(sql);

			while (rs.next()) {
			Conseiller tempocons = new Conseiller(rs.getString("nom"),rs.getString("prenom"),rs.getInt("id"),rs.getString("login"),rs.getString("mdp"));
			listeconseiller.add(tempocons);
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
		return listeconseiller;

	}

	public Conseiller getOneConseiller(Conseiller conseiller) { //Testé en dur

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Conseiller conseillertrouve = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			
			String sql = "SELECT * FROM `conseiller` WHERE `id`=?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, conseiller.getId());
			rs = pst.executeQuery();
			rs.next();
			
			
			String nom =rs.getString(1);
			String prenom = rs.getString(2);
			int id = rs.getInt(3);
			String loginconseiller = rs.getString(4);
			String mdp = rs.getString(5);

			conseillertrouve = new Conseiller(nom, prenom, id, loginconseiller, mdp);
			//System.out.println("=====CONSEILLER TROUVER" + conseillertrouve);
			return conseillertrouve;
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
		return conseillertrouve;

	}
	
	public Conseiller getConseillerFromLogin (String loginEmploye){ //Fonctionne en dur, pas le test
		
		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Conseiller conseiller =null;
		String mdp =null;
		String log = null;
		String nom = null;
		String prenom = null;
		int id = 0;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "SELECT * FROM conseiller WHERE `login`=?";

			pst = cn.prepareStatement(sql);
			pst.setString(1, loginEmploye);

			rs = pst.executeQuery();

			rs.next();
			nom = rs.getString(1);
			prenom = rs.getString(2);
			id = rs.getInt(3);
			log = rs.getString(4);
			mdp = rs.getString(5);
			 

			conseiller = new Conseiller(nom, prenom, id,log,mdp);				
			//System.out.println(conseiller);
			return conseiller;

			
		} catch (SQLException e) {
			System.out.println("==========ERREUR 007=============");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conseiller;
		
		
	}

}
