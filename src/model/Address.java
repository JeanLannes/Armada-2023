package model;

/**
 * @author BA - Papa Amath
 * @version 1.0
 */
public class Address{
	private int idaddress;
	private String address;
	
	public Address() {
		super();
	}
	public Address (int idaddress, String address ) {
		this.idaddress = idaddress;
		this.address = address;
	}
	
	//GETTER 
	public int getIdAddress() {
		return idaddress;
	}
	public String getAddress() {
		return address;
	}
	
	//SETTER
	public void setIdAddress(int idaddress) {
		this.idaddress = idaddress;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
