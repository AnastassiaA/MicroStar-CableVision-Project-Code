package com.microstar.dashboards;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerRepDashboard extends JFrame implements ActionListener {

	
	private JLabel serviceLabel;
	private JMenuBar menuBar;
	private JMenuItem viewOption, addOption, editOption, removeOption;
	private JMenu mainMenu, customerMenu, serviceMenu, technicianMenu, complaintMenu;
	private JPanel mainPanel, customerPanel, servicePanel, technicianPanel, complaintPanel;
	private JTable serviceTable;
    private JScrollPane scrollPane;
	
	private String[][] serviceTableRows = {
			{ "4031", "Kundan Kumar", "CSE" },
            { "6014", "Anand Jha", "IT" }
	};
	
	private String[] serviceTableColumns = {
			"Service Id",
			"Service Name",
			"Service Description"
	};
	
	
	public CustomerRepDashboard() {
		initializeComponent();
		addComponentsToPanels();
		addPanelsToFrame();
		setWindowProperties();
		registerListeners();
	}
	
	
	public void initializeComponent() {
		
		menuBar = new JMenuBar();
		mainMenu = new JMenu("Home");
		customerMenu = new JMenu("Customers");
		serviceMenu = new JMenu("Services");
		technicianMenu = new JMenu("Technician");
		complaintMenu = new JMenu("Complaint");
		
		viewOption = new JMenuItem("View Services");
		addOption = new JMenuItem("Add Service");
		editOption = new JMenuItem("Edit Service");
		removeOption = new JMenuItem("Remove Service");
		
		servicePanel = new JPanel();
		//loginButton = new JButton("Login");
		
		// Initializing the JTable
        serviceTable = new JTable(serviceTableRows, serviceTableColumns);
        //serviceTable.setBounds(30, 40, 100, 100);
        serviceTable.setPreferredScrollableViewportSize(new Dimension(650, 200));
        serviceTable.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(serviceTable);
        
        
        serviceLabel = new JLabel("Services List");
        
	}
	
	
	private void addComponentsToPanels() {
		serviceMenu.add(viewOption);
		serviceMenu.add(addOption);
		serviceMenu.add(editOption);
		serviceMenu.add(removeOption);
		
		menuBar.add(mainMenu);
		menuBar.add(customerMenu);
		menuBar.add(complaintMenu);
		menuBar.add(serviceMenu);
		menuBar.add(technicianMenu);
		
		//servicePanel.add(serviceLabel);
		//servicePanel.add(serviceTable);
		servicePanel.add(scrollPane);
		servicePanel.setBounds(23, 23, 650, 500);
		servicePanel.setBackground(Color.BLUE);
		servicePanel.setVisible(false);
		
		scrollPane.setVisible(true);
		
	}
	
	
	private void addPanelsToFrame() {
		this.setJMenuBar(menuBar);
		//this.add(scrollPane);
		this.add(servicePanel);
	}
	
	
	private void setWindowProperties() {
		this.setSize(680, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	
	private void registerListeners() {

		viewOption.addActionListener(this);
        
        addOption.addActionListener(this);
        
        editOption.addActionListener(this);
        
		removeOption.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == viewOption ) {

			System.out.println("Viewing...");
			scrollPane.setVisible(true);
			servicePanel.setVisible(true);
			
		} else if ( e.getSource() == addOption ) {
			
			System.out.println("Adding...");
			
		} else if ( e.getSource() == editOption ) {

			System.out.println("Editing...");
			
		} else if ( e.getSource() == removeOption ) {

			System.out.println("Removing...");
			
		}
		
	}
	
	public void updateTableRows() {
		
		// Fetch table data;
		//serviceTableRows
		
	}


	
	
}
