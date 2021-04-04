package client;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private int contactNumber;
	private String position;
	
	public Employee() {
		employeeId = 0;
		firstName = "";
		lastName = "";
		contactNumber = 0;
		position = "";
	}

	public Employee(Employee employee) {
		this.employeeId = employee.employeeId;
		this.firstName = employee.firstName;
		this.lastName = employee.lastName;
		this.contactNumber = employee.contactNumber;
		this.position = employee.position;
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

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
