package com.microstar.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.microstar.main.Login;

public class Customer {

	private Integer customerId;

	private String firstName;

	private String lastName;

	private int contactNumber;

	private String emailAddress;

	private String lotNumber;

	private String street;

	private String city;
	
	private static final String END_POINT_URL = "http://localhost:8080/api/customer/";


	public Customer() {
	}


	public Customer(Integer customerId, String firstName, String lastName, int contactNumber, String emailAddress,
			String lotNumber, String street, String city) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.lotNumber = lotNumber;
		this.street = street;
		this.city = city;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	@Override
	public String toString() {
		JSONObject customer = new JSONObject();
		customer.accumulate("customerId", this.customerId);
		customer.accumulate("firstName", this.firstName);
		customer.accumulate("lastName", this.lastName);
		customer.accumulate("contactNumber", this.contactNumber);
		customer.accumulate("emailAddress", this.emailAddress);
		customer.accumulate("lotNumber", this.lotNumber);
		customer.accumulate("street", this.street);
		customer.accumulate("city", this.city);


		return customer.toString();
	}


	public static String getAllCustomers() {
		System.out.println("Generating request to retrieve all customers");
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.GET()
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}

	public static String addCustomer(Customer newCustomer) {
		System.out.println("Generating request to add customer");
		newCustomer.setCustomerId(null);
		System.out.println("Data received:\n"+ newCustomer.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "add" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(newCustomer.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	public static String editCustomer(Customer updatedCustomer) {
		System.out.println("Generating request to update customer");
		System.out.println("Data received:\n"+ updatedCustomer.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "update" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(updatedCustomer.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	public static String removeCustomers(Integer id) {
		System.out.println("Generating request to remove customer");
		System.out.println("Data received:\n"+ id);
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "delete/" + id ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.DELETE()
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}


	public static ArrayList<Customer> prepareList(String response) {
		ArrayList<Customer> list = new ArrayList<Customer>();
		JSONArray services = new JSONArray(response);

		for( int a = 0; a < services.length(); a++ ) {
			JSONObject service = services.getJSONObject(a);
			Integer customerId = service.getInt("customerId");
			String firstName = service.getString("firstName");
			String lastName = service.getString("lastName");
			int contactNumber = service.getInt("contactNumber");		

			String emailAddress = service.getString("emailAddress");
			String lotNumber = service.getString("lotNumber");
			String street = service.getString("street");
			String city = service.getString("city");
			

			//System.out.println(customerId + "  " + firstName + "  " + lastName + );
			Customer compService = new Customer(customerId, firstName, lastName, contactNumber, emailAddress, lotNumber, street, city);
			list.add(compService);
		}

		return list;
	}

}
