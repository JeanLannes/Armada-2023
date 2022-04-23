package model;

public class PersonneMorale {

	/** 
	 * reference du plaisancier
	 */
	private int idPersonneMorale;		
	/**
	 * nom
	 */
	private String name;
	/**
	 * prénom
	 */
	private String surname;
	
	/**
	 * plaisancier représenté
	 */
	private Plaisancier plaisancier;
	/**
	 * date naissance personne Morale
	 */
	private String dateDeNaissance;
	
	
	/**
	 * famille acceuil
	 */
	private FamilleAcceuil familleAcceuil;
	

	/**
	 * sexe
	 */
	private String sexe;
	/**
	 * email
	 */
	private String email;
	
	public PersonneMorale()
	{
		super();
	}
	
	public PersonneMorale (int idPersonneMorale, String name, String surname,String dateDeNaissance, String sexe, String email)
	{

		this.idPersonneMorale = idPersonneMorale;
		this.name = name;
		this.surname = surname;
		this.dateDeNaissance = dateDeNaissance;
		this.sexe = sexe;
		this.email = email;
		plaisancier = new Plaisancier();
		familleAcceuil = new FamilleAcceuil();
		
	}
	
	
	public int getIdPersonneMorale() {
		return idPersonneMorale;
	}
	public void setIdPersonneMorale(int idPersonneMorale) {
		this.idPersonneMorale = idPersonneMorale;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Plaisancier getPlaisancier() {
		return plaisancier;
	}


	public void setPlaisancier(Plaisancier plaisancier) {
		this.plaisancier = plaisancier;
	}
	
	
	public FamilleAcceuil getFamilleAcceuil() {
		return familleAcceuil;
	}


	public void setFamilleAcceuil(FamilleAcceuil familleAcceuil) {
		this.familleAcceuil = familleAcceuil;
	}

	
	
	
	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "Personne Morale [ref : " + idPersonneMorale + ", " + name + ", surnom:"+surname+", Date de Naissance: "+dateDeNaissance+", "+sexe+", "+email+"]";
	}



	

}
