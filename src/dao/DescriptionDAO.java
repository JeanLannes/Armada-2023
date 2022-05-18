package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import GUI.DescriptionSheet;
import GUI.EditParticipant;
import GUI.Main;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Description
 * 
 * @author DURAND Tom
 * @version 1.0
 */

public class DescriptionDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public DescriptionDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter une fiche descriptive dans la BDD.
	 * @param description la fiche descriptive a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public static int add(Description desc) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		ResultSet rs = null;
			
		// connexion a la base de donnees
		try {
			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
				
			// Verifie que le mail n'est pas deja utilise


			// Insert dans la BDD le nouveau participant
			ps = con.prepareStatement("INSERT INTO fichedescriptive (IDFICHE, NOMFICHE, DESCRIPTIONFICHE) VALUES (?, ?, ?)");			
			ps.setInt   (1, desc.getIdSheet());
			ps.setString(2, desc.getName());
			ps.setString(3, desc.getDescription());
			rs = ps.executeQuery();
			rs.next();	
			return returnValue;
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Erreur : L'id est deja associe");
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
			ps = con.prepareStatement("SELECT MAX(IDFICHE) FROM FICHEDESCRIPTIVE");
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			rs.next();
			id=rs.getInt("MAX(IDFICHE)");

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
	
	public static Description get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Description returnValue = null;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM fichedescriptive WHERE IDFICHE = ?");
			ps.setInt(1, id);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Description(rs.getInt("IDFICHE"), rs.getString("NOMFICHE"), rs.getString("DESCRIPTIONFICHE"));
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
