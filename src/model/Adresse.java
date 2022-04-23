package model;

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
	
	
	
	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String toString() {
		return "Plaisancier [ref : " + idAdresse + ", " + adresse + "]";
	}

}
