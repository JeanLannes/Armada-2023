package model;
public class Inscription {
	private int id;
	private String firstName;
	private String lastName;
	private String mail;
	private String activity ;
	
	public Inscription()
	{
		super();
	}
	
	public Inscription(int id, String firstName,String lastName,String mail,String activity)
	{
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.activity = activity;
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
	public String getActivity() {
		return activity;
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
	public void setActivity(String activity) {
		this.activity = activity;
	}
}