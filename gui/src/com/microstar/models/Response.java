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


public class Response {

	private Integer responseId;
	
	private String visitDate;
	
	private String responseDescription;
	
	private int complaintId;
	
	private static final String END_POINT_URL = "http://localhost:8080/api/response/";


	public Response() {
	}

	public Response(Integer responseId, String visitDate, String responseDescription, int complaintId) {
		this.responseId = responseId;
		this.visitDate = visitDate;
		this.responseDescription = responseDescription;
		this.complaintId = complaintId;
	}

	public Integer getResponseId() {
		return responseId;
	}

	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	@Override
	public String toString() {
		JSONObject response = new JSONObject();
		
		response.accumulate("responseId", this.responseId);
		response.accumulate("visitDate", this.visitDate);
		response.accumulate("responseDescription", this.responseDescription);
		response.accumulate("complaintId", this.complaintId);
		
		return response.toString();
	}


	public static String getAllResponses() {
		System.out.println("Generating request to retrieve all responses");
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
	
	
	public static String addResponse(Response newResponse) {
		System.out.println("Generating request to add response");
		System.out.println("Data received:\n"+ newResponse.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "add" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(newResponse.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	
	public static String editResponse(Response updatedResponse) {
		System.out.println("Generating request to update response");
		System.out.println("Data received:\n"+ updatedResponse.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "update" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(updatedResponse.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	
	public static String removeResponse(Integer id) {
		System.out.println("Generating request to remove a response");
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
	
	
	public static ArrayList<Response> prepareList(String response) {
		ArrayList<Response> list = new ArrayList<Response>();
		JSONArray responses = new JSONArray(response);

		for( int a = 0; a < responses.length(); a++ ) {
			JSONObject responseObject = responses.getJSONObject(a);
			
			Integer responseId = responseObject.getInt("responseId");
			String visitDate = responseObject.getString("visitDate");
			String responseDescription = responseObject.getString("responseDescription");
			int complaintId = responseObject.getInt("complaintId");
			
			Response resp = new Response(responseId, visitDate, responseDescription, complaintId);
			
			list.add(resp);
		}

		return list;
	}
	
	
}
