package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

/**
 * Classe d'acces a la base de donnees
 * 
 * @author BA - Papa Amath
 * @version 2.0
 * */
public class ConnectionDAO {
	/**
	 * Parametres de connexion a la base de donnees oracle
	 * URL, LOGIN et PASS sont des constantes
	 */
	final static String URL   = "jdbc:oracle:thin:@193.52.189.224:1521:orcl";	//url pour une connexion à distance
	final static String LOGIN = "C##_G2_G4_APP";   // ID Compte  connexion a  la BDD
	final static String PASS  = "APP_2_4";   // Mot de passe de connexion a  la BDD
	
	/**
	 * Constructeur
	 */
	public ConnectionDAO() {
		// chargement du pilote de bases de donnees
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
}