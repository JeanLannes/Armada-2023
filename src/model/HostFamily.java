package model;

/**
 * @author BA - Papa Amath
 * @version 1.0
 */
public class HostFamily {
	
	private int idFamily;
	private int nbPlace;
	private String address ;
	
	public HostFamily()
	{
		super();
	}
	public HostFamily(int idFamily, String address, int nbPlace)
	{
		this.idFamily = idFamily;
		this.nbPlace = nbPlace;
		this.address = address;
	}

	//GETTER
	public int getIdFamily() {
		return idFamily;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public String getAddress() {
		return address;
	}

	//SETTER
	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
