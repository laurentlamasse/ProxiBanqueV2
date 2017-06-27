package com.gtm.proxibanquev2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.gtm.proxibanquev2.domaine.Conseiller;
import com.gtm.proxibanquev2.domaine.Virement;

public class CompteDAO {

	public boolean addCompteCourant(CompteCourant comptecourant) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "INSERT INTO `comptecourant` " + "(`numeroCompte`, `plafond`,`numeroClient`,`solde`)VALUES"
					+ "(?,?,?,?)";
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

	public boolean removeCompteCourant(CompteCourant comptecourant) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "DELETE FROM `comptecourant` " + "WHERE `numeroCompte`=?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, comptecourant.getNumeroCompte());
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

	public boolean addCompteEpargne(CompteEpargne compteepagne) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "INSERT INTO `compteepargne` "
					+ "(`numeroCompte`, `solde`,`numeroClient`,`remuneration`)VALUES" + "(?,?,?,?)";
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

	public boolean removeCompteEpargne(CompteEpargne compteepagne) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "DELETE FROM `compteepargne` " + "WHERE `numeroCompte`=?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, compteepagne.getNumeroCompte());
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

	public boolean modifierCompteCourantMontant(int numCompte, float nouveausolde) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "UPDATE `compte` " + "WHERE numeroCompte =" + numCompte;

			pst = cn.prepareStatement(sql);
			pst.setFloat(4, nouveausolde);
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

	public boolean modifierCompteEpargneMontant(int numCompte, float nouveausolde) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "UPDATE `compte` " + "WHERE numeroCompte =" + numCompte;

			pst = cn.prepareStatement(sql);
			pst.setFloat(2, nouveausolde);
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

	public ArrayList<? extends Compte> getListeCompteOneClient(Client client) {
		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<? extends Compte> listeCompteOneClient = new ArrayList();

		try {

			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);
			String sql = "SELECT * FROM comptecourant AS CC, `compteepargne`AS CE WHERE CE.numeroClient = ? || CC.idclient = ? ";

			pst = cn.prepareStatement(sql);

			pst.setInt(1, client.getNumeroClient());
			pst.setInt(2, client.getNumeroClient());
			rs = pst.executeQuery();

			return listeCompteOneClient;

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
		return listeCompteOneClient;

	}

	public CompteCourant getCompteCourant(Integer idclient) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		CompteCourant comptecourant = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);

			String sql = "SELECT * FROM `comptecourant` WHERE `numeroClient`=" + idclient;
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery(sql);

			rs.next();

			comptecourant = new CompteCourant(rs.getInt("numeroCompte"), rs.getFloat("solde"), rs.getInt("plafond"),
					rs.getInt("numeroCompte"));

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
		return comptecourant;

	}

	public CompteEpargne getCompteEpargne(Integer idclient) {

		String url = "jdbc:mysql://localhost/proxybanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		CompteEpargne compteepargne = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);

			String sql = "SELECT * FROM `compteepargne` WHERE `numeroClient`=" + idclient;
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery(sql);

			rs.next();
			compteepargne = new CompteEpargne(rs.getInt("numeroCompte"), rs.getFloat("solde"),
					rs.getFloat("remuneration"), rs.getInt("numeroCompte"));

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
		return compteepargne;

	}

}
