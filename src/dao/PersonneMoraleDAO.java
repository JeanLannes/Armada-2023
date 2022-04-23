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

public class PersonneMoraleDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public PersonneMoraleDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter une personne morale dans la table PersonneMorale. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param personneMorale la personne Morale a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(PersonneMorale personneMorale) {
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
			ps = con.prepareStatement("INSERT INTO personnemorale (IDPM, NOMPM, PRENOMPM, DATEDENAISSANCEPM, SEXEPM, EMAILPM) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt   (1, personneMorale.getIdPersonneMorale());
			ps.setString(2, personneMorale.getName());
			ps.setString(3, personneMorale.getSurname());
			ps.setString(4, personneMorale.getDateDeNaissance());
			ps.setString(5, personneMorale.getSexe());
			ps.setString(6, personneMorale.getEmail());
	
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Ce idPersonneMorale existe d�j�. Ajout impossible !");
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
	 * Permet de modifier une personne morale dans la table PersonneMorale. Le mode est
	 * auto-commit par defaut : chaque modification est validee
	 * 
	 * @param personneMorale la personneMorale à modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(PersonneMorale personneMorale) {
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
			ps = con.prepareStatement("UPDATE personnemorale set NOMPM = ?, PRENOMPM = ?, DATEDENAISSANCEPM = ?, SEXEPM = ?, EMAILPM = ?  WHERE IDPM = ?");
			ps.setString(1, personneMorale.getName());
			ps.setString(2, personneMorale.getSurname());
			ps.setString(3, personneMorale.getDateDeNaissance());
			ps.setString(4, personneMorale.getSexe());
			ps.setString(5, personneMorale.getEmail());
			ps.setInt   (6, personneMorale.getIdPersonneMorale());

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
	 * Permet de supprimer une personneMorale dans la table PersonneMorale. Si ce dernier
	 * est référencé dans d'autre table, la suppression n'aura pas lieu. Le mode est auto-commit
	 * par defaut : chaque suppression est validee
	 * 
	 * @param personneMorale la personneMorale à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(PersonneMorale personneMorale) {
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
			ps = con.prepareStatement("DELETE FROM personnemorale WHERE IDPM = ?");
			ps.setInt(1, personneMorale.getIdPersonneMorale());

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
	 * Permet de recuperer une personneMoralel à partir de son ID
	 * 
	 * @param reference la reference de la personne Morale a récupérer
	 * @return la personne Morale trouve; null si aucune personne Morale ne correspond a
	 *         cette immatriculation
	 */
	public PersonneMorale get(int idPersonneMorale) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PersonneMorale returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personnemorale WHERE IDPM = ?");
			ps.setInt(1, idPersonneMorale);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new PersonneMorale(rs.getInt("IDPM"), rs.getString("NOMPM"), rs.getString("PRENOMPM"), rs.getString("DATEDENAISSANCEPM"), rs.getString("SEXEPM"),rs.getString("EMAILPM"));
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
				PersonneMoraleDAO personneMorale = new PersonneMoraleDAO();
				// test du constructeur
				PersonneMorale p1 = new PersonneMorale(2367, "BZ1", "AGood", "19/12/1999","m","A@gmail.com");
				PersonneMorale p2 = new PersonneMorale(213, "B2aZ", "ABad", "11/12/2005","m","B@gmail.com");
				PersonneMorale p3 = new PersonneMorale(671, "B3aS", "SGood", "12/05/1905","m","C@gmail.com");
				//test de la methode add
				returnValue = personneMorale.add(p1);
				System.out.println(returnValue + " Personne Morale ajoutée");
				returnValue = personneMorale.add(p2);
				System.out.println(returnValue + " Personne Morale ajoutée");
				returnValue = personneMorale.add(p3);
				System.out.println(returnValue + " Personne Morale ajoutée");
				System.out.println();
				
				// appelà nouveau du constructeur
				PersonneMorale p4 = new PersonneMorale(2367, "WAB","shs" ,"11/12/2999"," M","A@gmail.com");
				PersonneMorale p5 = new PersonneMorale(213, "WAC", "fkr","09/06/1005", " M","B@gmial.com");
				PersonneMorale p6 = new PersonneMorale(671, "WAD", "nd,","06/02/3905", " M","C@gmail.com");
				// test de la methode update
				returnValue = personneMorale.update(p4);
				System.out.println(returnValue + " Personne Morale MAJ");
				returnValue = personneMorale.update(p5);
				System.out.println(returnValue + " Personne Morale MAJ");
				returnValue = personneMorale.update(p6);
				System.out.println(returnValue + " Personne Morale MAJ");
				System.out.println();
				// test de la methode delete
				returnValue = 0;
				
				returnValue = personneMorale.delete(p2);
				System.out.println(returnValue + " personneMorale supprimée");

				System.out.println();
				
				
				// test de la methode get
				PersonneMorale p = personneMorale.get(2367); 
				// appel implicite de la methode toString de la classe Object (à eviter)
				System.out.println(p);
				System.out.println();


				
				
			}
		
		
		
		
		

	

}
