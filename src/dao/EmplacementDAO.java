package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Emplacement;

/**
 * Classe d'acces aux donnees contenues dans la table Emplacement
 * 
 * @author DURAND Tom
 * @version 1.0
 */

public class EmplacementDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public EmplacementDAO()
	{
		super();
	}

	public static void add(Emplacement emp) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// connexion a la base de donnees
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO emplacement (IDEMPLACEMENT, NOMEMPLACEMENT, RIVE, LONGUEUR) VALUES (?, ?, ?, ?)");
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getRive());
			ps.setString(4, emp.getLengh());
			// Execution de la requete
			ps.executeUpdate();
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cette immatriculation de emplacement existe d�j�. Ajout impossible !");
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
			ps = con.prepareStatement("SELECT MAX(IDEMPLACEMENT) FROM EMPLACEMENT");
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			rs.next();
			id=rs.getInt("MAX(IDEMPLACEMENT)");
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
		
	public static Emplacement get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emplacement returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM emplacement WHERE IDEMPLACEMENT = ?");
			ps.setInt(1, id);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Emplacement(rs.getInt("IDEMPLACEMENT"), rs.getString("NOMEMPLACEMENT"), rs.getString("RIVE"), rs.getString("TAILLE"));
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
			return new Emplacement();
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
			ps = con.prepareStatement("DELETE FROM emplacement WHERE IDEMPLACEMENT = ?");
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
