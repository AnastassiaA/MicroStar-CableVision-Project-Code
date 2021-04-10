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

public class Accounts {
	
	private Integer accountNumber;
	
	private int amountDue;
	
	private String paymentDueDate;
	
	private String paymentStatus;
	

	private static final String END_POINT_URL = "http://localhost:8080/api/customer/accounts/";


	public Accounts() {
	}


	public Accounts(Integer accountNumber, int amountDue, String paymentDueDate, String paymentStatus) {
		this.accountNumber = accountNumber;
		this.amountDue = amountDue;
		this.paymentDueDate = paymentDueDate;
		this.paymentStatus = paymentStatus;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getAmountDue() {
		return amountDue;
	}


	public void setAmountDue(int amountDue) {
		this.amountDue = amountDue;
	}


	public String getPaymentDueDate() {
		return paymentDueDate;
	}


	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	@Override
	public String toString() {
		JSONObject accounts = new JSONObject();
		accounts.accumulate("accountNumber", this.accountNumber);
		accounts.accumulate("amountDue", this.amountDue);
		accounts.accumulate("paymentDueDate", this.paymentDueDate);
		accounts.accumulate("paymentStatus", this.paymentStatus);
		
		
		return accounts.toString();
	}
	
	

	public static String getAllCompanyServices() {
		System.out.println("Generating request to retrieve all accounts");
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
	
	
	public static String addCompanyService(Accounts newAccount) {
		System.out.println("Generating request to add account");
		System.out.println("Data received:\n"+ newAccount.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "save" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(newAccount.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	
	public static String editCompanyService(Accounts updatedAccount) {
		System.out.println("Generating request to edit a account");
		System.out.println("Data received:\n"+ updatedAccount.toString());
		System.out.println("Building request body");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create( END_POINT_URL + "update" ) )
				.setHeader("Content-type", "application/json")
				.setHeader("Authorization", "Bearer " + Login.getAuthorizationToken())
				.POST( BodyPublishers.ofString(updatedAccount.toString()) )
				.build();

		System.out.println("Sending request...");

		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(data -> data)
				.join();

		return response;
	}
	
	public static String removeCompanyService(Integer id) {
		System.out.println("Generating request to remove a account");
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

	
	public static ArrayList<Accounts> prepareList(String response) {
		ArrayList<Accounts> list = new ArrayList<Accounts>();
		JSONArray accounts = new JSONArray(response);

		for( int a = 0; a < accounts.length(); a++ ) {
			JSONObject acc = accounts.getJSONObject(a);
			
			Integer accountNumber = acc.getInt("accountNumber");
			int amountDue = acc.getInt("amountDue");
			String paymentDueDate = acc.getString("paymentDueDate");
			String paymentStatus = acc.getString("paymentStatus");
			

			Accounts account = new Accounts(accountNumber, amountDue, paymentDueDate, paymentStatus);
			list.add(account);
		}

		return list;
	}
	
	
	
	
	
	
}
