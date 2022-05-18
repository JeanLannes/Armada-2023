package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Inscription
 * 
 * @author DURAND Tom
 * @version 1.0
 */

public class ParticipantDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public ParticipantDAO()
	{
		super();
	}
	
	public static int add(Participant participant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		// Connexion a la BDD
		try {
			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO Participant (IDPARTICIPANT, PROFIL) VALUES (?, ?)");
			ps.setInt   (1, participant.getIdParticipant());
			ps.setString(2, participant.getProfil());
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				JOptionPane.showMessageDialog(null, "Le participant existe dÈj‡ dans la BDD");
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
	 *
	 */
	public static Participant get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Participant returnValue = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM participant WHERE IDPARTICIPANT = ?");
			ps.setInt(1, id);
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Participant(rs.getInt("IDPARTICIPANT"));
				returnValue.setProfil((rs.getString("PROFIL")));
				returnValue.setIdBoat(rs.getInt("IDBATEAU"));
				returnValue.setIdRetailer(rs.getInt("IDCOMMERCANT"));
				returnValue.setIdPersonneMorale(rs.getInt("IDPERSONNEMORALE"));
				returnValue.setIdDelegation(rs.getInt("IDDELEGATION"));
				returnValue.setIdEntreprise(rs.getInt("IDENTREPRISE"));
				returnValue.setIdFamille(rs.getInt("IDFAMILLE"));
				returnValue.setIdPlaisancier(rs.getInt("IDPLAISANCIER"));
				returnValue.setIdFiche(rs.getInt("IDFICHE"));
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
			return new Participant(0);
		else 
			return returnValue;
	}
	
	public static Participant setConnexion(int id, int type, int idtype) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Participant returnValue = null;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
		
			if(type==1) { //EST UN BATEAU
				ps = con.prepareStatement("UPDATE participant set IDBATEAU = ? WHERE IDPARTICIPANT = ?");
				ps.setInt(1, idtype);
				ps.setInt(2, id);
				// on execute la requete
				rs = ps.executeQuery();
			}
			
			if(type==2) { //EST UN COMMERCANT
				ps = con.prepareStatement("UPDATE participant set IDCOMMERCANT = ? WHERE IDPARTICIPANT = ?");
				ps.setInt(1, idtype);
				ps.setInt(2, id);
				// on execute la requete
				rs = ps.executeQuery();
			}
			
			if(type==3) { //EST UNE ENTREPRISE
				ps = con.prepareStatement("UPDATE participant set IDENTREPRISE = ? WHERE IDPARTICIPANT = ?");
				ps.setInt(1, idtype);
				ps.setInt(2, id);
				// on execute la requete
				rs = ps.executeQuery();
			}
			
			if(type==4) { //EST UNE FAMILLE D'ACCUEIL
				ps = con.prepareStatement("UPDATE participant set IDFAMILLE = ? WHERE IDPARTICIPANT = ?");
				ps.setInt(1, idtype);
				ps.setInt(2, id);
				// on execute la requete
				rs = ps.executeQuery();
			}
			
			if(type==5) { //EST MEMBRE D'UNE DELEGATION
				ps = con.prepareStatement("UPDATE participant set IDDELEGATION = ? WHERE IDPARTICIPANT = ?");
				ps.setInt(1, idtype);
				ps.setInt(2, id);
				// on execute la requete
				rs = ps.executeQuery();
			}
			
			if(type==6) { //AJOUTE UN EMPLACEMENT
				ps = con.prepareStatement("UPDATE participant set EMPLACEMENT = ? WHERE IDPARTICIPANT = ?");
				ps.setInt(1, idtype);
				ps.setInt(2, id);
				// on execute la requete
				rs = ps.executeQuery();
			}
			
			if(type==7) { //AJOUTE UNE RESERVATION DE PLAISANCIER
				ps = con.prepareStatement("UPDATE participant set IDPLAISANCIER = ? WHERE IDPARTICIPANT = ?");
				ps.setInt(1, idtype);
				ps.setInt(2, id);
				// on execute la requete
				rs = ps.executeQuery();
			}

			if(type==8) { //AJOUTE UNE FICHE DESCRIPTIVE
				ps = con.prepareStatement("UPDATE participant set IDFICHE = ? WHERE IDPARTICIPANT = ?");
				ps.setInt(1, idtype);
				ps.setInt(2, id);
				// on execute la requete
				rs = ps.executeQuery();
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
			return new Participant(0);
		else 
			return returnValue;
	}
	
	public static void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		// connexion a la base de donnees
		try {
			// Tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// Requete
			ps = con.prepareStatement("DELETE FROM participant WHERE IDPARTICIPANT = ?");
			ps.setInt(1, id);
			// Execution de la requete
			ps.executeUpdate();
			
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Suppression impossible !"
						+ "Supprimer d'abord les r√©f√©rences");
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

	public static int getIdEmplacement(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT EMPLACEMENT FROM participant WHERE IDPARTICIPANT = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue=rs.getInt("EMPLACEMENT");
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

	public static int getIdPlaisancier(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT IDPLAISANCIER FROM participant WHERE IDPARTICIPANT = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue=rs.getInt("IDPLAISANCIER");
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
