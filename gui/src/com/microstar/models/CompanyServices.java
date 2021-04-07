package com.microstar.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CompanyServices {

	private Integer serviceId;

	private String serviceName;

	private String serviceDescription;


	private static final String END_POINT_URL = "http://localhost:8080/api/company/services/";


	public CompanyServices() {
	}

	public CompanyServices(Integer serviceId, String serviceName, String serviceDescription) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	@Override
	public String toString() {
		JSONObject companyService = new JSONObject();
		companyService.accumulate("serviceId", this.serviceId);
		companyService.accumulate("serviceName", this.serviceName);
		companyService.accumulate("serviceDescription", this.serviceDescription);

		return companyService.toString();
	}

	public static String getAllCompanyServices() {
		System.out.println("Generating request to retrieve all services");
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL ) )
				.setHeader("Content-type", "application/json")
				.GET()
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(CompanyServices::parseResponse)
				.join();

		return response;
	}

	public static String parseResponse(String response) {

		JSONArray services = new JSONArray(response);

		for( int a = 0; a < services.length(); a++ ) {
			JSONObject service = services.getJSONObject(a);
			int service_id = service.getInt("serviceId");
			String service_name = service.getString("serviceName");
			String service_description = service.getString("serviceDescription");

			System.out.println(service_id + "  " + service_name + "  " + service_description);
		}

		return response;
	}
	
	public static ArrayList<CompanyServices> prepareList(String response) {
		ArrayList<CompanyServices> servicesList = new ArrayList<CompanyServices>();
		JSONArray services = new JSONArray(response);

		for( int a = 0; a < services.length(); a++ ) {
			JSONObject service = services.getJSONObject(a);
			int service_id = service.getInt("serviceId");
			String service_name = service.getString("serviceName");
			String service_description = service.getString("serviceDescription");

			System.out.println(service_id + "  " + service_name + "  " + service_description);
			CompanyServices compService = new CompanyServices(service_id, service_name, service_description);
			servicesList.add(compService);
		}

		return servicesList;
	}



}
