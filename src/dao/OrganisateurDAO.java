package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Organisateur
 * 
 * @author DURAND Tom
 * @version 1.0
 */

public class OrganisateurDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public OrganisateurDAO()
	{
		super();
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
			ps = con.prepareStatement("SELECT MAX(IDORGANISATEUR) FROM ORGANISATEUR");
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			rs.next();
			id=rs.getInt("MAX(IDORGANISATEUR)");

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

	public static Organisateur get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Organisateur returnValue = null;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM organisateur WHERE IDORGANISATEUR = ?");
			ps.setInt(1, id);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Organisateur(rs.getInt("IDORGANISATEUR"), rs.getString("PRENOMORGANISATEUR"), rs.getString("NOMORGANISATEUR"), rs.getString("EMAILORGANISATEUR"), rs.getString("PASSWORD"));
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
	
	/**
	 * Permet de retrouver un compte dans la BDD via le MAIL et le MDP
	 * @param mail MAIL DU COMPTE ORGANISATEUR
	 * @param password MOT DE PASSE DU COMPTE ORGANISATEUR
	 * @return Organisateur
	 */
	public static Organisateur SignIn (String mail, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Organisateur returnValue = null;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);	//CONNECTION A LA BDD
			ps = con.prepareStatement("SELECT * FROM organisateur WHERE EMAILORGANISATEUR = ? AND PASSWORD = ?");	//REQUETE
			ps.setString(1, mail);
			ps.setString(2, password);
			rs = ps.executeQuery();	//EXECTUTION DE LA REQUETE
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Organisateur(rs.getInt("IDORGANISATEUR"), rs.getString("PRENOMORGANISATEUR"), rs.getString("EMAILORGANISATEUR"), rs.getString("NOMORGANISATEUR"), rs.getString("PASSWORD"));
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