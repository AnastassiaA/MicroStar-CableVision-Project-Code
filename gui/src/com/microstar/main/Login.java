package com.microstar.main;


import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;



// This class is used during the login process to accept user credentials (i.e user name and password)
public class Login implements Serializable {


	private String userName;


	private String passWord;
	
	private static final String END_POINT_URL = "http://localhost:8080/api/auth/";

	public Login() {

	}

	public Login(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		JSONObject login = new JSONObject();
		login.accumulate("userName", this.userName);
		login.accumulate("passWord", this.passWord);
		
		return login.toString();
	}

	//Send request using java.net.HttpClient
	public String sendLoginRequest(Login login) {
		System.out.println("Generating login");
		System.out.println(login.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create(END_POINT_URL + "login" ))
				.setHeader("Content-type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(login.toString()))
				.build();
		
		System.out.println("Sending request to login");
		CompletableFuture<HttpResponse<?>>future = null;
		
		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
		.thenApply(HttpResponse::body)
		.thenApply(data -> data)
		.join();
		
		System.out.println(response);
		
		return response;
		//Login::parseResponse
		//Login::parseLoginResponse

	}
	
	public static void parseLoginResponse(String response) {
		System.out.println(response);
		JSONObject loginResponse = new JSONObject(response);
		
		JOptionPane.showMessageDialog(null,
				"Successfull login attempt",
				"Status", JOptionPane.INFORMATION_MESSAGE);
		return;
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

		return null;
	}


}

