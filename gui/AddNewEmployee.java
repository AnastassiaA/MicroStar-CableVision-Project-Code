package com.gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddNewEmployee extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel secondPane;
	private JButton cancelButton;
	private JButton addEmpButton;
	private JLabel  firstName;
	private JLabel  lastName;
	private JLabel  contactNumber;
	private JLabel addEmployeeTitle;
	private JLabel signUpImage;
	private JLabel password;
	private JLabel reenterPassword;
	private Image images;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField  contactNumberTextField;
	private JPasswordField passwordField;
	private JPasswordField reenterPasswordField;
	
	
	
	
	public AddNewEmployee() {
		initilizeCompnents();
		layoutComponents();
		addactionLitsners();
		addToSecondPane();
		
		
	}

	public void initilizeCompnents() {
		
		//main jpanel
		contentPane = new JPanel();
		
		//JButtons
		cancelButton = new JButton("Cancel");
		addEmpButton = new JButton("Add");
		
		//JLabels
		addEmployeeTitle = new JLabel(" Add Employeee");
		signUpImage = new JLabel("");
		firstName = new JLabel("First Name:");
		lastName = new JLabel("Last Name:");
		contactNumber = new JLabel("Contact Number:");
		password = new JLabel("Password:");
		reenterPassword = new JLabel("Re-Enter Password:");
		
		//images
		images = new ImageIcon(this.getClass().getResource("/Signup-icon.png")).getImage();
		
		//text fields
		firstNameTextField = new JTextField();
		lastNameTextField = new JTextField();
	    contactNumberTextField = new JTextField();
		passwordField = new JPasswordField();
		reenterPasswordField = new JPasswordField();
		
		
		//second jpanel
		secondPane = new JPanel();
				
	}
	
	public void layoutComponents() {
		
		//layout for the main contentPane
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 583);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//layout for the second content pane
		secondPane.setBounds(0, 0, 557, 583);
		contentPane.add(secondPane);
		secondPane.setLayout(null);	
		
		//layout for the button component
		cancelButton.setBounds(219, 432, 89, 23);
		addEmpButton.setBounds(219,388,89, 23);
		
		//layout for add employee title
		addEmployeeTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		addEmployeeTitle.setBounds(201, 20, 186, 45);
		
		///layout for the employee image JLabel
		signUpImage.setIcon(new ImageIcon(images));
		signUpImage.setBounds(219, 63, 89, 96);
		
		//layout for first name label and text field
		firstName.setBounds(71, 165, 82, 13);
		firstNameTextField.setBounds(194, 169, 139, 19);
		firstNameTextField.setColumns(10);
		
		//layout for last name label and text field
		lastName.setBounds(71, 205, 72, 13);
		lastNameTextField.setBounds(192, 238, 141, 19);
		lastNameTextField.setColumns(10);
		
		
		//layout for contact number label and text field
		contactNumber.setBounds(71, 241, 111, 13);
		contactNumberTextField.setBounds(192, 202, 141, 19);
		contactNumberTextField.setColumns(10);
		
		
		//Layout for password JLabel and password field
		password.setBounds(71, 283, 60, 13);
		passwordField.setBounds(192, 280, 139, 19);
		
		//Layout for re-enter password JLabel and password field
		reenterPassword.setBounds(71, 316, 126, 13);
		reenterPasswordField.setBounds(194, 313, 139, 19);

	}
	
	//action button for the cancel  button
	public void addactionLitsners() {
		
		cancelButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  EmployeeLogin  employee = new EmployeeLogin();
		    	  employee.setVisible(true);
		    	  
		      }
		    });
		
		//action button for the sign up  button
		addEmpButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		      }
		    });
		
	}
	
	public void addToSecondPane() {
		
		//add buttons to the second JPanel
		secondPane.add(cancelButton);
		secondPane.add(addEmpButton);
		
		//Add labels to the second JPanel
		secondPane.add(addEmployeeTitle);
		secondPane.add(firstName);
		secondPane.add(lastName);
		secondPane.add(contactNumber);
		secondPane.add(password);
		secondPane.add(reenterPassword);
		
		
		//Add images to the second JPanel
		secondPane.add(signUpImage);
		
		//Add text fields to the second JPanel
		secondPane.add(firstNameTextField);
		secondPane.add(lastNameTextField);
		secondPane.add(contactNumberTextField);
				
		
		//Add password Text fields to the second JPanel
		secondPane.add(passwordField);
		secondPane.add(reenterPasswordField);
		
		
	}
	

}
