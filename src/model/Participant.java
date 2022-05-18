package model; 

public class Participant {
	private int idParticipant;
	private String profil;
	private int idBoat;
	private int idRetailer;
	private int idPersonneMorale;
	private int idDelegation;
	private int idEntreprise;
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
	public int getIdBoat() {
		return idBoat;
	}
	public int getIdRetailer() {
		return idRetailer;
	}
	public int getIdPersonneMorale() {
		return idPersonneMorale;
	}
	public int getIdDelegation() {
		return idDelegation;
	}
	public int getIdEntreprise() {
		return idEntreprise;
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
	public void setIdBoat(int idBoat) {
		this.idBoat = idBoat;
	}
	public void setIdRetailer(int idRetailer) {
		this.idRetailer = idRetailer;
	}
	public void setIdDelegation(int idDelegation) {
		this.idDelegation=idDelegation;
	}
	public void setIdPersonneMorale(int idPersonneMorale) {
		this.idPersonneMorale=idPersonneMorale;
	}
	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise=idEntreprise;
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