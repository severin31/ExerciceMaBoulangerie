package fr.gtm.projetboulangerie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.projetboulangerie.domaine.Boulanger;

public class BoulangerDAO {

	public void createBoulanger(Boulanger boulanger) {

		// Etape 1 Ajouter la Librairie my Sql -- ok

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/superboulangerie";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Préparer la requête
			st = cn.createStatement();

			// String sql = "INSERT INTO `persons` (`ID`, `LastName`, `FirstName`, `Age`)
			// VALUES (3, 'Hugo', 'Victor', 187)";

			String sql = "INSERT INTO `boulanger` (`nom`, `prenom`, `specialite`) " + "VALUES ('"
					+ boulanger.getNom() + "', '" + boulanger.getPrenom() + "', '" + boulanger.getSpecialite() + "')";
			// + + ", " + boulanger.getPrenom() + ", " + boulanger.getSpecialite() + ";)";
			// System.out.println(sql);

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

			System.out.println("Nouveau boulanger ajouté");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// : gestion erreur
			e.printStackTrace();
		} finally {

			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				// gestion erreur
				e.printStackTrace();
			}
		}

	}

	public Boulanger getBoulangerById(int id) {

		Boulanger boulanger = new Boulanger();

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/superboulangerie";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Préparer la requête
			st = cn.createStatement();

			String sql = "SELECT `id`, `nom`, `prenom`, `specialite` FROM `boulanger` WHERE `id` = " + id + ";";

			// Etape 4 : exécution requête
			ResultSet rs = st.executeQuery(sql);

			rs.next();
			String name = rs.getString("nom");
			String firstName = rs.getString("prenom");
			String specialite = rs.getString("specialite");
			System.out.println("Le boulanger " + name + " " + firstName + " " + specialite);

			boulanger.setId(id);
			boulanger.setNom(name);
			boulanger.setPrenom(firstName);
			boulanger.setSpecialite(specialite);

			// System.out.println("Insertion en base OK");

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
		return boulanger;
	}

	public Boulanger updateBoulanger(Boulanger boulanger) {
		return new Boulanger();
	}

	public void deleteBoulanger(Boulanger boulanger) {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/superboulangerie";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Préparer la requête
			st = cn.createStatement();

			// Ajout de la requete
			
			String sql = "DELETE FROM `boulanger` WHERE `id` = " + boulanger.getId();
			
			
			// System.out.println(sql);

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

			System.out.println("Le Boulanger a bien été supprimé");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// : gestion erreur
			e.printStackTrace();
		} finally {

			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				// gestion erreur
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Boulanger> getAllBoulanger() {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/superboulangerie";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		// Création de la liste des boulangers
		ArrayList<Boulanger> listeBoulangers = new ArrayList<Boulanger>();

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Préparer la requête
			st = cn.createStatement();

			String sql = "SELECT * FROM `boulanger`";
			// Etape 4 : exécution requête

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nom");
				String firstName = rs.getString("prenom");
				String specialite = rs.getString("specialite");
				

				// Creation d'un boulanger
				Boulanger b = new Boulanger(id, name, firstName, specialite);
				listeBoulangers.add(b);
			}

			// System.out.println("Insertion en base OK");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: gestion erreur
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				// TODO: gestion erreur
				e.printStackTrace();
			}
		}
		return listeBoulangers;

	}

}
