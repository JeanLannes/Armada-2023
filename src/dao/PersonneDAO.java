package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Personne
 * 
 * @author DURAND Tom
 * @version 1.0
 */

public class PersonneDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public PersonneDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter une personne dans la BDD. Chaque personne est liée à une fonction, chaque personne est liée à un compte participant
	 * @param Personne la personne a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public static int add(Personne personne) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// Connexion a la BDD
		try {
			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO personne (ID, FIRST_NAME, LAST_NAME, FUNCTION, BIRTHDATE) VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, personne.getId());
			ps.setString(2, personne.getFirstName());
			ps.setString(3, personne.getLastName());
			ps.setInt(4, personne.getFunction());
			ps.setString(5, personne.getBirthday());
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Erreur !");
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
	 * Permet d'obtenir les informations d'une personne en fonction de son id
	 * @param int id la personne recherchee
	 * @return Personne
	 */
	public static Personne get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Personne returnValue = null;

		// connexion a la base de donnees
		try {
			// Tentative de connection
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// Requête
			ps = con.prepareStatement("SELECT * FROM personne WHERE ID = ?");
			ps.setInt(1, id);
			// Execution de la requête
			rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = new Personne(rs.getInt("ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getInt("FUNCTION"), rs.getString("BIRTHDATE"));
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

	public static void update(Personne per) {
	Connection con = null;
	PreparedStatement ps = null;
	// connexion a la base de donnees
	try {

		// Tentative de connexion
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		// Requete
		ps = con.prepareStatement("UPDATE personne set BIRTHDATE = ?, FIRST_NAME = ?, LAST_NAME = ?, FUNCTION = ?  WHERE ID = ?");
		ps.setString(1, per.getBirthday());
		ps.setString(2, per.getFirstName());
		ps.setString(3, per.getLastName());
		ps.setInt(4, per.getFunction());
		ps.setInt(5, per.getId());
		// Execution de la requete
		ps.executeUpdate();

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
}
}
