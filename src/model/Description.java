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
	
	public Description(int idSheet, String name, String description, int idParticipant)
	{
		this.idSheet=idSheet;
		this.name = name;
		this.description = description;
		this.idParticipant=idParticipant;
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
	public int getIdParticipant() {
		return idParticipant;
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
	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}
}