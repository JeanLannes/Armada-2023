package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import GUI.EditParticipant;
import model.*;
 
/**
 * Classe d'acces aux donnees contenues dans la table Compte
 * 
 * @author DURAND Tom
 * @version 1.0
 */
public class CompteDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public CompteDAO()
	{
		super();
	}

	/**
	 * Permet d'ajouter un compte a la BDD
	 * @param compte Objet COMPTE comprenant les informations donnees par l'admin
	 * @return Compte
	 */
	@SuppressWarnings("resource")
	public static int add(Compte compte) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		ResultSet rs = null;
		
		// connexion a la base de donnees
		try {
			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// Verifie que le mail n'est pas deja utilise
			ps = con.prepareStatement("SELECT * FROM compte WHERE MAILCOMPTE = ?");
			ps.setString(1, compte.getMail());
			rs = ps.executeQuery();
			if(!rs.next()) {
				// Insert dans la BDD le nouveau participant
				ps = con.prepareStatement("INSERT INTO compte (IDCOMPTE, MOTDEPASSE, MAILCOMPTE) VALUES (?, ?, ?)");			
				ps.setInt   (1, compte.getId());
				ps.setString(2, compte.getPassword());
				ps.setString(3, compte.getMail());
				rs = ps.executeQuery();
				rs.next();
			} else {
				EditParticipant.reject(1);
				return 2;
			}
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Erreur : L'id est deja associe");
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
			ps = con.prepareStatement("SELECT MAX(IDCOMPTE) FROM COMPTE");
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			rs.next();
			id=rs.getInt("MAX(IDCOMPTE)");

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

	/**
	 * Permet de retrouver un compte dans la BDD via le MAIL et le MDP
	 * @param mail MAIL DU COMPTE 
	 * @param password MOT DE PASSE DU COMPTE 
	 * @return Compte
	 */
	public static Compte get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Compte returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE IDCOMPTE = ?");
			ps.setInt(1, id);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Compte(rs.getInt("IDCOMPTE"), rs.getString("MOTDEPASSE"), rs.getString("MAILCOMPTE"));
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
			return new Compte(0,"0","0");
		else 
			return returnValue;
	}

		/**
	 * Permet de retrouver un compte dans la BDD via le MAIL et le MDP
	 * @param mail MAIL DU COMPTE 
	 * @param password MOT DE PASSE DU COMPTE 
	 * @return Compte
	 */
	public static Compte getWithMail(String mail) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Compte returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE MAILCOMPTE = ?");
			ps.setString(1, mail);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Compte(rs.getInt("IDCOMPTE"), rs.getString("MOTDEPASSE"), rs.getString("MAILCOMPTE"));
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
			return new Compte(0,"0","0");
		else 
			return returnValue;
	}
	
	/**
	 * Permet de retrouver un compte dans la BDD via le MAIL et le MDP : Cette méthode sert de vérification pour se connecter au programme
	 * @param mail MAIL DU COMPTE 
	 * @param password MOT DE PASSE DU COMPTE
	 * @return Compte
	 */
	public static Compte SignIn (String mail, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Compte returnValue = null;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);	//CONNECTION A LA BDD
			ps = con.prepareStatement("SELECT * FROM compte WHERE MAILCOMPTE = ? AND MOTDEPASSE = ?");	//REQUETE
			ps.setString(1, mail);
			ps.setString(2, password);
			rs = ps.executeQuery();	//EXECTUTION DE LA REQUETE
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Compte(rs.getInt("IDCOMPTE"), rs.getString("MOTDEPASSE"), rs.getString("MAILCOMPTE"));
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

	public static void update(Compte cpt) {
		Connection con = null;
		PreparedStatement ps = null;
		// connexion a la base de donnees
		try {

			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// Requete
			ps = con.prepareStatement("UPDATE compte set MOTDEPASSE = ?, MAILCOMPTE = ?  WHERE IDCOMPTE = ?");
			ps.setString(1, cpt.getPassword());
			ps.setString(2, cpt.getMail());
			ps.setInt(3, cpt.getId());
			// Execution de la requete
			ps.executeUpdate();

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
	}

	/**
	 * Permet de supprimer un compte dans la BDD
	 * @param id du compte a supprimer
	 */
	public static void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		// connexion a la base de donnees
		try {
			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// Requete
			ps = con.prepareStatement("DELETE FROM compte WHERE IDCOMPTE = ?");
			ps.setInt(1, id);
			// Execution de la requete
			ps.executeUpdate();

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
	}

}
