package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table LegalPerson
 * 
 * @author BA - Papa Amath
 * @version 1.0
 */

public class LegalPersonDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public LegalPersonDAO()
	{
		super();
	}
	

	/**
	 * Permet d'ajouter une personne morale dans la table LegalPerson. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param legalPerson la personne Morale a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(LegalPerson legalPerson) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO personnemorale (IDPM, NOMPM, PRENOMPM, DATEDENAISSANCEPM, SEXEPM, EMAILPM) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt   (1, legalPerson.getIdLegalPerson());
			ps.setString(2, legalPerson.getName());
			ps.setString(3, legalPerson.getSurname());
			ps.setString(4, legalPerson.getBirthday());
			ps.setString(5, legalPerson.getSexe());
			ps.setString(6, legalPerson.getEmail());
	
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Ce idLegalPerson existe d�j�. Ajout impossible !");
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
	 * Permet de modifier une personne morale dans la table LegalPerson. Le mode est
	 * auto-commit par defaut : chaque modification est validee
	 * 
	 * @param legalPerson la legalPerson à modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(LegalPerson legalPerson) {
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
			ps.setString(1, legalPerson.getName());
			ps.setString(2, legalPerson.getSurname());
			ps.setString(3, legalPerson.getBirthday());
			ps.setString(4, legalPerson.getSexe());
			ps.setString(5, legalPerson.getEmail());
			ps.setInt   (6, legalPerson.getIdLegalPerson());

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
	 * Permet de supprimer une legalPerson dans la table LegalPerson. Si ce dernier
	 * est référencé dans d'autre table, la suppression n'aura pas lieu. Le mode est auto-commit
	 * par defaut : chaque suppression est validee
	 * 
	 * @param legalPerson la legalPerson à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(LegalPerson legalPerson) {
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
			ps.setInt(1, legalPerson.getIdLegalPerson());

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
	 * Permet de recuperer une legalPersonl à partir de son ID
	 * 
	 * @param reference la reference de la personne Morale a récupérer
	 * @return la personne Morale trouve; null si aucune personne Morale ne correspond a
	 *         cette immatriculation
	 */
	public LegalPerson get(int idLegalPerson) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LegalPerson returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personnemorale WHERE IDPM = ?");
			ps.setInt(1, idLegalPerson);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new LegalPerson(rs.getInt("IDPM"), rs.getString("NOMPM"), rs.getString("PRENOMPM"), rs.getString("DATEDENAISSANCEPM"), rs.getString("SEXEPM"),rs.getString("EMAILPM"));
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
