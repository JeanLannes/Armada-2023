package model;
  
/**
 * @author DURAND Tom
 * @version 1.0
 */

public class Description {
	private int idSheet;
	private String name;
	private String description;
	private int idParticipant;
	
	public Description()
	{
		super();
	}
	
	public Description(int idSheet, String name, String description)
	{
		this.idSheet=idSheet;
		this.name = name;
		this.description = description;
	}

	//GETTERS
	public int getIdSheet() {
		return idSheet;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}

	//SETTERS
	public void setIdSheet(int idSheet) {
		this.idSheet=idSheet;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}