package com.microstar.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class MainLoginWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel secondPane;
	private JButton customerButton;
	private JButton employeeButton;
	private JLabel  companyName;
	private JLabel loginImage;
	private Image images;
	
	
	public MainLoginWindow() {
		
		//Calls all the methods
		initilizeCompnents();
		layoutComponents();
		addactionLitsners();
		addToSecondPane();
		
	}

	public void initilizeCompnents() {
		
		//Initializes  all components
		contentPane = new JPanel();
		customerButton = new JButton("Customer");
		employeeButton = new JButton("Employee");
		companyName = new JLabel("\t\t Micro-Star Cable Vision");
		loginImage = new JLabel("");
		images = new ImageIcon(this.getClass().getResource("/Login-icon.png")).getImage();
		secondPane = new JPanel();
				
	}//end of initilizeCompnents() method
	
	public void layoutComponents() {
		
		//layout for the main contentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 483);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//layout for the second content pane
		secondPane.setBounds(0, 0, 557, 444);
		contentPane.add(secondPane);
		secondPane.setLayout(null);	
		
		//layout for the button component
		customerButton.setBounds(192, 205, 149, 45);
		employeeButton.setBounds(192,291,149, 45);
		
		//layout for the company name JLabel
		companyName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		companyName.setBounds(147, 20, 254, 45);
		
		//layout for the Login icon
		loginImage.setIcon(new ImageIcon(images));
		loginImage.setBounds(202, 75, 120, 120);

	}
	
	public void addactionLitsners() {
		
		//action button for the customer button
		customerButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  CustomerLogin customer = new CustomerLogin();
		    	  customer.setVisible(true);
		    	  
		      }
		    });
		
		//action button for the employee button
		employeeButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  
		    	  EmployeeLogin  employee = new EmployeeLogin();
		    	  employee.setVisible(true);
		    	  
		      }
		    });
		
	}
	
	public void addToSecondPane() {
		
		//Add buttons to the secondPane
		secondPane.add(customerButton);
		secondPane.add(employeeButton);
		
		//Add JLabel to secondPane
		secondPane.add(companyName);
		
		//Add Image to secondPane
		secondPane.add(loginImage);
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLoginWindow frame = new MainLoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	}


