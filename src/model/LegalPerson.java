package model;

public class LegalPerson {

	private int idLegalPerson;		
	private String name;
	private String surname;
	private String birthday;
	private String sexe;
	private String email;
	
	public LegalPerson()
	{
		super();
	}
	
	public LegalPerson (int idLegalPerson, String name, String surname,String birthday, String sexe, String email)
	{
		this.idLegalPerson = idLegalPerson;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.sexe = sexe;
		this.email = email;
	}
	
	//GETTER
	public int getIdLegalPerson() {
		return idLegalPerson;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getSexe() {
		return sexe;
	}
	public String getEmail() {
		return email;
	}

	//SETTER 
	public void setIdLegalPerson(int idLegalPerson) {
		this.idLegalPerson = idLegalPerson;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
