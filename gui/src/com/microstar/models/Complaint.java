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

public class Complaint {
	
	private Integer complaintId;
	
	private int serviceId;
	
	private String complaintType;
	
	private String complaintStatus;
	
	private String complaintDescription;

	private int customerId;

	private static final String END_POINT_URL = "http://localhost:8080/api/customer/complaints/";

	public Complaint() {
	}

	public Complaint(Integer complaintId, int serviceId, String complaintType, String complaintStatus,
			String complaintDescription, int customerId) {
		this.complaintId = complaintId;
		this.serviceId = serviceId;
		this.complaintType = complaintType;
		this.complaintStatus = complaintStatus;
		this.complaintDescription = complaintDescription;
		this.customerId = customerId;
	}

	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		JSONObject complaint = new JSONObject();
		complaint.accumulate("complaintId", this.complaintId);
		complaint.accumulate("serviceId", this.serviceId);
		complaint.accumulate("complaintType", this.complaintType);
		complaint.accumulate("complaintStatus", this.complaintStatus);
		complaint.accumulate("complaintDescription", this.complaintDescription);
		complaint.accumulate("customerId", this.customerId);
		
		return complaint.toString();
	}
	

	public static String getAllCompanyServices() {
		System.out.println("Generating request to retrieve all complaints");
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
				.thenApply(data-> data)
				.join();

		return response;
	}
	
	public static String lodgeComplaint(Complaint newComplaint) {
		System.out.println("Generating request to lodge complaint");
		newComplaint.setComplaintId(null);
		System.out.println("Data received:\n"+ newComplaint.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "add" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(newComplaint.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	public static String editComplaint(Complaint updatedComplaint) {
		System.out.println("Generating request to update complaint");
		System.out.println("Data received:\n"+ updatedComplaint.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "update" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(updatedComplaint.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	public static String removeCompanyService(Integer id) {
		System.out.println("Generating request to remove complaint");
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

	
	public static ArrayList<Complaint> prepareList(String response) {
		ArrayList<Complaint> list = new ArrayList<Complaint>();
		JSONArray responseArray = new JSONArray(response);

		for( int a = 0; a < responseArray.length(); a++ ) {
			JSONObject complaint = responseArray.getJSONObject(a);
			
			Integer complaintId = complaint.getInt("complaintId");
			int serviceId = complaint.getInt("serviceId");
			String complaintType = complaint.getString("complaintType");
			String complaintStatus = complaint.getString("complaintStatus");
			String complaintDescription = complaint.getString("complaintDescription");
			int customerId = complaint.getInt("customerId");
			

			//System.out.println(service_id + "  " + service_name + "  " + service_description);
			Complaint compService = new Complaint(complaintId, serviceId, complaintType, complaintStatus, complaintDescription, customerId);
			list.add(compService);
		}

		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
