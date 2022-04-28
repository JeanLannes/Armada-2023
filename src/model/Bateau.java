package model; 

/**
 * @author BA - Papa Amath
 * @version 1.0
 */
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

	/**
	 * Renvoie les infos du bateau dans une chaine de caractere
	 * @return String 
	 */
	public String toString() {
		return "Bateau [ref : " + IDBateau + ", " + name
				+ ", "+tailleBateau+ ", " + pavillon +", "+ capitaine +", "+ immatriculation+", "+typeBateau+", "+ dateCreation+"]";
	}
	//GETTER
	public int getIDBateau() {
		return IDBateau;
	}
	public String getName() {
		return name;
	}
	public String getPavillon() {
		return pavillon;
	}
	public String getTypeBateau() {
		return typeBateau;
	}
	public Plaisancier getPlaisancier() {
		return plaisancier;
	}
	public String getCapitaine() {
		return capitaine;
	}
	public int getTailleBateau() {
		return tailleBateau;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public String getDateCreation() {
		return dateCreation;
	}

	//SETTER 
	public void setTypeBateau(String typeBateau) {
		this.typeBateau = typeBateau;
	}
	public void setIDBateau(String immatriculation) {
		this.dateCreation = immatriculation;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPavillon(String pavillon) {
		this.pavillon = pavillon;
	}
	public void setPlaisancier(Plaisancier plaisancier) {
		this.plaisancier = plaisancier;
	}
	public void setCapitaine(String capitaine) {
		this.capitaine = capitaine;
	}
	public void setTailleBateau(int tailleBateau) {
		this.tailleBateau = tailleBateau;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
}
