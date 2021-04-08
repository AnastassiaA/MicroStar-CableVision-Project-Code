package com.microstar.dashboards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;


	public class LodgeComplaint extends JInternalFrame{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTextPane textPane;
		private JRadioButton technicalRadioButton;
		private JRadioButton accountRadioButton;
		private JRadioButton serviceRadioButton;
		private JButton lodgeButton;
	
	public LodgeComplaint() {
		//call all functions
		initilize();
		layoutComponents();
		addactionLitsners();
		
	}
	
	public void initilize() {
		//initiize all variables 
	       textPane = new JTextPane();
	
	       //radio buttons on complaint Frame
	        technicalRadioButton = new JRadioButton("Technical");
			accountRadioButton = new JRadioButton("Account");
			serviceRadioButton= new JRadioButton("Service Package");
			
			//
			lodgeButton = new JButton("Lodge Complaint");
	
	
	}
	
	public void layoutComponents() {
		
		
		    textPane.setBounds(241, 44, 719, 479);
		    
		    //Radio buttons on complaintFrame 
			technicalRadioButton.setBounds(41, 181, 103, 21);
			accountRadioButton.setBounds(41, 277, 103, 21);
			serviceRadioButton.setBounds(41, 373, 135, 21);
			
			lodgeButton.setBounds(534, 567, 215, 39);
			
			    setTitle("Lodge Complaint");
			    setLayout(null);
		        setResizable(true);
		        setClosable(true);
		        setMaximizable(true);
		        setIconifiable(true);
		        setBounds(10, 40, 451, 287);
		        getContentPane().add(textPane);
		        getContentPane().add(technicalRadioButton);
		        getContentPane().add(accountRadioButton);
		        getContentPane().add(serviceRadioButton);
		        getContentPane().add(lodgeButton);
		        pack();
			    setVisible(false);
			 
	}
	
	public void addactionLitsners() {
		
		//addaction Litsner to lodge a complaint
				lodgeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(technicalRadioButton.isSelected()) {
							JOptionPane.showMessageDialog(lodgeButton, "Technical Complaint Lodged");
						}
						if(accountRadioButton.isSelected()) {
							JOptionPane.showMessageDialog(lodgeButton, "Complaint about Account Lodged.");
						}
						if(serviceRadioButton.isSelected()) {
							JOptionPane.showMessageDialog(lodgeButton, "Complaint about Internet/Cable service Lodged.");
						}
					}
				});
		
	}
}
