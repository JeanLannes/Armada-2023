package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table plaisancier
 * 
 * @author BA Papa Amath
 * @version 1.0
 */
public class PlaisancierDAO extends ConnectionDAO{
	/**
	 * Constructeur
	 * 
	 */
	
	public PlaisancierDAO ()
	{
		super();
	}
	
	/**
	 * Permet d'ajouter un plaisancier dans la table plaisancier. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param plaisancier le plaisancier a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Plaisancier plaisancier) {
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
			ps = con.prepareStatement("INSERT INTO plaisancier (IDPLAISANCIER, HORAIREARR, HORAIREDEP, EMPLACEMENTBASSIN) VALUES (?, ?, ?, ?)");
			ps.setInt   (1, plaisancier.getId());
			ps.setString(2, plaisancier.getHorraireArr());
			ps.setString(3, plaisancier.getHorraireDep());
			ps.setString(4, plaisancier.getEmplacementBassin());

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe d�j�. Ajout impossible !");
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
	 * Permet de modifier un plaisancier dans la table plaisancier. Le mode est
	 * auto-commit par defaut : chaque modification est validee
	 * 
	 * @param plaisancier le plaisancier à modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Plaisancier plaisancier) {
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
			ps = con.prepareStatement("UPDATE plaisancier set HORAIREARR = ?, HORAIREDEP = ?, EMPLACEMENTBASSIN = ?  WHERE IDPLAISANCIER = ?");
			ps.setString(1, plaisancier.getHorraireArr());
			ps.setString(2, plaisancier.getHorraireDep());
			ps.setString(3, plaisancier.getEmplacementBassin());
			ps.setInt(4, plaisancier.getId());
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
	 * Permet de supprimer un plaisancier dans la table plaisancier. Si ce dernier
	 * est référé dans d'autre table, il ne sera pas supprimé. Le mode est auto-commit
	 * par defaut : chaque suppression est validee
	 * 
	 * @param plaisancier le le plaisancier a supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(Plaisancier plaisancier) {
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
			ps = con.prepareStatement("DELETE FROM plaisancier WHERE IDPLAISANCIER = ?");
			ps.setInt(1, plaisancier.getId());

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

	
	/**
	 * Permet de recuperer une personneMoralel à partir de son ID
	 * 
	 * @param reference la reference de la personne Morale a récupérer
	 * @return la personne Morale trouve; null si aucune personne Morale ne correspond a
	 *         cette immatriculation
	 */
	public Plaisancier get(int IDplaisancier) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Plaisancier returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM plaisancier WHERE IDPLAISANCIER = ?");
			ps.setInt(1, IDplaisancier);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				
				returnValue = new Plaisancier(rs.getInt("IDPLAISANCIER"), rs.getString("HORAIREARR"), rs.getString("HORAIREDEP"), rs.getString("EMPLACEMENTBASSIN"));
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
	
	
	/**
	 * Permet d'éditer les informations d'un plaisancier dans la table plaisancier. Le mode est
	 * auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param plaisancier le plaisancier dont les informations seront éditée 
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int editer(Plaisancier plaisancier) {
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
			ps = con.prepareStatement("INSERT INTO supplier (HORRAIREARR, HORRAIREDEP, EMPLACEMENTBASSIN) VALUES (?, ?, ?, ?)  WHERE IDPLAISANCIER = ?");
			ps.setString(1, plaisancier.getHorraireArr());
			ps.setString(2, plaisancier.getHorraireDep());
			ps.setString(3, plaisancier.getEmplacementBassin());
			ps.setInt(4, plaisancier.getId());

			// Execution de la requete
			returnValue = ps.executeUpdate();


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
	
	// main permettant de tester la classe (pour des test unitaires)
		public static void main(String[] args) throws SQLException {
			int returnValue;
			PlaisancierDAO plaisancier = new PlaisancierDAO();
			// test du constructeur
			Plaisancier p1 = new Plaisancier(112, "13H04", "18H58", "RiveDroite ");
			Plaisancier p2 = new Plaisancier(221, "18H04", "22H58", "RiveDroite ");
			Plaisancier p3 = new Plaisancier(3091, "23H04", "00H58", "RiveDroite ");
			// test de la methode add
			returnValue = plaisancier.add(p1);
			System.out.println(returnValue + " Plaisancier ajouté");
			returnValue = plaisancier.add(p2);
			System.out.println(returnValue + " Plaisancier ajouté");
			returnValue = plaisancier.add(p3);
			System.out.println(returnValue + " Plaisancier ajouté");
			System.out.println();

			

			// appelà nouveau du constructeur
			Plaisancier p4 = new Plaisancier(112, "13H04", "18H58", "RiveDroite ");
			Plaisancier p5 = new Plaisancier(221, "18H04", "22H58", "RiveDroite ");
			Plaisancier p6 = new Plaisancier(3091, "23H04", "00H58", "RiveDroite ");
			// test de la methode update
			returnValue = plaisancier.update(p4);
			System.out.println(returnValue + " plaisancier MAJ");
			returnValue = plaisancier.update(p5);
			System.out.println(returnValue + " Plaisancier MAJ");
			returnValue = plaisancier.update(p6);
			System.out.println(returnValue + " Plaisancier MAJ");
			System.out.println();
			
			
			// test de la methode delete
			returnValue = 0;
			
			returnValue = plaisancier.delete(p2);
			System.out.println(returnValue + " Plaisancier supprimée");

			System.out.println();
			
			
			// test de la methode get
			Plaisancier p = plaisancier.get(3091); 
			// appel implicite de la methode toString de la classe Object (à eviter)
			System.out.println(p);
			System.out.println();


			

			

			
			
		}
	
	
	
	
	

}
