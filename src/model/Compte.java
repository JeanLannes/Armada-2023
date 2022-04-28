package model;
public class Compte {
	private int id;
	private String password;
	private String mail;
	
	public Compte()
	{
		super();
	}
	
	public Compte(int id, String passsword,String mail)
	{
		this.id=id;
		this.password = passsword;
		this.mail = mail;
	}

	//GETTERS
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getMail() {
		return mail;
	}

	//SETTERS
	public void setId(int id) {
		this.id=id;
	}
	public void setPasssword(String password) {
		this.password = password;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}