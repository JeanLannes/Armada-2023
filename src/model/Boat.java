package model; 

/**
 * @author BA - Papa Amath
 * @version 1.0
 */
public class Boat {
	
	private int idBoat;
	private String name;
	private String type;
	private String captain;
	private String flag;
	private String date;
	private int lengh;
	private String immatriculation; 
	
	public Boat()
	{
		super();
	}
	
	public Boat(int idBoat, String name, int lengh, String flag, String captain,String immatriculation,String type,String date)
	{
		this.idBoat = idBoat;
		this.name = name;
		this.type = type;
		this.flag = flag;
		this.date = date;
		this.immatriculation = immatriculation;
		this.captain = captain;
		this.lengh = lengh;
		
	}

	//GETTER
	public int getIdBoat() {
		return idBoat;
	}
	public String getName() {
		return name;
	}
	public String getFlag() {
		return flag;
	}
	public String getType() {
		return type;
	}
	public String getCaptain() {
		return captain;
	}
	public int getLengh() {
		return lengh;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public String getDate() {
		return date;
	}

	//SETTER 
	public void setIdBoat(int idBoat) {
		this.idBoat = idBoat;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	public void setLengh(int lengh) {
		this.lengh = lengh;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
