package model;

/**
 * @author BA - Papa Amath
 * @version 1.0
 */
public class Retailer {
	
	private int idRetailer;
	private String activity;
	private String stand;
	
	public Retailer()
	{
		super();
	}
	public Retailer(int idRetailer, String activity, String stand)
	{
		this.idRetailer = idRetailer;
		this.activity = activity;
		this.stand = stand;
	}

	//GETTER
	public int getIdRetailer() {
		return idRetailer;
	}
	public String getActivity() {
		return activity;
	}
	public String getStand() {
		return stand;
	}

	//SETTER
	public void setIdRetailer(int idRetailer) {
		this.idRetailer = idRetailer;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public void setStand(String stand) {
		this.stand = stand;
	}
}
