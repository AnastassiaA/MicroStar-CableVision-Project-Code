package com.microstar.dashboards;
import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ComplaintResponseTable extends JInternalFrame {
	
	 private JScrollPane scroll;
	 private JTable table;
	
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String[] columns = {"Customer ID","Complaint ID", "Service", "Complaint Type","Complaint Detail"};
		String[][] data_rows = {
				{"1234","1","Cable","Technical","Cable is not working"},
				{"1236","12","Telephone","Technical","calls keep droping"},
				};

		public ComplaintResponseTable() {
			//call all functions in the ComplaintResponseTable
			initilize();
			layoutComponents();
			
			
		}//
		
		public void initilize() {
			
			//initiize all variables 
			table = new JTable(data_rows, columns);
			scroll= new JScrollPane(table);
			scroll.setBounds(128, 142, 303, -71);
			
		
		}
		
		public void layoutComponents() {
			
			//set layout component for the ComplaintInfoTable   
		    setTitle("Complaint Table");
	        setResizable(true);
	        setClosable(true);
	        setMaximizable(true);
	        setIconifiable(true);
	        pack();
	        getContentPane().add(scroll,BorderLayout.CENTER);
		    setVisible(false);
		 }
	}
