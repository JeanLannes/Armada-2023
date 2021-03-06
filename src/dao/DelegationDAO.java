package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Delegation
 * 
 * @author DURAND Tom
 * @version 1.0
 */

public class DelegationDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public DelegationDAO()
	{
		super();
	}
	
	public static int add(Delegation del) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		int number = 0;
		String country = null;
		ResultSet rs = null;
		// connexion a la base de donnees
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM delegation WHERE PAYS = ?");
			ps.setString(1, del.getCountry());
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				country = rs.getString("PAYS");
				number = rs.getInt("NOMBREDEPERSONNES")+1;
				ps = con.prepareStatement("UPDATE DELEGATION set NOMBREDEPERSONNES = ? WHERE PAYS = ?");
				ps.setString(1, country);
				ps.setInt(2, number);
				// Execution de la requete
				returnValue = ps.executeUpdate();
			} else {
				ps = con.prepareStatement("INSERT INTO delegation (IDDELEGATION, PAYS, NOMBREDEPERSONNES) VALUES (?, ?, 1)");
				ps.setInt(1, del.getId());
				ps.setString(2, del.getCountry());
				// Execution de la requete
				returnValue = ps.executeUpdate();
			}	
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cette immatriculation de delegation existe d�j�. Ajout impossible !");
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
			ps = con.prepareStatement("SELECT MAX(IDDELEGATION) FROM DELEGATION");
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			rs.next();
			id=rs.getInt("MAX(IDDELEGATION)");
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
		
	public static Delegation get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Delegation returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM delegation WHERE IDDELEGATION = ?");
			ps.setInt(1, id);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Delegation(rs.getInt("IDDELEGATION"), rs.getString("PAYS"), rs.getInt("NOMBREDEPERSONNES"));
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
			return new Delegation(0,"0",0);
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
			ps = con.prepareStatement("DELETE FROM delegation WHERE IDDELEGATION = ?");
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
