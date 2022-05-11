package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
				returnValue.setBoatName(rs.getString("NOMBATEAU"));
				returnValue.setIdRetailer(rs.getInt("IDCOMMERCANT"));
				returnValue.setIdPersonneMorale(rs.getInt("IDPERSONNEMORALE"));
				returnValue.setCountry(rs.getString("PAYS"));
				returnValue.setProfil(rs.getString("IMENTREPRISE"));
				returnValue.setIdFamille(rs.getInt("IDFAMILLE"));
				returnValue.setIdPlaisancier(rs.getInt("IDPLAISANCIER"));
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
		
			if(type==2) { //EST UN COMMERCANT
				ps = con.prepareStatement("UPDATE participant set IDCOMMERCANT = ? WHERE IDPARTICIPANT = ?");
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
}
