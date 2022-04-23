package model;
import java.util.ArrayList;
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
		this.adresse = new Adresse();
		
		
	}






	public int getIdFamille() {
		return idFamille;
	}




	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}




	public int getNbPlace() {
		return nbPlace;
	}




	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}


	/**
	 * getter pour l'attribut listArticles
	 * @return liste des articles du fournisseur
	 */
	public ArrayList<Plaisancier> getListPlaisanciers(){
		return listPlaisanciers;
	}
	
	/**
	 * setter pour l'attribut listArticles
	 * @param liste des articles du fournisseur
	 */
	public void setListArticles(ArrayList<Plaisancier> listPlaisanciers){
		this.listPlaisanciers = listPlaisanciers;
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


	
	public ArrayList <PersonneMorale> getListPersonneMorale() {
		return listPersonneMorales;
	}


	public void setListPersonneMorale(ArrayList <PersonneMorale> listPersonneMorale) {
		this.listPersonneMorales = listPersonneMorale;
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
	
	@Override
	public String toString() {
		return "famille d'acceuil [ref : " + idFamille + ", " + nbPlace +"]";
	}


}
