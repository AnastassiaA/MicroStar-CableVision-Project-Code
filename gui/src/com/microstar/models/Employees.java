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


public class Employees {

	private Integer employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String contactNum;
	

	private static final String END_POINT_URL = "http://localhost:8080/api/employee/";

	
	public Employees() {
	}
	
	
	public Employees(int employeeId, String firstName, String lastName, String contactNum) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNum = contactNum;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	
	
	public String getContactNum() {
		return contactNum;
	}
	
	
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}


	@Override
	public String toString() {
		JSONObject employee = new JSONObject();

		employee.accumulate("employeeId", this.employeeId);
		employee.accumulate("firstName", this.firstName);
		employee.accumulate("lastName", this.lastName);
		employee.accumulate("contactNum", this.contactNum);
		
		return employee.toString();
	}	
	

	public static String getAllCompanyServices() {
		System.out.println("Generating request to retrieve all employees");
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
	
	
	public static String addCompanyService(Employees newEmployee) {
		System.out.println("Generating request to add employee");
		System.out.println("Data received:\n"+ newEmployee.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "save" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(newEmployee.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	
	public static String editCompanyService(Employees updatedEmployee) {
		System.out.println("Generating request to edit a employee");
		System.out.println("Data received:\n"+ updatedEmployee.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "update" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(updatedEmployee.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	
	public static String removeCompanyService(Integer id) {
		System.out.println("Generating request to remove a employee");
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
	
	
	public static ArrayList<Employees> prepareList(String response) {
		ArrayList<Employees> list = new ArrayList<Employees>();
		JSONArray employees = new JSONArray(response);

		for( int a = 0; a < employees.length(); a++ ) {
			JSONObject employee = employees.getJSONObject(a);
			
			Integer employeeId = employee.getInt("employeeId");
			String firstName = employee.getString("firstName");
			String lastName = employee.getString("lastName");
			String contactNum = employee.getString("contactNum");

			Employees emp = new Employees(employeeId, firstName, lastName, contactNum);
			list.add(emp);
		}

		return list;
	}
	
	
	
}
