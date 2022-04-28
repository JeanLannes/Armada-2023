package model;

/**
 * @author BA - Papa Amath
 * @version 1.0
 */
public class Adresse {
	private int idAdresse;
	private String adresse;
	
	public Adresse() {
		super();
	}
	public Adresse (int idAdresse, String adresse ) {
		
		this.idAdresse = idAdresse;
		this.adresse = adresse;
	
	}
	
	/**
	 * Renvoie les infos de l'adresse dans une chaine de caractere
	 * @return String 
	 */
	public String toString() {
		return "Plaisancier [ref : " + idAdresse + ", " + adresse + "]";
	}
	
	//GETTER 
	public int getIdAdresse() {
		return idAdresse;
	}
	public String getAdresse() {
		return adresse;
	}
	
	//SETTER
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	


}
