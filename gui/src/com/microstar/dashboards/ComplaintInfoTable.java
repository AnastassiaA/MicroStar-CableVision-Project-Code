package com.microstar.dashboards;

import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ComplaintInfoTable extends JInternalFrame {
	
    private JScrollPane scroll;
	private JTable table;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] columns = {"Complaint", "Response", "Date of Response","Representative"};
	String[][] data_rows = {
			{"Internet is not working","Please reset the modem","March 10,2021","Daniel Bernard"},
			{"Cable is not working","Please reset the modem","Feburary 10,2021","Christina Thomas"},
			};

	public ComplaintInfoTable() {
		//call all functions in the ComplaintInfoTable
		initilize();
		layoutComponents();
		
		
	}//
	
	public void initilize() {
		
		//initiize all variables 
		table = new JTable(data_rows, columns);
		scroll= new JScrollPane(table);
		
	
	}
	
	public void layoutComponents() {
		
		//set layout component for the ComplaintInfoTable   
	    setTitle("Past Complaint");
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        pack();
        getContentPane().add(scroll,BorderLayout.CENTER);
	    setVisible(false);
	}
	
	
	
	
	
	}
