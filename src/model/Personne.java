package model;

public class Personne {
	private int id;
	private String firstName;
	private String lastName;
	private String function;
	private String birthday ;

	public Personne()
	{
		super();
	}
	
	public Personne(int id, String firstName, String lastName, String function, String birthday)
	{
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.function = function;
		this.birthday = birthday;
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
	public String getFunction() {
		return function;
	}
	public String getBirthday() {
		return birthday;
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
	public void setFunction(String function) {
		this.function = function;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}

