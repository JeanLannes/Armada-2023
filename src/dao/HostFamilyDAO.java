package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table HostFamily
 * 
 * @author BA - Papa Amath
 * @version 1.0
 */

public class HostFamilyDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public HostFamilyDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter une famille d'acceuil dans la table supplier. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param hostFamily la famille d'acceuil à ajouter 
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(HostFamily hostFamily) {
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
			ps = con.prepareStatement("INSERT INTO familleac (IDFAMILLE, NOMBREDEPLACE) VALUES (?, ?)");
			ps.setInt(1, hostFamily.getIdFamille());
			ps.setInt(2, hostFamily.getNbPlace());
	
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cette ID de famille d'acceuil  existe déjà. Ajout impossible !");
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
	 * Permet de modifier une famille d'acceuil dans la table HostFamily. Le mode est
	 * auto-commit par defaut : chaque modification est validee
	 * 
	 * @param hostFamily la famille d'acceuil à modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(HostFamily hostFamily) {
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
			ps = con.prepareStatement("UPDATE familleac set NOMBREDEPLACE = ? WHERE IDFAMILLE = ?");
			ps.setInt(1, hostFamily.getNbPlace());
			ps.setInt(2, hostFamily.getIdFamille());

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
	 * Permet de supprimer une famille d'acceuil dans la table familleac. Si ce dernier
	 * est référencé dans d'autre table, la suppression n'aura pas lieu. Le mode est auto-commit
	 * par defaut : chaque suppression est validee
	 * 
	 * @param hostFamily le fournisseur a supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(HostFamily hostFamily) {
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
			ps = con.prepareStatement("DELETE FROM familleac WHERE IDFAMILLE = ?");
			ps.setInt(1, hostFamily.getIdFamille());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Suppression impossible !"
						+ "Supprimer d'abord les références");
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
	 * Permet de recuperer une famille d'Acceuil à partir de son ID
	 * 
	 * @param idFamily la reference de la famille d'acceuil a récupérer
	 * @return la famille d'acceuil trouve; null si aucune famille d'acceuil ne correspond à
	 *         cette immatriculation
	 */
	public static HostFamily get(int idFamily) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HostFamily returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM familleac WHERE IDFAMILLE = ?");
			ps.setInt(1, idFamily);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new HostFamily(rs.getInt("IDFAMILLE"), rs.getInt("NOMBREDEPLACE") );
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
