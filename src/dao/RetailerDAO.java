package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Commercant
 * 
 * @author BA - Papa Amath
 * @version 1.0
 */
public class RetailerDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public RetailerDAO()
	{
		super();
	}
	
	/**
	 * Permet d'ajouter un commercant  dans la table Commercant. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param commercant le commercant a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public static int add(Retailer retailer) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			ps = con.prepareStatement("INSERT INTO commercant (IDCOMMERCANT, ACTIVITE, STAND) VALUES (?, ?, ?)");
			ps.setInt(1, retailer.getIdRetailer());
			ps.setString(2, retailer.getActivity());
			ps.setString(3, retailer.getStand());
			
	
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("L'ID de ce commercant existe déjà. Ajout impossible !");
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
	 * @return int
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
			ps = con.prepareStatement("SELECT MAX(IDCOMMERCANT) FROM COMMERCANT");
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			rs.next();
			id=rs.getInt("MAX(IDCOMMERCANT)");
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

	public static Retailer get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Retailer returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM commercant WHERE IDCOMMERCANT = ?");
			ps.setInt(1, id);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Retailer(rs.getInt("IDCOMMERCANT"), rs.getString("ACTIVITE"), rs.getString("STAND"));
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
		if (returnValue==null)
			return new Retailer(0,"0","0");
		else 
			return returnValue;
	}

	public static int delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM COMMERCANT WHERE IDCOMMERCANT = ?");
			ps.setInt(1, id);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Suppression impossible !"
						+ " le plaisancier est référee dans d'autre table.");
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
	
}

