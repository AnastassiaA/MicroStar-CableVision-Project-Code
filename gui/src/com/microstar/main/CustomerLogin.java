package com.microstar.main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class CustomerLogin extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel secondPane;
	private JButton signInButton;
	private JButton signUpButton;
	private JLabel  customerId;
	private JLabel title;
	private JLabel userImage;
	private JLabel password;
	private Image images;
	private JTextField userIdTextField;
	private JPasswordField passwordField;
	
	
	public CustomerLogin() {
		
		//Calls all the methods
		initilizeCompnents();
		layoutComponents();
		addactionLitsners();
		addToSecondPane();
		
		
	}

	public void initilizeCompnents() {
		
		//Initializes  all components
		contentPane = new JPanel();
		signInButton = new JButton("Sign In");
		signUpButton = new JButton("Sign Up");
		title = new JLabel("\t\t Customer Login");
		userImage = new JLabel("");
		images = new ImageIcon(this.getClass().getResource("/User-icon.png")).getImage();
		customerId = new JLabel("Customer ID:");
		userIdTextField = new JTextField();
		password = new JLabel("Password:");
		passwordField = new JPasswordField();
		secondPane = new JPanel();
				
	}
	
	public void layoutComponents() {
		
		//layout for the main contentPane
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 483);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//layout for the second content pane
		secondPane.setBounds(0, 0, 557, 444);
		contentPane.add(secondPane);
		secondPane.setLayout(null);	
		
		//layout for the button component
		signInButton.setBounds(151, 351, 107, 34);
		signUpButton.setBounds(289,351,115, 34);
		
		//layout for the Customer Login JLabel
		title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		title.setBounds(183, 20, 162, 45);
		
		//layout for the user icon
		userImage.setIcon(new ImageIcon(images));
		userImage.setBounds(209, 75, 120, 120);
		
		//layout for customer id JLabel and text field
		customerId.setBounds(71, 244, 82, 13);
		userIdTextField.setBounds(206, 241, 139, 19);
		userIdTextField.setColumns(10);
		
		//Layout for password JLabel and password field
		password.setBounds(71, 279, 60, 13);
		passwordField.setBounds(206, 276, 139, 19);


	}
	
	public void addactionLitsners() {
		
		//action button for the sign in  button
		signInButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	    
		      }
		    });
		
		//action button for the sign up  button
		signUpButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  CustomerSignUp signUp = new CustomerSignUp();
		    	  signUp.setVisible(true);
		    	  
		      }
		    });
		
	}
	
	public void addToSecondPane() {
		
		//add buttons to the second JPanel
		secondPane.add(signInButton);
		secondPane.add(signUpButton);
		
		//add JLabels to the second JPanel
		secondPane.add(title);
		secondPane.add(customerId);
		secondPane.add(password);
		
		//add user image icon to the second JPanel
		secondPane.add(userImage);
		
		//add text fields to the second JPanel
		secondPane.add(userIdTextField);
		
		//add password field to the second JPane;
		secondPane.add(passwordField);
		
	}
	
}
