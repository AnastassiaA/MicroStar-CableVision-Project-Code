package com.microstar.dashboards;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AccountInfoTable extends JInternalFrame{
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem payHistory;
	private JMenuItem queryStatus;
    private JScrollPane scroll;
	private JScrollPane scroll2;
	private JTable table;
	private JTable payHistoryTable;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] columns = {"Payment Status", "Amount Due", "Payment Due Date"};
	String[][] data_rows = {
			{"Due","4500","April 10,2021"},
			};
	
	String[] columnPayHistory = {"Payment Status", "Amount", "Payment Date"};
	String[][] data_rowsPayHistory = {
			{"PAYED","4500","March 10,2021"},
			{"PAYED","4500","Feburary 10,2021"},
			{"PAYED","4500","January 10,2021"}
			};
	
	 
	
	
	public AccountInfoTable() {
		initilize();
		layoutComponents();
		addactionLitsners();
		
	}//
	
	public void initilize() {
		menuBar = new JMenuBar();
		menu = new JMenu();
		menu = new JMenu("Menu");
		//
		payHistory= new JMenuItem("Payment History");
		queryStatus= new JMenuItem("Account Status");
		//
		menuBar.add(menu);
		menu.add(payHistory);
		menu.add(queryStatus);
		//
		table = new JTable(data_rows, columns);
		payHistoryTable = new JTable(data_rowsPayHistory, columnPayHistory);
		//
		scroll= new JScrollPane(table);
		scroll2 = new JScrollPane(payHistoryTable);
	
	}
	
	public void layoutComponents() {
		
		    setJMenuBar(menuBar); 
	        setTitle("Payment Query");
	        setResizable(true);
	        setClosable(true);
	        setMaximizable(true);
	        setIconifiable(true);
	        pack();
	         
	}
	
	public void addactionLitsners() {
		 
        queryStatus.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	
			       getContentPane().add(scroll,BorderLayout.CENTER);
			       setVisible(true);
			       
			      }
			    });
	
       
        payHistory.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	getContentPane().add(scroll2,BorderLayout.SOUTH);
			        setVisible(true);
			         
			      }
			    });
		
	}
	
	
}//

