package model;
  
/**
 * @author DURAND Tom
 * @version 1.0
 */

public class Entreprise {
	private int id;
	private String name;
	private String immatriculation;
	
	public Entreprise()
	{
		super();
	}
	
	public Entreprise(int id, String name, String immatriculation)
	{
		this.id=id;
		this.name = name;
		this.immatriculation=immatriculation;
	}

	//GETTERS
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getImmatriculation() {
		return immatriculation;
	}

	//SETTERS
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
}