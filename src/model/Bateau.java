package model;


public class Bateau {
	
	private int IDBateau;
	private String name;
	private String typeBateau;
	private String capitaine;
	private String pavillon;
	private Plaisancier plaisancier;
	private String dateCreation;
	private int tailleBateau;
	private String immatriculation; 
	
	public Bateau()
	{
		super();
	}
	
	public Bateau(int IDBateau, String name, int tailleBateau, String pavillon, String capitaine,String immatriculation,String typeBateau,String dateCreation)
	{
		this.IDBateau = IDBateau;
		this.name = name;
		this.typeBateau = typeBateau;
		this.pavillon = pavillon;
		this.dateCreation = dateCreation;
		this.immatriculation = immatriculation;
		this.capitaine = capitaine;
		this.tailleBateau = tailleBateau;
		
	}



	public int getIDBateau() {
		return IDBateau;
	}



	public void setIDBateau(String immatriculation) {
		this.dateCreation = immatriculation;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPavillon() {
		return pavillon;
	}



	public void setPavillon(String pavillon) {
		this.pavillon = pavillon;
	}



	public String getTypeBateau() {
		return typeBateau;
	}



	public void setTypeBateau(String typeBateau) {
		this.typeBateau = typeBateau;
	}
	
	@Override
	public String toString() {
		return "Bateau [ref : " + IDBateau + ", " + name
				+ ", "+tailleBateau+ ", " + pavillon +", "+ capitaine +", "+ immatriculation+", "+typeBateau+", "+ dateCreation+"]";
	}



	public Plaisancier getPlaisancier() {
		return plaisancier;
	}



	public void setPlaisancier(Plaisancier plaisancier) {
		this.plaisancier = plaisancier;
	}

	public String getCapitaine() {
		return capitaine;
	}

	public void setCapitaine(String capitaine) {
		this.capitaine = capitaine;
	}

	public int getTailleBateau() {
		return tailleBateau;
	}

	public void setTailleBateau(int tailleBateau) {
		this.tailleBateau = tailleBateau;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

}
