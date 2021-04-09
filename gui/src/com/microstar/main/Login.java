package com.microstar.main;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
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
		
		String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
							.thenApply(HttpResponse::body)
							.thenApply(Login::parseLoginResponse)
							.join();
				
		return response;

	}
	
	public static String parseLoginResponse(String response) {
		System.out.println( "Parsing response" );
		JSONObject loginResponse = new JSONObject(response);
		String data = "";
				
		//System.out.println( loginResponse.getString("userName") +"\n"+ loginResponse.getString("token") +"\n"+ loginResponse.getString("userRole") );
		
		boolean stored = Login.storeResponseData( loginResponse.getString("userName"),
													loginResponse.getString("token"),
													loginResponse.getString("userRole") );
		
		//String data = loginResponse.getString("userName") +"  "+ loginResponse.getString("token") +"  "+ loginResponse.getString("userRole");
		
		if( stored ) {
			data = loginResponse.getString("userRole");
			
		} else {
			data = "Unable to store authorization";
		}
		
		

		return data;
	}

		
	private static boolean storeResponseData(String user, String token, String role) {
		
		try ( FileWriter writer = new FileWriter("Authorization.bin", false) ) {
			
			writer.write(token);
			
			return true;
			
		} catch( IOException io ) {
			System.err.println( io.getLocalizedMessage() );
			io.printStackTrace();
			
		} catch( Exception ex ) {
			System.err.println( ex.getLocalizedMessage() );
			ex.printStackTrace();
			
		}
		
		return false;
	}
	
	
	public static String getAuthorizationToken() {
		String token = "";
		try {
			File file = new File("Authorization.bin");
			Scanner scanner = new Scanner(file);
			
			while( scanner.hasNextLine() ) {
				token = scanner.next();
			}
			scanner.close();
			
		} catch (FileNotFoundException fnf) {
			System.err.println( fnf.getLocalizedMessage() );
			fnf.printStackTrace();
			
		} catch( Exception ex ) {
			System.err.println( ex.getLocalizedMessage() );
			ex.printStackTrace();
			
		}
		
		return token;
	}


}

