package model;
  
/**
 * @author DURAND Tom
 * @version 1.0
 */

public class Delegation {
	private int id;
	private String country;
	private int number;
	
	public Delegation()
	{
		super();
	}
	
	public Delegation(int id, String country)
	{
		this.id=id;
		this.country = country;

	}

	public Delegation(int id, String country, int number)
	{
		this.id=id;
		this.country = country;
		this.number = number;

	}

	//GETTERS
	public int getId() {
		return id;
	}
	public String getCountry() {
		return country;
	}
	public int getNumber() {
		return number;
	}

	//SETTERS
	public void setId(int id) {
		this.id=id;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}