package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table PersonneMorale
 * 
 * @author BA - Papa Amath
 * @version 1.0
 */

public class CommercantDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public CommercantDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter un commercant  dans la table PersonneMorale. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param commercant le commercant  a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Commercant commercant) {
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
			ps = con.prepareStatement("INSERT INTO commercant (IDCOMMERCANT, ACTIVITE, STAND) VALUES (?, ?, ?)");
			ps.setInt(1, commercant.getIDcommercant());
			ps.setString(2, commercant.getActivite());
			ps.setString(3, commercant.getStand());
			
	
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
	 * Permet de modifier une un commercant dans la table commercant. Le mode est
	 * auto-commit par defaut : chaque modification est validee
	 * 
	 * @param commercaant la personneMorale à modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Commercant commercaant) {
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
			ps = con.prepareStatement("UPDATE commercant set ACTIVITE = ?, STAND = ?  WHERE IDCOMMERCANT = ?");
			ps.setString(1, commercaant.getActivite());
			ps.setString(2, commercaant.getStand());
			ps.setInt(3, commercaant.getIDcommercant());

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
	 * Permet de supprimer un commercant dans la table commercant. Si ce dernier
	 * est référencé dans d'autre table, la suppression n'aura pas lieu. Le mode est auto-commit
	 * par defaut : chaque suppression est validee
	 * 
	 * @param commercant la personneMorale à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(Commercant commercant) {
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
			ps = con.prepareStatement("DELETE FROM commercant WHERE IDCOMMERCANT = ?");
			ps.setInt(1, commercant.getIDcommercant());

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
	 * Permet de recuperer un commercant à partir de son ID
	 * 
	 * @param reference la reference du commercant a récupérer
	 * @return le commercant  trouve; null si aucune personne Morale ne correspond a
	 *         cette immatriculation
	 */
	public Commercant get(int idPersonneMorale) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Commercant returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM commercant WHERE IDCOMMERCANT = ?");
			ps.setInt(1, idPersonneMorale);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Commercant(rs.getInt("IDCOMMERCANT"), rs.getString("ACTIVITE"), rs.getString("STAND"));
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
	
	
	// main permettant de tester la classe (pour des test unitaires)
			public static void main(String[] args) throws SQLException {
				int returnValue;
				CommercantDAO commercant = new CommercantDAO();
				// test du constructeur
				Commercant c1 = new Commercant(2367, "oui", "19/12/1999");
				Commercant c2 = new Commercant(213, "oui", "11/12/2005");
				Commercant c3 = new Commercant(671, "OUI", "12/05/1905");
				//test de la methode add
				returnValue = commercant.add(c1);
				System.out.println(returnValue + " commercant ajouté");
				returnValue = commercant.add(c2);
				System.out.println(returnValue + " commercant ajouté");
				returnValue = commercant.add(c3);
				System.out.println(returnValue + " commercant ajouté");
				System.out.println();
				
				// appelà nouveau du constructeur
				Commercant c4 = new Commercant(2367, "WAB", "11/12/2999");
				Commercant c5 = new Commercant(213, "WAC", "09/06/1005");
				Commercant c6 = new Commercant(671, "WAD", "06/02/3905");
				// test de la methode update
				returnValue = commercant.update(c4);
				System.out.println(returnValue + " commercant MAJ");
				returnValue = commercant.update(c5);
				System.out.println(returnValue + " commercant MAJ");
				returnValue = commercant.update(c6);
				System.out.println(returnValue + " commercant MAJ");
				System.out.println();
				// test de la methode delete
				returnValue = 0;
				
				returnValue = commercant.delete(c2);
				System.out.println(returnValue + " commercant supprimé");

				System.out.println();
				
				
				// test de la methode get
				Commercant c = commercant.get(2367); 
				// appel implicite de la methode toString de la classe Object (à eviter)
				System.out.println(c);
				System.out.println();


				
				
			}
		
		
		
		
		

	

}

