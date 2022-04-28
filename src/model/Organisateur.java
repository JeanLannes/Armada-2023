package model;
public class Organisateur {
	private int id;
	private String firstName;
	private String lastName;
	private String mail;
	private String password ;

	public Organisateur()
	{
		super();
	}
	
	public Organisateur(int id, String firstName,String lastName,String mail,String password)
	{
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.password = password;
	}

	//GETTERS
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getMail() {
		return mail;
	}
	public String getPassword() {
		return password;
	}

	//SETTERS
	public void setId(int id) {
		this.id=id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

