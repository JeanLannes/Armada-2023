package model;

public class Boater {
	private int id;		
	private String horraireArr;
	private String horraireDep;
	private String emplacementBassin;

	public Boater ()
	{
		super();
	}
	
	public Boater(int id, String horraireArr, String horraireDep)
	{
		this.id = id;
		this.horraireArr = horraireArr ;
		this.horraireDep = horraireDep;	
		this.emplacementBassin = emplacementBassin;
		
	}
	
	// GETTERS
	public int getId() {
		return id;
	}
	public String getHorraireArr() {
		return horraireArr;
	}
	public String getHorraireDep() {
		return horraireDep;
	}
	public String getEmplacementBassin() {
		return emplacementBassin;
	}
	
	// SETTERS 
	public void setId(int id) {
		this.id = id;
	}
	public void setEmplacementBassin(String emplacementBassin) {
		this.emplacementBassin = emplacementBassin;
	}
	public void setHorraireDep(String horraireDep) {
		this.horraireDep = horraireDep;
	}
	public void setHorraireArr(String horraireArr) {
		this.horraireArr = horraireArr;
	}
}
