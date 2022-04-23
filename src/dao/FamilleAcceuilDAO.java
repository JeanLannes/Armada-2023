package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table FamilleAcceuil
 * 
 * @author BA - Papa Amath
 * @version 1.0
 */

public class FamilleAcceuilDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public FamilleAcceuilDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter une famille d'acceuil dans la table supplier. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param familleAcceuil la famille d'acceuil à ajouter 
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(FamilleAcceuil familleAcceuil) {
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
			ps.setInt(1, familleAcceuil.getIdFamille());
			ps.setInt(2, familleAcceuil.getNbPlace());
	
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
	 * Permet de modifier une famille d'acceuil dans la table FamilleAcceuil. Le mode est
	 * auto-commit par defaut : chaque modification est validee
	 * 
	 * @param familleAcceuil la famille d'acceuil à modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(FamilleAcceuil familleAcceuil) {
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
			ps.setInt(1, familleAcceuil.getNbPlace());
			ps.setInt(2, familleAcceuil.getIdFamille());

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
	 * @param familleAcceuil le fournisseur a supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(FamilleAcceuil familleAcceuil) {
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
			ps.setInt(1, familleAcceuil.getIdFamille());

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
	 * @param idFamille la reference de la famille d'acceuil a récupérer
	 * @return la famille d'acceuil trouve; null si aucune famille d'acceuil ne correspond à
	 *         cette immatriculation
	 */
	public FamilleAcceuil get(int idFamille) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FamilleAcceuil returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM familleac WHERE IDFAMILLE = ?");
			ps.setInt(1, idFamille);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new FamilleAcceuil(rs.getInt("IDFAMILLE"), rs.getInt("NOMBREDEPLACE") );
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

	
	// main permettant de tester la classe (pour effectuer les test unitaires)
	public static void main(String[] args) throws SQLException {
		int returnValue;
		FamilleAcceuilDAO famille = new FamilleAcceuilDAO();
		// test du constructeur
		FamilleAcceuil f1 = new FamilleAcceuil(2367,123);
		FamilleAcceuil f2 = new FamilleAcceuil(213, 21);
		FamilleAcceuil f3 = new FamilleAcceuil(671,123);
		//test de la methode add
		returnValue = famille.add(f1);
		System.out.println(returnValue + " famille d'acceuil ajoutée");
		returnValue = famille.add(f2);
		System.out.println(returnValue + " famille d'acceuil ajoutée");
		returnValue = famille.add(f3);
		System.out.println(returnValue + " famille d'acceuil ajoutée");
		System.out.println();
		
		// appelà nouveau du constructeur
		FamilleAcceuil f4 = new FamilleAcceuil(2367, 45);
		FamilleAcceuil f5 = new FamilleAcceuil(213, 3);
		FamilleAcceuil f6 = new FamilleAcceuil(671, 56);
		// test de la methode update
		returnValue = famille.update(f4);
		System.out.println(returnValue + " famille d'acceuil MAJ");
		returnValue = famille.update(f5);
		System.out.println(returnValue + " famille d'acceuil MAJ");
		returnValue = famille.update(f6);
		System.out.println(returnValue + " famille d'acceuil MAJ");
		System.out.println();
		// test de la methode delete
		returnValue = 0;
		
		returnValue = famille.delete(f2);
		System.out.println(returnValue + " famille d'acceuil supprimée");

		System.out.println();
		
		
		// test de la methode get
		FamilleAcceuil p = famille.get(2367); 
		// appel implicite de la methode toString de la classe Object (à eviter)
		System.out.println(p);
		System.out.println();


		
		
	}

	
	
	

}
