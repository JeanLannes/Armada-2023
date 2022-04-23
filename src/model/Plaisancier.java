package model;

public class Plaisancier {
	/** 
	 * reference du Plaisancier
	 */
	private int id;		
	/**
	 * horaire d'arrivée du plaisancier
	 */
	private String horraireArr;
	/**
	 * horraire de départ du plaisancier
	 */
	private String horraireDep;
	/**
	 * emplacement dans le  bassin
	 */
	private String emplacementBassin;
	
	/**
	 * famille d'acceuil du plaisancier
	 */
	private FamilleAcceuil familleAcceuil;		
	/**
	 * email du plaisancier
	 */
	private String email;
	/**
	 * Fiche Descriptive du plaisancier
	 */
	private String ficheDesc;
	/**
	 * Bateau du plaisancier du plaisancier
	 */
	private Bateau bateau;
	/**
	 * Personne morale du plaisancier du plaisancier
	 */
	private PersonneMorale personneMorale;
	
	
	/**
	 * Constructor
	 * @param id identifiant du plaisancier
	 * @param horraireArr nom 
	 * @param horraireDep prénom
	 * @param emplacementBassin adresse postale
	 
	 */
	public Plaisancier ()
	{
		super();
	}
	
	public Plaisancier(int id, String horraireArr, String horraireDep, String emplacementBassin  )
	{
		this.id = id;
		this.horraireArr = horraireArr ;
		this.horraireDep = horraireDep;	
		this.emplacementBassin = emplacementBassin;
		familleAcceuil = new FamilleAcceuil();
		bateau = new Bateau();
		personneMorale = new PersonneMorale();
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFicheDesc() {
		return ficheDesc;
	}

	public void setFicheDesc(String ficheDesc) {
		this.ficheDesc = ficheDesc;
	}
	
	
	public FamilleAcceuil getFamilleAcceuil() {
		return familleAcceuil;
	}

	public void setFamilleAcceuil(FamilleAcceuil familleAcceuil) {
		this.familleAcceuil = familleAcceuil;
	}

	public PersonneMorale getPersonneMorale() {
		return personneMorale;
	}

	public void setPersonneMorale(PersonneMorale personneMorale) {
		this.personneMorale = personneMorale;
	}

	public Bateau getBateau() {
		return bateau;
	}

	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}
	
	
	@Override
	public String toString() {
		return "Plaisancier [ref : " + id + ", " + horraireArr+ ", "+horraireDep+ ", " + emplacementBassin +"]";
	}

	public String getHorraireArr() {
		return horraireArr;
	}

	public void setHorraireArr(String horraireArr) {
		this.horraireArr = horraireArr;
	}

	public String getHorraireDep() {
		return horraireDep;
	}

	public void setHorraireDep(String horraireDep) {
		this.horraireDep = horraireDep;
	}

	public String getEmplacementBassin() {
		return emplacementBassin;
	}

	public void setEmplacementBassin(String emplacementBassin) {
		this.emplacementBassin = emplacementBassin;
	}

	

	
}
