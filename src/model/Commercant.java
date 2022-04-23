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
		this.familleAcceuil = new FamilleAcceuil();
		this.personneMorale = new PersonneMorale();
		
	}
	
	
	public int getIDcommercant() {
		return IDcommercant;
	}
	public void setIDcommercant(int iDcommercant) {
		IDcommercant = iDcommercant;
	}
	public String getStand() {
		return stand;
	}
	public void setStand(String stand) {
		this.stand = stand;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String toString() {
		return "commercant [ref : " + IDcommercant + ", " + activite + ", "+stand+"]";
	}

}
