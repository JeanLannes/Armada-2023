package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Adresse
 * 
 * @author BA - Papa Amath
 * @version 1.0
 */

public class AdresseDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public AdresseDAO() {
		super();
	}

	/**
	 * Permet d'ajouter une adresse dans la BDD. 
	 * @param adresse l'adresse a ajouter
	 * @return int retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Adresse adresse) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO adresse (IDADRESSE, ADRESSE) VALUES (?, ?)");
			ps.setInt(1, adresse.getIdAdresse());
			ps.setString(2, adresse.getAdresse());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cette adresse existe déjà. Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de modifier une adresse dans la BDD. 
	 * @param adresse l'adresse a modifier
	 * @return int
	 */
	public int update(Adresse adresse) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE adresse set ADRESSE = ? WHERE IDADRESSE = ?");
			ps.setString(1, Adresse.getAdresse());
			ps.setInt(2, Adresse.getIdAdresse());

			// Execution de la requete

			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de supprimer une adresse dans la BDD. 
	 * @param adresse l'adresse a supprimer
	 * @return int
	 */
	public int delete(Adresse Adresse) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du fournisseur
			ps = con.prepareStatement("DELETE FROM adresse WHERE IDADRESSE = ?");
			ps.setInt(1, Adresse.getIdAdresse());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Suppression impossible !" + "Supprimer d'abord les références");
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet d'obtenir une adresse dans la BDD. 
	 * @param idAdresse id de l'adresse a obtenir
	 * @return Adresse 
	 */
	public Adresse get(int idAdresse) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Adresse returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM adresse WHERE IDADRESSE = ?");
			ps.setInt(1, idAdresse);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Adresse(rs.getInt("IDADRESSE"), rs.getString("ADRESSE"));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	
	/*
	// main permettant de tester la classe (pour des test unitaires)
	public static void main(String[] args) throws SQLException {
		int returnValue;
		AdresseDAO adresse = new AdresseDAO();
		// test du constructeur
		Adresse p1 = new Adresse(2367, "AGood");
		Adresse p2 = new Adresse(213, "B2aZ");
		Adresse p3 = new Adresse(671, "SGood");
		// test de la methode add
		returnValue = adresse.add(p1);
		System.out.println(returnValue + " Adresse Ajoutée ajoutée");
		returnValue = adresse.add(p2);
		System.out.println(returnValue + " Adresse Ajoutée ajoutée");
		returnValue = adresse.add(p3);
		System.out.println(returnValue + " Adresse Ajoutée ajoutée");
		System.out.println();

		// appelà nouveau du constructeur
		
		  Adresse p4 = new Adresse(2367, "WAB");
		  Adresse p5 = new Adresse(213, "WAC");
		  Adresse p6 = new Adresse(671, "WAD");
		 
		// test de la methode update
		
		  returnValue = adresse.update(p4); System.out.println(returnValue +
		  " Personne Morale MAJ"); returnValue = adresse.update(p5);
		  System.out.println(returnValue + " Personne Morale MAJ"); returnValue =
		  adresse.update(p6); System.out.println(returnValue +
		  " Personne Morale MAJ"); System.out.println(); // test de la methode delete
		  returnValue = 0;
		 

		returnValue = adresse.delete(p2);
		System.out.println(returnValue + " Adresse supprimée");

		System.out.println();

		// test de la methode get
		Adresse p = adresse.get(2367);
		// appel implicite de la methode toString de la classe Object (à eviter)
		System.out.println(p);
		System.out.println();

	}
	*/
}
