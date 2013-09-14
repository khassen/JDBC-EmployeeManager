package fr.treeptik.jdbc;

public class Adresse {
	private int id;
	private String city;
	private String state;
	private String street;
	private String zip;

	
	public Adresse(int id, String city, String state, String street, String zip) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.street = street;
		this.zip = zip;
	}

	public Adresse(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
