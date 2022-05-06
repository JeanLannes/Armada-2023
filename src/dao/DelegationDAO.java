package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import GUI.Main;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table Delegation
 * 
 * @author DURAND Tom
 * @version 1.0
 */

public class DelegationDAO extends ConnectionDAO {
	/**
	 * Constructeur
	 */
	public DelegationDAO()
	{
		super();
	}
	
}
