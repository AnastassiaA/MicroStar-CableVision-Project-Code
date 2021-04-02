package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {
	private Socket socket;
	private ObjectOutputStream objOS;
	private ObjectInputStream objIS;
	private String action;
	
	public Client() {
		this.createConnection();
		this.configureStreams();
	}
	
	private void createConnection() {
		try {
			socket = new Socket("127.0.0.1", 8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void configureStreams() {
		try {
			objIS = new ObjectInputStream(socket.getInputStream());
			objOS = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void closeConnection() {
		try {
			objOS.close();
			objIS.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendAction(String action) {
		this.action = action;
		
		try {
			objOS.writeObject(action);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//save new customer data
	private void sendCustomer(Customer customer) {
		try {
			objOS.writeObject(customer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//save new employee data
	private void sendEmployee(Employee employee) {
		try {
			objOS.writeObject(employee);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//request from server by complaint id 
	private void sendComplaintId(String complaintId) {
		try {
			objOS.writeObject(complaintId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//request from server by response id
	private void sendResponseId(String responseId) {
		try {
			objOS.writeObject(responseId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//receive response from server
	//add customer
	//find customer
	//update customer
	//delete customer
	private void receiveResponse() {
		try {
			if(action.equalsIgnoreCase("Add Customer")) {
				Boolean flag = (Boolean) objIS.readObject();
					if(flag == true) {
						JOptionPane.showMessageDialog(null, "Customer added successfully", 
								"Add Customer Status", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(action.equalsIgnoreCase("Find Customer")) {
				Customer customer = new Customer();
				customer = (Customer) objIS.readObject();
				
				if(customer == null) {
					JOptionPane.showMessageDialog(null,  "Customer record not found", "Find Customer Status", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		} catch (ClassCastException cce) {
			cce.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
