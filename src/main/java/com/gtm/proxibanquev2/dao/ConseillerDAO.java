package com.gtm.proxibanquev2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gtm.proxibanquev2.domaine.Client;
import com.gtm.proxibanquev2.domaine.Conseiller;

import domaine.Livre;

public class ConseillerDAO {

	public Conseiller addConseillerBase(Conseiller conseiller) {

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
			String sql = "INSERT INTO `Conseiller` " + "(`ID`, `Login`, `Mdp`)VALUES" + "(?,?,?)";

			pst = cn.prepareStatement(sql);

			pst.setInt(1, conseiller.getId());
			pst.setString(2, conseiller.getLogin());
			pst.setString(3, conseiller.getMdp());
			pst.executeUpdate();
			return conseiller;

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
		return conseiller;
	}

	

	public boolean removeConseilleBase(Conseiller conseiller) {
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
			String sql = "DELETE FROM `Client` " + "WHERE `ID`=?";

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

	public Collection<Conseiller> getListeConseiller() {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Conseiller> listeconseiller = new ArrayList();

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();

			String sql = "SELECT * FROM `Conseiller` WHERE 1 ";
			rs = st.executeQuery(sql);

			while (rs.next()) {

				Conseiller tempocons = new Conseiller(rs.getInt("ID"), rs.getString("Login"),
						rs.getString("Mdp"));
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

	public Conseiller getOneConseiller(Conseiller conseiller) {

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
			String sql = "SELECT * FROM `Conseiller` WHERE `ID`=?";

			pst = cn.prepareStatement(sql);
			pst.setInt(1, conseiller.getId());
			rs = pst.executeQuery();

			System.out.println("Le conseiller est cherché et l'ID est  " + conseiller.getId());

			rs.next();

			int id = rs.getInt(1);

			String log = rs.getString(2);

			String  mdp = rs.getString(3);

			 conseillertrouve = new Conseiller(id, log, mdp);

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
	
	public Conseiller getConseillerFromLogin (String loginEmploye){
		
		String url = "jdbc:mysql://localhost/libraire";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Conseiller conseiller =null;
		String mdp =null;
		String log = null;
		int id = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "SELECT * FROM `Conseiller` WHERE `Login`=?";

			pst = cn.prepareStatement(sql);
			pst.setString(1, loginEmploye);

			rs = pst.executeQuery();

			rs.next();

			id = rs.getInt(1);
			log = rs.getString(2);
			 mdp = rs.getString(3);
			System.out.println("Lemdp du conseiller est " + mdp);

			conseiller = new Conseiller(id,log,mdp);				

			return conseiller;

			// }
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
