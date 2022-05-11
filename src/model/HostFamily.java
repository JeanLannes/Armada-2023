package model;

/**
 * @author BA - Papa Amath
 * @version 1.0
 */
public class HostFamily {
	
	private int idFamily;
	private int nbPlace;
	private Address address ;
	
	public HostFamily()
	{
		super();
	}
	public HostFamily(int idFamily, int nbPlace )
	{
		this.idFamily = idFamily;
		this.nbPlace = nbPlace;
		this.setAddress(new Address());
	}

	//GETTER
	public int getIdFamille() {
		return idFamily;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public Address getAddress() {
		return address;
	}

	//SETTER
	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static void showUpdateProfile(Participant part) {
		// TODO Auto-generated method stub
		
	}
}
