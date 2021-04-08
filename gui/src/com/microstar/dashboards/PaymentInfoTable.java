package com.microstar.dashboards;
import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PaymentInfoTable extends JInternalFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scroll2;
	private JTable payHistoryTable;
	
	String[] columnPayHistory = {"Payment Status", "Amount", "Payment Date"};
	String[][] data_rowsPayHistory = {
			{"PAYED","4500","March 10,2021"},
			{"PAYED","4500","Feburary 10,2021"},
			{"PAYED","4500","January 10,2021"}
			};
	
	public PaymentInfoTable() {
		//call all functions
		initilize();
		layoutComponents();
		
	}//
	
	public void initilize() {
		//initilize variables
		payHistoryTable = new JTable(data_rowsPayHistory, columnPayHistory);
		scroll2 = new JScrollPane(payHistoryTable);
	
	}
	
	public void layoutComponents() {
		
		//set layout components for AccountInfoTable
        setTitle("Payment History");
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        pack();
        getContentPane().add(scroll2,BorderLayout.CENTER);
	    setVisible(false);
        
	 
}

	
	

}
