package dao; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Bateau
 * 
 * @author BA - Papa Amath
 * @version 1.0
 */

public class BoatDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public BoatDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter un bateau dans la table Bateau. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param bateau le bateau à ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public static int add(Boat boat) {
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
			ps = con.prepareStatement("INSERT INTO bateau (IDBATEAU, NOMBATEAU, TAILLEB, PAVILLONB, CAPITAINEB, IMMATRICULATION, TYPEBATEAU, DATECREATION) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, boat.getIdBoat());
			ps.setString(2, boat.getName());
			ps.setInt(3, boat.getLengh());
			ps.setString(4, boat.getFlag());
			ps.setString(5, boat.getCaptain());
			ps.setString(6, boat.getImmatriculation());
			ps.setString(7, boat.getType());
			ps.setString(8, boat.getDate());
			
			
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cette immatriculation de bateau existe d�j�. Ajout impossible !");
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
			ps = con.prepareStatement("SELECT MAX(IDBATEAU) FROM BATEAU");
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			rs.next();
			id=rs.getInt("MAX(IDBATEAU)");
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
		
}
