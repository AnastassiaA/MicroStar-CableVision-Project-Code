package com.microstar.dashboards;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ResponseForm extends JInternalFrame {
	
	private JLabel complaintResponseHeader;
	private JLabel customerIDLabel; 
	private JLabel complaintIDLabel;
	private JLabel siteVisitLabel;
	private JLabel responseLabel;
	private JTextField customerIDTextField;
	private JTextField complaintIDTextField;
	private JTextField dateTextField;
	private JTextPane responseTextPane;
	private JButton submitButton;
	
public ResponseForm() {
		//calls all the functions 
		initilize();
		layoutComponents();
		addactionLitsners();
	}

public void initilize() {
	
	//initilize customerID Label and textfield variables relating to customer 
	 complaintResponseHeader = new JLabel("Complaint Response");
	 customerIDLabel = new JLabel("Customer ID:");
	 customerIDTextField = new JTextField();
	 
	 //initilize complaintID Label and textfield variables relating to complaint
	 complaintIDLabel = new JLabel("Complaint ID:");
	 complaintIDTextField = new JTextField();
	 
	 
	 //initilize siteVisit Label and textfield variables relating to set date for site visit
	siteVisitLabel = new JLabel("Date for visit:");
	dateTextField = new JTextField();
	
	//initilize response Label and textfield variables relating to response text section
	responseLabel = new JLabel("Response:");
	responseTextPane = new JTextPane();
	
	//initilize submit button
	submitButton = new JButton("Submit");
}

public void layoutComponents() {
	
	//layout for Complaint Response internalframe
	setTitle("Complaint Response");
	setBounds(10, 40, 451, 287);
	setLayout(null);
    setResizable(true);
    setClosable(true);
    setMaximizable(true);
    setIconifiable(true);
    
    //layout for complaint header label
    complaintResponseHeader.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	complaintResponseHeader.setBounds(438, 61, 222, 26);
	getContentPane().add(complaintResponseHeader);
	
	//layout for customer id
	customerIDLabel.setBounds(209, 134, 129, 26);
	getContentPane().add(customerIDLabel);
	//customer textfield 
	customerIDTextField.setBounds(438, 138, 222, 19);
	customerIDTextField.setColumns(10);
	getContentPane().add(customerIDTextField);
	
	//layout for complaint id
	complaintIDLabel.setBounds(209, 189, 129, 26);
	getContentPane().add(complaintIDLabel);
	complaintIDTextField.setBounds(438, 193, 222, 19);
	complaintIDTextField.setColumns(10);
	getContentPane().add(complaintIDTextField);
	
	
	//layout for date/site visit
	siteVisitLabel.setBounds(209, 249, 88, 13);
	getContentPane().add(siteVisitLabel);
	dateTextField.setBounds(438, 246, 222, 19);
	dateTextField.setColumns(10);
	getContentPane().add(dateTextField);
	
	//layout for response
	responseLabel.setBounds(209, 311, 129, 26);
	getContentPane().add(responseLabel);
	responseTextPane.setToolTipText("enter response to complaint");
	responseTextPane.setBounds(428, 312, 381, 238);
	getContentPane().add(responseTextPane);
	
	//layout submit button
	submitButton.setBounds(544, 653, 160, 40);
	getContentPane().add(submitButton);
	
	pack();
    setVisible(false);
	
	
}

public void addactionLitsners() {
	
	submitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		}
	});
}
}
