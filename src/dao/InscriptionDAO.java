package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Inscription
 * 
 * @author DURAND Tom
 * @version 1.0
 */

public class InscriptionDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public InscriptionDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter une inscription dans la BDD.
	 * @param Inscription la personne Morale a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public static int add(Inscription inscription) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// Connexion a la BDD
		try {
			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// Preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// Les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO inscription (IDINSCRIPTION, PRENOMINSCRIPTION, NOMINSCRIPTION, ADRESSEMAIL, ACTIVITEINSCRIPTION) VALUES (?, ?, ?, ?, ?)");
			ps.setInt   (1, inscription.getId());
			ps.setString(2, inscription.getFirstName());
			ps.setString(3, inscription.getLastName());
			ps.setString(4, inscription.getMail());
			ps.setString(5, inscription.getActivity());
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
	 * Cette methode sert a obtenir l'id max dans la BDD. Cela permet de donner un nouvel id non-utilise.
	 * @return id 
	 */
	public static int getMaxID() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id=0;

		// Connexion a la BDD
		try {
			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// Selectionne l'ID Max des inscriptions
			ps = con.prepareStatement("SELECT MAX(IDINSCRIPTION) FROM INSCRIPTION");
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			rs.next();
			id=rs.getInt("MAX(IDINSCRIPTION)");

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
		return id;
	}

	public Inscription get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Inscription returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM inscription WHERE IDINSCRIPTION = ?");
			ps.setInt(1, id);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Inscription(rs.getInt("IDINSCRIPTION"), null, null, null, null);
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
}
