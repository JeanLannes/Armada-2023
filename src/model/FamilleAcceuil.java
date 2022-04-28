package model;
import java.util.ArrayList;

/**
 * @author BA - Papa Amath
 * @version 1.0
 */
public class FamilleAcceuil {
	
	private int idFamille;
	private int nbPlace;
	private ArrayList <Plaisancier> listPlaisanciers ;
	private ArrayList <PersonneMorale> listPersonneMorales ;
	private Adresse adresse ;
	
	public FamilleAcceuil()
	{
		super();
	}
	public FamilleAcceuil(int idFamille, int nbPlace )
	{
		this.idFamille = idFamille;
		this.nbPlace = nbPlace;
		listPlaisanciers = new ArrayList<Plaisancier>();
		listPersonneMorales = new ArrayList<PersonneMorale>();
		this.setAdresse(new Adresse());
	}


	/**
	 * permet d'ajouter un plaisancier  dans la liste des plaisancier de la famille d'acceuil
	 * @param plaisancier : reference de l'article a ajouter
	 */
	public void addArticle(Plaisancier plaisancier) {
		if(!listPlaisanciers.contains(plaisancier))
		{
			listPlaisanciers.add(plaisancier);
		}
		else
		{
			System.out.println("Ce plaisancier existe déja dans la famille d'acceuil");
		}
	}

	/**
	 * permet d'ajouter une personne morale dans la liste des personnes morales de la famille d'acceuil
	 * @param personneMorale :référence de la personne morale à ajouter
	 */
	public void addPersonneMorale(PersonneMorale personneMorale) {
		if(!listPersonneMorales.contains(personneMorale))
		{
			listPersonneMorales.add(personneMorale);
		}
		else
		{
			System.out.println("Cette personne morale existe déja dans la famille d'acceuil");
		}
	}
	
	/**
	 * Renvoie les infos de la famille d'acceuil dans une chaine de caractere
	 * @return String 
	 */
	public String toString() {
		return "famille d'acceuil [ref : " + idFamille + ", " + nbPlace +"]";
	}

	//GETTER
	public int getIdFamille() {
		return idFamille;
	}
	public int getNbPlace() {
		return nbPlace;
	}

	public ArrayList<Plaisancier> getListPlaisanciers(){
		return listPlaisanciers;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public ArrayList <PersonneMorale> getListPersonneMorale() {
		return listPersonneMorales;
	}

	//SETTER
	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public void setListArticles(ArrayList<Plaisancier> listPlaisanciers){
		this.listPlaisanciers = listPlaisanciers;
	}
	public void setListPersonneMorale(ArrayList <PersonneMorale> listPersonneMorale) {
		this.listPersonneMorales = listPersonneMorale;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


}
