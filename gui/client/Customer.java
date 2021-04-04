package client;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private int contactNumber;
	private String emailAddress;
	private Address address;
	
	public Customer() {
		customerId = 0;
		firstName = "";
		lastName = "";
		contactNumber = 0;
		emailAddress = "";
		address = new Address();
	}

	public Customer(int customerId, String firstName, String lastName, int contactNumber, String emailAddress,
			Address address) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	public Customer(Customer customer) {
		this.customerId = customer.customerId;
		this.firstName = customer.firstName;
		this.lastName = customer.lastName;
		this.contactNumber = customer.contactNumber;
		this.emailAddress = customer.emailAddress;
		this.address = customer.address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
