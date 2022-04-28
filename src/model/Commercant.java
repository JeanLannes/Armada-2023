package model;

public class Commercant {
	private int IDcommercant;
	private String activite;
	private String stand;
	private FamilleAcceuil familleAcceuil;
	private PersonneMorale personneMorale;
	
	
	public Commercant(int IDCommercant, String activite, String stand) {
		this.IDcommercant = IDCommercant;
		this.activite = activite;
		this.stand = stand;
		this.setFamilleAcceuil(new FamilleAcceuil());
		this.setPersonneMorale(new PersonneMorale());
		
	}
	
	/**
	 * Renvoie les infos du commercant dans une chaine de caractere
	 * @return String 
	 */
	public String toString() {
		return "commercant [ref : " + IDcommercant + ", " + activite + ", "+stand+"]";
	}

	//GETTER
	public int getIDcommercant() {
		return IDcommercant;
	}
	public String getStand() {
		return stand;
	}
	public String getActivite() {
		return activite;
	}
	public PersonneMorale getPersonneMorale() {
		return personneMorale;
	}
	public FamilleAcceuil getFamilleAcceuil() {
		return familleAcceuil;
	}
	
	//SETTER 
	public void setIDcommercant(int iDcommercant) {
		IDcommercant = iDcommercant;
	}
	public void setStand(String stand) {
		this.stand = stand;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	public void setFamilleAcceuil(FamilleAcceuil familleAcceuil) {
		this.familleAcceuil = familleAcceuil;
	}
	public void setPersonneMorale(PersonneMorale personneMorale) {
		this.personneMorale = personneMorale;
	}
}
