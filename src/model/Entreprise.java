package model;
  
/**
 * @author DURAND Tom
 * @version 1.0
 */

public class Entreprise {
	private int idSheet;
	private String name;
	private int immatriculation;
	
	public Entreprise()
	{
		super();
	}
	
	public Entreprise(int id, String name, int immatriculation)
	{
		this.idSheet=idSheet;
		this.name = name;
		this.immatriculation=immatriculation;
	}

	//GETTERS
	public int getId() {
		return idSheet;
	}
	public String getName() {
		return name;
	}
	public int getImmatriculation() {
		return immatriculation;
	}

	//SETTERS
	public void setId(int idSheet) {
		this.idSheet=idSheet;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImmatriculation(int immatriculation) {
		this.immatriculation = immatriculation;
	}
}