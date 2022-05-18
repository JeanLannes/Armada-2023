package model;
  
/**
 * @author DURAND Tom
 * @version 1.0
 */

public class Emplacement {
	private int id;
	private String name;
	private String lengh;
	private String rive;
	
	public Emplacement()
	{
		super();
	}
	
	public Emplacement(int id, String name, String rive, String lengh)
	{
		this.id=id;
		this.name = name;
		this.rive = rive;
		this.lengh = lengh;
	}

	//GETTERS
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRive() {
		return rive;
	}
	public String getLengh() {
		return lengh;
	}

	//SETTERS
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRive(String rive) {
		this.rive = rive;
	}
	public void setLengh(String lengh) {
		this.lengh=lengh;
	}
}