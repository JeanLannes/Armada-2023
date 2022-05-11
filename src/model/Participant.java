package model; 

public class Participant {
	private int idParticipant;
	private String profil;
	private String boatName;
	private int idRetailer;
	private int idPersonneMorale;
	private String country;
	private String imEntreprise;
	private int idFamille;
	private int idPlaisancier;
	private int idFiche;
	private String emplacement;

	public Participant()
	{
		super();
	}
	
	public Participant(int idParticipant)
	{
		this.idParticipant=idParticipant;
	}

	//GETTERS
	public int getIdParticipant() {
		return idParticipant;
	}
	public String getProfil() {
		return profil;
	}
	public String getBoatName() {
		return boatName;
	}
	public int getIdRetailer() {
		return idRetailer;
	}
	public int getIdPersonneMorale() {
		return idPersonneMorale;
	}
	public String getCountry() {
		return country;
	}
	public String getImEntreprise() {
		return imEntreprise;
	}
	public int getIdFamille() {
		return idFamille;
	}
	public int getIdPlaisancier() {
		return idPlaisancier;
	}
	public int getIdFiche() {
		return idFiche;
	}
	public String getEmplacement() {
		return emplacement;
	}


	//SETTERS
	public void setIdParticipant(int idParticipant) {
		this.idParticipant=idParticipant;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	public void setIdRetailer(int idRetailer) {
		this.idRetailer = idRetailer;
	}
	public void setCountry(String country) {
		this.country=country;
	}
	public void setIdPersonneMorale(int idPersonneMorale) {
		this.idPersonneMorale=idPersonneMorale;
	}
	public void setImEntreprise(String imEntreprise) {
		this.imEntreprise=imEntreprise;
	}
	public void setIdFamille(int idFamille) {
		this.idFamille=idFamille;
	}
	public void setIdPlaisancier(int idPlaisancier) {
		this.idPlaisancier=idPlaisancier;
	}
	public void setIdFiche(int idFiche) {
		this.idFiche=idFiche;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement=emplacement;
	}

}