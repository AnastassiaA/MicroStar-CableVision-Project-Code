package com.microstar.dashboards;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AccountInfoTable extends JInternalFrame{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scroll;
	private JTable table;
		
	
	String[] columns = {"Payment Status", "Amount Due", "Payment Due Date"};
	String[][] data_rows = {
			{"Due","4500","April 10,2021"},
			};
		 
	
	
	public AccountInfoTable() {
		//call all functions
		initilize();
		layoutComponents();
		
		
	}//
	
	public void initilize() {
		//initilize variables
		table = new JTable(data_rows, columns);
		scroll= new JScrollPane(table);
		
	
	}
	
	public void layoutComponents() {
		
		    //set layout components for AccountInfoTable
	        setTitle("Account Status");
	        setResizable(true);
	        setClosable(true);
	        setMaximizable(true);
	        setIconifiable(true);
	        pack();
	        getContentPane().add(scroll,BorderLayout.CENTER);
		    setVisible(false);
	        
		 
	}
	
}

