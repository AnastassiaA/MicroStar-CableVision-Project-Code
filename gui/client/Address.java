package client;

public class Address {
	private String lotNumber;
	private String street;
	private String city;
	
	
	public Address() {
		lotNumber = "";
		street = "";
		city = "";
	}


	public Address(String lotNumber, String street, String city) {
		this.lotNumber = lotNumber;
		this.street = street;
		this.city = city;
	}
	
	public Address(Address address) {
		this.lotNumber = address.lotNumber;
		this.street = address.street;
		this.city = address.city;
	}


	public String getLotNumber() {
		return lotNumber;
	}


	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
}
