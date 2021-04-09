package com.microstar.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

import com.microstar.main.Login;

public class Register {

	private Integer credentialId;

	private String userName;

	private String password;

	private String roles;

	private static final String END_POINT_URL = "http://localhost:8080/api/auth/";


	public Register() {
	}

	public Register(Integer credentialId, String userName, String password, String roles) {
		this.credentialId = credentialId;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public Integer getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Integer credentialId) {
		this.credentialId = credentialId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		JSONObject registrationObject = new JSONObject();

		registrationObject.accumulate("credentialId", this.credentialId);
		registrationObject.accumulate("userName", this.userName);
		registrationObject.accumulate("password", this.password);

		return registrationObject.toString();
	}

	//Send request using java.net.HttpClient
	public String sendRegistrationRequest(Register registration) {
		System.out.println("Generating registration request");
		System.out.println(registration.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create(END_POINT_URL + "register" ))
				.setHeader("Content-type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(registration.toString()))
				.build();

		System.out.println("Sending request to login");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(Login::parseLoginResponse)
				.join();

		return response;

	}



}
