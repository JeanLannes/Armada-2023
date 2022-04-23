package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Bateau
 * 
 * @author BA - Papa Amath
 * @version 1.0
 */

public class BateauDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public BateauDAO()
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
	public int add(Bateau bateau) {
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
			ps.setInt(1, bateau.getIDBateau());
			ps.setString(2, bateau.getName());
			ps.setInt(3, bateau.getTailleBateau());
			ps.setString(4, bateau.getPavillon());
			ps.setString(5, bateau.getCapitaine());
			ps.setString(6, bateau.getImmatriculation());
			ps.setString(7, bateau.getTypeBateau());
			ps.setString(8, bateau.getDateCreation());
			
			
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
	
	/**
	 * Permet de modifier un bateau dans la Bateau. Le mode est
	 * auto-commit par defaut : chaque modification est validee
	 * 
	 * @param bateau le bateau à modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Bateau bateau) {
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
			ps = con.prepareStatement("UPDATE Bateau set NOMBATEAU = ?, TAILLEB = ?, PAVILLONB = ?, CAPITAINEB = ?, IMMATRICULATION = ?, TYPEBATEAU = ? ,DATECREATION = ? WHERE IDBATEAU = ?");
			ps.setString(1, bateau.getName());
			ps.setInt(2, bateau.getTailleBateau());
			ps.setString(3, bateau.getPavillon());
			ps.setString(4, bateau.getCapitaine());
			ps.setString(5, bateau.getImmatriculation());
			ps.setString(6, bateau.getTypeBateau());
			ps.setString(7, bateau.getDateCreation());
			ps.setInt(8, bateau.getIDBateau());

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
	 * Permet de supprimer un bateau dans la table Bateau. Si ce dernier
	 * est référencé dans d'autre table, la suppression n'aura pas lieu. Le mode est auto-commit
	 * par defaut : chaque suppression est validee
	 * 
	 * @param bateau à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(Bateau bateau) {
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
			ps = con.prepareStatement("DELETE FROM Bateau WHERE IDBATEAU = ?");
			ps.setInt(1, bateau.getIDBateau());

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
	 * Permet de recuperer un bateau à partir de son immatriculation
	 * 
	 * @param immatriculation l'immatriculation du Bateau a récupérer
	 * @return le bateau trouve; null si aucun bateau ne correspond a
	 *         cette immatriculation
	 */
	public Bateau get(int ID) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bateau returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM bateau WHERE IDBATEAU = ?");
			ps.setInt(1, ID);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Bateau(rs.getInt("IDBATEAU"), rs.getString("NOMBATEAU"), rs.getInt("TAILLEB"),
						rs.getString("PAVILLONB"), rs.getString("CAPITAINEB"), rs.getString("IMMATRICULATION"), rs.getString("TYPEBATEAU"), rs.getString("DATECREATION"));
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
				BateauDAO bateauDAO = new BateauDAO();
				// test du constructeur
				Bateau b1 = new Bateau(1, "A1", 4, "A2B", "djd","kbdk7278","Voilier","18/12/1993");
				Bateau b2 = new Bateau(2, "A1", 5, "A2B", "djd","kbdk7278","Voilier","18/12/1991");
				Bateau b3 = new Bateau(3, "A1", 6, "A2B", "djd","kbdk7278","Voilier","18/12/1994");
				// test de la methode add
				returnValue = bateauDAO.add(b1);
				System.out.println(returnValue + " Bateau ajouté");
				returnValue = bateauDAO.add(b2);
				System.out.println(returnValue + " Bateau ajouté");
				returnValue = bateauDAO.add(b3);
				System.out.println(returnValue + " Bateau ajouté");
				System.out.println();
				
				//Appel du nouveau constructeur
				Bateau b4 = new Bateau(1, "A231", 4, "A2B", "dZjd","kbdk7278","Voilier","18/12/1992");
				Bateau b5 = new Bateau(2, "A331", 5, "A2B", "djZd","kbdk7278","Voilier","18/12/1999");
				Bateau b6 = new Bateau(3, "A1231", 6, "A2B", "djZd","kbdk7278","Voilier","18/12/1991");
				// test de la methode update
				
				  returnValue = bateauDAO.update(b4); System.out.println(returnValue +
				  " bateau  MAJ"); returnValue = bateauDAO.update(b5);
				  System.out.println(returnValue + " bateau  MAJ"); returnValue =
				  bateauDAO.update(b6); System.out.println(returnValue +
				  " bateau  MAJ"); System.out.println(); // test de la methode delete
				  returnValue = 0;
				
				// test de la methode delete
				returnValue = 0;
				
				returnValue = bateauDAO.delete(b2);
				System.out.println(returnValue + " bateau supprime");

				System.out.println();
				
				// test de la methode get
				Bateau b = bateauDAO.get(3);
				// appel implicite de la methode toString de la classe Object (à eviter)
				System.out.println(b);
				System.out.println();
								
			}
		
}
