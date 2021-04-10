package com.microstar.dashboards;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CustomerInfoTable extends JInternalFrame {
	
	 /**
		 * 
		 */
		  private static final long serialVersionUID = 1L;
		   private JTextField searchTextField;
		   private JLabel searchLabel;
		   private TableModel model;
		   private JTable table;
		   private TableRowSorter sorter;
		   private JScrollPane scroll;
		   
		   String[] columnNames = {"Customer ID","Complaint ID", "Service", "Complaint Type","Complaint Detail"};
		      Object[][] rowData = {
		    		  {"1234","1","Cable","Technical","Cable is not working"},
		    		  {"1300","12","Telephone","Technical","calls keep droping"},
		    		 };
		   
		   
		   public CustomerInfoTable() {
			   
			    initilize();
				layoutComponents();
				addactionLitsners();
			   
		   }
		   
		   public void initilize() {
			   
			   searchTextField = new JTextField(15);
			   searchLabel = new JLabel("Search");
			   
			   //
			   model = new DefaultTableModel(rowData, columnNames);
			   sorter = new TableRowSorter<>(model);
			   table = new JTable(model);
			   scroll = new JScrollPane(table);
			   
		   }
		   
		   public void layoutComponents() {
			   //
			   setTitle("Customer Account Info");
			   getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
			 
			   table.setRowSorter(sorter);
			   scroll.setBounds(200, 300, 603, 400);
			   
			   getContentPane().add(searchLabel);
			   getContentPane().add(searchTextField);
			   getContentPane().add(scroll);
			   setResizable(true);
		       setClosable(true);
		       setMaximizable(true);
		       setIconifiable(true);
		       pack();
			   setVisible(false);
		   }
		   
		   public void addactionLitsners() {
			   
			   searchTextField.getDocument().addDocumentListener(new DocumentListener() {
			         @Override
			         public void insertUpdate(DocumentEvent e) {
			            search(searchTextField.getText());
			         }
			         @Override
			         public void removeUpdate(DocumentEvent e) {
			            search(searchTextField.getText());
			         }
			         @Override
			         public void changedUpdate(DocumentEvent e) {
			            search(searchTextField.getText());
			         }
			         public void search(String str) {
			            if (str.length() == 0) {
			               sorter.setRowFilter(null);
			            } else {
			               sorter.setRowFilter(RowFilter.regexFilter(str));
			            }
			         }
			      });
			   
		   }
		   
		   
	
}
